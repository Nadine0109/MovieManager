package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private AfishaRepository repository;
    private int feedSize = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager() {
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getFeed() {
        Movie[] movies = repository.findAll();
        Movie[] feed = new Movie[feedSize];

        if (movies.length < feedSize) {
            feed = getAll();
        } else {
            for (int i = 0; i < feed.length; i++) {

                System.arraycopy(movies, 0, feed, 0, feed.length);

            }
            for (int i = 0; i < feed.length; i++) {
                int index = movies.length - i - 1;
                feed[i] = movies[index];
            }
        }
        return feed;
    }

    public void removeById(int idToRemove) {
        repository.removeById(idToRemove);
    }
}
