package com.gepardec.jeetestapp.ui.service;

import com.gepardec.jeetestapp.domain.Person;
import com.gepardec.jeetestapp.service.PersonService;
import com.gepardec.jeetestapp.ui.model.Mapper;
import com.gepardec.jeetestapp.ui.model.PersonDto;
import com.gepardec.jeetestapp.utils.Duration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class GuiPersonService {

    @Inject
    private PersonService personService;

    @Inject
    private Mapper mapper;

    public List<PersonDto> getPersons() {
        return mapper.personToDto(personService.getAllPersons());
    }

    @Duration
    public PersonDto findPersonById(Long id) {
        return mapper.personToDto(personService.getPersonById(id));
    }

    public PersonDto save(PersonDto personDto) {
        Person person;
        if (personDto.getId() == null) {
            person = personService.addPerson(personDto.getFirstName(), personDto.getLastName());
        } else {
            person = personService.modifyPerson(personDto.getId(), personDto.getFirstName(), personDto.getLastName());
        }

        return mapper.personToDto(person);
    }

    public void remove(Long personId) {
        personService.deletePerson(personId);
    }
}
