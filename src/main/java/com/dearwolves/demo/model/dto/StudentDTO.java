package com.dearwolves.demo.model.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {

    private static final long serialVersionUID = -4628101634068246702L;

    public StudentDTO() {}

    public StudentDTO(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public StudentDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private long id;
    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
