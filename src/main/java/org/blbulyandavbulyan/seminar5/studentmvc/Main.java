package org.blbulyandavbulyan.seminar5.studentmvc;

import org.blbulyandavbulyan.seminar5.studentmvc.controllers.Controller;
import org.blbulyandavbulyan.seminar5.studentmvc.models.HashModel;
import org.blbulyandavbulyan.seminar5.studentmvc.models.ListModel;
import org.blbulyandavbulyan.seminar5.studentmvc.views.LocalizedConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Точка входа в приложение
 */
public class Main {
    public static void main(String[] args) {
        LocalizedConsoleView localizedConsoleView = createLocalizedConsoleView();
        HashModel hashModel = new HashModel();
        ListModel listModel = new ListModel();
        Controller controller = new Controller(List.of(hashModel, listModel), localizedConsoleView);
        controller.run();
    }

    /**
     * Метод запрашивает у пользователя язык с клавиатуры
     * @return возвращает соответсвующую введённому константу enum
     */
    private static AvailableLanguage selectLanguage(){
        System.out.println("Available languages: " + Arrays.toString(AvailableLanguage.values()));
        System.out.println("Choose language: ");
        Scanner sc = new Scanner(System.in);
        String languageName = sc.nextLine();
        return AvailableLanguage.valueOf(languageName);
    }

    /**
     * @return возвращает view на выбранном поддерживаемом языке
     */
   private static LocalizedConsoleView createLocalizedConsoleView(){
        return new LocalizedConsoleView(System.out, System.in, selectLanguage().getShortName());
   }
}
