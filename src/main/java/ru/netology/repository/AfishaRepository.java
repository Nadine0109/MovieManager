package ru.netology.repository;

import org.apache.commons.lang3.ArrayUtils;
import ru.netology.domain.Movie;

public class AfishaRepository {

    private Movie[] movies = new Movie[0];

    public void save(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public Movie[] removeById(int id) {
        Movie[] allMovies = findAll();
        int index = id;
        Movie[] newAllMovies = ArrayUtils.remove(allMovies, index);
        return newAllMovies;
    }

    public Movie[] removeAll() {
        Movie[] none = new Movie[]{};
        return none;
    }
}
