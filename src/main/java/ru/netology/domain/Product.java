package ru.netology.domain;

import java.util.Objects;
//создали класс продукт с полями
public class Product {
    private int id;
    private String name;
    private int price;
//сделали пустой конструктор
    public Product() {
    }
//сделали полный конструктор
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
//наделали геттеров и сеттеров
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//добавили персональные проверяшки на уникальность
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

}

