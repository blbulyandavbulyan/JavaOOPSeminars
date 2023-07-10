package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

/**
 * Предоставляет параметризованного учителя
 * @param <NT> тип имени учителя
 * @param <AT> тип возраста учителя(должен быть подтипом Number)
 * @param <DT> тип академической степени учителя
 */
public class TeacherPrototype<NT, AT extends Number, DT> extends PersonPrototype<NT, AT>{
    /**
     * Академическая степень учителя
     */
    private DT acadDegree;
    /**
     * Создаёт экземпляр учителя с переданным возрастом и именем
     *
     * @param name имя учителя
     * @param age  возраст учителя
     * @param acadDegree академическая степень учителя
     */
    public TeacherPrototype(NT name, AT age, DT acadDegree) {
        super(name, age);
    }

    public DT getAcadDegree() {
        return acadDegree;
    }

    @Override
    public String toString() {
        return "TeacherPrototype{" +
                "name=" + name +
                ", age=" + age +
                ", acadDegree=" + acadDegree +
                '}';
    }
}
