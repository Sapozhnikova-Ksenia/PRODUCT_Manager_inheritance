package ru.netology.domain;

import java.util.Objects;
//создали класс смартфон, унаследованный от класса продукт
public class Smartphone extends Product {
    //добавили персональное поле производитель
    private String manufacturer;
    //создали пустой конструктор, с прицепом к родительскому классу
    public Smartphone() {
        super();
    }
    //создали полный конструктор с привязкой к родительскому классу
    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
    //добавили геттеры и сеттеры для нового поля
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    //добавили персональные проверяшки уникальности
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return manufacturer.equals(that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
