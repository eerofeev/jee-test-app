/*
 * Copyright 2020 Gepardec IT Services GmbH and the CheetUnit contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;
import io.github.cheetunit.test.BaseServiceInvoker;

import javax.inject.Inject;
import java.util.List;

public class CourseServiceInvoker extends BaseServiceInvoker {

    @Inject
    private CourseService service;

    public Course getCourseById(Long id) {
       return service.getCourseById(id);
    }
}
