package com.company.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentEntity {

    private String name;
    private long age;
    private String number;
    private Mark[][] marks = new Mark[3][5];
    private List<CourseEntity> courses;

    public StudentEntity(String name, long age, String number) {

        this.name = name;
        this.age = age;
        this.number = number;
        courses = new ArrayList<>();
    }

    public boolean addCourse(CourseEntity course) {

        if (courses.contains(course)) {

            return false;
        }

        if ((courses.size() < 3)) {

            courses.add(course);
            int i = courses.size() - 1;
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = Mark.getRandom();
            }
            System.out.println("студенту записан курс и такие оценки : ");
                for (int j1 = 0; j1 < marks[i].length; j1++) {
                    System.out.println(marks[i][j1]);
                }

            return true;

        } else {
            return false;
        }

    }

    @Override
    public String toString() {

        String s = " ";

        if (courses.size() == 0)
            return "Студент: Имя - '" + name + "' Возраст: '" + age
                    + "' Номер телефона: '" + number + "'";
        else
            for (int i = 0; i < courses.size(); i++) {

                s = s + courses.get(i).getName() + ":";

                for (int j = 0; j < marks[i].length; j++) {

                    if (j == marks[i].length - 1) {

                        s = s + marks[i][j] + ";";
                    } else {

                        s = s + marks[i][j] + ",";
                    }
                }

                s = s + " ";
            }
        return "Студент: Имя - '" + name + "' Возраст: '" + age
                + "' Номер телефона: '" + number + "' Курсы: " + s;
    }


    @Override
    public boolean equals(Object student) {

        return this.getName().trim().toLowerCase().equals(((StudentEntity) student).getName().trim().toLowerCase());
    }
}
