package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kizilov.dbcourceproject.models.Fight;
import ru.kizilov.dbcourceproject.service.FightServise;
import ru.kizilov.dbcourceproject.service.SportsmanService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class FightController {

    @Autowired
    private FightServise fightServise;

    @Autowired
    private SportsmanService sportsmanService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/fights")
    public String getAllFights(Model model) {
        List<Fight> fights = fightServise.getAllFight();
        for (Fight str : fights) {
            System.out.println("1");
        }
        model.addAttribute("fights", fights);
        return "fights";
    }

    @GetMapping("/newfight")
    public String getFightPage() {
        return "newfight";
    }

    @PostMapping("/newfight")
    public String addFight(@Valid Fight fight,
                           @RequestParam String aliasFirstFighter,
                           @RequestParam String aliasSecondFighter,
                           @RequestParam String description,
                           @RequestParam("file") MultipartFile file) {

        try {
            saveFile(fight, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fightServise.addFight(fight, sportsmanService.getFighterByAlias(aliasFirstFighter), sportsmanService.getFighterByAlias(aliasSecondFighter));
        return "redirect:/fights";
    }

    @GetMapping("/fights/{fightid}")
    public String showFight(@PathVariable Long fightid, Model model) {
        Optional<Fight> fight = fightServise.getFightByID(fightid);
        model.addAttribute("fight", fight.get());
        return "infoAboutFight";
    }

    private void saveFile(@Valid Fight fight, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            fight.setFilename(resultFileName);
        }
    }
}
