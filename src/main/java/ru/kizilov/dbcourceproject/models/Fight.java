package ru.kizilov.dbcourceproject.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Sportsman> sportsmans;

    private Long identifWin;

    private Long identifEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sportsman> getSportsmans() {
        return sportsmans;
    }

    public void setSportsmans(List<Sportsman> sportsmans) {
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
