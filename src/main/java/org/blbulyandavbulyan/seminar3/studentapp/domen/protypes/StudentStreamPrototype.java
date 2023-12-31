package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Поток параметризованных студентов из параметризованных групп студентов<br>
 * <b>Этот класс не имеет ничего общего с {@link java.util.stream.Stream}!</b>
 * @param <GT> тип групп, которые будут храниться в данном потоке
 */
public class StudentStreamPrototype<GT extends StudentGroupPrototype<?>> implements Iterable<GT>{
    /**
     * Группы, которые состоят в данном потоке
     */
    private final List<GT> groups;
    /**
     * Номер потока
     */
    private final int streamNumber;

    /**
     * Создаёт экземпляр потока с заданным номером и группами
     * @param groups группы, которые будут включены в данный поток
     * @param streamNumber номер потока
     */
    public StudentStreamPrototype(List<GT> groups, int streamNumber) {
        this.groups = groups;
        this.streamNumber = streamNumber;
    }

    /**
     * Создаёт пустой поток с заданным номером
     * @param streamNumber номер потока
     */
    public StudentStreamPrototype(int streamNumber){
        this(new ArrayList<>(), streamNumber);
    }
    @Override
    public Iterator<GT> iterator() {
        //поскольку в списке уже и так есть итератор, и его просто верну отсюда
        return groups.iterator();
    }

    /**
     * Добавляет параметризованную группу в поток
     * @param studentGroup параметризованная группа, которую нужно добавить
     */
    public void add(GT studentGroup){
        groups.add(studentGroup);
    }

    /**
     * Сортирует параметризованные группы в потоке используя стандартный компаратор в группе
     */
    public void sort(){
        Collections.sort(groups);
    }

    /**
     * Сортирует параметризованные группы в потоке сначала по размеру группы, а потом по идентификатору
     */
    public void sortByGroupSizeAndThanByGroupIdentifier(){
        groups.sort(Comparator.comparing(GT::size).thenComparing(StudentGroupPrototype::getGroupId));
    }
    @Override
    public String toString() {
        return "StudentStream{" + "number=" + streamNumber +
                ", groups=" + groups.stream().map(StudentGroupPrototype::toString).collect(Collectors.joining("\n\t", "[\n\t", "\n]")) +
                '}';
    }
}