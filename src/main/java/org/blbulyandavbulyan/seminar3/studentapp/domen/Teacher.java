package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.TeacherPrototype;

/**
 * Предоставляет учителя наследника параметризованного учителя, у которого:
 * имя - строка,
 * возраст - целое число,
 * академическая степень - строка
 */
public class Teacher extends TeacherPrototype<String, Integer, String> {
    /**
     * Создаёт экземпляр учителя с переданным возрастом и именем
     *
     * @param name       имя учителя
     * @param age        возраст учителя
     * @param acadDegree академическая степень учителя
     */
    public Teacher(String name, Integer age, String acadDegree) {
        super(name, age, acadDegree);
    }
}
