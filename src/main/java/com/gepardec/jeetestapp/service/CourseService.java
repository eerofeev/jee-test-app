package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Course;
import com.gepardec.jeetestapp.domain.Person;
import com.gepardec.jeetestapp.domain.dao.CourseDao;
import com.gepardec.jeetestapp.domain.dao.PersonDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CourseService {

    @Inject
    private CourseDao courseDao;

    @Inject
    private PersonDao personDao;

    public List<Course> getAllCourses(){
        return courseDao.findAll();
    }

    public Course addNewParticipant(Long courseId, Long personId){
        Person participant = personDao.findById(personId);
        Course course = courseDao.findById(courseId);
        if(course.getParticipants().contains(participant)){
            return course;
        } else {
            course.getParticipants().add(participant);
            return courseDao.update(course);
        }
    }

    public Course removeParticipant(Long courseId, Long personId){
        Person participant = personDao.findById(personId);
        Course course = courseDao.findById(courseId);
        if(!course.getParticipants().contains(participant)){
            return course;
        } else {
            course.getParticipants().remove(participant);
            return courseDao.update(course);
        }
    }
}
