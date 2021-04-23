package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerFullTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
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
    public void shouldSetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = new Movie[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldGetTenMoviesForFeed() {
        Movie[] returned = new Movie[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoviesForFeedAboveMax() {
        Movie[] returned = new Movie[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFourMovieForFeed() {
        Movie[] returned = new Movie[]{first, second, third, forth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOneMovieForFeed() {
        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNoMoviesForFeed() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}