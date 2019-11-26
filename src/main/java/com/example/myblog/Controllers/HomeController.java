package com.example.myblog.Controllers;
import com.example.myblog.Domain.User;
import com.example.myblog.Repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    BlogRepository blogRepository;


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String getAdmins(Model model) {
        List<User> users = blogRepository.getAllAdmins();
        model.addAttribute("admin", admins);
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<User> users = blogService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

@GetMapping("/editBlog/{adminId}")
    public String editBlog(@PathVariable Integer adminId, Model model) {
    model.addAttribute("admin", blogService.findAdminById(adminId).get());
        return "editBlog";
}

    @PutMapping("/editBlog")
    public String editBlog(@ModelAttribute Admin admin) {
        blogService.update(admin);
        return "redirect:/";
    }

    @GetMapping("/blog/{adminId}")
    public String blogText(@PathVariable int adminId,  Model model) {
        Optional<Admin> admin = blogService.findAdminById(adminId);
        model.addAttribute("admin", admin.get());

        return "blog";
    }

    @GetMapping("/update/{userId}")
    public String update(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", blogService.findById(userId).get());
        return "update";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute User user) {
        blogService.update(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") int userId, Model model) {
        Optional<User> user = blogService.findById(userId);
        model.addAttribute("user", user.get());

        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute User user, Model model) {
        blogService.delete(user.getUserId());
        return "redirect:/";
    }

    @GetMapping("/details/{userId}")
    public String userDetails(@PathVariable int userId,  Model model) {
        Optional<User> user = blogService.findById(userId);
        model.addAttribute("user", user.get());

        return "details";
    }


  /*

    @PostMapping("/index")
    public String login(Model model, String username, String password, User user) {
        User users = blogService.login(username, password, user);
        if (users == user) {
            return "home";
        }
        model.addAttribute("invalidCredentials", true);
        return "index";
    }


    @GetMapping("/home")
    public String blogHome(Model model) {

        return "home";
    }


    @GetMapping("admin")
    public String adminPage(Model model) {

    //    model.addAttribute("users", users);
        return "admin";
    }

    __________________________________________________*/
    //ADMIN________________________________-
/*
    @GetMapping("/admin")
    public String loginPageAdmin(Model model) {
        model.addAttribute("users", blogService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin")
            public String loginAdmin(Model model, String username, String password, Admin admin) {
                Admin admins = blogService.loginAdmin(username, password, admin);
                if (admins == admin) {
                    return "adminPage";
        }
        model.addAttribute("invalidCredentials", true);
        return "admin";
    }


*/
}




  /*  @PostMapping("/index")
    public String login(Model model) {
        List<User> users = blogService.getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals("username") & users.get(i).getPassword().equals("password")) {

                return "home";
            }
        }
            model.addAttribute("invalidCredentials", true);
            return "index";

    }
}





/*
@RequestMapping(value = "/login", method = RequestMethod.GET)
        public String showLoginForm() {
            return "login";
    }


@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam int userId, @RequestParam String password, HttpSession session) {
    User user = blogService.userLogin(userId, password);
    if (user == null) {
        return "login";
    }
    return "/home";
}

}



    /*
    @GetMapping("/login")
    public String getLoginUser(Model model, User user) {
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/loginAccess")
        public String login(@ModelAttribute User user, Model model) {
        if (user.getUserName().equals(true) && user.getPassword().equals(true)) {
            return "home";
        }
        return "login";
    }
}
   /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginUser() {
       return "login";
    }
    @RequestMapping(value = "/loginAccess", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "user") User user, Model model) {
        String password = user.getUserName();
        String username = user.getPassword();
        blogService.login(user);
       if (user.getUserName().equals(true) && user.getPassword().equals(true)) {
           return "home";
       }
        // if ("username".equals(username) && "password".equals(password)) {
       //     return "home";
       // } //WORK WITH OBJECT
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    }


    /*
  @GetMapping("/login")
public String tryLogin(Model model) {
      List<User> users = blogService.getAllUsers();
model.addAttribute("users", users);
return "login";
  }

    @PostMapping("/home")
    public String login(@ModelAttribute User user, Model model) {
        List<User> users = blogService.getAllUsers();
        model.addAttribute("users", blogService.getAllUsers());
        String password = user.getUserName();
        String username = user.getPassword();
        if ("users".equals(username) && "users".equals(password)) {
            return "redirect:/";
        }
return "/home";
    }



  /*  @GetMapping("/")
    public String index(Model model) {
        List<User> users = blogService.getAllUsers();

        model.addAttribute("users", users);
        return "index";

    }
    */


