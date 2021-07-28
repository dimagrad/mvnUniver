package com.company;

import com.company.entity.StudentEntity;
import com.company.mock.StudentMock;
import com.company.service.SystemInputService;
import com.company.service.parseFile.ParsingFile;
import com.company.wrapper.StudentsWrapper;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UserDialog {

    private StudentsWrapper studentsWrapper;

    public UserDialog(){

        studentsWrapper = new StudentsWrapper(StudentMock.getStudents());

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

                System.out.println("\n");
                Callable<List <StudentEntity>> callable = new ParsingFile();
                FutureTask futureTask = new FutureTask(callable);
                new Thread(futureTask).start();

                List<StudentEntity> students = (List<StudentEntity>) futureTask.get();

                for (StudentEntity studenta : students)
                    if (studenta !=null)
                        studentsWrapper.addStudent(studenta);
                System.out.println("Все студенты записаны");
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
        System.out.println("2: Запись студентов в программу");
    }

}
