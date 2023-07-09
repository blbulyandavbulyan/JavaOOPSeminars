package org.blbulyandavbulyan.seminar3.studentapp.domen.protypes;

public class EmployeePrototype<NT, AT extends Number, ST> extends PersonPrototype<NT, AT>{
    private final ST speciality;
    /**
     * Создаёт экземпляр человека с переданным возрастом и именем
     *
     * @param name имя человека
     * @param age  возраст человека
     */
    public EmployeePrototype(NT name, AT age, ST speciality) {
        super(name, age);
        this.speciality = speciality;
    }

    public ST getSpeciality() {
        return speciality;
    }
}
