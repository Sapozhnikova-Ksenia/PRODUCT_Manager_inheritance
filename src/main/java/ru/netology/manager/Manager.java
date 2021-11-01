package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

public class Manager {
    Repository repository= new Repository();
    //наш менеджер должен считать сложные вещи, и хранить в поле место, где он все запоминает, соответственно
    //в поле у него будет репозиторий

    //далее создаем конструктор с репозиторием, по логике будет читаться "я умный менеджер, могу работать в любым
    //помощником-репозиторием, дайте мне его (на вход в скобках и будет прописан даваемый в помощь репозиторий)
    public Manager() {
        this.repository = repository;
    }

    //дальше прописываем метод- добавление в репозиторий (в последующем наш массив) какого-либо продукта
    //логика добавления у нас уже была прописана в репозитории
    //поэтому пишем: метод , он публичный, название -Адд (добавление), в круглых скобках указываем что мы хотим
    //добавить продукт, и прописываем его тип Продукт, далее в фигурных скобках прописываем логику, а именно
    //отсылку к команде репозиторий.выполни команду сохранения, что именно надо сохранить указано в круглых скобках)
    public void add(Product product) {
        repository.save(product);
    }

//дальше пишем метод на возвращение(нахождение) товара по тексту
    public  Product[] searchBy (String text){
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;

        }
        return false;
    }
}