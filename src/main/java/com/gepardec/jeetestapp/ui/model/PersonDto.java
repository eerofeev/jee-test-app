package com.gepardec.jeetestapp.ui.model;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class PersonDto implements Serializable {
    private Long id;

    @Pattern(regexp = "[a-zA-Z]+", message = "Firstname must not be empty and contain only letters")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]+", message = "Lastname must not be empty and contain only letters")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
