package com.company;

import com.company.entity.StudentEntity;
import com.company.mock.CourseMock;
import com.company.mock.StudentMock;
import com.company.service.AddStudentToCourse;
import com.company.service.SystemInputService;
import com.company.service.addFromFile.AddFromFile;
import com.company.wrapper.CoursesWrapper;
import com.company.wrapper.StudentsWrapper;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class UserDialog {

    private AddStudentToCourse addStudentToCourse;
    private StudentsWrapper studentsWrapper;
    private CoursesWrapper coursesWrapper;
    private AddFromFile addFromFile;

    public UserDialog(){

        addStudentToCourse = new AddStudentToCourse();
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

            case 4:

                addStudentToCourse.addStudentToCourse(studentsWrapper,coursesWrapper);
                break;
            case 5:
               List<StudentEntity> without3 = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.getHigher(z.getAllMarks())).collect(Collectors.toList());
                for (StudentEntity studentEntity : without3) {
                    System.out.println(studentEntity);
                }
                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

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
        System.out.println("4: Добавить студента на курс");
        System.out.println("5 Студенты у которых нет 3");
        System.out.println("6: Студенты отсортированные по среднему балу");
        System.out.println("7: Студенты без пропусков");
        System.out.println("8: Разбивание на 4 списка");


    }

}
