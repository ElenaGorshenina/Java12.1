package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repository = new Repository();
    private Book onegin = new Book(11, "Евгений Онегин", 250, "А.С. Пушкин");
    private Book dubrovskiy = new Book(12, "Дубровский", 274, "А.С. Пушкин");

    @BeforeEach
    public void setUpBook () {
        repository.save(onegin);
        repository.save(dubrovskiy);
    }

    private Smartphone galaxyA12 = new Smartphone(21,"Galaxy A12", 11_990, "Samsung");
    private Smartphone galaxyA21s = new Smartphone(22,"Galaxy A21s", 14_490, "Samsung");
    private Smartphone redmi9 = new Smartphone(23, "Redmi 9", 11_110, "Xiaomi");

    @BeforeEach
    public void setUpSmartphone() {
        repository.save(galaxyA12);
        repository.save(galaxyA21s);
        repository.save(redmi9);
    }

    @Test
    public void findAllTest() {
       Product[] actual = repository.findAll();
       Product[] expected = new Product[] {onegin, dubrovskiy, galaxyA12, galaxyA21s, redmi9};
       assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest(){
        Product[] actual = repository.removeById(21);
        Product[] expected = new Product[] {onegin, dubrovskiy, galaxyA21s, redmi9};
        assertArrayEquals(expected, actual);
    }
}