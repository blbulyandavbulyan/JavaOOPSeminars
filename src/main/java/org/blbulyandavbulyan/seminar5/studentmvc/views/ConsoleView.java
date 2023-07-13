package org.blbulyandavbulyan.seminar5.studentmvc.views;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar5.studentmvc.controllers.Command;
import org.blbulyandavbulyan.seminar5.studentmvc.controllers.IView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleView implements IView {
    private final PrintStream ps;
    private final Scanner scanner;
    private final ResourceBundle rb;

    public ConsoleView(PrintStream ps, InputStream is, ResourceBundle rb) {
        this.ps = ps;
        scanner = new Scanner(is);
        this.rb = rb;
    }

    @Override
    public void displayStudents(Collection<Student> students) {
        students.forEach(ps::println);
    }

    @Override
    public void updateView(Collection<Student> students) {
        ps.println("Результат: ");
        displayStudents(students);
    }

    @Override
    public Student selectStudentForDelete(Collection<Student> students) {
        ps.println("Выберите из списка студента для удаления: ");
        displayStudents(students);
        ps.print("Введите ИД студента для удаления: ");
        int idForDelete = scanner.nextInt();
        while (true){
            try {
                return students.stream().filter(student -> student.getId().equals(idForDelete)).findFirst().orElseThrow(() -> new IllegalArgumentException("Выв ввели ИД которого нет в списке!"));
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Student selectStudentForUpdate(Collection<Student> students) {
        return null;
    }

    @Override
    public Student getStudentForAdd() {
        ps.print("Введите имя студента: ");
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        return new Student(name, age);
    }

    @Override
    public Command getCommand() {
        String inputCommand = scanner.nextLine().toUpperCase();
        return Command.valueOf(inputCommand);
    }
}
