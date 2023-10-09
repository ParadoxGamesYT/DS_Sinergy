import controller.ShopController;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.servives.ShopService;
import view.*;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        // Создает источники данных для корзины, каталога и заказа
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();

        // Создает сервис магазина, который использует указанные выше источники данных
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource );

        // Создает представления для добавления товаров в корзину, каталог, корзину и заказ
        AppView addToCartView = new AddToCartView(shopService);
        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        AppView catalogView = new CatalogView(catalogChildren, shopService);
        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        // Создает основной вид для каталога, корзины и заказа
        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        // Создает контроллер магазина с основным видом и запускаем его
        new ShopController(mainView).run();
    }
}
