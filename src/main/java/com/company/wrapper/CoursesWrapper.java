package com.company.wrapper;

import com.company.entity.CourseEntity;

import java.util.List;

public class CoursesWrapper {
    List<CourseEntity> courses;

    public CoursesWrapper(List<CourseEntity> courses) {
        this.courses = courses;
    }

}
