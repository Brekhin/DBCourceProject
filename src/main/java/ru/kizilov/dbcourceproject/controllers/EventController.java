package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "events";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("allEvent", eventService.getAllEvent());
        return "events";
    }

    @GetMapping("/events/{id}")
    public String getEventById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("singleEvent", eventService.getEventById(id));
        return "infoAboutEvent";
    }

    @GetMapping("/events/edit/{id}")
    public String getEventByIdForEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("singleEvent", eventService.getEventById(id));
        model.addAttribute("listFights", fightServise.getAllFight());
        return "editEvent";
    }

    @PostMapping("/events/edit/{id}")
    public String getEventByIdForEditSave(@RequestParam("present") List<String> present,
                                          @Valid Event event) {
        eventService.save(event, present);
        return "redirect:/events";
    }

    @GetMapping("/newevent")
    public String getNewEventPage(Model model) {

        model.addAttribute("listFights", fightServise.getAllFight());
        return "newEvent";
    }

    @PostMapping("/newevent")
    public String newEvent(@RequestParam("present") List<String> present,
                           @Valid Event event) {

        eventService.addEvent(event, present);
        return "redirect:/events";
    }
}
