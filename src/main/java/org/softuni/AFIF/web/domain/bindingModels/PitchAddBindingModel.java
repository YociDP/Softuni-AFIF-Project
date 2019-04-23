package org.softuni.AFIF.web.domain.bindingModels;

import org.softuni.AFIF.web.domain.entities.User;

public class PitchAddBindingModel {
    private String id;
    private String name;
    private Integer capacity;
    private String club;
    private User owner;

    public PitchAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
