package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private NotFoundException notFoundException = new NotFoundException();
    private ProductRepository repository = new ProductRepository();
    private Product book1 = new Book(1, "книга", 120, "автор", 500, 1920);
    private Product book2 = new Book(2, "другая книга", 120, "другой автор", 300, 2000);
    private Product tshirt1 = new TShirt(5, "Шапка", 120, "красный", "L");

    @BeforeEach
    public void add() {
        repository.save(book1);
        repository.save(book2);
        repository.save(tshirt1);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = new Product[]{book2, tshirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNPE() {
        repository.removeById(3);
        assertThrows(NullPointerException.class, () -> notFoundException.NPE());
    }

}
