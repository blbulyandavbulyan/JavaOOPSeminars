package org.blbulyandavbulyan.seminar3.studentapp.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Teacher;
import org.blbulyandavbulyan.seminar3.studentapp.services.TeacherService;
import org.blbulyandavbulyan.seminar3.studentapp.utils.PersonComparator;

/**
 * Предоставляет контроллер над учителями
 */
public class TeacherController implements IPersonController<Teacher> {
    /**
     * Сервис с учителями
     */
    private final TeacherService teacherService;

    /**
     * Создаёт экземпляр контроллера
     */
    public TeacherController() {
        teacherService = new TeacherService();
    }

    /**
     * Создаёт учителя и сортирует всех учителей в сервисе
     * @param firstName имя будущей персоны
     * @param age возраст будущей персоны
     */
    @Override
    public void create(String firstName, int age) {
        teacherService.create(firstName, age);
        teacherService.sort(new PersonComparator<>());
    }
}
