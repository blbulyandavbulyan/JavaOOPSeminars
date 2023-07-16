package org.blbulyandavbulyan.seminar5.studentmvc.models;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar5.studentmvc.controllers.IModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class ListModel implements IModel {
    private Supplier<Integer> nextIdSupplier;
    private List<Student> students;
    public ListModel(){
        students = new ArrayList<>();
    }
    @Override
    public Collection<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public void add(Student student) {
        student.setId(nextIdSupplier.get());
        students.add(student);
    }

    @Override
    public boolean delete(int idForDelete) {
        return students.removeIf(s->s.getId().equals(idForDelete));
    }

    @Override
    public boolean contains(int studentId) {
        return students.stream().anyMatch(s->s.getId().equals(studentId));
    }
    @Override
    public void setNextStudentIdSupplier(Supplier<Integer> nextStudentIdSupplier) {
        this.nextIdSupplier = nextStudentIdSupplier;
    }
}
