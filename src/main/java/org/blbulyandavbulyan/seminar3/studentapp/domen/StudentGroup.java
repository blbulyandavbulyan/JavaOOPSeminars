package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.StudentGroupPrototype;

import java.util.List;

/**
 * Предоставляет реализацию StudentGroupPrototype в которой будет Student
 */
public class StudentGroup extends StudentGroupPrototype<Student> {
    /**
     * Создаёт группу студентов
     * @param students список студентов(типа Student)
     * @param groupId ИД группы
     */
    public StudentGroup(List<Student> students, int groupId) {
        super(students, groupId);
    }

    /**
     * Создаёт пустую группу с заданным ИД
     * @param groupId ИД группы
     */
    public StudentGroup(int groupId) {
        super(groupId);
    }
}
