package main.com.myApp.controller;

import main.com.myApp.model.User;
import main.com.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showHomePage()
    {
        return "homePage";
    }

    @RequestMapping("/dataForm")
    public String processForm(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                              @RequestParam("email") String email, @RequestParam("date_of_Birth") String dateOfBirthStr,
                              @RequestParam("city") String city, Model model)
    {
        Date dateOfBirth = Date.valueOf(dateOfBirthStr);

        User user = new User(firstName, lastName, email, dateOfBirth, city);

        userService.save(user);

        model.addAttribute("user", user);

        return "resultPage";
    }
}


