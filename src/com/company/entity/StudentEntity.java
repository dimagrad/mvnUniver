package com.company.entity;

import lombok.Data;

@Data
public class StudentEntity {

    private String name;
    private int age;
    private String number;
    private Integer id = 0;

    public StudentEntity(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;

    }

    @Override
    public String toString() {

        return "Студент: Имя - '" + name + "' Возраст: '" + age
                + "' Номер телефона: '" + number + "' ID = " + id;
    }


    @Override
    public boolean equals(Object student) {

        return this.getName().trim().toLowerCase().equals(((StudentEntity) student).getName().trim().toLowerCase());
    }
}
