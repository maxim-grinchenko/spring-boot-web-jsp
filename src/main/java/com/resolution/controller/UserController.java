package com.resolution.controller;

import com.codahale.metrics.annotation.Timed;
import com.resolution.domain.dto.CodeDto;
import com.resolution.domain.dto.UserConfirmDto;
import com.resolution.domain.dto.UserDTO;
import com.resolution.domain.entity.User;
import com.resolution.infra.transformer.UserMapper;
import com.resolution.repository.UserRepository;
import com.resolution.security.SecurityUtils;
import com.resolution.service.UserService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Optional;

@Slf4j
@ComponentScan("com.resolution.controller.*")
@Controller
@NoArgsConstructor
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    private UserMapper mapper = UserMapper.INSTANCE;

//    @Autowired
//    public UserController(UserService service, UserRepository repository) {
//        this.service = service;
//        this.repository = repository;
//    }

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

        System.out.println("****************************");
        System.out.println(user.toString());
        System.out.println("****************************");

        LOGGER.info("Start save / update user : {}", user.toString());

        if (user.getId() == null) {
            service.saveUser(user);
            LOGGER.debug(".......... user save!");
        } else {
            service.updateUser(user);
            LOGGER.debug(".......... user update!");
        }
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping("/view")
    public ModelAndView getAllUsers() {
        Iterator<UserDTO> list = service.findAllUsers().stream().map(mapper::userToUserDTO).iterator();
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
//    @Timed
    public ResponseEntity<CodeDto> updateEmail(@RequestBody UserConfirmDto userConfirm) throws URISyntaxException {

        String email = userConfirm.getEmail();

        if (!email.contains("@") || email.length() > 100)
            return new ResponseEntity<>(new CodeDto("INCORRECT_EMAIL"), HttpStatus.OK);

        if (repository.findByEmail(email.toLowerCase()).isPresent()) {
            return new ResponseEntity<>(new CodeDto("EMAIL_EXISTS"), HttpStatus.OK);
        }

        if (!service.confirmPasswordForChangeEmail(userConfirm.getPassword())) {
            return new ResponseEntity<>(new CodeDto("INCORRECT_PASS"), HttpStatus.OK);
        }

        Optional<User> userOpt = repository.findByName(SecurityUtils.getCurrentUserLogin());
        userOpt.ifPresent(user -> {
            user.setEmail(email);
            repository.save(user);
        });

        return userOpt.map(p -> new ResponseEntity<>(new CodeDto("EMAIL_CHANGED"), HttpStatus.OK))
                .orElse(new ResponseEntity<>(new CodeDto("USER_NOT_FOUND"), HttpStatus.NOT_FOUND));
    }

}
