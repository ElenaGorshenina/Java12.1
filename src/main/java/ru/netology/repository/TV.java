package ru.netology.repository;

public class TV extends Product {
    private String manufacturer;

    public TV() {
        super();
    }

    public TV(int id, String name, int price, String author) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
