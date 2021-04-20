package ru.netology.manager;


import lombok.Data;
import ru.netology.domain.Movie;

@Data

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int feedSize;

    public MovieManager() {
        this.feedSize = getFeedSize();
    }

    private Movie[] feed = new Movie[feedSize];

    {
        setFeedSize(10);
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
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getFeed() {
        Movie[] feed = new Movie[feedSize];
        if (movies.length < feedSize) {
            feed = getAll();
        }
        for (int i = 0; i < feed.length; i++) {
            int index = movies.length - i - 1;
            feed[i] = movies[index];
        }
        return feed;
    }
}
