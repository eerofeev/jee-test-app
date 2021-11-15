/*
 * Copyright 2020 Gepardec IT Services GmbH and the CheetUnit contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;
import io.github.cheetunit.test.CheetUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceIT {

    private static CourseServiceInvoker courseService;

    @BeforeAll
    static void beforeAll() {
        courseService = CheetUnit.createProxy(CourseServiceInvoker.class);
    }


    @Test
    void testGetCourse() {
        Course course = courseService.getCourseById(1L);
        assertNotNull(course);
        assertEquals(2, course.getParticipants().size());
    }

}
