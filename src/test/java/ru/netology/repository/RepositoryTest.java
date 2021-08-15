package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repository = new Repository();
    private Book onegin = new Book(11, "Евгений Онегин", 250, "А.С. Пушкин");
    private Book dubrovskiy = new Book(12, "Дубровский", 274, "А.С. Пушкин");

    private Smartphone galaxyA12 = new Smartphone(21, "Galaxy A12", 11_990, "Samsung");
    private Smartphone galaxyA21s = new Smartphone(22, "Galaxy A21s", 14_490, "Samsung");
    private Smartphone redmi9 = new Smartphone(23, "Redmi 9", 11_110, "Xiaomi");

    @BeforeEach
    public void setUp() {
        repository.save(onegin);
        repository.save(dubrovskiy);
        repository.save(galaxyA12);
        repository.save(galaxyA21s);
        repository.save(redmi9);
    }

    @Test
    public void findAllTest() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{onegin, dubrovskiy, galaxyA12, galaxyA21s, redmi9};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        Product[] actual = repository.removeById(11);
        Product[] expected = new Product[]{dubrovskiy, galaxyA12, galaxyA21s, redmi9};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest() {
        Product actual = repository.findById(12);
        assertEquals(dubrovskiy, actual);
    }

    @Test
    public void notFoundFindByIdTest() {
        Product actual = repository.findById(5);
        assertEquals(null, actual);
    }

    @Test
    public void shouldThrowNotFoundIdException() {
        assertThrows(NotFoundIdException.class, () -> {
            repository.removeById(5);
        });
    }
}