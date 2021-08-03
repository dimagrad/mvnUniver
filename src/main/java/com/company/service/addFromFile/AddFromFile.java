package com.company.service.addFromFile;

import com.company.entity.CourseEntity;
import com.company.entity.StudentEntity;
import com.company.service.parseFile.ParsingFileCourses;
import com.company.service.parseFile.ParsingFileStudent;
import com.company.wrapper.CoursesWrapper;
import com.company.wrapper.StudentsWrapper;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AddFromFile {
    public void adding(StudentsWrapper studentsWrapper, CoursesWrapper coursesWrapper) throws ExecutionException, InterruptedException {
        System.out.println("\n");
        Callable<List<StudentEntity>> callableStudents = new ParsingFileStudent();
        FutureTask futureTaskStudent = new FutureTask(callableStudents);
        new Thread(futureTaskStudent).start();

        List<StudentEntity> students = (List<StudentEntity>) futureTaskStudent.get();

        for (StudentEntity studenta : students)
            if (studenta !=null)
                studentsWrapper.addStudent(studenta);
        System.out.println("Все студенты записаны");

        System.out.println("\n");
        Callable<List <CourseEntity>> callableCourses = new ParsingFileCourses();
        FutureTask futureTaskCourses = new FutureTask(callableCourses);
        new Thread(futureTaskCourses).start();

        List<CourseEntity> courses = (List<CourseEntity>) futureTaskCourses.get();

        for (CourseEntity course : courses)
            if (course !=null)
                coursesWrapper.addCourse(course);
        System.out.println("Все курсы записаны");
    }
}
