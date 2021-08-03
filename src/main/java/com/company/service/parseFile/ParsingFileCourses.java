package com.company.service.parseFile;

import com.company.entity.CourseEntity;
import com.company.service.entityService.CourceEntityService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ParsingFileCourses implements Callable<List<CourseEntity>>{

        private List<CourseEntity> courses = new ArrayList<>();

        public List<CourseEntity> call () throws Exception{

            JSONParser jsonParser = new JSONParser();


            try(FileReader file = new FileReader("src/main/resources/Courses_add.json")) {

                JSONObject coursesJsonObject = (JSONObject) jsonParser.parse(file);
                JSONArray coursesJsonArray = (JSONArray) coursesJsonObject.get("courses");

                for (Object course: coursesJsonArray){

                    JSONObject courseJSON = (JSONObject) course;
                    String jsonName = (String)courseJSON.get("name");
                    long jsonPte = (long)courseJSON.get("pte");
                    long jsonPoints = (long)courseJSON.get("points");
                    long jsonMaxHours = (long)courseJSON.get("maxHours");
                    courses.add(CourceEntityService.createCource(jsonPte,jsonName, jsonPoints, jsonMaxHours));

                }

            }catch (Exception e){

                System.out.println("file reader bug");
            }
            return courses;

        }

    }

