package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherService implements IPersonService<Teacher>{
    private final List<Teacher> teachers;
    private final List<Teacher> unmodifiableTeachers;
    public TeacherService(){
        teachers = new ArrayList<>();
        this.unmodifiableTeachers = Collections.unmodifiableList(teachers);
    }
    @Override
    public List<Teacher> getAll() {
        return unmodifiableTeachers;
    }

    @Override
    public void create(String name, int age) {
        teachers.add(new Teacher(name, age, "unknown"));
    }
}
