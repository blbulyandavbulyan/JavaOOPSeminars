package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Предоставляет контроллер для студентов
 */
public class Controller {
    private final Collection<IModel> models;
    private final IView iView;
    private Iterator<IModel> modelIterator;
    public Controller(List<IModel> models, IView iView){
        if (models == null) throw new IllegalArgumentException("models is null!");
        else if (iView == null) throw new IllegalArgumentException("iView is null!");
        this.iView = iView;
        this.models = models;
        modelIterator = this.models.iterator();
    }
    public void run(){
        Command c;
        while ((c = iView.getCommand()) != Command.EXIT){
            switch (c){
                case ADD -> addStudent();
                case DELETE -> deleteStudent();
                case LIST -> displayStudents();
            }
        }
    }

    private void displayStudents() {
        for (IModel iModel : models) {
            var students = iModel.findAll();
            iView.displayStudents(students);
        }
    }

    public void deleteStudent(){
        int idForDelete = iView.getStudentIdForDelete();
        //ищем студента по ид в наших моделях
        for(IModel iModel : models){
            if(iModel.contains(idForDelete)){
                iModel.delete(idForDelete);
                break;
            }
        }
    }
    public void addStudent(){
        Student student = iView.getStudentForAdd();
        if(student != null) {
            IModel modelForAdd = getNextModelForAdding();
            modelForAdd.add(student);
//            iView.updateView(iModel.findAll());
        }
    }
    private IModel getNextModelForAdding(){
        if (!modelIterator.hasNext()) modelIterator = models.iterator();
        if(!modelIterator.hasNext()) throw new IllegalStateException("There are no models in this controller!");
        return modelIterator.next();
    }
}
