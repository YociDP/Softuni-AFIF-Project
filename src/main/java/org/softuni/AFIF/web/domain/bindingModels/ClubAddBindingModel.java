package org.softuni.AFIF.web.domain.bindingModels;

import org.softuni.AFIF.web.domain.entities.User;

public class ClubAddBindingModel {
    private String id;
    private String name;
    private String supportedClub;
    private Integer budget;
    private User founder;

    public ClubAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupportedClub() {
        return supportedClub;
    }

    public void setSupportedClub(String foundedOn) {
        this.supportedClub = foundedOn;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
