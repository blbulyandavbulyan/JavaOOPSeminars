package org.blbulyandavbulyan.seminar5.studentmvc.models;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;
import org.blbulyandavbulyan.seminar5.studentmvc.controllers.IModel;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Предоставляет модель для студентов, в которых поле ИД уникальное, и оно будет использоваться для поиска их по модели
 */
public class HashModel implements IModel {
    /**
     * Map из ИД студента в студента
     */
    private final Map<Integer, Student> idToStudent = new HashMap<>();
    private Supplier<Integer> nextIdSupplier;

    /**
     * Возвращает всех студентов в данной модели
     * @return студенты, хранящиеся в данной модели
     */
    @Override
    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(idToStudent.values());
    }

    /**
     * Добавляет студента в модель
     * Поле ИД будет заменено на внутреннее ИД при добавлении
     * @param student студент, которого нужно добавить
     */
    @Override
    public void add(Student student) {
        int studentID = nextId();
        student.setId(studentID);
        idToStudent.put(studentID, student);
    }
    @Override
    public boolean delete(int idForDelete) {
        return idToStudent.remove(idForDelete) != null;
    }

    @Override
    public boolean contains(int studentId) {
        return idToStudent.containsKey(studentId);
    }

    @Override
    public void setNextStudentIdSupplier(Supplier<Integer> nextStudentIdSupplier) {
        this.nextIdSupplier = nextStudentIdSupplier;
    }
    private int nextId(){
        return nextIdSupplier.get();
    }
}
