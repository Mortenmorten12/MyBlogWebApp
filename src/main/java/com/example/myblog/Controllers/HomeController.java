package com.example.myblog.Controllers;

import com.example.myblog.Domain.BlogPost;
import com.example.myblog.Domain.User;
import com.example.myblog.Repositories.BlogRepository;
import com.example.myblog.Repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController
{

    private Boolean isLoggedIn = false;


    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepositoryImpl userRepository;


    @GetMapping("/login")
    public String login(Model model)
    {
        // send empty user to be filled by the user of the system
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user)
    {
        // fetch all users to compare registered user with db
        List<User> users = userRepository.fetchAllUsers();
        for (User userEntity : users)
        {
            if (user.getUsername().equals(userEntity.getUsername()) && user.getPassword().equals(userEntity.getPassword()))
            {

                // user is admin
                if (userEntity.getUsertype().equals("admin"))
                {
                    return "redirect:/createBlog";
                }
                // user is normal user
                else
                {
                    return "redirect:/blog";
                }
            }
        }
        // unknown login
        return "redirect:/login";
    }

    @GetMapping("/createBlog")
    public String createBlog(Model model){
        model.addAttribute("blog", new BlogPost());
        return "admin";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute("blog") BlogPost blogPost){
        blogRepository.save(blogPost);
        return "redirect:/createBlog";
    }
}