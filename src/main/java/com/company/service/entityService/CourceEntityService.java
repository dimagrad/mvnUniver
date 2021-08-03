package com.company.service.entityService;

import com.company.entity.CourseEntity;

public class CourceEntityService {

    public static CourseEntity createCource(long pte, String name, long points, long maxHours) {

        return new CourseEntity(pte, name, points, maxHours);
    }
}
