package com.company.entity;

import lombok.Data;

import java.util.List;

@Data
public class StudentEntity {

    private String name;
    private long age;
    private String number;
    private Integer[][] marks = new Integer[3][5];
    private List<CourseEntity> courses;

    public StudentEntity(String name, long age, String number) {

        this.name = name;
        this.age = age;
        this.number = number;
    }

    public boolean enterence(CourseEntity course){

        if (courses.size()<3){

            courses.add(course);
            int i = courses.size()-1;
                for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = Mark.getRandom();
                }
            return true;

        }else {
            return false;
        }

    }

    @Override
    public String toString() {

        return "Студент: Имя - '" + name + "' Возраст: '" + age
                + "' Номер телефона: '" + number + "'";
    }


    @Override
    public boolean equals(Object student) {

        return this.getName().trim().toLowerCase().equals(((StudentEntity) student).getName().trim().toLowerCase());
    }
}
