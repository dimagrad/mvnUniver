package com.company.entity;

import lombok.Data;

import java.util.List;
@Data
public class CourseEntity {

    private int pte;
    private String name;
    private List<StudentEntity> students = null;
    private Integer points;
    private Integer maxHours;

    public CourseEntity(int pte, String name, Integer points, Integer maxHours) {

        this.pte = pte;
        this.name = name;
        this.points = points;
        this.maxHours = maxHours;

    }

@Override
    public String toString(){
        if (students == null)
            return "Название курса: " + name + " Мест: " + pte + " Важность: " + points + " Кол-во часов: " + maxHours;
        else
            return "Название курса: " + name + " Мест: " + pte + " Важность: " + points + " Кол-во часов: " + maxHours + " Студенты на курсе: " + students;
}

}
