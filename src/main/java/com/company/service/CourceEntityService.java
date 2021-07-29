package com.company.service;

import com.company.entity.CourseEntity;

public class CourceEntityService {

    public static CourseEntity createCource(int pte, String name, Integer points, Integer maxHours) {

        return new CourseEntity(pte, name, points, maxHours);
    }
}
