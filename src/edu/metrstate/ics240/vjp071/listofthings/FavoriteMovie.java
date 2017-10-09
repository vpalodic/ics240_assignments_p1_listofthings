/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * The FavoriteMovie class contains information about a particular favorite
 * movie The properties of a FavoriteMovie are:
 * <ul>
 * <li>
 * IMDB Number
 * </li>
 * <li>
 * Title (Searchable)
 * </li>
 * <li>
 * Release Year
 * </li>
 * <li>
 * Writer
 * </li>
 * <li>
 * Director
 * </li>
 * <li>
 * Box-office Gross
 * </li>
 * <li>
 * Number of Oscar Nominations
 * </li>
 * </ul>
 *
 * @author Vincent
 */
public class FavoriteMovie implements Serializable {

    /**
     * The constant value returned from getYearsReleased() if no release date
     * has been set for this movie.
     */
    public static final int UNSET_RELEASE_DATE = -2;
    
    /**
     * The constant value returned from getYearsReleased() if the release date
     * is in the future.
     */
    public static final int FUTURE_RELEASE_DATE = -1;

    private Integer imdb;
    private String title;
    private LocalDate releaseDate;
    private String writer;
    private String director;
    private Double gross;
    private Integer nominations;

    public FavoriteMovie() {
        this(null, null, null, null, null, null, null);
    }
    
    public FavoriteMovie(Integer imdb, String title, LocalDate releaseDate, String writer, String director, Double gross, Integer nominations) {
        this.imdb = imdb;
        this.title = title;
        this.releaseDate = releaseDate;
        this.writer = writer;
        this.director = director;
        this.gross = gross;
        this.nominations = nominations;
    }
    
    /**
     * Returns the IMDB number of this movie or null if no IMDB number has been
     * set.
     * 
     * @return The IMDB number of this movie
     */
    public Integer getImdb() {
        return imdb;
    }

    /**
     * Sets the IMDB number of this movie to be the specified IMDB number
     * 
     * @param imdb The new IMDB number for this movie, which may be null
     */
    public void setImdb(Integer imdb) {
        this.imdb = imdb;
    }
    
    /**
     * Returns the title of this movie or null if no title has been set.
     * 
     * @return The title of this movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this movie to be the specified title
     * 
     * @param title The new title for this movie, which may be null
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the release date of this movie or null if no release date has
     * been set.
     * 
     * @return The release date for this movie
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date for this movie to the specified releaseDate
     * 
     * @param releaseDate The new release date for this movie, which
     * may be null.
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Returns the writer for this movie or null if no writer has been set.
     * 
     * @return The writer for this movie.
     */
    public String getWriter() {
        return writer;
    }

    /**
     * Sets the writer for this movie to the specified writer
     * 
     * @param writer The new writer for this movie, which may be null.
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * Returns the director for this movie or null if no director has been set.
     * 
     * @return The director for this movie.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director for this movie to the specified director
     * 
     * @param director The new director for this movie, which may be null.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Returns the box-office gross for this movie or null if no gross has been set.
     * 
     * @return The box-office gross for this movie.
     */
    public Double getGross() {
        return gross;
    }

    /**
     * Sets the box-office gross for this movie to the specified gross
     * 
     * @param gross The new box-office gross for this movie, which may be null.
     */
    public void setGross(Double gross) {
        this.gross = gross;
    }

    /**
     * Returns the number of Oscar nominations for this movie or null if none
     * have been set.
     * 
     * @return The number of Oscar nominations for this movie.
     */
    public Integer getNominations() {
        return nominations;
    }

    /**
     * Sets the number of Oscar nominations for this movie to the specified
     * nominations
     * 
     * @param nominations The new number of Oscar nominations for this movie,
     * which may be null.
     */
    public void setNominations(Integer nominations) {
        this.nominations = nominations;
    }

    /**
     * Returns the number of years since the release date of this movie. If no
     * release date is set, then UNSET_RELEASE_DATE is returned. If the release
     * date is in the future, then FUTURE_RELEASE_DATE is returned. Otherwise
     * the return value is &gt;= 0.
     *
     * @return number of years since the release date of this movie.
     */
    public int getYearsReleased() {
        int answer = 0;

        if (releaseDate == null) {
            answer = -2;
        } else if (releaseDate.isAfter(LocalDate.now()) == true) {
            answer = -1;
        } else {
            Period span = Period.between(releaseDate, LocalDate.now());

            if (span != null) {
                answer = span.getYears();
            }
        }

        return answer;
    }

     /**
     * Returns the hash code for this FavoriteMovie. If two FavoriteMovie are
     * equal, their hash codes will be equal.
     * 
     * @return A hash code for this Product.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(imdb);
        return hash;
    }

    /**
     * Returns true if two FavoriteMovie object references have the same IMDB
     * number.
     * 
     * @param obj The other FavoriteMovie to compare to.
     * @return Returns true if the two FavoriteMovie are considered to be equal.
     */
    @Override
    public boolean equals(Object obj) {
        boolean answer = true;

        if (this == obj) {
            answer = true;
        } else if (obj != null && getClass() == obj.getClass()) {
            final FavoriteMovie other = (FavoriteMovie) obj;

            if (imdb != null && other.imdb != null && Objects.equals(title, other.title) != true) {
                answer = false;
            } else if ((imdb == null) ^ (other.imdb == null)) {
                answer = false;
            }
        } else {
            answer = false;
        }

        return answer;
    }

    /**
     * Returns a String representation of this favorite movie.
     *
     * @return A String representation of this favorite movie.
     */
    @Override
    public String toString() {
        return "IMDB: " + imdb + " -- Title: " + title + " -- Release Date: " + releaseDate + " -- Years in Release: " + getYearsReleased() + " -- Writer: " + writer + " -- Director: " + director + " -- Box Office Gross: " + gross + " -- Oscar Nominations: " + nominations;
    }
}
