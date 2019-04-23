package org.softuni.AFIF.web.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Table(name = "clubs")
@Entity
public class Club extends BaseEntity {
    @Column(name = "`name`")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "supportedClub")
    @NotNull(message = "Date of Founding cannot be null")
    private String supportedClub;

    @Column(name = "budget")
    @NotNull(message = "Budget cannot be null")
    private Integer budget;

    @ManyToOne(targetEntity = User.class , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH , CascadeType.REMOVE} , fetch = FetchType.EAGER)
    @JoinColumn(
            name = "founder",
            referencedColumnName = "id"
    )
    private User founder;

    public Club() {
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
}
