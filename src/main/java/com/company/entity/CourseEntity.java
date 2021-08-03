package com.company.entity;

import lombok.Data;

import java.util.List;
@Data
public class CourseEntity {

    private long pte;
    private String name;
    private List<StudentEntity> students = null;
    private long points;
    private long maxHours;

    public CourseEntity(long pte, String name, long points, long maxHours) {

        this.pte = pte;
        this.name = name;
        this.points = points;
        this.maxHours = maxHours;

    }
     public boolean addStudent(StudentEntity student){

        if ((this.students.size() < pte) ){
            students.add(student);
            return true;
        } else {
            System.out.println("Места заняты");
            return false;
        }
     }

@Override
    public String toString(){
        if (students == null)
            return "Название курса: " + name + " Мест: " + pte + " Важность: " + points + " Кол-во часов: " + maxHours;
        else
            return "Название курса: " + name + " Мест: " + pte + " Важность: " + points + " Кол-во часов: " + maxHours + " Студенты на курсе: " + students;
}

}
