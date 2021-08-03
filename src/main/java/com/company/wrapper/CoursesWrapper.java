package com.company.wrapper;

import com.company.entity.CourseEntity;
import com.company.entity.Except;

import java.util.List;

public class CoursesWrapper {
    List<CourseEntity> courses;

    public CoursesWrapper(List<CourseEntity> courses) {

        this.courses = courses;
    }

    public List<CourseEntity> getCourses() {

        return courses;
    }

    public void addCourse(CourseEntity course){
        courses.add(course);
    }

    public void printCourses(){
        System.out.println("Список курсов : \n");

        for (CourseEntity course : courses) {

            System.out.println(course);
        }
    }

    public CourseEntity getCourse(int index) throws Exception {

        if (this.courses.size() >= index) {

            return this.courses.get(index);

        } else {

            throw new Except("Слишком много студентов");
        }
    }
}
