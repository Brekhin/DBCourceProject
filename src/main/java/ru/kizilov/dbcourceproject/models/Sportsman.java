package ru.kizilov.dbcourceproject.models;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Table(name = "sportsmans")
public class Sportsman {

    public Sportsman() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String alias;

    private int growth;

    private int weight;

    private int lengthOfHands;

    private int countOfLose;

    private int countOfWin;

    private int countOfDraw;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLengthOfHands() {
        return lengthOfHands;
    }

    public void setLengthOfHands(int lengthOfHands) {
        this.lengthOfHands = lengthOfHands;
    }

    public int getCountOfLose() {
        return countOfLose;
    }

    public void setCountOfLose(int countOfLose) {
        this.countOfLose = countOfLose;
    }

    public int getCountOfWin() {
        return countOfWin;
    }

    public void setCountOfWin(int countOfWin) {
        this.countOfWin = countOfWin;
    }

    public int getCountOfDraw() {
        return countOfDraw;
    }

    public void setCountOfDraw(int countOfDraw) {
        this.countOfDraw = countOfDraw;
    }
}
