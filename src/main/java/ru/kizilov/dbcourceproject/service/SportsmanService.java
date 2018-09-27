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

    public boolean addSportsman(Sportsman sportsman) {
        Sportsman sportsmanFromDb = sportsmanRepo.findOne(sportsman.getId());
        if(sportsmanFromDb != null) {
            return false;
        }

        sportsmanRepo.save(sportsman);

        return true;
    }

    public List<Sportsman> getAllSportsmans(){
        return sportsmanRepo.findAll();
    }
}
