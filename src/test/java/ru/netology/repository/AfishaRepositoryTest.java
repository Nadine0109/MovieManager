package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;


class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();

    private Movie first = new Movie(0, "Бладшот", "боевик", "link", false);
    private Movie second = new Movie(1, "Вперёд", "мульфильм", "link", false);
    private Movie third = new Movie(2, "Отель 'Белград'", "комедия", "link", false);
    private Movie forth = new Movie(3, "Джентельмены", "боевик", "link", false);
    private Movie fifth = new Movie(4, "Человек-невидимка", "ужасы", "link", false);
    private Movie sixth = new Movie(5, "Тролли. Мировой тур", "Мультфильм", "link", true);
    private Movie seventh = new Movie(6, "Номер один", "комедия", "link", true);
    private Movie eighth = new Movie(7, "Хабр", "триллер", "link", false);
    private Movie ninth = new Movie(8, "Ведьмак", "любовная комедия", "link", true);
    private Movie tenth = new Movie(9, "Захват", "боевик", "link", true);
    private Movie eleventh = new Movie(10, "Name", "comedy", "link", true);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void findAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        int id = 7;
        Movie actual = repository.findById(id);
        Movie expected = new Movie(7, "Хабр", "триллер", "link", false);
        assertEquals(expected, actual);

    }

    @Test
    void removeById() {
        int idToRemove = 2;
        Movie[] actual = repository.removeById(idToRemove);
        Movie[] expected = new Movie[]{first, second, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}