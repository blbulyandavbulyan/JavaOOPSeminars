package org.blbulyandavbulyan.seminar1.vendingmachine.ui.gui;

import org.blbulyandavbulyan.seminar1.vendingmachine.VendingMachineFiller;
import org.blbulyandavbulyan.seminar1.vendingmachine.domen.Product;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.SimpleMoneyHolder;
import org.blbulyandavbulyan.seminar1.vendingmachine.services.VendingMachine;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class VendingMachineWindow extends JFrame {
    private final VendingMachine vendingMachine;
    private final JButton buyButton;
    private DefaultListModel<Product> productsModel;
    private JFormattedTextField moneyField;
    private JList<Product> productJList;
    public VendingMachineWindow(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        productsModel = new DefaultListModel<>();
        productsModel.addAll(vendingMachine.getProducts());
        moneyField = createNumberField(Integer.class, 1, Integer.MAX_VALUE);
        moneyField.setValue(1L);
        productJList = new JList<>(productsModel);
        buyButton = new JButton("Купить");
        this.getContentPane().add(createRootPanel());
        this.pack();
    }
    private void showInformationMessage(String message, String caption){
        JOptionPane.showMessageDialog(this, message, caption, JOptionPane.INFORMATION_MESSAGE);
    }
    private int getEnteredPrice(){
        return (Integer) moneyField.getValue();
    }
    private static<T extends Comparable<T>> JFormattedTextField createNumberField(Class<T> type, T minValue, T maxValue){
        NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(type);
        numberFormatter.setMinimum(minValue);
        numberFormatter.setMaximum(maxValue);
        numberFormatter.setAllowsInvalid(false);
        return new JFormattedTextField(numberFormatter);
    }
    private void configureButtons(){
        buyButton.addActionListener(event->{
            //
            if(!productJList.isSelectionEmpty()){//у нас что-то выбрано в списке
                Product selectedProduct = productJList.getSelectedValue();
                int enteredPrice = getEnteredPrice();
                if(selectedProduct.getPrice() < enteredPrice){//цена нашего продукта меньше введённой, можем купить
                    Product product = vendingMachine.buy(selectedProduct.getId(), enteredPrice);//покупаем продукт
                    showInformationMessage("Вы успешно купили %s".formatted(product.getName()), "Успешная покупка");
                    //а теперь нам надо убрать продукт из списка, где мы его отображаем
//                    productJList
                }
            }
            else {
                //сообщаем о том что нужно выбрать продукт
            }
        });
    }
    /**
     * Метод создающий панель, на которой будет всё отображаться в данном окне
     */
    private JPanel createRootPanel(){
        //вообше тут надо было выбрать какой-нибудь другой layout но мне было лень сильно заморачиваться
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(2, 1));
        rootPanel.add(productJList);
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.add(moneyField);
        controlPanel.add(buyButton);
        rootPanel.add(controlPanel);
        return rootPanel;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new SimpleMoneyHolder());
        VendingMachineFiller.fill(vendingMachine);
        VendingMachineWindow vendingMachineWindow = new VendingMachineWindow(vendingMachine);
        vendingMachineWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vendingMachineWindow.setVisible(true);
    }
}
