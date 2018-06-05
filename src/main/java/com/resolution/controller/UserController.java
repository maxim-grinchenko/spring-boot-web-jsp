package com.resolution.controller;

import com.resolution.domain.entity.User;
import com.resolution.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", service.findAllUsers());
        return "register";
    }

//    @PostMapping("/save")
////    @PreAuthorize("hasRole('ROLE_USER')")
//    public String addUser(@ModelAttribute("user") User user) {
//        service.saveUser(user);
//        return "redirect:/view";
//    }

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

//    @RequestMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable long id, Model model) {
//        User user = service.findUserById(id);
//        LOGGER.debug(user.getName() + "*************************************");
//        model.addAttribute("user", user);
//        return new ModelAndView("edit_user", "user", user );
//    }


//    @RequestMapping("/edit/{id}")
//    public String editPerson(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.service.findUserById(id));
//        model.addAttribute("list", this.service.findAllUsers());
//        return "editform";
//    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable long id) {
        User user = service.findUserById(id);
        return new ModelAndView("editform", "command", user);
    }

//    @PostMapping(value="/update")
//    public ModelAndView update(@ModelAttribute("user") User user){
//        service.update(emp);
//        return new ModelAndView("redirect:/viewemp");
//    }

//    @RequestMapping("/update")
//    public String update(@ModelAttribute("user") User user) {
//        service.updateUser(user);
//        return "redirect:/view";
//    }

    @GetMapping("/delete/{id}")
    public ModelAndView update(@PathVariable long id) {
        service.deleteById(id);
        return new ModelAndView("redirect:/view");
    }
}
