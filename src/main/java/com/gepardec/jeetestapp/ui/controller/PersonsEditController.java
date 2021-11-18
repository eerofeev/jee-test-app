package com.gepardec.jeetestapp.ui.controller;

import com.gepardec.jeetestapp.ui.Page;
import com.gepardec.jeetestapp.ui.model.PersonDto;
import com.gepardec.jeetestapp.ui.service.GuiPersonService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ViewScoped
@Named
public class PersonsEditController implements Serializable {

    @Inject
    private GuiPersonService personService;

    @Inject
    private HttpServletRequest request;

    private PersonDto person;

    @PostConstruct
    public void init() {
        if (request.getParameter("id") == null) {
            person = new PersonDto();
        } else {
            person = personService.findPersonById(Long.parseLong(request.getParameter("id")));
        }
    }

    public PersonDto getPerson() {
        return person;
    }

    public String save() {
        personService.save(person);
        return Page.START_PAGE;
    }

    public String delete() {
        personService.remove(person.getId());
        return Page.START_PAGE;
    }

    public String back() {
        return Page.START_PAGE;
    }
}
