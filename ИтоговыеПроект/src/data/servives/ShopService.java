package data.servives;

import data.data_source.cart.CartDataSource;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.order.OrderDataSource;
import data.models.CartItem;
import data.models.Order;
import data.models.Product;

import java.util.ArrayList;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;


    // Конструктор ShopService для инициализации зависимостей
    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }
    // Получение списка продуктов из источника данных CatalogDataSource
    public ArrayList<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }
    // Получение списка товаров в корзине из источника данных CartDataSource

    public ArrayList<CartItem> getCart(){
        return cartDataSource.getCart();
    }

    // Добавление продукта в корзину

    public boolean addToCart(String productID, int count) {
        ArrayList<Product> products = getCatalog();
        for (Product p : products) {
            if (p.id.equals(productID) && p.available) {
                cartDataSource.addToCart(p, count);
                return true;

            }
        }
        return false;
    }
    // Создание нового заказа на основе данных о пользователе и корзине

    public  void createOrder(String name, String phone, String paymentType, String deliveryTime, String address){
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, paymentType, deliveryTime, address, cart);
        orderDataSource.createOrder(newOrder);

    }
}
