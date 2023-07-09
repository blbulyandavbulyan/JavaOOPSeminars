package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.StudentGroupPrototype;

import java.util.List;

public class StudentGroup extends StudentGroupPrototype<Student> {
    public StudentGroup(List<Student> students, int groupId) {
        super(students, groupId);
    }

    public StudentGroup(int groupId) {
        super(groupId);
    }
}
