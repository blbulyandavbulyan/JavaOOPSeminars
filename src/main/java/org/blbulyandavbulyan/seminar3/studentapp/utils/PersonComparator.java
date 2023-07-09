package org.blbulyandavbulyan.seminar3.studentapp.utils;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

import java.util.Comparator;

/**
 * Данный компаратор сравнивает generics Person с таким же, сначала сравнивает по имени, а затем по возрасту<br>
 * Для более удобного создания используете метод {@link PersonComparator#of(Class)}:<br>
 * Пример использования: PersonComparator.of(Person.class)
 * @param <NT> тип имени в PersonPrototype
 * @param <AT> тип возраста в PersonPrototype(должен быть Number и Comparable)
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

    /**
     * Создаёт PersonComparator из переданного класса, наследника PersonPrototype
     * @param personPrototypeClass класс из которого нужно создать PersonComparator
     * @return созданный на базе класса personPrototypeClass компаратор
     * @param <AT> тип возраста в {@link PersonPrototype}
     * @param <NT> тип имени в {@link PersonPrototype}
     * @param <R> сам тип класса {@link PersonPrototype}
     */
    @SuppressWarnings("unused")//специально подавляю предупреждение о неиспользуемом параметре, я лучше знаю что мне надо
    public static <AT extends Number & Comparable<AT>, NT extends Comparable<NT>, R extends PersonPrototype<NT, AT>> PersonComparator<NT, AT, R> of(Class<R> personPrototypeClass){
        //Несмотря на то, что параметр personPrototype здесь не используется, но он позволяет мне не указывать кучу остальных generic параметров, т.к. они выводятся автоматически компилятором
        return new PersonComparator<>();
    }
}
