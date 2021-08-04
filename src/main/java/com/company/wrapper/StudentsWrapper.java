package com.company.wrapper;

import com.company.entity.CourseEntity;
import com.company.entity.Mark;
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

    public boolean addCourse(StudentEntity student, CourseEntity course) {

        if (student.getCourses().contains(course)) {

            return false;
        }

        if ((student.getCourses().size() < 3)) {

            student.setCourse(course);
            int i = student.getCourses().size() - 1;
            for (int j = 0; j < student.getSizeOfMarks(i); j++) {
                student.setMark(i, j, Mark.getRandom());
            }
            System.out.println("студенту записан курс и такие оценки : ");
            for (int j1 = 0; j1 < student.getSizeOfMarks(i); j1++) {
                System.out.println(student.getMarks(i, j1));
            }

            return true;

        } else {
            return false;
        }


    }

    public boolean getHigher(Mark mark[][]) {
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[i].length; j++) {
                if (mark[i][j].getMark() < Mark.D.getMark()) {
                    return false;
                }
            }
        }
        return true;
    }
}


