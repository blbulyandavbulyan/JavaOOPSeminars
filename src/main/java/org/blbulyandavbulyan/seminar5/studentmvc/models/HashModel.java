package org.blbulyandavbulyan.seminar5.studentmvc.models;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar5.studentmvc.controllers.IModel;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashModel implements IModel {
    private final Map<Integer, Student> idToStudent = new HashMap<>();
    private Integer nextId = 0;
    @Override
    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(idToStudent.values());
    }

    @Override
    public void add(Student student) {
        int studentID = ++nextId;
        student.setId(studentID);
        idToStudent.put(studentID, student);
    }

    @Override
    public void update(Student student) {
        if (idToStudent.containsKey(student.getId())) idToStudent.replace(student.getId(), student);
        else throw new IllegalArgumentException("student with given id doesn't exists in model!");
    }

    @Override
    public void delete(Student student) {
        if (idToStudent.containsKey(student.getId())) idToStudent.remove(student.getId());
        else throw new IllegalArgumentException("student with given id doesn't exists in model!");
    }
}
