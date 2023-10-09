package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;

public class MockCatalogDataImpl  extends CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog() {
        // Создаем пустой список для хранения товаров
        ArrayList<Product> products = new ArrayList<>();
        // Добавляем товары в список products для мок-источника данных
        products.add(new Product("1", "Телефон","Nokio" ,1000, true));
        products.add(new Product("2", "Смартфон","BQ" ,15000, true));
        products.add(new Product("3", "Ноутбук","Hp" ,98000, true));
        products.add(new Product("4", "Ноутбук","Lenovo" ,100000, true));
        products.add(new Product("5", "Lego","Bonsai" ,4900, true));
        products.add(new Product("6", "Apple","телефон" ,499000, false));
        return products;
    }
}
