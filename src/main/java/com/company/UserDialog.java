package com.company;

import com.company.entity.Mark;
import com.company.entity.StudentEntity;
import com.company.mock.CourseMock;
import com.company.mock.StudentMock;
import com.company.service.AddStudentToCourse;
import com.company.service.SystemInputService;
import com.company.service.addFromFile.AddFromFile;
import com.company.wrapper.CoursesWrapper;
import com.company.wrapper.StudentsWrapper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class UserDialog {

    private AddStudentToCourse addStudentToCourse;
    private StudentsWrapper studentsWrapper;
    private CoursesWrapper coursesWrapper;
    private AddFromFile addFromFile;

    public UserDialog() {

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
                addFromFile.adding(studentsWrapper, coursesWrapper);

                break;
            case 3:

                System.out.println("\n");
                coursesWrapper.printCourses();
                break;

            case 4:

                addStudentToCourse.addStudentToCourse(studentsWrapper, coursesWrapper);
                break;
            case 5:
                List<StudentEntity> without3 = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.getHigherTwo(z.getAllMarks())).collect(Collectors.toList());
                //List<StudentEntity> without4 = studentsWrapper.getStudents().stream().filter(st-> st.getAllMarks().stream().filter(m -> m < Mark.C).collect(Collectors.toList()).size==0);
                for (StudentEntity studentEntity : without3) {
                    System.out.println(studentEntity);
                }
                break;

            case 6:
                Map<String, Double> notSorted = studentsWrapper.getStudents().stream().collect(Collectors.toMap(StudentEntity::getName, z -> studentsWrapper.getAverage(z.getAllMarks())));
                System.out.println(notSorted);

                List<String> sorted = notSorted.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).map(Map.Entry::getKey).collect(Collectors.toList());
                //notSorted.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(System.out::println);
                break;

            case 7:

                List<StudentEntity> withMaxHours = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.goodAttendance(z)).collect(Collectors.toList());

                for (StudentEntity studentEntity : withMaxHours) {
                    System.out.println(studentEntity);
                }
                break;

            case 8:

                List<String> excelent = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.checkMark(studentsWrapper.getAverage(z.getAllMarks()), Mark.A)).map(StudentEntity::getName).collect(Collectors.toList());
                System.out.println("на отлично " + excelent);

                List<String> good = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.checkMark(studentsWrapper.getAverage(z.getAllMarks()), Mark.B)).map(StudentEntity::getName).collect(Collectors.toList());
                System.out.println("хорошо " +good);

                List<String> normal = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.checkMark(studentsWrapper.getAverage(z.getAllMarks()), Mark.C)).map(StudentEntity::getName).collect(Collectors.toList());
                System.out.println("Нормально " +normal);

                List<String> goodBye = studentsWrapper.getStudents().stream().filter(z -> studentsWrapper.checkMark(studentsWrapper.getAverage(z.getAllMarks()), Mark.D)).map(StudentEntity::getName).collect(Collectors.toList());
                System.out.println("отчислен " +goodBye);

                break;

            case 9:

                Map<String, Double> perfomanceNotSorted = studentsWrapper.getStudents().stream().collect(Collectors.toMap(StudentEntity::getName, z -> studentsWrapper.getPerfomanceMark(z)*(studentsWrapper.getPercentAttendance(z)/100)));//sr*points *%attendance
                //System.out.println(perfomanceNotSorted);
                perfomanceNotSorted.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(System.out::println);

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
        System.out.println("5: Студенты у которых нет 3");
        System.out.println("6: Студенты отсортированные по среднему балу");
        System.out.println("7: Студенты без пропусков");
        System.out.println("8: Разбивание на 4 списка");
        System.out.println("9: Рейтинг успеваемости");


    }

}
