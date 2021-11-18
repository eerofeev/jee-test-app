package com.gepardec.jeetestapp.ui.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CourseDto implements Serializable {
    private Long id;
    private String name;
    private PersonDto teacher;
    private LocalDate start;
    private Integer duration;
    private Set<PersonDto> participants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDto getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonDto teacher) {
        this.teacher = teacher;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<PersonDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<PersonDto> participants) {
        this.participants = participants;
    }

    public LocalDate getEnd() {
        if (start != null) {
            return start.plusDays(duration);
        }

        return null;
    }
}
