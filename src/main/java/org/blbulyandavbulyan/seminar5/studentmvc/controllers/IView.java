package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

public interface IView {
    void displayStudents(Collection<Student> students);
    void updateView(Collection<Student> students);
    Student selectStudentForDelete();
    Student selectStudentForUpdate();
    Student getStudentForAdd();
    Command getCommand();
}
