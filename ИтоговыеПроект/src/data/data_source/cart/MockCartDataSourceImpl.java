package data.data_source.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource{
    // Создается пустая коллекция для хранения товаров в корзине
    private ArrayList<CartItem> cart = new ArrayList<>();
    // Реализуется метод для получения списка товаров в корзине
    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }
    // Реализуется метод для добавления товара в корзину
    @Override
    public void addToCart(Product product, int count) {
        cart.add(new CartItem(product , count));
    }
}
