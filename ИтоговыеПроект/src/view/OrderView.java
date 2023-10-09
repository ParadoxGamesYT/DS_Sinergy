package view;

import data.servives.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;

    public OrderView(ShopService shopService) {
        super("Оформление заказа ", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод имени пользователя
        System.out.println("Введите свое имя: ");
        String name = scanner.nextLine();

        // Запрос на ввод номера телефона пользователя
        System.out.println("Введите свой номер: ");
        String phone = scanner.nextLine();

        // Вызов метода createOrder() объекта shopService для оформления заказа со введенными данными
        shopService.createOrder(name , phone, "Адреcс", "VISA","20:00");
    }
}
