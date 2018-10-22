package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Event;
import ru.kizilov.dbcourceproject.models.Fight;
import ru.kizilov.dbcourceproject.repositories.EventRepo;
import ru.kizilov.dbcourceproject.repositories.FightRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private FightRepo fightRepo;

    public void addEvent(Event event, List<String> present) {
        for (String s : present) {
            Set<Fight> fights = event.getFights();
            Fight fightFromDB = fightRepo.findById(Long.parseLong(s)).get();
            fightFromDB.setEvent(event);

            if (event.getFights() == null) {
                event.setFights(new HashSet<Fight>());
            }
            event.getFights().add(fightFromDB);
            eventRepo.save(event);
        }
        System.out.println(event);
        eventRepo.save(event);
    }

    public List<Event> getAllEvent() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepo.getOne(id);
    }

    public void save(Event event, List<String> present) {
        Event eventFromDB = eventRepo.getOne(event.getId());
        if(eventFromDB != null) {
            if (present != null) {
                for (String s : present) {
                    Set<Fight> fights = eventFromDB.getFights();
                    Fight fightFromDB = fightRepo.findById(Long.parseLong(s)).get();
                    fightFromDB.setEvent(eventFromDB);

                    if (fights == null) {
                        eventFromDB.setFights(new HashSet<Fight>());
                    }
                    eventFromDB.getFights().add(fightFromDB);
                    eventRepo.save(eventFromDB);
                }
            }
        }
    }
}
