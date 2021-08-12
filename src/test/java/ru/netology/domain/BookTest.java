package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Repository repository = new Repository();
    private Book onegin = new Book(11, "Евгений Онегин", 250, "А.С. Пушкин");
    private Book dubrovskiy = new Book(12, "Дубровский", 274, "А.С. Пушкин");

    @BeforeEach
    public void setUp () {
        repository.save(onegin);
        repository.save(dubrovskiy);
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }

    @Test
    public void findAllTest(){
        Product[] actual = repository.findAll();
        Product[] expected = new Product[] {onegin, dubrovskiy};
        assertArrayEquals(expected, actual);
    }


}