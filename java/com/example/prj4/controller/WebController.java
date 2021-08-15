package com.example.prj4.controller;

import com.example.prj4.entity.PostEntity;
import com.example.prj4.entity.UserEntity;
import com.example.prj4.model.BaseModel;
import com.example.prj4.service.PostService;
import com.example.prj4.service.UserServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    UserServiceItf userServiceItf;

    @Autowired
    PostService postService;


    @GetMapping({"/", "index"})
    private String index() {
        return "index";
    }

    @GetMapping("/user")
    private String user() {
        return "user";
    }


    @GetMapping("/404")
    private String error() {
        return "404";
    }



    @GetMapping("/register")
    private String register(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        if(userEntity.getRoleid() == 0){
            userEntity.setRoleid(1);
        }
        return "register";
    }

    @GetMapping("/adduser")
    public String addUser(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        if(userEntity.getRoleid() == 0){
            userEntity.setRoleid(1);
        }
        return "adduser";
    }

    @GetMapping("/admin")
    public String listUser(Model model) {
        List<UserEntity> users = userServiceItf.getAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/logout")
    public String logoutUser(@ModelAttribute UserEntity userEntity, Model model) {
        userServiceItf.createUser(userEntity);
        return "redirect:/index";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity userEntity) {
        userServiceItf.createUser(userEntity);
        return "redirect:/login";
    }
    @PostMapping("/adduser")
    public String addUser(@ModelAttribute UserEntity userEntity) {
        userServiceItf.createUser(userEntity);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        userServiceItf.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        Optional<UserEntity> userEdit = userServiceItf.findUserById(id);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "edituser";
    }
}
