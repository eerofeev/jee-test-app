package com.gepardec.jeetestapp.ui.controller;

import com.gepardec.jeetestapp.ui.model.PersonDto;
import com.gepardec.jeetestapp.ui.service.GuiPersonService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@RequestScoped
@Named
public class PersonsController implements Serializable {

    @Inject
    private GuiPersonService personService;

    private List<PersonDto> persons;

    public List<PersonDto> getPersons() {
        if (persons == null) {
            persons = personService.getPersons();
            persons.sort(Comparator.comparing(PersonDto::getLastName));
        }

        return persons;
    }

}
