package org.blbulyandavbulyan.seminar1.vendingmachine.ui.gui;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.VendingMachine;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class VendingMachineWindow extends JFrame {
    /**
     * Торговый автомат, которым управляет данное окно
     */
    private final VendingMachine vendingMachine;
    /**
     * Кнопка покупки
     */
    private final JButton buyButton;
    /**
     * Модель для списка с продуктами
     */
    private final DefaultListModel<Product> productsModel;
    /**
     * Поле для денег
     */
    private final JFormattedTextField moneyField;
    /**
     * Список с продуктами
     */
    private final JList<Product> productJList;

    /**
     * Создаёт окно с заданным автоматом
     * @param vendingMachine автомат, которым будет управлять данное окно
     */
    public VendingMachineWindow(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        productsModel = new DefaultListModel<>();
        productsModel.addAll(vendingMachine.getProducts());//добавляем в модель для списка все продукты из vendingMachine
        moneyField = createMoneyField();
        moneyField.setValue(0);//устанавливаем начально значение в 1 для поля с деньгами
        productJList = new JList<>(productsModel);
        buyButton = new JButton("Купить");
        this.getContentPane().add(createRootPanel());
        configureUI();
        this.pack();
    }

    /**
     * Метод показывает информационное сообщение с кнопкой ok
     * @param message текст сообщения
     * @param caption заголовок всплывающего окна
     */
    private void showInformationMessage(String message, String caption){
        JOptionPane.showMessageDialog(this, message, caption, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Метод показывает сообщение об ошибке с кнопкой ok
     * @param message текст сообщения
     * @param caption заголовок всплывающего окна
     */
    private void showErrorMessage(String message, String caption){
        JOptionPane.showMessageDialog(this, message, caption, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Метод получает введённую сумму денег из текстового поля
     * @return сумму денег, которую ввёл пользовать
     */
    private int getEnteredPrice(){
        return (Integer) moneyField.getValue();
    }
    private static JFormattedTextField createMoneyField(){
        NumberFormatter numberFormatter = new NumberFormatter();//эта штука нужна для текстового поля, чтобы оно могло отслеживать на корректность введённых данных
        //в данном случае это задаёт что там будет число
        numberFormatter.setValueClass(Integer.class);//задаём тип значения для формата
        numberFormatter.setMinimum(0);//задаём минимальное значение
        numberFormatter.setMaximum(Integer.MAX_VALUE);//максимальное значение
        numberFormatter.setAllowsInvalid(false);
        return new JFormattedTextField(numberFormatter);
    }
    private void configureUI(){
        productJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//делаем так чтобы в списке можно было выбрать только один продукт
        //добавляем обработчик для кнопки покупки
        buyButton.addActionListener(event->{
            //сообщаем о том что нужно выбрать продукт
            if(!productJList.isSelectionEmpty()){//у нас что-то выбрано в списке
                Product selectedProduct = productJList.getSelectedValue();
                int enteredPrice = getEnteredPrice();
                if(selectedProduct.getPrice() < enteredPrice){//цена нашего продукта меньше введённой, можем купить
                    int change = vendingMachine.buy(selectedProduct.getId(), enteredPrice);//покупаем продукт
                    showInformationMessage("Вы успешно купили %s".formatted(selectedProduct.getName()), "Успешная покупка");
                    //а теперь нам надо убрать продукт из списка, где мы его отображаем
                    productsModel.removeElement(selectedProduct);//убираем продукт из списка
                    if(change != 0) showInformationMessage("Вам вернули сдачу " + change, "Возврат сдачи");
                    moneyField.setValue(change);
                }
                else showErrorMessage("У вас недостаточно средств!", "Ошибка покупки!");
            }
            else showErrorMessage("Выберите продукт перед покупкой!", "Ошибка!");
        });
        //эта штука нам нужна для отслеживания изменений в нашем списке, и чтобы вовремя выключить управляющие компоненты, когда список пуст
        productsModel.addListDataListener(new ListDataListener() {
            private void enableIfNeeded(){
                //это всё здесь нам нужно для того, чтобы выключить кнопку покупки и поле ввода денег если список пуст
                boolean enableControls = !productsModel.isEmpty();
                moneyField.setEnabled(enableControls);
                buyButton.setEnabled(enableControls);
            }
            @Override
            public void contentsChanged(ListDataEvent e) {

            }
            @Override
            public void intervalAdded(ListDataEvent e) {
                enableIfNeeded();
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                enableIfNeeded();
            }
        });
    }
    /**
     * Метод создающий панель, на которой будет всё отображаться в данном окне
     */
    private JPanel createRootPanel(){
        //вообше тут надо было выбрать какой-нибудь другой layout но мне было лень сильно заморачиваться
        JPanel rootPanel = new JPanel();//наша панель на которую будет добавлено всё
        rootPanel.setLayout(new GridLayout(2, 1));//сеточное выравнивание с двумя строками и одним столбцом
        rootPanel.add(productJList);//добавляем список продуктов в нашу корневую панель
        JPanel controlPanel = new JPanel();//панель содержащая элементы управления
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.add(moneyField);//добавляем поле с деньгами
        controlPanel.add(buyButton);//добавляем кнопку покупки
        rootPanel.add(controlPanel);
        return rootPanel;
    }
}
