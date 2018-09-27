package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kizilov.dbcourceproject.service.SportsmanService;

@Controller
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @GetMapping("/index")
    public String sportsmansList(Model model) {
        model.addAttribute("sportsmans", sportsmanService.getAllSportsmans());
        return "index";
    }

}
