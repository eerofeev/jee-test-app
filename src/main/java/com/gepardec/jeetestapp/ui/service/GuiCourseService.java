package com.gepardec.jeetestapp.ui.service;

import com.gepardec.jeetestapp.service.CourseService;
import com.gepardec.jeetestapp.ui.model.CourseDto;
import com.gepardec.jeetestapp.ui.model.Mapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class GuiCourseService {

    @Inject
    private CourseService courseService;

    @Inject
    private Mapper mapper;

    public List<CourseDto> getCourses() {
        return mapper.courseToDto(courseService.getAllCourses());
    }
}
