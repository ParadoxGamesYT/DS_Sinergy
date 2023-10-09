package view;

import data.servives.ShopService;
import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    final ShopService shopService;

    public AddToCartView(ShopService shopService) {
        super("Добавить в корзину", new ArrayList<>());
        this.shopService = shopService;
    }

    // Метод, который вызывается при открытии представления "Добавить в корзину"
    @Override
    public  void action() {
        Scanner scanner = new Scanner(System.in);

        // Запрашивает у пользователя идентификатор продукта
        System.out.println("Введите id продукта: ");
        String productID = scanner.nextLine();

        // Запрашивает у пользователя количество продукта
        System.out.println("Введите кол-во: ");
        int count = scanner.nextInt();

        // Вызываем метод addToCart() из сервиса, передавая идентификатор продукта и количество, и сохраняет результат
        boolean result = shopService.addToCart(productID,count);

        // Выводит сообщение о результате добавления продукта в корзину
        if (result) {
            System.out.println("Поздравляю!");
        } else {
            System.out.println("Неудачно!");
        }
    }
}
