package ru.kizilov.dbcourceproject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fightid;

    @ManyToMany(mappedBy = "fights")
    private Set<Sportsman> sportsmans;

    private Long identifWin;

    private Long identifEvent;

    public Long getId() {
        return fightid;
    }

    public void setId(Long id) {
        this.fightid = id;
    }

    public Set<Sportsman> getSportsmans() {
        return sportsmans;
    }

    public void setSportsmans(Set<Sportsman> sportsmans) {
        this.sportsmans = sportsmans;
    }

    public Long getIdentifWin() {
        return identifWin;
    }

    public void setIdentifWin(Long identifWin) {
        this.identifWin = identifWin;
    }

    public Long getIdentifEvent() {
        return identifEvent;
    }

    public void setIdentifEvent(Long identifEvent) {
        this.identifEvent = identifEvent;
    }
}
