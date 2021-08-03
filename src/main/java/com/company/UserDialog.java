package com.company;

import com.company.mock.CourseMock;
import com.company.mock.StudentMock;
import com.company.service.SystemInputService;
import com.company.service.addFromFile.AddFromFile;
import com.company.wrapper.CoursesWrapper;
import com.company.wrapper.StudentsWrapper;

import java.util.concurrent.ExecutionException;

public class UserDialog {

    private StudentsWrapper studentsWrapper;
    private CoursesWrapper coursesWrapper;
    private AddFromFile addFromFile;

    public UserDialog(){
addFromFile = new AddFromFile();
        studentsWrapper = new StudentsWrapper(StudentMock.getStudents());
        coursesWrapper = new CoursesWrapper(CourseMock.getCourses());

    }

    public void startDialog() throws ExecutionException, InterruptedException {

        head();
        int x = 0;

        try {

            x = Integer.parseInt(SystemInputService.readLine());

        } catch (NumberFormatException e) {

            System.out.println("Неверное значение");
            startDialog();
        }

        switch (x) {

            case 1:

                System.out.println("\n");
                studentsWrapper.printStudents();
                break;

            case 2:
                addFromFile.adding(studentsWrapper,coursesWrapper);

                break;
            case 3:

                System.out.println("\n");
                coursesWrapper.printCourses();
                break;

            default:
                System.out.println("Неверный выбор");
        }
        System.out.println("\n");
        startDialog();
    }


    public void head() {

        System.out.println("Выберите что вы хотите:");
        System.out.println("1: Посмотреть всех студентов");
        System.out.println("2: Запись студентов и курсов в программу");
        System.out.println("3: Посмотреть все курсы");

    }

}
