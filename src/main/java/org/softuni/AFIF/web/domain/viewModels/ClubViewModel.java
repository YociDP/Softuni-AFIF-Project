package org.softuni.AFIF.web.domain.viewModels;

import org.softuni.AFIF.web.domain.entities.User;

public class ClubViewModel {
    private String name;
    private String supportedClub;
    private User founder;
    private Integer budget;

    public ClubViewModel() {
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

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }
}
