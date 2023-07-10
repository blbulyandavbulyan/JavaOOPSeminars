package org.blbulyandavbulyan.seminar3.studentapp.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Teacher;
import org.blbulyandavbulyan.seminar3.studentapp.services.TeacherService;
import org.blbulyandavbulyan.seminar3.studentapp.utils.PersonComparator;

public class TeacherController implements IPersonController<Teacher> {
    private final TeacherService teacherService;
    public TeacherController() {
        teacherService = new TeacherService();
    }

    @Override
    public void create(String firstName, int age) {
        teacherService.create(firstName, age);
        teacherService.sort(new PersonComparator<>());
    }
}
