package main.com.myApp.controller;

import main.com.myApp.model.User;
import main.com.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "homePage";
    }

    @RequestMapping("/dataForm")
    public String processForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "homePage";
        }
        userService.save(user);
        model.addAttribute("user", user);
        return "resultPage";
    }

}


