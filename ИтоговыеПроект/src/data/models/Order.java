package data.models;
import data.models.CartItem;

import java.util.ArrayList;

public class Order {
    public final String name;
    public final String phone;
    public final String address;
    public final String paymentType;
    public final String deliveryTime;

    public final ArrayList<CartItem> cart;

    public Order(String name, String phone, String paymentType, String deliveryTime, String address, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cart = cart;
    }
}

