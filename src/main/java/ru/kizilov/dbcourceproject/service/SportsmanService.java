package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Sportsman;
import ru.kizilov.dbcourceproject.repositories.SportsmanRepo;

import java.util.List;

@Service
public class SportsmanService {

    @Autowired
    private SportsmanRepo sportsmanRepo;

    public void addSportsman(String firstName, String lastName, String alias) {
        Sportsman sportsman = new Sportsman();
        sportsman.setFirstName(firstName);
        sportsman.setLastName(lastName);
        sportsman.setAlias(alias);

        sportsmanRepo.save(sportsman);
    }

    public List<Sportsman> getAllSportsmans(){
        return sportsmanRepo.findAll();
    }
}
