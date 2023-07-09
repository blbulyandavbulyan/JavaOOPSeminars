package org.blbulyandavbulyan.seminar3.studentapp.utils;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

import java.util.Comparator;

/**
 * Данный компаратор сравнивает generics Person с таким же, сначала сравнивает по имени, а затем по возрасту
 * @param <NT> тип имени в PersonPrototype
 * @param <AT> тип возраста в PersonPrototype
 * @param <T> конкретный тип, который будет сравнивать данный компаратор, должен быть наследником PersonPrototype
 */
public class PersonComparator<NT extends Comparable<NT>, AT extends Number & Comparable<AT>, T extends PersonPrototype<NT, AT>> implements Comparator<T> {
    /**
     * Компаратор, который будет сравнивать двух PersonPrototype
     */
    private final Comparator<T> comparator;

    /**
     * Инициализирует данный компаратор
     */
    public PersonComparator(){
        comparator = Comparator.comparing(T::getName, NT::compareTo)
                .thenComparing(T::getAge);
    }
    @Override
    public int compare(T o1, T o2) {
        return comparator.compare(o1, o2);
    }
}
