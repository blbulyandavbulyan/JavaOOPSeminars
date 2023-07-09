package org.blbulyandavbulyan.seminar3.studentapp;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar3.studentapp.domen.StudentGroup;
import org.blbulyandavbulyan.seminar3.studentapp.domen.StudentStream;

import java.util.List;

/**
 * Класс содержащий точку входа в приложение
 */
public class Main {
    public static void main(String[] args) {
        StudentStream studentStream = createStudentStream();
        //печатаем через toString весь studentStream
        System.out.println("Не отсортировано:");
        System.out.println(studentStream);
        System.out.println("Отсортировано по размеру группы:");
        studentStream.sort();
        //печатаем через for тот же studentStream
        printStudentStream(studentStream);
        //а теперь отсортируем сначала по размеру группы, а потом по ИД группы
        studentStream.sortByGroupSizeAndThanByGroupIdentifier();
        System.out.println("Отсортированные по размеру группы и ИД:");
        printStudentStream(studentStream);
    }

    /**
     * Печатает studentStream используя цикл for
     * @param studentStream поток студентов, который нужно напечатать
     */
    public static void printStudentStream(StudentStream studentStream){
        for (StudentGroup sg : studentStream){
            System.out.println(sg);
        }
    }

    /**
     * Создаёт поток студентов и наполняет его данными
     * @return созданный и заполненный поток студентов
     */
    public static StudentStream createStudentStream(){
        StudentGroup group1 = new StudentGroup(List.of(new Student("Георгий", 19, 1), new Student("Борис", 20, 2), new Student("Анатолий", 20, 3)), 1);
        StudentGroup group2 = new StudentGroup(List.of(new Student("Андрей", 20, 4), new Student("Евгений", 21, 5)), 2);
        StudentGroup group3 = new StudentGroup(List.of(new Student("Алексей", 20, 6), new Student("Эдуард", 21, 7)), 3);
        StudentStream studentStream = new StudentStream(1);
        studentStream.add(group2);
        studentStream.add(group1);
        studentStream.add(group3);
        return studentStream;
    }
}
