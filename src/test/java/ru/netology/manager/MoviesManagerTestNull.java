package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoviesManagerTestNull {

    @Test
    void shouldGetNoMoviesForFeed() {
        MovieManager manager = new MovieManager();
        Movie noMovie = new Movie(0, null, null, null, false);
        manager.add(noMovie);

        Movie[] actual = manager.getMoviesForFeed();
        Movie[] expected = new Movie[]{noMovie, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, actual);
    }
}
