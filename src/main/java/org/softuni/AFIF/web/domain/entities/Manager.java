package org.softuni.AFIF.web.domain.entities;

import org.softuni.AFIF.web.domain.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "managers")
public class Manager extends BaseEntity {

    @Column(name = "firstName" , nullable = false)
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @Column(name = "lastName" , nullable = false)
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @Column(name = "club" , nullable = false)
    @NotNull(message = "Club Name cannot be null")
    private String club;

    @Column(name = "division" , nullable = false)
    @NotNull(message = "Division cannot be null")
    private String division;

    @Column(name = "age" , nullable = false)
    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Column(name = "contract" , nullable = false)
    @NotNull(message = "Contract cannot be null")
    private Integer contract;

    public Manager() {
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

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }
}
