package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "homePage";
    }

    @RequestMapping("/calcAge")
    public String processForm(HttpServletRequest request, Model model)
    {
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        LocalDate localDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        Period period = Period.between(localDate, today);
        model.addAttribute("year", period.getYears());
        model.addAttribute("month", period.getMonths());
        model.addAttribute("day", period.getDays());

        return "resultPage";
    }
}


