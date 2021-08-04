package com.company.wrapper;

import com.company.entity.CourseEntity;
import com.company.entity.Except;
import com.company.entity.StudentEntity;

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
        if (!courses.contains(course)){

            courses.add(course);

        } else {

            System.out.println("Курс уже существует");
        }

    }

    public boolean addStudent(StudentEntity student, CourseEntity course) {

        if (course.getStudents().contains(student)){

            System.out.println("Cтудент уже добавлен");
            return false;
        }

        if (course.getStudents().size() < course.getPte()) {


            course.setStudent(student);
            return true;

        } else {

            System.out.println("Места заняты");
            return false;
        }
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
