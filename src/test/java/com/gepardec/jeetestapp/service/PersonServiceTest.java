package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Person;
import com.gepardec.jeetestapp.domain.dao.PersonDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    // TODO: create mock
    private PersonDao personDao;

    // TODO: use dao mock in personService
    private PersonService personService;

    @BeforeEach
    public void setup() {
        Person person = Factory.createPerson("Jack", "Johnson");
        person.setId(1L);

        // TODO: configure mocked personDao
    }

    @Test
    void testFindPerson() {
        //TODO: implement test: personService.getPersonById(1L) must return a person with the first name "Jack"
    }
}