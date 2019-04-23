package org.softuni.AFIF.web.domain.bindingModels;

public class ManagerAddBindingModel {
    private String firstName;

    private String lastName;

    private Integer contract;

    private String club;

    private String division;

    private Integer age;

    public ManagerAddBindingModel() {
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

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
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
}
