package com.abhay.diddy.Controller;

import com.abhay.diddy.Entity.Teachers;
import com.abhay.diddy.Repository.TeachersRepository;
import com.abhay.diddy.Service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {

    @GetMapping("/")
    public String homePage(Model model){

        Teachers teachers = new Teachers();
        teachers.setName("Ram lala");
        teachers.setSalary(32523.45);
        teachers.setID(544L);
        teachers.setMarried(false);

        model.addAttribute("teacher", teachers);
        model.addAttribute("message","this is a message");
        model.addAttribute("name", "Abhay Singh");

        return "main";
    }
}