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
import ru.kizilov.dbcourceproject.models.Sportsman;
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
        Long id = fight.get().getIdentifWin();
        if( id != 0){
            Sportsman sportsman = sportsmanService.getOne(id);
            model.addAttribute("sportsmanWin", sportsman);
        }
        model.addAttribute("fight", fight.get());
        return "infoAboutFight";
    }

    @GetMapping("/fights/edit/{fightid}")
    public String showFightForEdit(@Valid Fight fight, Model model) {
        Optional<Fight> fightFormDB = fightServise.getFightByID(fight.getId());
        model.addAttribute("fight", fightFormDB.get());
        return "editFight";
    }


    @PostMapping("/fights/edit/{fightid}")
    public String editFight(@RequestParam(value="present", required = false) List<String> present,
                            @PathVariable(name = "fightid") Long id) {
        fightServise.editFight(present, fightServise.getFightByID(id).get());
        return "redirect:/fights/{fightid}";
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
