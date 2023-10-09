package data.data_source.order;

import data.models.Order;

public class MockOrderDataSourceImpl  extends OrderDataSource{

    private Order order;

    // Метод для сохранения заказа
    @Override
    public void createOrder(Order order) {
        this.order = order;
    }

    // Метод для получения заказа
    @Override
    public Order getOrder() {
        return order;
    }
}
