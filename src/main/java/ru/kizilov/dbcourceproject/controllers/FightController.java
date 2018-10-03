package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kizilov.dbcourceproject.models.Fight;
import ru.kizilov.dbcourceproject.service.FightServise;
import ru.kizilov.dbcourceproject.service.SportsmanService;

import java.util.List;

@Controller
public class FightController {

    @Autowired
    private FightServise fightServise;

    @Autowired
    private SportsmanService sportsmanService;

    @GetMapping("/fights")
    public String getAllFights(Model model) {
        List<Fight> fights = fightServise.getAllFight();
        model.addAttribute("fights", fights);
        return "fights";
    }

    @GetMapping("/newfight")
    public String getFightPage(){
        return "newfight";
    }

    @PostMapping("/newfight")
    public String addFight(@RequestParam String aliasFirstFighter,
                           @RequestParam String aliasSecondFighter) {

        fightServise.addFight(sportsmanService.getFighterByAlias(aliasFirstFighter), sportsmanService.getFighterByAlias(aliasSecondFighter));
        return "redirect:/fights";
    }
}
