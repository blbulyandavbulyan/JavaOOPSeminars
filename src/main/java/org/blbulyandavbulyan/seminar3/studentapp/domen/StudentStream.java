package org.blbulyandavbulyan.seminar3.studentapp.domen;

import java.util.*;

/**
 * Поток студентов<br>
 * <b>Этот класс не имеет ничего общего с {@link java.util.stream.Stream}!</b>
 */
public class StudentStream implements Iterable<StudentGroup>{
    private List<StudentGroup> groups;
    public StudentStream(List<StudentGroup> groups) {
        this.groups = groups;
    }
    public StudentStream(){
        this(new ArrayList<>());
    }
    @Override
    public Iterator<StudentGroup> iterator() {
        //поскольку в списве уже и так есть итератор, и его просто верну отсюда
        return groups.iterator();
    }
    public void add(StudentGroup studentGroup){
        this.add(studentGroup);
    }
    public void sort(){
        Collections.sort(groups);
    }
    public void sort(Comparator<StudentGroup> studentGroupComparator){
        groups.sort(studentGroupComparator);
    }
}
