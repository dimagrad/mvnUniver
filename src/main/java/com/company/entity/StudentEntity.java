package com.company.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentEntity {

    private String name;
    private long age;
    private String number;
    private List<Mark[]> marks;
    private List<CourseEntity> courses;
    private List<Long> attendance;

    public StudentEntity(String name, long age, String number) {

        this.name = name;
        this.age = age;
        this.number = number;
        courses = new ArrayList<>();
        marks = new ArrayList<>();
        attendance = new ArrayList<>();
    }

    public List<Long> getAttendance() {
        return attendance;
    }

    public void setAttendance(Long hours) {
        attendance.add(hours);
    }

    public List<CourseEntity> getCourses() {

        return courses;
    }

    public void setCourse(CourseEntity course) {

        courses.add(course);

    }

    public void setMark(Mark[] mark) {

        marks.add(mark);

    }

    public List<Mark[]> getAllMarks() {

        return marks;
    }



    @Override
    public String toString() {

        Mark[] mark;
        String s = " ";


        if (courses.size() == 0)
            return "Студент: Имя - '" + name + "' Возраст: '" + age
                    + "' Номер телефона: '" + number + "'";
        else
            for (int i = 0; i < courses.size(); i++) {

                s = s + courses.get(i).getName() + ":";
                mark = marks.get(i);

                for (int j = 0; j < mark.length; j++) {

                    if (j == mark.length - 1) {

                        s = s + mark[j] + ";";
                    } else {

                        s = s + mark[j] + ",";
                    }
                }

                s = s + " Посещаемость: " + attendance.get(i) + " из " + courses.get(i).getMaxHours() + " ";
            }
        return "Студент: Имя - '" + name + "' Возраст: '" + age
                + "' Номер телефона: '" + number + "' Курсы: " + s;
    }


    @Override
    public boolean equals(Object student) {

        return this.getName().trim().toLowerCase().equals(((StudentEntity) student).getName().trim().toLowerCase());
    }
}
