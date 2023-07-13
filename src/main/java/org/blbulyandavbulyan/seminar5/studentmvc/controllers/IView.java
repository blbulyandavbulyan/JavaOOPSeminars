package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

public interface IView {
    void displayStudents(Collection<Student> students);
    void update(Collection<Student> students);
    Student selectStudentForDelete(Collection<Student> students);
    Student selectStudentForUpdate(Collection<Student> students);
    Student getStudentForAdd();
    Command getCommand();
}
