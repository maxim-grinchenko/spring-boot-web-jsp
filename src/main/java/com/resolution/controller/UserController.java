package com.resolution.controller;

import com.resolution.domain.entity.User;
import com.resolution.domain.entity.dto.CodeDto;
import com.resolution.domain.entity.dto.UserConfirmDto;
import com.resolution.service.UserService;
import com.resolution.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import com.codahale.metrics.annotation.Timed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@ComponentScan("com.resolution.controller.*")
@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", service.findAllUsers());
        return "register";
    }

    @PostMapping("/save")
    public ModelAndView saveEmployee(@ModelAttribute User user) {
        if (user.getId() == 0) {
            service.saveUser(user);
        } else {
            service.updateUser(user);
        }
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping("/view")
    public ModelAndView getUsers() {

        Iterable<User> list = service.findAllUsers();

        return new ModelAndView("view", "list", list);
    }

    @RequestMapping(value = "/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView edit(@PathVariable long id) {
        User user = service.findUserById(id);
        return new ModelAndView("editform", "command", user);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView update(@PathVariable long id) {
        service.deleteById(id);
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping(value = "/users-ext/updateEmail",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<CodeDto> updateEmail(@RequestBody UserConfirmDto userConfirm) throws URISyntaxException {

        String email = userConfirm.getEmail();

        if (!email.contains("@") || email.length() > 100)
            return new ResponseEntity<>(new CodeDto("INCORRECT_EMAIL"), HttpStatus.OK);

        if (service.findOneByEmail(email.toLowerCase()).isPresent()) {
            return new ResponseEntity<>(new CodeDto("EMAIL_EXISTS"), HttpStatus.OK);
        }

        if (!service.confirmPasswordForChangeEmail(userConfirm.getPassword())) {
            return new ResponseEntity<>(new CodeDto("INCORRECT_PASS"), HttpStatus.OK);
        }

        Optional<User> userOpt = service.findOneByLogin(SecurityUtils.getCurrentUserLogin());
        userOpt.ifPresent(user -> {
            user.setEmail(email);
            service.saveUser(user);
        });

        return userOpt.map(p -> new ResponseEntity<>(new CodeDto("EMAIL_CHANGED"), HttpStatus.OK))
                .orElse(new ResponseEntity<>(new CodeDto("USER_NOT_FOUND"), HttpStatus.NOT_FOUND));
    }
}
