package view;

import data.models.CartItem;
import data.models.Product;
import data.servives.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService shopService;
    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }
    @Override
    public  void action() {
        // Получает список товаров в корзине
        ArrayList<CartItem> cart = shopService.getCart();
        // Выводит информацию о товарах в корзине
        for (CartItem item : cart) {
            System.out.println(item.count + " " + item.product.title + " " + item.product.price);
        }
        System.out.println();
    }
}
