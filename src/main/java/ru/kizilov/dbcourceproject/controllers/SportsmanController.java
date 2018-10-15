package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kizilov.dbcourceproject.models.Sportsman;
import ru.kizilov.dbcourceproject.service.SportsmanService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @Value("${upload.path}")
    private String uploadPath;

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
    public String addSportsman(@Valid Sportsman sportsman,
                               @RequestParam("file") MultipartFile file
    ) {
        try {
            saveFile(sportsman, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sportsmanService.addSportsman(sportsman);
        return "redirect:/index";
    }

    private void saveFile(@Valid Sportsman sportsman, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            sportsman.setFilename(resultFileName);
        }
    }
    

    @GetMapping("/index/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        Optional<Sportsman> sportsman1 = sportsmanService.getSportsmanInfo(id);
        model.addAttribute("sportsman", sportsman1.get());
        return "sportsmanShow";
    }

    @GetMapping("/edit/{id}")
    public String showForEdit(@PathVariable Long id, Model model) {
        Optional<Sportsman> sportsman1 = sportsmanService.getSportsmanInfo(id);
        model.addAttribute("sportsman", sportsman1.get());
        return "sportsmanEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateProfile(@PathVariable Long id,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String alias,
                                @RequestParam String growth,
                                @RequestParam String weight,
                                @RequestParam String lengthOfHands,
                                Model model) {
        Optional<Sportsman> sportsman1 = sportsmanService.getSportsmanInfo(id);
        if(growth == "")
            growth = "-100";
        if(weight == "")
            weight = "-100";
        if(lengthOfHands == "")
            lengthOfHands = "-100";
        sportsmanService.updateSportsman(sportsman1, firstName, lastName, alias,
                Integer.parseInt(growth),  Integer.parseInt(weight),  Integer.parseInt(lengthOfHands));
        return "redirect:/index/{id}";
    }
}
