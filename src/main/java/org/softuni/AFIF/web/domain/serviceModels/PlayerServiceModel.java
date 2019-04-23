package org.softuni.AFIF.web.domain.serviceModels;

public class PlayerServiceModel {
    private String id;

    private String firstName;

    private String lastName;

    private Integer overallRating;

    private Integer pace;

    private Integer dribbling;

    private Integer passing;

    private Integer shooting;

    private Integer defending;

    private Integer physical;

    private String position;

    private Integer weakFoot;

    private Integer skillMoves;

    private Integer height;

    private Integer price;

    public PlayerServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
