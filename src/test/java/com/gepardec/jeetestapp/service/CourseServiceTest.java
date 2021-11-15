package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;
import com.gepardec.jeetestapp.domain.dao.CourseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseDao courseDao;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    public void setup(){
        Course course1 = Factory.createCourse("test", LocalDateTime.now(), 1);
        Person teacher = Factory.createPerson("Teacher", "1");
        Person participant = Factory.createPerson("Student", "1");
        course1.setTeacher(teacher);
        course1.setParticipants(Set.of(participant));
        List<Course> courses = new ArrayList<>();
        courses.add(course1);

        when(courseDao.findAll()).thenReturn(courses);
    }

    @Test
    void getAllCourses() {
        List<Course> allCourses = courseService.getAllCourses();
        assertEquals(1, allCourses.size());
    }
}