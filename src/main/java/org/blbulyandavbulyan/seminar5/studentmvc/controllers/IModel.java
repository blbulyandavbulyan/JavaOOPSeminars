package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;

public interface IModel {
    Collection<Student> findAll();
    void add(Student student);
    void update(Student student);
    void delete(Student student);
}
