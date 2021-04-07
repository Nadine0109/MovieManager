package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(0, "link", "Бладшот", "боевик", false);
    private Movie second = new Movie(1, "link", "Вперёд", "мульфильм", false);
    private Movie third = new Movie(2, "link", "Отель 'Белград'", "комедия", false);
    private Movie forth = new Movie(3, "link", "Джентельмены", "Боевик", false);
    private Movie fifth = new Movie(4, "link", "Человек-невидимка", "Ужасы", false);
    private Movie sixth = new Movie(5, "link", "Тролли. Мировой тур", "Мультфильм", true);
    private Movie seventh = new Movie(6, "link", "Номер один", "Комедия", true);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    void shouldGetMoviesForFeed() {
        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, forth, third, second, first, null, null, null};
        assertArrayEquals(expected, actual);
    }
}
