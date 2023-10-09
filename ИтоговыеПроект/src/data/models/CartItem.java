package data.models;

public class CartItem {

    // Поле, хранящее информацию о товаре
    public final Product product;

    // Поле, хранящее количество товара
    public final int count;

    // Конструктор класса, инициализирующий поля
    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
