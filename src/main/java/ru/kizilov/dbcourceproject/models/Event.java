package ru.kizilov.dbcourceproject.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "eventstable")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid", unique = true, nullable = false)
    private Long id;

    public String geoPosition;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date date;

    public String name;

    public String description;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fight> fights = new HashSet<>();

    public Event(Long id, String geoPosition, String name, String description, Set<Fight> fights) {
        this.id = id;
        this.geoPosition = geoPosition;
        this.date = date;
        this.name = name;
        this.description = description;
        this.fights = fights;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(String geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Fight> getFights() {
        return fights;
    }

    public void setFights(Set<Fight> fights) {
        this.fights = fights;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", geoPosition='" + geoPosition + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fights=" + fights +
                '}';
    }
}
