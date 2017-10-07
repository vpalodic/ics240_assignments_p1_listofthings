/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings;

import java.io.Serializable;

/**
 * The FavoriteMovieCollection class represents a last-in-first-out (LIFO) collection of objects of type E.
 * The usual push and pop operations are provided, as well as a method to peek at the top item
 * on the collection, a method to test for whether the collection is empty, and a method to search the
 * collection for an item of type E and discover how far it is from the top.
 *  
 * <p>
 * <b>Limitations:</b>
 * <ul>
 * 	<li>
 *   Stacks can be of any length and are limited only by the amount of
 *   free memory on the heap.
 *  </li>
 * 	<li>
 *   Stacks larger than Int.MAX_VALUE will get an incorrect return value from size
 *   because of arithmetic overflow.
 *  </li>
 *  <li>
 *   The push and clone methods will result in an OutOfMemoryError exception when free
 *   memory is exhausted.
 *  </li>
 * </ul>
 * <p>
 * <b>Example:</b>
 * <pre>
 * // Create a new collection with one node that has 10.5 as its data.
 * ArrayStack&lt;Double&gt; shortStack;
 * shortStack = new ArrayStack&lt;Double&gt;(10.5, null);
 * 
 * // Add a couple of nodes to our list.
 * shortStack.push(20.5);
 * shortStack.push(30.5);
 * 
 * // Create a copy of the shortStack
 * ArrayStack&lt;Double&gt; copy = ArrayStack.clone();
 * 	</pre>
 * 
 * @author Vincent J Palodichuk
 * 	<A HREF="mailto:hu0011wy@metrostate.edu"> (e-mail me) </A>
 */
public class FavoriteMovieCollection implements Serializable, Cloneable {
    private static int DEFAULT_INITIAL_CAPACITY = 16;
    private FavoriteMovie[] movies;
    private int numberOfMovies;
    
    /**
     * Creates a new FavoriteMovieCollection with an initial capacity of DEFAULT_INITIAL_CAPACITY (16).
     * <p>
     * <b>Note:</b>
     * <ul>
     * 	<li>
     * 	 The add method works efficiently until the capacity of the
     *   collection is reached.
     * 	</li>
     * 	<li>
     *   When the capacity of this collection is reached, it will automatically
     *   increase by twice the current size.
     *  </li>
     * </ul>
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     *      This collection is empty and has an initial capacity of 16.
     * 	</li>
     * </ul>
     * 
     * @throws OutOfMemoryError
     * 	Indicates insufficient memory.
     */
    public FavoriteMovieCollection() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Creates a new FavoriteMovieCollection with an initial capacity of DEFAULT_INITIAL_CAPACITY (16).
     * <p>
     * <b>Note:</b>
     * <ul>
     * 	<li>
     * 	 The add method works efficiently until the capacity of the
     *   collection is reached.
     * 	</li>
     * 	<li>
     *   When the capacity of this collection is reached, it will automatically
     *   increase by twice the current size.
     *  </li>
     * </ul>
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     *      This collection is empty and has an initial capacity of 16.
     * 	</li>
     * </ul>
     * 
     * @param initialCapacity
     * 	An integer specifying the initial capacity of the collection.
     * @throws IllegalArgumentException
     * 	Indicates <code>initialCapacity</code> is less than zero.
     * @throws OutOfMemoryError
     * 	Indicates insufficient memory
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
     * 	<li>
     * 	  favoriteMovie is not null.
     * 	</li>
     * </ul>
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     * 	  The <code>favoriteMovie</code> was added to the end of this collection,
     *    the number of movies in this collection has been updated to reflect the new movie,
     *    and the return value is the <code>favoriteMovie</code> that was just
     *    added to the collection.
     * 	</li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     *  <li>
     *    This method is efficient (O(1)) up to when the capacity has been
     *    reached. When this happens, the capacity of the collection is doubled,
     *    so future calls will be efficient again.
     *  </li>
     *  <li>
     *    If the collection becomes so large that capacity reaches
     *    Integer.MAX_VALUE, there will be an arithmetic overflow and the
     *    add will fail.
     *  </li>
     * </ul>
     * @param favoriteMovie
     * 	The favoriteMovie to add to the collection, which cannot be null.
     * @return
     *  Returns the FavoriteMovie that was added to the end of the collection.
     * @throws IllegalArgumentException
     * 	Indicates that there is insufficient memory for the new movie.
     * @throws OutOfMemoryError
     * 	Indicates that there is insufficient memory for the new movie.
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
     * Removes the specified FavoriteMovie from the collection.
     * <p>  
     * <b>Precondition:</b>
     * <ul>
     * 	<li>
     * 	  The collection is not empty.
     * 	</li>
     * 	<li>
     * 	  favoriteMovie is not null.
     * 	</li>
     * </ul>
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     * 	  The <code>favoriteMovie</code> was removed from this collection if it,
     *    was in the collection. the return value is the
     *    <code>favoriteMovie</code> that was just deleted from the collection.
     * 	</li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     *  <li>
     *    This method is efficient (O(1)) when deleting a movie but, it takes
     *    O(n) time to find the movie to delete this way.
     *  </li>
     * </ul>
     * @param favoriteMovie
     * 	The favoriteMovie to remove from the collection, which cannot be null.
     * @return
     *  Returns the FavoriteMovie that was removed from the collection or null.
     * @throws IllegalArgumentException
     *  Indicates that favoriteMovie is null.
     * @throws IllegalStateException
     *  Indicates that the collection is empty.
     */
    public FavoriteMovie delete(FavoriteMovie favoriteMovie) {
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
     * 	<li>
     * 	  The collection is not empty.
     * 	</li>
     * 	<li>
     * 	  index is &gt;= 0 and &lt; size().
     * 	</li>
     * </ul>
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     * 	  The <code>favoriteMovie</code> was removed from this collection if it,
     *    was in the collection. the return value is the
     *    <code>favoriteMovie</code> that was just deleted from the collection.
     * 	</li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     *  <li>
     *    This method is efficient (O(1)) when deleting a movie.
     *  </li>
     * </ul>
     * @param index
     * 	The index to remove from the collection. Must be &gt;= 0 and &lt; size()
     * @return
     *  Returns the FavoriteMovie that was removed from the collection or null.
     * @throws IllegalArgumentException
     *  Indicates that index is not &gt;= 0 and &lt; size().
     * @throws IllegalStateException
     *  Indicates that the collection is empty.
     */
    public FavoriteMovie delete(int index) {
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
     * 	<li>
     * 		This collection is empty after the method returns.
     * 	</li>
     * </ul>
     *  Removes all elements from the collection.
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
     * 	<li>
     *      Be sure to cast the return value to the proper <code>FavoriteMovieCollection</code> type
     *      before use.
     * 	</li>
     * </ul>
     * @return
     * 	The return value is a copy of this collection. Subsequent changes to the copy will not affect
     * 	the original, nor vice versa.
     * @throws OutOfMemoryError
     * 	Indicates that there is insufficient memory for the new collection.
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
            throw new RuntimeException ("FavoriteMovieCollection.clone(): This class does not implement Cloneable.");
        }

        // Deep-copy the array.
        answer.movies = movies.clone();

        return answer;
    }

    /**
     * Returns true if the collection is empty; otherwise, false is returned.
     * @return
     *  Returns true if the collection is empty; otherwise, false is returned.
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
     * 	<li>
     * 		This collection's capacity has been changed to at least <code>minimumCapacity</code>. If the capacity was already
     * 		at or greater than <code>minimumCapacity</code>, then the capacity is left unchanged.
     * 	</li>
     * </ul>
     * @param minimumCapacity
     * 	The new capacity of this collection.
     * @throws OutOfMemoryError
     * 	Indicates insufficient memory for altering the capacity.
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
     * 	<li>
     * 	 The push method work efficiently (without needing more memory)
     * 	 until this capacity is reached.
     * 	</li>
     * </ul>
     * @return
     * 	Returns the current capacity of this collection.
     */
    public int getCapacity() {
        return movies.length;
    }

    /**
     * Reduce the current capacity of this collection to its actual size (i.e., the number
     * of elements it contains).
     * <p>  
     * <b>Postcondition:</b>
     * <ul>
     * 	<li>
     * 		This collection's capacity has been changed to its current size.
     * 	</li>
     * </ul>
     * @throws OutOfMemoryError
     * 	Indicates insufficient memory for altering the capacity.
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
     * @param index The zero based index for the desired FavoriteMovie. Must be
     * &gt;= 0 and &lt; size().
     * @return The FavoriteMovie at the specified index.
     * @throws IllegalArgumentException indicates that index is &lt; 0 or &gt;= size()
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
     * Returns the index for the first instance of title found in the collection.
     * If title is not found in the collection, -1 is returned.
     * <p>  
     * <b>Precondition:</b>
     * <ul>
     * 	<li>
     * 	  The collection is not empty.
     * 	</li>
     * </ul>
     * <p>
     * <b>Note:</b>
     * <ul>
     *  <li>
     *      If there are more than one movie with the same title, only
     *      the first one encountered is returned. 
     *  </li>
     *  <li>
     *      The titles are compared for equality without respect to case.
     *  </li>
     *  <li>
     *      Search time is linear.
     *  </li>
     * </ul>
     * @param title
     * 	The title to search for, which may be the null reference.
     * @return
     * 	the index for the first FavoriteMovie that matches the specified
     *  <code>title</code> in the collection. If there is no such title, then -1
     *  is returned.
     * @throws IllegalStateException
     *  Indicates that the collection is empty.
     */
    public int search(String title) {
        int answer = -1;

        if (empty()) {
            throw new IllegalStateException("Cannot search an empty collection.");
        }

        if (title == null)
        {
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
     * Returns the actual number of movies that are contained within this collection.
     * @return
     *  Returns the actual number of movies that are contained within this collection.
     */
    public int size() {
        return numberOfMovies;
    }
}
