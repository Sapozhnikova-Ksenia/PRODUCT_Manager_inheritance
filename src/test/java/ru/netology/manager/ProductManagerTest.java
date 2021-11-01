package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    //добавляем проверочные данные
    Product one = new Book(1, "The City of yellow Devil", 2300, "Maxim Gorkiy");
    Product two = new Book(23, "Griet from the mind", 3200, "Alexander Griboedov");
    Product three = new Smartphone(456, "3310", 4200, "Nokia");
    Product four = new Smartphone(78910, "iPhone 12 Pro", 85000, "Apple");


    @Test
    public void shouldSearchByName() {
        Manager manager = new Manager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("The City of yellow Devil");
        Product[] expected = new Product[]{one};
        assertArrayEquals(actual, expected);

    }
    public void shouldSearchBy() {
        Manager manager = new Manager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("The City of yellow Devil");
        Product[] expected = new Product[]{one};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByManufacturer() {
        Manager manager = new Manager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{four};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthor() {
        Manager manager = new Manager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Alexander Griboedov");
        Product[] expected = new Product[]{two};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAnybodyFindNothing() {
        Manager manager = new Manager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Motorolla");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

}