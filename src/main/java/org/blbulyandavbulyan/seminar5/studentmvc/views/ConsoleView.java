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
        ps.println(rb.getString("messages.result"));
        displayStudents(students);
    }

    @Override
    public Student selectStudentForDelete(Collection<Student> students) {
        ps.println(rb.getString("questions.select_student_for_deleting"));
        displayStudents(students);
        while (true) {
            ps.print(rb.getString("questions.input_student_id_for_deleting"));
            int idForDelete = scanner.nextInt();
            scanner.nextLine();
            try {
                return students.stream()
                        .filter(student -> student.getId().equals(idForDelete))
                        .findFirst().orElseThrow(() -> new IllegalArgumentException(rb.getString("errors.you_entered_wrong_id")));
            } catch (IllegalArgumentException e) {
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
        ps.print(rb.getString("messages.enter_student_name"));
        String name = scanner.nextLine();
        ps.print(rb.getString("messages.enter_student_age"));
        int age = scanner.nextInt();
        scanner.nextLine();
        return new Student(name, age);
    }

    @Override
    public Command getCommand() {
        ps.print(rb.getString("messages.enter_command"));
        String inputCommand;
        inputCommand = scanner.nextLine().toUpperCase();
        return Command.valueOf(inputCommand);
    }
}
