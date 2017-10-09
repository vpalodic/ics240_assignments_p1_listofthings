/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings;

import java.time.LocalDate;
import java.util.Iterator;
import javax.swing.AbstractListModel;

/**
 * The FavoriteMovieCollection class represents a collection of FavoriteMovie
 * object references. The usual add and remove operations are provided, as well
 * as a method to test for whether the collection is empty, a method to search
 * the collection for a movie by title to find the movie's location in the
 * collection and a get method to access a specific movie by index. A read-only
 * iterator is provided so that the enhanced for loop can be used to iterate
 * over the entire collection.
 *
 * <p>
 * <b>Limitations:</b>
 * <ul>
 * <li>
 * The collection can be of any length and is limited only by the amount of free memory.
 * </li>
 * <li>
 * Collections larger than Int.MAX_VALUE will get an incorrect return value from size
 * because of arithmetic overflow.
 * </li>
 * <li>
 * The add and clone methods will result in an OutOfMemoryError exception when
 * free memory is exhausted.
 * </li>
 * </ul>
 *
 * @author Vincent J Palodichuk
 * <A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 */
public class FavoriteMovieCollection  extends AbstractListModel<String> implements Cloneable, Iterable<FavoriteMovie> {

    private static int DEFAULT_INITIAL_CAPACITY = 16;
    private FavoriteMovie[] movies;
    private int numberOfMovies;

    /**
     * Creates a new FavoriteMovieCollection with an initial capacity of
     * DEFAULT_INITIAL_CAPACITY (16).
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * The add method works efficiently until the capacity of the collection is
     * reached.
     * </li>
     * <li>
     * When the capacity of this collection is reached, it will automatically
     * increase by twice the current size.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * This collection is empty and has an initial capacity of 16.
     * </li>
     * </ul>
     *
     * @throws OutOfMemoryError Indicates insufficient memory.
     */
    public FavoriteMovieCollection() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Creates a new FavoriteMovieCollection with an initial capacity of
     * DEFAULT_INITIAL_CAPACITY (16).
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * The add method works efficiently until the capacity of the collection is
     * reached.
     * </li>
     * <li>
     * When the capacity of this collection is reached, it will automatically
     * increase by twice the current size.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * This collection is empty and has an initial capacity of 16.
     * </li>
     * </ul>
     *
     * @param initialCapacity An integer specifying the initial capacity of the
     * collection.
     * @throws IllegalArgumentException Indicates <code>initialCapacity</code>
     * is less than zero.
     * @throws OutOfMemoryError Indicates insufficient memory
     */
    public FavoriteMovieCollection(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity: " + initialCapacity + " - initialCapacity must be >= 0");
        }

        initialCapacity = 0;
        movies = new FavoriteMovie[initialCapacity];
    }

    /**
     * Adds the <code>favoriteMovie</code> to the end this collection.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * favoriteMovie is not null.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovie</code> was added to the end of this collection,
     * the number of movies in this collection has been updated to reflect the
     * new movie, and the return value is the <code>favoriteMovie</code> that
     * was just added to the collection.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * This method is efficient (O(1)) up to when the capacity has been reached.
     * When this happens, the capacity of the collection is doubled, so future
     * calls will be efficient again.
     * </li>
     * <li>
     * If the collection becomes so large that capacity reaches
     * Integer.MAX_VALUE, there will be an arithmetic overflow and the add will
     * fail.
     * </li>
     * </ul>
     *
     * @param favoriteMovie The favoriteMovie to add to the collection, which
     * cannot be null.
     * @return Returns the FavoriteMovie that was added to the end of the
     * collection.
     * @throws IllegalArgumentException Indicates that there is insufficient
     * memory for the new movie.
     * @throws OutOfMemoryError Indicates that there is insufficient memory for
     * the new movie.
     */
    public FavoriteMovie add(FavoriteMovie favoriteMovie) {
        if (favoriteMovie == null) {
            throw new IllegalArgumentException("favoriteMovie cannot be null.");
        }

        if (numberOfMovies == movies.length) {
            // Double the capacity and add 1; this works even if numberOfMovies is 0. However, in
            // case that numberOfMovies * 2 + 1 is beyond Integer.MAX_VALUE, there will be an
            // arithmetic overflow and the sequence will fail.
            ensureCapacity(numberOfMovies * 2 + 1);
        }

        // Add the new movie to the end of the sequence.
        movies[numberOfMovies++] = favoriteMovie;

        return favoriteMovie;
    }

    /**
     * Adds the <code>favoriteMovie</code> to the end this collection.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * favoriteMovie is not null.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovie</code> was added to the end of this collection,
     * the number of movies in this collection has been updated to reflect the
     * new movie, and the return value is the <code>favoriteMovie</code> that
     * was just added to the collection.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * This method is efficient (O(1)) up to when the capacity has been reached.
     * When this happens, the capacity of the collection is doubled, so future
     * calls will be efficient again.
     * </li>
     * <li>
     * If the collection becomes so large that capacity reaches
     * Integer.MAX_VALUE, there will be an arithmetic overflow and the add will
     * fail.
     * </li>
     * </ul>
     *
     * @param imdb The IMDB number of the movie, which may be null.
     * @param title The Title of the movie, which may be null.
     * @param releaseDate The Release Date of the movie, which may be null.
     * @param writer The Writer of the movie, which may be null.
     * @param director The Director of the movie, which may be null.
     * @param gross The Box-Office Gross of the movie, which may be null.
     * @param nominations The number of Oscar Nominations received by the movie, which may be null.
     * @return Returns the FavoriteMovie that was added to the end of the
     * collection.
     * @throws IllegalArgumentException Indicates that there is insufficient
     * memory for the new movie.
     * @throws OutOfMemoryError Indicates that there is insufficient memory for
     * the new movie.
     */
    public FavoriteMovie add(Integer imdb, String title, LocalDate releaseDate, String writer, String director, Double gross, Integer nominations) {
        return add(new FavoriteMovie(imdb, title, releaseDate, writer, director, gross, nominations));
    }

    /**
     * Adds the <code>favoriteMovies</code> to the end of this collection.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * favoriteMovies is not null.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovies</code> were added to the end of this collection,
     * the number of movies in this collection has been updated to reflect the
     * new movies.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * If the collection becomes so large that capacity reaches
     * Integer.MAX_VALUE, there will be an arithmetic overflow and the add will
     * fail.
     * </li>
     * </ul>
     *
     * @param favoriteMovies The favoriteMovies to add to the collection, which
     * cannot be null.
     * @throws IllegalArgumentException Indicates that there is insufficient
     * memory for the new movie.
     * @throws OutOfMemoryError Indicates that there is insufficient memory for
     * the new movie.
     */
    public void addAll(FavoriteMovieCollection favoriteMovies) {
        if (favoriteMovies == null) {
            throw new IllegalArgumentException("favoriteMovies cannot be null.");
        }

        ensureCapacity((numberOfMovies + favoriteMovies.size()) * 2);

        // Add the new movies to the end of the sequence.
        System.arraycopy(favoriteMovies.movies, 0, movies, numberOfMovies, favoriteMovies.size());
        numberOfMovies += favoriteMovies.size();
    }

    /**
     * Adds the <code>favoriteMovies</code> to the end of this collection.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * favoriteMovies is not null.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovies</code> were added to the end of this collection,
     * the number of movies in this collection has been updated to reflect the
     * new movies.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * If the collection becomes so large that capacity reaches
     * Integer.MAX_VALUE, there will be an arithmetic overflow and the add will
     * fail.
     * </li>
     * </ul>
     *
     * @param favoriteMovies The favoriteMovies to add to the collection, which
     * cannot be null.
     * @throws IllegalArgumentException Indicates that there is insufficient
     * memory for the new movie.
     * @throws OutOfMemoryError Indicates that there is insufficient memory for
     * the new movie.
     */
    public void addMany(FavoriteMovie... favoriteMovies) {
        if (favoriteMovies == null) {
            throw new IllegalArgumentException("favoriteMovies cannot be null.");
        }

        if (numberOfMovies + favoriteMovies.length > movies.length) {
            ensureCapacity((numberOfMovies + favoriteMovies.length) * 2);
        }

        // Add the new movies to the end of the sequence.
        System.arraycopy(favoriteMovies, 0, movies, numberOfMovies, favoriteMovies.length);
        numberOfMovies += favoriteMovies.length;
    }

    /**
     * Removes the specified FavoriteMovie from the collection.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * The collection is not empty.
     * </li>
     * <li>
     * favoriteMovie is not null.
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovie</code> was removed from this collection if it,
     * was in the collection. the return value is the <code>favoriteMovie</code>
     * that was just deleted from the collection.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * This method is efficient (O(1)) when deleting a movie but, it takes O(n)
     * time to find the movie to remove this way.
     * </li>
     * </ul>
     *
     * @param favoriteMovie The favoriteMovie to remove from the collection,
     * which cannot be null.
     * @return Returns the FavoriteMovie that was removed from the collection or
     * null.
     * @throws IllegalArgumentException Indicates that favoriteMovie is null.
     * @throws IllegalStateException Indicates that the collection is empty.
     */
    public FavoriteMovie remove(FavoriteMovie favoriteMovie) {
        if (empty()) {
            throw new IllegalStateException("Cannot delete from an empty collection.");
        }

        if (favoriteMovie == null) {
            throw new IllegalArgumentException("favoriteMovie cannot be null.");
        }

        FavoriteMovie answer = null;

        for (int i = 0; i < numberOfMovies; i++) {
            FavoriteMovie movie = movies[i];

            if (movie != null && movie.equals(favoriteMovie) == true) {
                answer = movie;
                movies[i] = movies[numberOfMovies-- - 1];
                movies[numberOfMovies] = null;
                break;
            }
        }

        return answer;
    }

    /**
     * Removes the FavoriteMovie from the collection at the specified index.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * The collection is not empty.
     * </li>
     * <li>
     * index is &gt;= 0 and &lt; size().
     * </li>
     * </ul>
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * The <code>favoriteMovie</code> was removed from this collection if it,
     * was in the collection. the return value is the <code>favoriteMovie</code>
     * that was just deleted from the collection.
     * </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>
     * This method is efficient (O(1)) when deleting a movie.
     * </li>
     * </ul>
     *
     * @param index The index to remove from the collection. Must be &gt;= 0 and
     * &lt; size()
     * @return Returns the FavoriteMovie that was removed from the collection or
     * null.
     * @throws IllegalArgumentException Indicates that index is not &gt;= 0 and
     * &lt; size().
     * @throws IllegalStateException Indicates that the collection is empty.
     */
    public FavoriteMovie remove(int index) {
        if (empty()) {
            throw new IllegalStateException("Cannot delete from an empty collection.");
        }

        if (index < 0 || index >= numberOfMovies) {
            throw new IllegalArgumentException("index must be >= 0 and < size().");
        }

        FavoriteMovie answer = movies[index];
        movies[index] = movies[numberOfMovies-- - 1];
        movies[numberOfMovies] = null;

        return answer;
    }

    /**
     * Removes all elements from the collection.
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * This collection is empty after the method returns.
     * </li>
     * </ul>
     * Removes all elements from the collection.
     */
    public void clear() {
        int count = numberOfMovies;

        if (count == 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            movies[i] = null;
            numberOfMovies--;
        }
    }

    /**
     * Generate a copy of this collection.
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * Be sure to cast the return value to the proper
     * <code>FavoriteMovieCollection</code> type before use.
     * </li>
     * </ul>
     *
     * @return The return value is a copy of this collection. Subsequent changes
     * to the copy will not affect the original, nor vice versa.
     * @throws OutOfMemoryError Indicates that there is insufficient memory for
     * the new collection.
     *
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public FavoriteMovieCollection clone() {
        // Clone a ArrayStack<E> object
        FavoriteMovieCollection answer;

        try {
            answer = (FavoriteMovieCollection) super.clone();
        } catch (CloneNotSupportedException exception) {
            // This exception should not occur. But if it does, it would indicate a programming
            // error that made super.clone unavailable. The most common cause would be
            // forgecodeing the "implements Cloneable" clause at the start of the class.
            throw new RuntimeException("FavoriteMovieCollection.clone(): This class does not implement Cloneable.");
        }

        // Deep-copy the array.
        answer.movies = movies.clone();

        return answer;
    }

    /**
     * Returns the number of times the target movie title is found in the 
     * collection. If title is not found in the collection, 0 is returned.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * The collection is not empty.
     * </li>
     * </ul>
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * The titles are compared for equality without respect to case.
     * </li>
     * <li>
     * Search time is linear.
     * </li>
     * </ul>
     *
     * @param target The title to search for, which may be the null reference.
     * @return The number of times target is found in the collection.
     * @throws IllegalStateException Indicates that the collection is empty.
     */
    public int countOccurences(String target) {
        int answer = 0;

        if (empty()) {
            throw new IllegalStateException("Cannot search an empty collection.");
        }

        if (target == null) {
            for (int i = 0; i < numberOfMovies; i++) {
                FavoriteMovie fm = movies[i];
                if (fm != null && fm.getTitle() == null) {
                    answer++;
                }
            }
        } else {
            for (int i = 0; i < numberOfMovies; i++) {
                FavoriteMovie fm = movies[i];
                if (fm != null && fm.getTitle() != null && target.toLowerCase().equals(fm.getTitle().toLowerCase())) {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * Returns true if the collection is empty; otherwise, false is returned.
     *
     * @return Returns true if the collection is empty; otherwise, false is
     * returned.
     */
    public boolean empty() {
        boolean answer = false;

        if (numberOfMovies == 0) {
            answer = true;
        }

        return answer;
    }

    /**
     * Change the current capacity of this collection.
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * This collection's capacity has been changed to at least
     * <code>minimumCapacity</code>. If the capacity was already at or greater
     * than <code>minimumCapacity</code>, then the capacity is left unchanged.
     * </li>
     * </ul>
     *
     * @param minimumCapacity The new capacity of this collection.
     * @throws OutOfMemoryError Indicates insufficient memory for altering the
     * capacity.
     */
    public void ensureCapacity(int minimumCapacity) {
        FavoriteMovie[] biggerArray = null;

        if (movies.length < minimumCapacity) {
            biggerArray = new FavoriteMovie[minimumCapacity];
            System.arraycopy(movies, 0, biggerArray, 0, numberOfMovies);
            movies = biggerArray;
        }
    }

    /**
     * Return the current capacity of this collection.
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * The push method work efficiently (without needing more memory) until this
     * capacity is reached.
     * </li>
     * </ul>
     *
     * @return Returns the current capacity of this collection.
     */
    public int getCapacity() {
        return movies.length;
    }

    /**
     * Reduce the current capacity of this collection to its actual size (i.e.,
     * the number of elements it contains).
     * <p>
     * <b>Postcondition:</b>
     * <ul>
     * <li>
     * This collection's capacity has been changed to its current size.
     * </li>
     * </ul>
     *
     * @throws OutOfMemoryError Indicates insufficient memory for altering the
     * capacity.
     */
    public void trimToSize() {
        FavoriteMovie[] trimmedArray = null;

        if (movies.length != numberOfMovies) {
            trimmedArray = new FavoriteMovie[numberOfMovies];
            System.arraycopy(movies, 0, trimmedArray, 0, numberOfMovies);
            movies = trimmedArray;
        }
    }

    /**
     * Returns the FavoriteMovie found at index.
     *
     * @param index The zero based index for the desired FavoriteMovie. Must be
     * &gt;= 0 and &lt; size().
     * @return The FavoriteMovie at the specified index.
     * @throws IllegalArgumentException indicates that index is &lt; 0 or &gt;=
     * size()
     */
    public FavoriteMovie getAt(int index) {
        if (empty()) {
            throw new IllegalStateException("The collection is empty.");
        }

        if (index < 0 || index >= numberOfMovies) {
            throw new IllegalArgumentException("index: " + index + " - index must be >= 0 and < size()");
        }

        return movies[index];
    }

    /**
     * Returns the index for the first instance of title found in the
     * collection. If title is not found in the collection, -1 is returned.
     * <p>
     * <b>Precondition:</b>
     * <ul>
     * <li>
     * The collection is not empty.
     * </li>
     * </ul>
     * <p>
     * <b>Note:</b>
     * <ul>
     * <li>
     * If there are more than one movie with the same title, only the first one
     * encountered is returned.
     * </li>
     * <li>
     * The titles are compared for equality without respect to case.
     * </li>
     * <li>
     * Search time is linear.
     * </li>
     * </ul>
     *
     * @param title The title to search for, which may be the null reference.
     * @return the index for the first FavoriteMovie that matches the specified
     * <code>title</code> in the collection. If there is no such title, then -1
     * is returned.
     * @throws IllegalStateException Indicates that the collection is empty.
     */
    public int search(String title) {
        int answer = -1;

        if (empty()) {
            throw new IllegalStateException("Cannot search an empty collection.");
        }

        if (title == null) {
            for (int i = 0; i < numberOfMovies; i++) {
                FavoriteMovie fm = movies[i];
                if (fm != null && fm.getTitle() == null) {
                    answer = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < numberOfMovies; i++) {
                FavoriteMovie fm = movies[i];
                if (fm != null && fm.getTitle() != null && title.toLowerCase().equals(fm.getTitle().toLowerCase())) {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }

    /**
     * Returns the actual number of movies that are contained within this
     * collection.
     *
     * @return Returns the actual number of movies that are contained within
     * this collection.
     */
    public int size() {
        return numberOfMovies;
    }

    /**
     * Returns an iterator that can be used to traverse this movie collection.
     *
     * @return An iterator that can be used to traverse this movie collection.
     */
    @Override
    public Iterator<FavoriteMovie> iterator() {
        return new FavoriteMovieIterator(movies, numberOfMovies);
    }

    /**
     * AbstractListModel&lt;String&gt; method that returns the number of movies
     * in the collection.
     * @return The number of movies in the collection.
     */
    @Override
    public int getSize() {
        return size();
    }

    /**
     * AbstractListMode&gt;String&gt; method that returns a string representation
     * of the movie at the specified index.
     * @param index The index of the movie to return
     * @return The string representation of the movie
     */
    @Override
    public String getElementAt(int index) {
        return getAt(index).toString();
    }
}
