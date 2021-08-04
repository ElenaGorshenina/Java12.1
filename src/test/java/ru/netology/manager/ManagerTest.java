package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.*;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repository = new Repository();
    public Manager manager = new Manager(repository);
    private Book onegin = new Book(11, "Евгений Онегин", 250, "А.С. Пушкин");
    private Book dubrovskiy = new Book(12, "Дубровский", 274, "А.С. Пушкин");

    @BeforeEach
    public void setUpBook() {
        manager.add(onegin);
        manager.add(dubrovskiy);
    }

    private Smartphone galaxyA12 = new Smartphone(21, "Galaxy A12", 11_990, "Samsung");
    private Smartphone galaxyA21s = new Smartphone(22, "Galaxy A21s", 14_490, "Samsung");
    private Smartphone redmi9 = new Smartphone(23, "Redmi 9", 11_110, "Xiaomi");

    @BeforeEach
    public void setUpSmartphone() {
        manager.add(galaxyA12);
        manager.add(galaxyA21s);
        manager.add(redmi9);
    }

    @Test
    public void searchByIdSmartphoneTest() {
        Product[] expected = new Product[]{redmi9};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByIdBookTest() {
        Product[] expected = new Product[]{onegin, dubrovskiy};
        Product[] actual = manager.searchBy("А.С. Пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notSearchByIdTest () {
        TV model1 = new TV(31, "UE43TU7090U", 29_400, "Samsung");
        manager.add(model1);
        Product[] expected = new Product[]{galaxyA12, galaxyA21s};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}