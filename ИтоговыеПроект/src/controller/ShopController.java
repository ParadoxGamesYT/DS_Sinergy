package controller;

import view.AppView;

import java.util.Scanner;

public class ShopController {
    final AppView view;

    public ShopController(AppView view) {
        this.view = view;
    }

    public void run() {
        // Бесконечный цикл для отображения меню и выполнения действий
        while (true) {
            // Отображаем текущее меню
            view.action();
            // Отображаем дочерние элементы текущего меню
            view.displayChildren();
            // Создаем объект сканнера для чтения ввода пользователя
            Scanner scanner = new Scanner(System.in);
            // Получаем целочисленное значение, введенное пользователем
            int value = scanner.nextByte();
            // Проверяем, что значение находится в пределах допустимых значений
            if (value < 0 || value > view.children.size() + 1){
                // Если значение некорректное,то выводит сообщение об ошибке
                System.out.println("Неверное значение!");
            }else if (value == view.children.size() + 1) {
                break;
            }else  {
                AppView selectedView = view.children.get(value - 1);
                new ShopController(selectedView).run();
            }
        }
    }
}
