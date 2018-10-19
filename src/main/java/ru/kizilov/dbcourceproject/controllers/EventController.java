package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kizilov.dbcourceproject.models.Event;
import ru.kizilov.dbcourceproject.service.EventService;
import ru.kizilov.dbcourceproject.service.FightServise;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private FightServise fightServise;

    @GetMapping("/events")
    public String getAllEvent(Model model) {
        model.addAttribute("allEvent", eventService.getAllEvent());
        System.out.println(eventService.getAllEvent().size());
        return "events";
    }

    @GetMapping("/newEvent")
    public String getEventPage(Model model) {
        model.addAttribute("allFights", fightServise.getAllFight());
        return "newEvent";
    }

    @PostMapping("/newEvent")
    public String newEvent(@RequestParam("present") List<String> present,
                           @Valid Event event) {

        eventService.addEvent(event, present);

        return "redirect:/events";
    }
}
