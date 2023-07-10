package org.blbulyandavbulyan.seminar3.studentapp;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;
import org.blbulyandavbulyan.seminar3.studentapp.services.TeacherService;
import org.blbulyandavbulyan.seminar3.studentapp.utils.AverageAge;
import org.blbulyandavbulyan.seminar3.studentapp.utils.PersonComparator;

import java.util.Collection;

public class Seminar4Main {
    public static void main(String[] args) {
        //данный кусок кода относится к первой задаче
        var teacherService = createTeacherService();
        System.out.println("До сортировки: ");
        printPersons(teacherService.getAll());
        teacherService.sort(new PersonComparator<>());
        System.out.println("После сортировки: ");
        printPersons(teacherService.getAll());
        //данный кусок относится к третьей задаче
        AverageAge averageAge = new AverageAge(teacherService.getAll());
        System.out.println("Среднее значение возрастов учителей: " + averageAge.average());
    }
    public static void printPersons(Collection<? extends PersonPrototype<?, ?>> personPrototypes){
        for (var personPrototype : personPrototypes) {
            System.out.println(personPrototype);
        }
    }
    public static TeacherService createTeacherService(){
        TeacherService teacherService = new TeacherService();
        teacherService.create("Анатолий", 19);
        teacherService.create("Евгений", 22);
        teacherService.create("Абраам", 18);
        return teacherService;
    }
}
