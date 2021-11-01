package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    //готовим место, куда репозиторий будет сохранять, и откуда удалять наши продукты
     Product[] products = new Product[0];
    //делаем метод добавления (сохранения) новых продуктов
//готовим для запоминания массив на 1 больше, копируем все из старого массива, в последнюю
// ячейку кладем наш новый продукт, присваиваем временный массив тмп к нашему массиву продуктов
    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    //метод выведения всего, что есть в нашем массиве продуктов
    public Product[] findAll() {
        return products;
    }

    //метод поиска продукта по ид
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    //удаление продукта из нашего массива по ид
    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}