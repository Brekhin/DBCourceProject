package ru.kizilov.dbcourceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kizilov.dbcourceproject.models.Fight;
import ru.kizilov.dbcourceproject.models.Sportsman;
import ru.kizilov.dbcourceproject.repositories.FightRepo;
import ru.kizilov.dbcourceproject.repositories.SportsmanRepo;

import java.util.*;

@Service
public class FightServise {

    @Autowired
    private FightRepo fightRepo;

    @Autowired
    private SportsmanRepo sportsmanRepo;

    public void addFight(Fight fight, Sportsman sportsmanFirst, Sportsman sportsmanSecond) {
        if(fight.getSportsmans() != null) {
            fight.getSportsmans().add(sportsmanFirst);
            fight.getSportsmans().add(sportsmanSecond);
        } else {
            List<Sportsman> sportsmanSet = new ArrayList<>();
            sportsmanSet.add(sportsmanFirst);
            sportsmanSet.add(sportsmanSecond);
            fight.setSportsmans(sportsmanSet);
        }

        sportsmanFirst.getFights().add(fight);
        sportsmanSecond.getFights().add(fight);

        fightRepo.save(fight);
    }


    //тут очень плохой код, но мне лень писать нормально :-(
    public void editFight(List<String> winId, Fight fight){
        if(fight.getIdentifWin() == 0) {
            if (!winId.get(0).isEmpty()) {
                if (winId.get(0).equals("1")) {
                    Long id = fight.getSportsmans().get(0).getId();
                    fight.setIdentifWin(id);
                    Sportsman sportsman = sportsmanRepo.findById(id).get();

                    int countOfWin = sportsman.getCountOfWin() + 1;
                    sportsman.setCountOfWin(countOfWin);

                    Long idLose = fight.getSportsmans().get(1).getId();
                    Sportsman sportsmanLose = sportsmanRepo.findById(idLose).get();
                    int countOfLose = sportsmanLose.getCountOfLose() + 1;
                    sportsmanLose.setCountOfLose(countOfLose);


                    sportsmanRepo.save(sportsmanLose);
                    sportsmanRepo.save(sportsman);
                }
                if (winId.get(0).equals("2")) {
                    Long id = fight.getSportsmans().get(1).getId();
                    fight.setIdentifWin(id);
                    Sportsman sportsman = sportsmanRepo.findById(id).get();
                    int countOfWin = sportsman.getCountOfWin() + 1;
                    sportsman.setCountOfWin(countOfWin);

                    Long idLose = fight.getSportsmans().get(0).getId();
                    Sportsman sportsmanLose = sportsmanRepo.findById(idLose).get();
                    int countOfLose = sportsmanLose.getCountOfLose() + 1;
                    sportsmanLose.setCountOfLose(countOfLose);


                    sportsmanRepo.save(sportsmanLose);
                    sportsmanRepo.save(sportsman);
                }
                if (winId.get(0).equals("3")) {
                    Long id = fight.getSportsmans().get(0).getId();
                    fight.setIdentifWin(id);

                    Sportsman sportsman = sportsmanRepo.findById(id).get();
                    int countOfDraw = sportsman.getCountOfDraw() + 1;
                    sportsman.setCountOfDraw(countOfDraw);

                    Long id2 = fight.getSportsmans().get(1).getId();
                    Sportsman sportsman1 = sportsmanRepo.findById(id2).get();
                    int countOfDraw2 = sportsman1.getCountOfDraw() + 1;
                    sportsman1.setCountOfDraw(countOfDraw2);



                    sportsmanRepo.save(sportsman1);
                    sportsmanRepo.save(sportsman);
                }
            }
        }
        fightRepo.save(fight);
    }

    public List<Fight> getAllFight() {
        return fightRepo.findAll();
    }

    public Optional<Fight> getFightByID(Long id){
        return fightRepo.findById(id);
    }
}
