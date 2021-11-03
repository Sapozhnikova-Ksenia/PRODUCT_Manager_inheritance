package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    //вводим через приватное поле (чтоб никто не дотянулся) для использования наш менеджер, который будет стабильный,
    // неизменяемый (финал мы объявляем сразу, в самом начале, когда вводим поле), и через нью создаем новый "коробок"
    // с менеджером, на вход который будет принимать также новый репозиторий

    private final Manager manager = new Manager(new Repository());
    //добавляем проверочные данные
    //помним, что поля у нас приватные
    private Book one = new Book(1, "The City of yellow Devil", 2300, "Maxim Gorkiy");
    private Book two = new Book(23, "Griet from the mind", 3200, "Alexander Griboedov");
    private Smartphone three = new Smartphone(456, "3310", 4200, "Nokia");
    private Smartphone four = new Smartphone(78910, "iPhone 12 Pro", 85000, "Apple");
    private Book five = new Book(1112131415, "iPhone 12 Pro", 1720, "Steve Jobs");
    private Product six = new Product(01, "Bike", 89000);

    //добавляем БефорИч, чтобы это действие автоматом производилось перед каждым
    // тестом и нам это в каждом тесте не нужно было прописывать ручками- добавляем наши товары в репозиторий,
    // через команду в менеджере
    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
    }

    @Test
    public void shouldSearchByName() {

        Product[] actual = manager.searchBy("The City of yellow Devil");
        Product[] expected ={one};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByManufacturer() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {four};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthor() {

        Product[] actual = manager.searchBy("Alexander Griboedov");
        Product[] expected = {two};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAnybodyFindNothing() {

        Product[] actual = manager.searchBy("Motorolla");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByDoubleName() {

        Product[] actual = manager.searchBy("iPhone 12 Pro");
        Product[] expected = new Product[]{four,five};
        assertArrayEquals(actual, expected);

    }
}