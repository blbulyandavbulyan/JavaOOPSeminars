package org.blbulyandavbulyan.seminar5.studentmvc;

import org.blbulyandavbulyan.seminar5.studentmvc.controllers.Controller;
import org.blbulyandavbulyan.seminar5.studentmvc.models.HashModel;
import org.blbulyandavbulyan.seminar5.studentmvc.views.ConsoleView;

import java.util.ResourceBundle;

/**
 * Точка входа в приложение
 */
public class Main {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView(System.out, System.in, ResourceBundle.getBundle("locales/studentmvc/console-text"));
        HashModel hashModel = new HashModel();
        Controller controller = new Controller(hashModel, consoleView);
        controller.run();
    }
}
