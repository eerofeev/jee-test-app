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

    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setup() {
        Person person = Factory.createPerson("Jack", "Johnson");
        person.setId(1L);
        List<Person> persons = new ArrayList<>();

        when(personDao.findById(person.getId())).thenReturn(person);
        when(personDao.update(any(Person.class))).thenAnswer((Answer<Person>) invocationOnMock -> invocationOnMock.getArgument(0));
    }

    @Test
    void getAllCourses() {
        var person = personService.getPersonById(1L);
        assertNotNull(person);
        assertEquals("Jack", person.getFirstName());

        Person modified = personService.modifyPerson(1L, "John", "Jackson");
        assertEquals(modified.getLastName(), "Jackson");
    }
}