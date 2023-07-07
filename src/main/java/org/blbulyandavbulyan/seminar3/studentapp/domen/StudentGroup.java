package org.blbulyandavbulyan.seminar3.studentapp.domen;

import java.util.List;

public class StudentGroup implements Comparable<StudentGroup>{
    private List<Student> group;
    private int groupId;

    public StudentGroup(List<Student> group, int groupId) {
        this.group = group;
        this.groupId = groupId;
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public int compareTo(StudentGroup studentGroup) {
        return Integer.compare(this.group.size(), studentGroup.group.size());
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupId=" + groupId +
                ", groupSize=" + group.size() +
                ", students=" + group +
                '}';
    }
}
