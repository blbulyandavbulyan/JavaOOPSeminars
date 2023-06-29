package services;

import domen.Product;
import services.exceptions.ProductIsNotAvailableException;

import java.util.*;

/**
 * Данный класс предназначен для хранения продуктов
 *
 */
public class ItemHolder {

    private final Map<Long, Product> idToProduct;
    private final Collection<Product> unmodifiableProducts;

    /**
     * Создаёт держатель продуктов с заданными продуктами
     * @param products продукты которые нужно добавить
     */
    public ItemHolder(Collection<Product> products){
        idToProduct = new HashMap<>();
        unmodifiableProducts = Collections.unmodifiableCollection(idToProduct.values());//оборачиваем продукты в немодифицироваемое view над исходными значениями в map
        products.forEach(this::add);
    }

    /**
     * Добавляет продукт в наименее забитое место
     * @param product продукт который нужно добавить
     */
    public void add(Product product){
        //чтобы автомат заполнялся равномерно, нам нужно найти ячейку с минимальным количеством элементов, которые меньше чем max depth
        if(idToProduct.containsKey(product.getId()))throw new IllegalArgumentException("product already added!");
        idToProduct.put(product.getId(), product);
    }

    /**
     * Проверяет, доступен ли продукт с заданным номером
     * @param productId ИД продукта для проверки на доступность
     * @return true если доступен, иначе false
     */
    public boolean isAvailable(long productId){
        return idToProduct.containsKey(productId);
    }

    /**
     * Возвращает продукт под заданным номером и удаляет его из себя
     * @param productId номер продукта для выбора
     * @return продукт под номером productId
     * @throws ProductIsNotAvailableException если продукта нет в наличии
     */
    public Product release(long productId){
        if(isAvailable(productId)){
            return idToProduct.get(productId);
        }
        else throw new ProductIsNotAvailableException(productId);
    }

    /**
     * Смотрит какая цена у продукта
     * @param productNumber номер продукта, цену которого нужно проверить
     * @return цену продукта
     * @throws ProductIsNotAvailableException если продукта нет в наличии
     */
    public int getPrice(long productNumber){
        if(isAvailable(productNumber)) return idToProduct.get(productNumber).getPrice();
        else throw new ProductIsNotAvailableException(productNumber);
    }

    /**
     * Получить список доступных продуктов
     * @return возвращает не модифицируемую коллекцию с продуктами
     */
    public Collection<Product> getProducts() {
        return unmodifiableProducts;
    }
}
