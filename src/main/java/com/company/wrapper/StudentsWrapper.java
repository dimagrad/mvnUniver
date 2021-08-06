package com.company.wrapper;

import com.company.entity.CourseEntity;
import com.company.entity.Mark;
import com.company.entity.StudentEntity;

import java.util.List;

public class StudentsWrapper {
    private List<StudentEntity> students;
    private Mark[] mark;

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

            mark = new Mark[5];
            student.setCourse(course);
            System.out.println("студенту записан курс и такие оценки : ");

            for (int j = 0; j < mark.length; j++) {

                mark[j] = Mark.getRandom();
                System.out.println(mark[j]);
            }
            student.setMark(mark);
            System.out.println("студенту записан курс и такие оценки : ");
            switch (student.getCourses().size()) {
                case 1:
                    student.setAttendance(course.getMaxHours());
                    break;
                case 2:
                    student.setAttendance(course.getMaxHours() - 1);
                    break;
                case 3:
                    student.setAttendance(course.getMaxHours() - 2);
                    break;
                default:
                    break;

            }
            return true;

        } else {

            return false;
        }

    }

    public boolean getHigherTwo(List<Mark[]> mark) {
        if (mark.size() == 0) {
            return false;
        }
        Mark[] marks = new Mark[5];
        for (int i = 0; i < mark.size(); i++) {
            marks = mark.get(i);

            for (int j = 0; j < marks.length; j++) {
                if (marks[j].getMark() < Mark.D.getMark()) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getAverage(List<Mark[]> marks) {

        if (marks.isEmpty())
            return 0;

        double average = 0;
        int sum = 0;
        Mark[] mark = new Mark[5];

        for (int i = 0; i < marks.size(); i++) {

            mark = marks.get(i);
            for (int j = 0; j < mark.length; j++) {

                sum = sum + mark[j].getMark();
            }

        }
        average = sum / (marks.size() * 5);

        return average;
    }

    public boolean goodAttendance(StudentEntity student) {

        if (student.getAttendance().size() == 0) return false;

        int k = 0;

        for (int i = 0; i < student.getAttendance().size(); i++) {

            if (!(student.getAttendance().get(i) == student.getCourses().get(i).getMaxHours())) {

                k++;
            }
        }
        return k == 0 ? true : false;
    }

    public boolean checkMark(double sr, Mark m) {

        if ((sr > m.getMark() - 10) & (sr < m.getMark() + 10))
            return true;
        else
            return false;
    }

    public double getPerfomanceMark(StudentEntity student) {

        if (student.getCourses().isEmpty()) return 0;

        List<Mark[]> marks = student.getAllMarks();
        Mark[] mark;
        List<CourseEntity> courses = student.getCourses();

        int sum = 0;
        double sr;
        double perfomance = 0;

        for (int i = 0; i < courses.size(); i++) {

            mark = marks.get(i);

            for (int j = 0; j < mark.length; j++) {

                sum += mark[j].getMark();
            }

            sr = sum / mark.length;
            sum = 0;
            perfomance += sr * courses.get(i).getPoints();
        }

        perfomance = perfomance / courses.size();

        return perfomance;
    }

    public double getPercentAttendance(StudentEntity student) {

        if (student.getCourses().isEmpty()) return 0;

        List<Long> attendance = student.getAttendance();
        List<CourseEntity> courses = student.getCourses();
        double sr = 0;

        for (int i = 0; i < courses.size(); i++) {

            sr += (100 / courses.get(i).getMaxHours()) * attendance.get(i);
        }
        sr = sr / courses.size();

        return sr;
    }
}



