package org.blbulyandavbulyan.seminar5.studentmvc;

public enum AvailableLanguage {
    ENGLISH("en"), RUSSIAN("ru");
    private final String shortName;

    AvailableLanguage(String shortName) {
        this.shortName = shortName;
    }
    public String getShortName() {
        return shortName;
    }
}
