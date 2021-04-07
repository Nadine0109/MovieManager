package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager {
    private Movie[] movies = new Movie[0];
    int feedSize = 10;
    Movie[] feed = new Movie[feedSize];

    {
        for (int i = 0; i < feedSize; i++)
            feed[i] = new Movie();
    }


    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[feed.length];

        for (int i = 0; i < movies.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }

    public Movie[] getTheFeed() {
        Movie[] lastAddedMovies = new Movie[feed.length];
        Movie[] allMovies = getAll();
        for (int i = 0; i < feed.length; i++) {
            int theFeed = allMovies.length - i - 1;
            lastAddedMovies[i] = movies[theFeed];
        }
        return lastAddedMovies;
    }
}
