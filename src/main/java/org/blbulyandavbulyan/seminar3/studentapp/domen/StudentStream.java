package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.StudentStreamPrototype;

import java.util.List;

/**
 * Предоставляет поток студентов, в котором в качестве группы хранится StudentGroup
 */
public class StudentStream extends StudentStreamPrototype<StudentGroup> {
    /**
     * Создаёт поток студентов с заданными группами и номером
     * @param groups группы, с которыми будет создан поток
     * @param streamNumber номер потока
     */
    public StudentStream(List<StudentGroup> groups, int streamNumber) {
        super(groups, streamNumber);
    }

    /**
     * Создаёт поток студентов не содержащий групп
     * @param streamNumber номер потока
     */
    public StudentStream(int streamNumber) {
        super(streamNumber);
    }
}
