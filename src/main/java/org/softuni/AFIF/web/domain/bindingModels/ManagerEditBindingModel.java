package org.softuni.AFIF.web.domain.bindingModels;

public class ManagerEditBindingModel {
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Integer contract;

    private String division;

    private String club;

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public ManagerEditBindingModel() {
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
