package org.blbulyandavbulyan.seminar5.studentmvc;

/**
 * Данное перечисление описывает какие языки доступны
 */
public enum AvailableLanguage {
    ENGLISH("en"), RUSSIAN("ru");
    /**
     * Короткое имя языка, которое будет использоваться для поиска ресурсов
     */
    private final String shortName;

    AvailableLanguage(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return заданное в конструкторе короткое имя языка
     */
    public String getShortName() {
        return shortName;
    }
}
