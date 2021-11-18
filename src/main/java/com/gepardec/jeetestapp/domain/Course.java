/*
 * Copyright 2020 Gepardec IT Services GmbH and the CheetUnit contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.gepardec.jeetestapp.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_generator", sequenceName = "sequence_course", allocationSize = 1)
    @GeneratedValue(generator = "course_generator", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Transient
    private Person teacher;

    @Column()
    private LocalDate start;

    @Column()
    private Integer duration;

    @Transient
    private Set<Person> participants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        if (teacher == this.teacher) {
            return;
        }
        final Person oldTeacher = this.teacher;

        this.teacher = teacher;
        if (oldTeacher != null) {
            oldTeacher.removeFromCoursesTeached(this);
        }
        if (teacher != null) {
            teacher.addToCoursesTeached(this);
        }
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public Set<Person> getParticipants() {
        return participants;
    }

    public void addParticipant(final Person participant) {
        this.participants.add(participant);
        participant.getCoursesParticipating().add(this);
    }

    public void removeParticipant(final Person participant) {
        this.participants.remove(participant);
        participant.getCoursesParticipating().remove(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setParticipants(Set<Person> participants) {
        this.participants = participants;
    }

    public Integer getDuration() {
        return 1;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
