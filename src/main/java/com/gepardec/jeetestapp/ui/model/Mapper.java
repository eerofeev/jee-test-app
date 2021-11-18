package com.gepardec.jeetestapp.ui.model;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class Mapper {

    public PersonDto personToDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        return dto;
    }

    public List<PersonDto> personToDto(List<Person> persons) {
        return persons.stream().map(this::personToDto).collect(Collectors.toList());
    }

    public Set<PersonDto> personToDto(Set<Person> persons) {
        return persons.stream().map(this::personToDto).collect(Collectors.toSet());
    }

    public CourseDto courseToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setDuration(course.getDuration());
        dto.setTeacher(personToDto(course.getTeacher()));
        dto.setName(course.getName());
        dto.setParticipants(this.personToDto(course.getParticipants()));
        dto.setStart(course.getStart());
        dto.setId(course.getId());
        return dto;
    }

    public List<CourseDto> courseToDto(List<Course> courses) {
        return courses.stream().map(this::courseToDto).collect(Collectors.toList());
    }

    public Set<CourseDto> courseToDto(Set<Course> courses) {
        return courses.stream().map(this::courseToDto).collect(Collectors.toSet());
    }

    public Person dtoToPerson(PersonDto dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        return person;
    }

    public List<Person> dtoToPerson(List<PersonDto> dtos) {
        return dtos.stream().map(this::dtoToPerson).collect(Collectors.toList());
    }

    public Set<Person> dtoToPerson(Set<PersonDto> dtos) {
        return dtos.stream().map(this::dtoToPerson).collect(Collectors.toSet());
    }

    public Course dtoToCourse(CourseDto dto) {
        Course course = new Course();
        course.setDuration(dto.getDuration());
        course.setTeacher(dtoToPerson(dto.getTeacher()));
        course.setName(dto.getName());
        course.setParticipants(this.dtoToPerson(dto.getParticipants()));
        course.setStart(dto.getStart());
        course.setId(dto.getId());
        return course;
    }

    public List<Course> dtoToCourse(List<CourseDto> dtos) {
        return dtos.stream().map(this::dtoToCourse).collect(Collectors.toList());
    }

    public Set<Course> dtoToCourse(Set<CourseDto> dtos) {
        return dtos.stream().map(this::dtoToCourse).collect(Collectors.toSet());
    }

}
