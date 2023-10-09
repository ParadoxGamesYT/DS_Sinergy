package view;

import java.util.ArrayList;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;

    // Конструктор, который инициализирует заголовок
    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    // Абстрактный метод
    public  void action() {};

    // Метод, который выводит список в консоль
    public void displayChildren() {
        System.out.println(title);
        System.out.println("Выберите от 1 до " + (children.size() + 1));

        // Выводим нумерованный список
        for (int i = 0; i < children.size(); i++) {
            AppView view = children.get(i);
            System.out.println(i + 1 + " - " + view.title);
        }
        System.out.println(children.size() + 1 + " - Назад");
    }
}
