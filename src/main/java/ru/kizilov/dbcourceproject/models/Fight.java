package ru.kizilov.dbcourceproject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fightid", unique = true, nullable = false)
    private Long fightid;

    @ManyToMany(mappedBy = "fights")
    private Set<Sportsman> sportsmans;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eventid")
    private Event event;

    private Long identifWin;

    private Long identifEvent;

    private String description;

    private String filename;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFightid() {
        return fightid;
    }

    public void setFightid(Long fightid) {
        this.fightid = fightid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

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
