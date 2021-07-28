package com.company.wrapper;

import com.company.entity.StudentEntity;

import java.util.List;

public class StudentsWrapper {
    private List<StudentEntity> students;

    public StudentsWrapper(List<StudentEntity> students) {

        this.students = students;
    }

    public void addStudent(StudentEntity student) {

        if (!students.contains(student)) {

            students.add(student);
            System.out.println(student.getName() + " добавлен");

        } else {

            System.out.println(student.getName() + " существует");
        }
    }

    public StudentEntity getStudent(int index) {

        return this.students.get(index);
    }

    public List<StudentEntity> getStudents() {

        return students;
    }

    public void printStudents() {

        System.out.println("Список студентов: \n");

        for (StudentEntity student : students) {

            System.out.println(student);
        }
    }
}
