package org.softuni.AFIF.web.domain.serviceModels;

import org.softuni.AFIF.web.domain.entities.User;

public class PitchServiceModel {
    private String id;
    private String name;
    private String club;
    private User owner;
    private Integer capacity;

    public PitchServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
