package ui.console;

import domen.Product;
import services.ItemSelector;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleItemSelector implements ItemSelector {
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleItemSelector(Scanner scanner, PrintStream out){
        this.out = out;
        this.scanner = scanner;
    }
    @Override
    public long select(Collection<Product> products) {
        if(!products.isEmpty()){
            Collection<Long> productIds = products.stream().map(Product::getId).collect(Collectors.toSet());
            out.println("Список доступных продуктов: ");
            products.forEach(out::println);
            while (true){
                out.println("Введите ИД продукта: ");
                long productId = scanner.nextLong();
                if(productIds.contains(productId)){
                    return productId;
                }
                else out.println("Такого ИД нет, попробуйте ещё раз");
            }

        }
        else throw new RuntimeException();
    }
}
