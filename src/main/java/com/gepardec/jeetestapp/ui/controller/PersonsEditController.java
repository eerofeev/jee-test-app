package com.gepardec.jeetestapp.ui.controller;

import com.gepardec.jeetestapp.ui.model.PersonDto;
import com.gepardec.jeetestapp.ui.service.GuiPersonService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class PersonsEditController implements Serializable {

    @Inject
    private GuiPersonService personService;

    private PersonDto person;

    @PostConstruct
    public void init() {
        // TODO: init person using a data from the db if the id is provided /app/person?id=xxx
        // TODO: init person by empty object if there is no id
    }

    public PersonDto getPerson() {
        return person;
    }

    public String save() {
        // TODO: save person using personService and go to the start page
        return null;
    }

    public String delete() {
        // TODO: delete person using personService and go to the start page
        return null;
    }

    public String back() {
        // TODO: go to the start page. Use Page class to get the url
        return null;
    }
}
