package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

public class Controller {
    private final IModel iModel;
    private final IView iView;
    public Controller(IModel iModel, IView iView) {
        if (iModel == null) throw new IllegalArgumentException("iModel is null!");
        else if (iView == null) throw new IllegalArgumentException("iView is null!");
        this.iModel = iModel;
        this.iView = iView;
    }
    public void deleteStudent(){
        var students = iModel.findAll();
        Student studentForDelete = iView.selectStudentForDelete(students);
        if(studentForDelete != null)
            iModel.delete(studentForDelete);
    }
    public void updateStudent(){
        var students = iModel.findAll();
        Student studentForUpdate = iView.selectStudentForUpdate(students);
        if(studentForUpdate != null)
            iModel.update(studentForUpdate);
    }
    public void addStudent(){
        Student student = iView.getStudentForAdd();
        if(student != null)
            iModel.add(student);
    }
}
