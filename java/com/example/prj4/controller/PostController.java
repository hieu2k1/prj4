package com.example.prj4.controller;

import com.example.prj4.entity.PostEntity;
import com.example.prj4.entity.UserEntity;
import com.example.prj4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/listpost")
    private String listPost(Model model) {
        List<PostEntity> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "listpost";
    }

    @GetMapping("/createpost")
    private String addPost(Model model) {
        PostEntity postEntity = new PostEntity();
        model.addAttribute("post", postEntity);
        return "createpost";
    }
    @PostMapping("/createpost")
    public String addPost(@ModelAttribute PostEntity postEntity) {
        postService.createPost(postEntity);
        return "redirect:/listpost";
    }
    @GetMapping("/deletepost/{mabaiviet}")
    public String deletePost(@PathVariable("mabaiviet") int mabaiviet, Model model) {
        postService.deletePost(mabaiviet);
        return "redirect:/listpost";
    }

    @GetMapping("/editpost/{mabaiviet}")
    public String editPost(@PathVariable("mabaiviet") int mabaiviet, Model model) {
        Optional<PostEntity> postEdit = postService.findPostById(mabaiviet);
        postEdit.ifPresent(post -> model.addAttribute("post", post));
        return "editpost";
    }

}
