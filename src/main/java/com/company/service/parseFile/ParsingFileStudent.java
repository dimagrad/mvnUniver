package com.company.service.parseFile;

import com.company.entity.StudentEntity;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

//import com.fasterxml.jackson.databind.ObjectMapper.


public class ParsingFileStudent implements Callable<List<StudentEntity>> {

    private List<StudentEntity> students = new ArrayList<>();

    public List<StudentEntity> call () throws Exception{

//        JSONParser jsonParser = new JSONParser();
        try(FileReader file = new FileReader("src/resources/Students_add.json")) {
        jsonParser.parse(file);
        }catch (Exception e){
            System.out.println("file reader bug");
        }
        return students;

    }
}
