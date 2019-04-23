package org.softuni.AFIF.web.domain.entities;

import org.softuni.AFIF.web.domain.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "firstName")
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @Column(name = "lastName" , nullable = false)
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @Column(name = "overallRating" , nullable = false)
    @NotNull(message = "Overall Rating cannot be null")
    @Max(value = 99 , message = "Overall Rating cannot be more than 99")
    private Integer overallRating;

    @Column(name = "pace" , nullable = false)
    @NotNull(message = "Pace cannot be null")
    @Max(value = 99 , message ="Pace cannot be more than 99")
    private Integer pace;

    @Column(name = "dribbling" , nullable = false)
    @NotNull(message = "Dribbling cannot be null")
    @Max(value = 99 , message = "Dribbling cannot be more than 99")
    private Integer dribbling;

    @Column(name = "passing" , nullable = false)
    @NotNull(message = "Passing cannot be null")
    @Max(value = 99 , message = "Passing cannot be more than 99")
    private Integer passing;

    @Column(name = "shooting" , nullable = false)
    @NotNull(message = "Shooting cannot be null")
    @Max(value = 99 , message = "Shooting cannot be more than 99")
    private Integer shooting;

    @Column(name = "defending" , nullable = false)
    @NotNull(message = "Defending cannot be null")
    @Max(value = 99 , message = "Defending cannot be more than 99")
    private Integer defending;

    @Column(name = "physical" , nullable = false)
    @NotNull(message = "Physical cannot be null")
    @Max(value = 99 , message = "Physical cannot be more than 99")
    private Integer physical;

    @Column(name = "position" , nullable = false)
    @NotNull(message = "Position cannot be null")
    private String position;

    @Column(name = "weakFoot" , nullable = false)
    @NotNull(message = "Weak Foot cannot be null")
    @Max(value = 5 , message = "Weak Foot rating cannot be more than 5")
    private Integer weakFoot;

    @Column(name = "skillMoves" , nullable = false)
    @NotNull(message = "Skill Moves cannot be null")
    @Max(value = 5 , message = "Skill Moves rating cannot be more than 5")
    private Integer skillMoves;

    @Column(name = "height" , nullable = false)
    @NotNull(message = "Height cannot be null")
    private Integer height;

    @Column(name = "price" , nullable = false)
    @NotNull(message = "Price cannot be null")
    private Integer price;



    public Player() {
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

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getPace() {
        return pace;
    }

    public void setPace(Integer pace) {
        this.pace = pace;
    }

    public Integer getDribbling() {
        return dribbling;
    }

    public void setDribbling(Integer dribbling) {
        this.dribbling = dribbling;
    }

    public Integer getPassing() {
        return passing;
    }

    public void setPassing(Integer passing) {
        this.passing = passing;
    }

    public Integer getShooting() {
        return shooting;
    }

    public void setShooting(Integer shooting) {
        this.shooting = shooting;
    }

    public Integer getDefending() {
        return defending;
    }

    public void setDefending(Integer defending) {
        this.defending = defending;
    }

    public Integer getPhysical() {
        return physical;
    }

    public void setPhysical(Integer physical) {
        this.physical = physical;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getWeakFoot() {
        return weakFoot;
    }

    public void setWeakFoot(Integer weakFoot) {
        this.weakFoot = weakFoot;
    }

    public Integer getSkillMoves() {
        return skillMoves;
    }

    public void setSkillMoves(Integer skillMoves) {
        this.skillMoves = skillMoves;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }
}
