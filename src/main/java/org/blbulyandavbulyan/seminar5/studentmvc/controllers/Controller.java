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
    public void run(){
        Command c;
        while ((c = iView.getCommand()) != Command.EXIT){
            switch (c){
                case ADD -> addStudent();
                case DELETE -> deleteStudent();
                case UPDATE -> updateStudent();
                case LIST -> displayStudents();
            }
        }
    }

    private void displayStudents() {
        var students = iModel.findAll();
        iView.displayStudents(students);
    }

    public void deleteStudent(){
        Student studentForDelete = iView.selectStudentForDelete(iModel.findAll());
        if(studentForDelete != null) {
            iModel.delete(studentForDelete);
            iView.updateView(iModel.findAll());
        }
    }
    public void updateStudent(){
        Student studentForUpdate = iView.selectStudentForUpdate(iModel.findAll());
        if(studentForUpdate != null) {
            iModel.update(studentForUpdate);
            iView.updateView(iModel.findAll());
        }

    }
    public void addStudent(){
        Student student = iView.getStudentForAdd();
        if(student != null) {
            iModel.add(student);
            iView.updateView(iModel.findAll());
        }
    }
}
