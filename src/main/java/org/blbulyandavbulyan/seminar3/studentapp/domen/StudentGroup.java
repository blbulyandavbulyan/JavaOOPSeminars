package org.blbulyandavbulyan.seminar3.studentapp.domen;

import java.util.List;

public class StudentGroup implements Comparable<StudentGroup>{
    private List<Student> students;
    private int groupId;

    public StudentGroup(List<Student> students, int groupId) {
        this.students = students;
        this.groupId = groupId;
    }

    public List<Student> getGroup() {
        return students;
    }

    public void setGroup(List<Student> group) {
        this.students = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public int size(){
        return students.size();
    }
    @Override
    public int compareTo(StudentGroup studentGroup) {
        return Integer.compare(this.students.size(), studentGroup.students.size());
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
