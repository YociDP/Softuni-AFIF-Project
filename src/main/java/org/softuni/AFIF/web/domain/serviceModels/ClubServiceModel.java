package org.softuni.AFIF.web.domain.serviceModels;
import org.softuni.AFIF.web.domain.entities.User;

import java.util.List;

public class ClubServiceModel {
    private String id;
    private String supportedClub;
    private User founder;
    private Integer budget;
    private String name;

    public ClubServiceModel() {
    }

    public String  getSupportedClub() {
        return supportedClub;
    }

    public void setSupportedClub(String foundedOn) {
        this.supportedClub = foundedOn;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
