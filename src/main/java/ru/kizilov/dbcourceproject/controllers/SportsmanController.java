package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kizilov.dbcourceproject.models.Sportsman;
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

    @GetMapping("/newsportsman")
    public String registration() {
        return "newsportsman";
    }

    @PostMapping("/newsportsman")
    public String addSportsman(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String alias,
                               @RequestParam int growth,
                               @RequestParam int weight,
                               @RequestParam int lengthOfHands) {

        sportsmanService.addSportsman(firstName, lastName, alias, growth, weight, lengthOfHands);
        return "redirect:/index";
    }

}
