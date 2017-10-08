/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code Iterator<FavoriteMovie>} for the {@code FavoriteMovieCollection} class.
 * This is not a fail-fast iterator. The iterator traverses the movies collection
 * from index 0 through numberOfMovies - 1.
 * 
 * @author Vincent J Palodichuk <a href="mailto:hu0011wy@metrostate.edu">
 *         (e-mail me) </a>
 *
 */
public class FavoriteMovieIterator implements Iterator<FavoriteMovie>{
    private final FavoriteMovie[] movies;
    private final int size;
    private int index;

    /**
     * Initializes a new FavoriteMovieIterator bound to the passed in movies array
     * and number of movies. The passed in array cannot be null.
     * This iterator will traverse the movies array from 0 through numberOfMovies - 1.
     * The numberOfMovies must be &gt;= 0 and &lt; movies.length.
     * @param movies The array that contains the FavoriteMovie object references.
     * @param numberOfMovies The number of movies contained in the movies array.
     * 
     * @throws NullPointerException Indicates that tree is null.
     * @throws IllegalArgumentException Indicates that numberOfMovies is negative or greater than the length of the movies array.
     * 
     */
    public FavoriteMovieIterator(FavoriteMovie[] movies, int numberOfMovies) {
        if (movies == null) {
            throw new NullPointerException("The collection cannot be null.");
        }

        if (numberOfMovies < 0) {
            throw new IllegalArgumentException("numberOfMovies cannot be negative.");
        }
        
        if (numberOfMovies > movies.length) {
            throw new IllegalArgumentException("numberOfMovies cannot be greater than the length of the collection.");
        }

        this.movies = movies;
        size = numberOfMovies;
        index = 0;
    }

    /**
     * Returns true if there are more elements to iterate over; otherwise false.
     * @return true if there are more elements to iterate over; otherwise false.
     */
    @Override
    public boolean hasNext() {
        return index < size;
    }

    /**
     * Retrieve the next FavoriteMovie, in sequential order from the underlying
     * source. 
     * @throws NoSuchElementException
     *  Indicates that there are no more items to iterate over.
     * @see java.util.Iterator#next()
     */
    @Override
    public FavoriteMovie next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("All has been iterated over.");
        }
        
        return movies[index++];
    }

    /**
     * The {@code remove()} method is not supported by this iterator.
     * @throws UnsupportedOperationException
     *  This is a read-only iterator and {@code remove()} should not be called.
     * @see java.util.Iterator#remove()
     */
    public void remove() {
        throw new UnsupportedOperationException("This iterator is read-only");
    }
}
