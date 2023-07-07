package org.blbulyandavbulyan.seminar3.studentapp.domen;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Поток студентов<br>
 * <b>Этот класс не имеет ничего общего с {@link java.util.stream.Stream}!</b>
 */
public class StudentStream implements Iterable<StudentGroup>{
    private List<StudentGroup> groups;
    private int number;
    public StudentStream(List<StudentGroup> groups, int number) {
        this.groups = groups;
        this.number = number;
    }
    public StudentStream(int number){
        this(new ArrayList<>(), number);
    }
    @Override
    public Iterator<StudentGroup> iterator() {
        //поскольку в списве уже и так есть итератор, и его просто верну отсюда
        return groups.iterator();
    }
    public void add(StudentGroup studentGroup){
        groups.add(studentGroup);
    }
    public void sort(){
        Collections.sort(groups);
    }
    public void sort(Comparator<StudentGroup> studentGroupComparator){
        groups.sort(studentGroupComparator);
    }

    @Override
    public String toString() {
        return "StudentStream{" + "number=" + number +
                ", groups=" + groups.stream().map(StudentGroup::toString).collect(Collectors.joining("\n\t", "[\n\t", "\n]")) +
                '}';
    }
}