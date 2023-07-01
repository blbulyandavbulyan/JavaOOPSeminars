package org.blbulyandavbulyan.seminar1.vendingmachine.ui.gui;

import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.VendingMachine;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class VendingMachineWindow extends JFrame {
    private final VendingMachine vendingMachine;
    private final JButton buyButton;
    private final DefaultListModel<Product> productsModel;
    private final JFormattedTextField moneyField;
    private final JList<Product> productJList;
    public VendingMachineWindow(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        productsModel = new DefaultListModel<>();
        productsModel.addAll(vendingMachine.getProducts());//добавляем в модель для списка все продукты из vendingMachine
        moneyField = createMoneyField();
        moneyField.setValue(1L);//устанавливаем начально значение в 1 для поля с деньгами
        productJList = new JList<>(productsModel);
        buyButton = new JButton("Купить");
        this.getContentPane().add(createRootPanel());
        configureUI();
        this.pack();
    }
    private void showInformationMessage(String message, String caption){
        JOptionPane.showMessageDialog(this, message, caption, JOptionPane.INFORMATION_MESSAGE);
    }
    private void showErrorMessage(String message, String caption){
        JOptionPane.showMessageDialog(this, message, caption, JOptionPane.INFORMATION_MESSAGE);
    }
    private int getEnteredPrice(){
        return (Integer) moneyField.getValue();
    }
    private static JFormattedTextField createMoneyField(){
        NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(1);
        numberFormatter.setMaximum(Integer.MAX_VALUE);
        numberFormatter.setAllowsInvalid(false);
        return new JFormattedTextField(numberFormatter);
    }
    private void configureUI(){
        productJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//делаем так чтобы в списке можно было выбрать только один продукт
        //добавляем обработчик для кнопки покупки
        buyButton.addActionListener(event->{
            //
            if(!productJList.isSelectionEmpty()){//у нас что-то выбрано в списке
                Product selectedProduct = productJList.getSelectedValue();
                int enteredPrice = getEnteredPrice();
                if(selectedProduct.getPrice() < enteredPrice){//цена нашего продукта меньше введённой, можем купить
                    Product product = vendingMachine.buy(selectedProduct.getId(), enteredPrice);//покупаем продукт
                    showInformationMessage("Вы успешно купили %s".formatted(product.getName()), "Успешная покупка");
                    //а теперь нам надо убрать продукт из списка, где мы его отображаем
                    productsModel.removeElement(product);//убираем продукт из списка
                }
            }
            else {
                //сообщаем о том что нужно выбрать продукт
                showErrorMessage("Выберите продукт перед покупкой!", "Ошибка!");
            }
        });
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
