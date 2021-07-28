package com.company.service.parseFile;

import com.company.entity.StudentEntity;
import com.company.service.StudentEntityService;

import java.util.regex.Pattern;

public class StudentHandler {
    String[] fields;
    private Pattern p = Pattern.compile("'");
    public StudentEntity handleStudent(String string){
        try {

            fields = p.split(string);
            if (validation(fields)) {

                return StudentEntityService.createStudent(fields[1], Integer.parseInt(fields[3]), fields[5]);
            } else {

                System.out.println("Неверный формат данных у " + fields[1]);
            }
        }
        catch(IndexOutOfBoundsException e){

            System.out.println("Неверный формат данных");
        }
        return null;
    }

    public boolean validation(String[] a){
        try {

            if ((a[0].contains("Студент: Имя - ")) & (a[2].contains("Возраст: ")) & (a[4].contains("Номер телефона: "))) {

                return true;

            } else {

                return false;

            }
        }
        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("Неверный формат данных");
        }
        catch(IndexOutOfBoundsException e){

            System.out.println("Неверный формат данных");
        }
        return false;
    }
}
