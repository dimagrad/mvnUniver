package com.company.service.parseFile;

import com.company.entity.StudentEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ParsingFile implements Callable<List<StudentEntity>> {

    private File file;
    private List<StudentEntity> students = new ArrayList<>();
    private StudentHandler studentHandler = new StudentHandler();

    public List<StudentEntity> call () throws Exception{

        file = new File("src/resources/Student_add.txt");
        return getStudents();

    }
    public List<StudentEntity> getStudents() throws IOException {

        for (String student: new ReadLine(file).getLines()){

            students.add(studentHandler.handleStudent(student));

        }
        System.out.println("Студенты считаны");
        return students;
    }
}
