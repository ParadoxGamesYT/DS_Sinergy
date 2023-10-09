package view;

import java.util.ArrayList;

public class MainView  extends AppView {
    public MainView(ArrayList<AppView> children) {
        // Вызывает конструктор родительского класса AppView с названием главного меню
        super("Магазин Фиксик", children);
    }
}
