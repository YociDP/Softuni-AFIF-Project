package org.softuni.AFIF.web.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pitches")
public class Pitch extends BaseEntity{

    @Column(name = "`name`")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "capacity")
    @NotNull(message = "Capacity cannot be null")
    private Integer capacity;

    @ManyToOne(targetEntity = User.class , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH , CascadeType.REMOVE} , fetch = FetchType.EAGER)
    @JoinColumn(
            name = "owner",
            referencedColumnName = "id"
    )
    private User owner;

    @Column(name = "club")
    @NotNull(message = "Club cannot be null")
    private String club;

    public Pitch() {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

}
