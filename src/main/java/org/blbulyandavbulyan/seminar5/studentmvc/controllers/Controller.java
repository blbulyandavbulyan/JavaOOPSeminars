package org.blbulyandavbulyan.seminar5.studentmvc.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.Student;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Предоставляет контроллер для студентов
 */
public class Controller {
    /**
     * Коллекция моделей студентов
     */
    private final Collection<IModel> models;
    /**
     * Ссылка на IView, которое будет использоваться для работы с пользовательским интерфейсом
     */
    private final IView iView;
    private Iterator<IModel> modelIterator;
    /**
     * Следующее ИД, которое будет выдано новому студенту
     * Оно находится здесь, т.к. у нас в контроллере несколько моделей и это решение, по моему мнению единственный способ обеспечить уникальность ИД для всех моделей
     */
    private int nextId = 1;

    /**
     * Создаёт экземпляр контроллера с заданным view и моделями
     * @param models модели, с которыми будет работать данный контроллер
     * @param iView view, через которое контроллер будет взаимодействовать с пользователем
     */
    public Controller(List<IModel> models, IView iView){
        if (models == null) throw new IllegalArgumentException("models is null!");
        else if (iView == null) throw new IllegalArgumentException("iView is null!");
        this.iView = iView;
        this.models = models;
        modelIterator = this.models.iterator();
        models.forEach(model -> model.setNextStudentIdSupplier(this::getNextId));
    }

    /**
     * Запускает цикл обработки команд
     */
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

    /**
     * Отправляет запросы во view на отображение студентов
     */
    private void displayStudents() {
        for (IModel iModel : models) {
            var students = iModel.findAll();
            iView.displayStudents(students);
        }
    }

    /**
     * Отправляет во view запрос ид студента для удаления, а затем удаляет этого студента
     */
    private void deleteStudent(){
        int idForDelete = iView.getStudentIdForDelete();
        //ищем студента по ид в наших моделях
        for(IModel iModel : models){
            if(iModel.contains(idForDelete)){
                iModel.delete(idForDelete);
                return;
            }
        }
        //уведомляем о том что такого ИД не было найдено
        iView.notifyAboutGivenIdNotFound();
    }

    /**
     * Отправляет во view запрос на получение нового студента, а затем добавляет его в следующее по списку view
     */
    private void addStudent(){
        Student student = iView.getStudentForAdd();
        if(student != null) {
            getNextModelForAdding().add(student);
        }
    }

    /**
     * @return следующие по списку view
     */
    private IModel getNextModelForAdding(){
        if (!modelIterator.hasNext()) modelIterator = models.iterator();
        if(!modelIterator.hasNext()) throw new IllegalStateException("There are no models in this controller!");
        return modelIterator.next();
    }

    /**
     * Генератор уникальных ИД для студентов
     * @return следующее ИД
     */
    private int getNextId(){
        return nextId++;
    }
}
