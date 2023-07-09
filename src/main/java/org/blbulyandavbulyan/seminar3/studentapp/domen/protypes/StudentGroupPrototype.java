package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Предоставляет группу студентов
 * @param <T> тип студента, который будет хранится в данной группе
 */
public class StudentGroupPrototype<T extends StudentPrototype<?, ?, ?>> implements Comparable<StudentGroupPrototype<T>>{
    /**
     * Список студентов, состоящих в данной группе
     */
    private final List<T> students;
    /**
     * Идентификатор группы
     */
    private int groupId;

    /**
     * Создаёт экземпляр группы с заданными студентами и идентификатором
     * @param students студенты, которые будут включены в данную группу
     * @param groupId идентификатор данной группы
     */
    public StudentGroupPrototype(List<T> students, int groupId) {
        this.students = new ArrayList<>(students);
        this.groupId = groupId;
    }

    /**
     * Создаёт пустую группу с заданным идентификатором
     * @param groupId идентификатор данной группы
     */
    public StudentGroupPrototype(int groupId){
        this.groupId = groupId;
        this.students = new ArrayList<>();
    }

    /**
     * Добавляет студента в группе
     * @param student студент, которого нужно добавить
     */
    public void add(T student){
        students.add(student);
    }

    /**
     * @return идентификатор данной группы
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Устанавливает новый идентификатор группы
     * @param groupId новый идентификатор данной группы
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * Получает размер данной группы
     * @return количество студентов в данной группе
     */
    public int size(){
        return students.size();
    }
    @Override
    public int compareTo(StudentGroupPrototype<T> studentGroupPrototype) {
        return Integer.compare(this.students.size(), studentGroupPrototype.students.size());
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupId=" + groupId +
                ", groupSize=" + students.size() +
                ", students=" + students +
                '}';
    }
}
