package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
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
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        //manager.add(fifth);
        //manager.add(sixth);
        //manager.add(seventh);
        //manager.add(eighth);
        //manager.add(ninth);
        //manager.add(tenth);
    }

    @Test
    void shouldGetMoviesForFeed() {
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    //@Test
    //void shouldGetMoviesForFeedAboveMax() {
    //  manager.add(fifth);
    //  manager.add(sixth);
    //  manager.add(seventh);
    //  manager.add(eighth);
    //  manager.add(ninth);
    //  manager.add(tenth);
    //   manager.add(eleventh);
    //   Movie[] actual = manager.getAll();
    //  Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};
    //  assertArrayEquals(expected, actual);
    // }

    @Test
    void shouldGetFourMovieForFeed() {

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{forth, third, second, first, null, null, null, null, null, null,};
        assertArrayEquals(expected, actual);
    }
}

