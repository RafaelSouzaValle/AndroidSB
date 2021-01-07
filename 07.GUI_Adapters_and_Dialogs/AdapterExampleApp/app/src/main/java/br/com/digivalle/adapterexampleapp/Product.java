package br.com.digivalle.adapterexampleapp;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Keyboard", 18.00));
        list.add(new Product("Mouse", 5.00));
        list.add(new Product("Memory", 100.00));

        return list;
    }
}
