package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Repository repository = new Repository();
    private Smartphone galaxyA12 = new Smartphone(21,"Galaxy A12", 11_990, "Samsung");
    private Smartphone galaxyA21s = new Smartphone(22,"Galaxy A21s", 14_490, "Samsung");
    private Smartphone redmi9 = new Smartphone(23, "Redmi 9", 11_110, "Xiaomi");

    @BeforeEach
    public void setUp() {
        repository.save(galaxyA12);
        repository.save(galaxyA21s);
        repository.save(redmi9);
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        }
    }

    @Test
    public void findAllTest(){
        Product[] actual = repository.findAll();
        Product[] expected = new Product[] {galaxyA12, galaxyA21s, redmi9};
        assertArrayEquals(expected, actual);
    }
}