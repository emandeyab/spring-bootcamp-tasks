package main.com.myApp.controller;

import main.com.myApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel", new User());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") User user, Model model)
    {
        return "resultPage";
    }
}


