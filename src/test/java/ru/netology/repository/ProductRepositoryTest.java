package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private NotFoundException notFoundException = new NotFoundException();
    private ProductRepository repository = new ProductRepository();
    private Product book1 = new Book(1, "testbook1", 120, "Author", 500, 1920);
    private Product book2 = new Book(2, "testbook1", 120, "Author2", 300, 2000);

    @BeforeEach
    public void add() {
        repository.save(book1);
        repository.save(book2);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = new Product[]{book2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNPE() {
        repository.removeById(3);
        Product[] expected = new Product[]{book2};
        Product[] actual = repository.findAll();
        assertThrows(NullPointerException.class, () -> notFoundException.NPE());
    }

}
