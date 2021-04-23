package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestOneMovieAndNull {

    @Test
    void shouldGetOneMovieForFeed() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie(0, "Бладшот", "боевик", "link", false);
        manager.add(first);

        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNoMoviesForFeed() {
        MovieManager manager = new MovieManager();

        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}