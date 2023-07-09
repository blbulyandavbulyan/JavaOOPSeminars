package org.blbulyandavbulyan.seminar3.studentapp.domen;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.StudentStreamPrototype;

import java.util.List;

public class StudentStream extends StudentStreamPrototype<StudentGroup> {
    public StudentStream(List<StudentGroup> groups, int streamNumber) {
        super(groups, streamNumber);
    }

    public StudentStream(int streamNumber) {
        super(streamNumber);
    }
}
