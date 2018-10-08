package com.userManagement.Home.Controller;

import com.userManagement.User.Model.User;
import com.userManagement.User.Services.UserDao;
import com.userManagement.User.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private String message = "Home";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String welcome(Model model) {

        model.addAttribute("user", new User() );
        return "home";
    }
}

