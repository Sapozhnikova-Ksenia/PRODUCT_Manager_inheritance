package ru.netology.domain;

import java.util.Objects;
//создали класс книга, унаследованный от класса продукт
public class Book extends Product {
    //добавили персональное поле автор
    private String author;
//создали пустой конструктор, с прицепом к родительскому классу
    public Book() {
        super();
    }
//создали полный конструктор с привязкой к родительскому классу
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
//добавили геттеры и сеттеры для нового поля
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//добавили персональные проверяшки уникальности
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "author='" + author + '\'' +
//                '}';
//    }
}
