package org.blbulyandavbulyan.seminar3.studentapp.utils;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

import java.util.Collection;

/**
 * Данный класс предназначен для подсчёта среднего возраста персон
 */
public class AverageAge {
    private final Collection<? extends PersonPrototype<?, ? extends Number>> persons;

    /**
     * Создаёт экземпляр класса подсчитывателя с заданной коллекцией персон
     * @param persons коллекция персон, для которых будет считаться средний возраст
     */
    public AverageAge(Collection<? extends PersonPrototype<?, ?>> persons){
        this.persons = persons;
    }

    /**
     * Метод подсчитывает средний возраст для переданной в конструкторе коллекции персон
     * @return среднее значение возраста для коллекции персон
     */
    public double average(){
        return persons.stream()
                .map(PersonPrototype::getAge)//превращаем персон в их возраст
                .mapToDouble(Number::doubleValue)//конвертируем Number(тип нашего возраста) в double
                .average()//считаем среднее значение
                .orElseThrow(()->new IllegalArgumentException("collections is empty, there is no average value"));
    }
}
