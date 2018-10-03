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

    public void addSportsman(String firstName, String lastName, String alias, int growth,
                             int weight, int lengthOfHands) {
        Sportsman sportsman = new Sportsman();
        sportsman.setFirstName(firstName);
        sportsman.setLastName(lastName);
        sportsman.setAlias(alias);
        sportsman.setGrowth(growth);
        sportsman.setWeight(weight);
        sportsman.setLengthOfHands(lengthOfHands);
        sportsman.setCountOfLose(0);
        sportsman.setCountOfWin(0);
        sportsman.setCountOfDraw(0);

        sportsmanRepo.save(sportsman);
    }

    public void updateSportsman(Sportsman sportsman, String firstName, String lastName, String alias, int growth,
                                int weight, int lengthOfHands) {
        sportsman.setFirstName(firstName);
        sportsman.setLastName(lastName);
        sportsman.setAlias(alias);
        sportsman.setGrowth(growth);
        sportsman.setWeight(weight);
        sportsman.setLengthOfHands(lengthOfHands);
        sportsman.setCountOfLose(0);
        sportsman.setCountOfWin(0);
        sportsman.setCountOfDraw(0);
        sportsmanRepo.save(sportsman);
    }

    public Sportsman getSportsmanInfo(Long id) {
        return sportsmanRepo.findOne(id);
    }

    public Sportsman getFighterByAlias(String alias) {
        System.out.println(sportsmanRepo.findByAlias(alias).getAlias() + "---" + sportsmanRepo.findByAlias(alias).getFirstName());
        return sportsmanRepo.findByAlias(alias);
    }

    public List<Sportsman> getAllSportsmans() {
        return sportsmanRepo.findAll();
    }
}
