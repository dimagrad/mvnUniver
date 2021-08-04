package com.company.service;

import com.company.entity.CourseEntity;
import com.company.entity.StudentEntity;
import com.company.wrapper.CoursesWrapper;
import com.company.wrapper.StudentsWrapper;

public class AddStudentToCourse {

    public void studentToCourse(CourseEntity course, StudentEntity student) {

        try {

            if ((course.addStudent(student)) & (student.addCourse(course))) {

                System.out.println("Студент " + student.getName() + " добавлен на предмет " + course.getName());
            }

        } catch (Exception except) {

            System.out.println(except.getMessage());
        }
    }

    public void addStudentToCourse(StudentsWrapper studentsWrapper, CoursesWrapper coursesWrapper) {

        boolean choose;
        CourseEntity chosenCourse;
        StudentEntity chosenStudent;

        do {

            choose = false;
            System.out.println("Выберите студента");
            for (StudentEntity student : studentsWrapper.getStudents()) {

                System.out.println(student);
            }

            int st = Integer.parseInt(SystemInputService.readLine());
            System.out.println("Выберите курс");

            for (CourseEntity cours : coursesWrapper.getCourses()) {

                System.out.println(cours);
            }

            int crs = Integer.parseInt(SystemInputService.readLine());

            try {

                chosenCourse = coursesWrapper.getCourse(crs - 1);
                chosenStudent = studentsWrapper.getStudent(st - 1);
                studentToCourse(chosenCourse, chosenStudent);

            } catch (Exception еxc) {

                System.out.println("Вы ввели неверное значение");
                choose = true;
            }
        } while (choose == true);
    }
}
