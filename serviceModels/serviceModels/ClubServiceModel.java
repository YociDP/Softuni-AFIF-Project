package org.softuni.AFIF.web.models.serviceModels;

import org.softuni.AFIF.web.models.Player;
import org.softuni.AFIF.web.models.User;

import java.util.Date;
import java.util.List;

public class ClubServiceModel {

    private String id;

    private String foundedOn;

    private List<Player> players;

    private User founder;

    private Integer budget;

    private String name;

    public ClubServiceModel() {
    }

    public String  getFoundedOn() {
        return foundedOn;
    }

    public void setFoundedOn(String foundedOn) {
        this.foundedOn = foundedOn;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User user) {
        this.founder = user;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
