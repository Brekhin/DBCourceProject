package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Fight;
import ru.kizilov.dbcourceproject.models.Sportsman;
import ru.kizilov.dbcourceproject.repositories.FightRepo;
import ru.kizilov.dbcourceproject.repositories.SportsmanRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FightServise {

    @Autowired
    private FightRepo fightRepo;

    @Autowired
    private SportsmanRepo sportsmanRepo;

    public void addFight(Sportsman sportsmanFirst, Sportsman sportsmanSecond) {
        Fight fight = new Fight();
        if(fight.getSportsmans() != null) {
            fight.getSportsmans().add(sportsmanFirst);
            fight.getSportsmans().add(sportsmanSecond);
        } else {
            Set<Sportsman> sportsmanSet = new HashSet<>();
            sportsmanSet.add(sportsmanFirst);
            sportsmanSet.add(sportsmanSecond);
            fight.setSportsmans(sportsmanSet);
        }

        sportsmanFirst.getFights().add(fight);
        sportsmanSecond.getFights().add(fight);

        fightRepo.save(fight);
    }

    public List<Fight> getAllFight() {
        return fightRepo.findAll();
    }
}
