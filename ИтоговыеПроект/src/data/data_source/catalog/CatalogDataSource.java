package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;

public abstract class CatalogDataSource {
    // Абстрактный метод для получения списка товаров из каталога
    public abstract ArrayList<Product> getCatalog();
}
