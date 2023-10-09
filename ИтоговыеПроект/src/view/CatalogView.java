package view;

import data.models.Product;
import data.servives.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {
    final ShopService shopService;

    public CatalogView(ArrayList<AppView> children, ShopService shopService) {
        super("Каталог", children);
        this.shopService = shopService;
    }
    @Override
    public  void action() {
        ArrayList<Product> catalog = shopService.getCatalog();
        for (Product p : catalog) {
            System.out.println("ID: "+ p.id + " " + p.title + " " + p.price);
        }
        System.out.println();
    }
}
