package com.gepardec.jeetestapp.ui.controller;

import com.gepardec.jeetestapp.ui.model.CourseDto;
import com.gepardec.jeetestapp.ui.service.GuiCourseService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Comparator;
import java.util.List;

@RequestScoped
@Named
public class CoursesController {

    @Inject
    private GuiCourseService courseService;

    private List<CourseDto> courses;

    public List<CourseDto> getCourses() {
        if (courses == null) {
            courses = courseService.getCourses();
            courses.sort(Comparator.comparing(CourseDto::getName));
        }

        return courses;
    }

}
