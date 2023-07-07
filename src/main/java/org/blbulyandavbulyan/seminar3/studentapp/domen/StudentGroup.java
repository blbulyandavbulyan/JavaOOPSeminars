package org.blbulyandavbulyan.seminar3.studentapp.domen;

import java.util.List;

public class StudentGroup {
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
}
