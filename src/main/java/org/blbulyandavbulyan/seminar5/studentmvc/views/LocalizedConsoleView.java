package org.blbulyandavbulyan.seminar5.studentmvc.views;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Предоставляет локализованное view
 */
public class LocalizedConsoleView extends ConsoleView{
    private final String language;

    /**
     * Создаёт экземпляр данного класса
     *
     * @param ps поток в который будет печататься результат
     * @param is входной поток
     * @param language язык, с которым будет создано данное view
     */
    public LocalizedConsoleView(PrintStream ps, InputStream is, String language) {
        //здесь идёт загрузка .properties файла из ресурсов, смотреть в каталоге src/main/resources/locales/studentmvc
        super(ps, is,  ResourceBundle.getBundle("locales/studentmvc/console-text", Locale.of(language)));
        this.language = language;
    }

    /**
     * @return язык, с котором было создано данное view
     */
    public String getLanguage() {
        return language;
    }
}
