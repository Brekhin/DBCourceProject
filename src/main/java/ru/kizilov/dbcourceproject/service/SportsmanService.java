package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Sportsman;
import ru.kizilov.dbcourceproject.repositories.SportsmanRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SportsmanService {

    @Autowired
    private SportsmanRepo sportsmanRepo;

    public void addSportsman(Sportsman sportsman) {
        sportsmanRepo.save(sportsman);
    }

    public void updateSportsman(Optional<Sportsman> sportsman, String firstName, String lastName, String alias, int growth,
                                int weight, int lengthOfHands) {
        if(firstName != null) {
            sportsman.get().setFirstName(firstName);
        }
        if(lastName != null) {
            sportsman.get().setLastName(lastName);
        }
        if(alias != null) {
            sportsman.get().setAlias(alias);
        }
        if(growth != -100) {
            sportsman.get().setGrowth(growth);
        }
        if(weight != -100) {
            sportsman.get().setWeight(weight);
        }
        if(lengthOfHands != -100) {
            sportsman.get().setLengthOfHands(lengthOfHands);
        }

        sportsmanRepo.save(sportsman.get());
    }

    public Optional<Sportsman> getSportsmanInfo(Long id) {
        return sportsmanRepo.findById(id);
    }

    public Sportsman getFighterByAlias(String alias) {
        System.out.println(sportsmanRepo.findByAlias(alias).getAlias() + "---" + sportsmanRepo.findByAlias(alias).getFirstName());
        return sportsmanRepo.findByAlias(alias);
    }

    public List<Sportsman> getAllSportsmans() {
        return sportsmanRepo.findAll();
    }
}
