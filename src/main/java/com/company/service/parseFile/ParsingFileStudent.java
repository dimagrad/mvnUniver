package com.company.service.parseFile;

import com.company.entity.StudentEntity;
import com.company.service.entityService.StudentEntityService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ParsingFileStudent implements Callable<List<StudentEntity>> {

    private List<StudentEntity> students = new ArrayList<>();

    public List<StudentEntity> call () throws Exception{

        JSONParser jsonParser = new JSONParser();


        try(FileReader file = new FileReader("src/main/resources/Students_add.json")) {

            JSONObject studentsJsonObject = (JSONObject) jsonParser.parse(file);
            JSONArray studentsJsonArray = (JSONArray) studentsJsonObject.get("students");

            for (Object studentss: studentsJsonArray){

                JSONObject studentJSON = (JSONObject) studentss;
                String jsonName = (String)studentJSON.get("name");
                long jsonAge = (long)studentJSON.get("age");
                String jsonNumber = (String)studentJSON.get("number");
                students.add(StudentEntityService.createStudent(jsonName,jsonAge,jsonNumber));

            }

        }catch (Exception e){

            System.out.println("file reader bug");
        }
        return students;

    }

}
