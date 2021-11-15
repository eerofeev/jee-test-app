package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Factory {

    public static final AtomicLong id = new AtomicLong();

    public static Person createPerson(String firstName, String lastName){
        var person = new Person();
        person.setId(id.incrementAndGet());
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    public static Course createCourse(String name, LocalDateTime start, int duration){
        var course = new Course();
        course.setId(id.incrementAndGet());
        course.setName(name);
        course.setStart(start);
        course.setDuration(duration);
        return course;
    }

}
