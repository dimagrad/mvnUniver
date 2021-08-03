package com.company.service.entityService;

import com.company.entity.StudentEntity;

public class StudentEntityService {
    public static StudentEntity createStudent(String name, long age, String number) {

        return new StudentEntity(name, age, number);
    }
}
