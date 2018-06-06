package com.resolution.controller;

import com.resolution.domain.entity.User;
import com.resolution.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
}
