/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.metrstate.ics240.vjp071.listofthings;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    private transient final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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

    private FavoriteMovie(String[] props) {
        if (props == null || props.length != 7) {
            throw new IllegalArgumentException("props is null or does not contain 7 properties.");
        }
        
        try {
            Integer imdb1 = Integer.parseInt(props[0]);
            this.imdb = imdb1;
        } catch (NullPointerException | NumberFormatException ex) {
            
        }
        
        this.title = (props[1] == null || props[1].trim().isEmpty()) ? null : props[1].trim();
        
        try {
            LocalDate releaseDate1 = LocalDate.parse(props[2]);
            this.releaseDate = releaseDate1;
        } catch (NullPointerException | DateTimeParseException ex) {
            
        }
        
        this.writer = (props[3] == null || props[3].trim().isEmpty()) ? null : props[3].trim();
        this.director = (props[4] == null || props[4].trim().isEmpty()) ? null : props[4].trim();

        try {
            Double gross1 = Double.parseDouble(props[5]);
            this.gross = gross1;
        } catch (NullPointerException | NumberFormatException ex) {
            
        }
        
        try {
            Integer nominations1 = Integer.parseInt(props[6]);
            this.nominations = nominations1;
        } catch (NullPointerException | NumberFormatException ex) {
            
        }
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
        Integer oldValue = this.imdb;
        this.imdb = imdb;
        pcs.firePropertyChange("imdb", oldValue, imdb);
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
        String oldValue = this.title;
        this.title = title;
        pcs.firePropertyChange("title", oldValue, title);
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
        LocalDate oldValue = this.releaseDate;
        int oldYR = getYearsReleased();
        this.releaseDate = releaseDate;
        int newYR = getYearsReleased();
        pcs.firePropertyChange("releaseDate", oldValue, releaseDate);
        
        if (oldYR != newYR) {
            pcs.firePropertyChange("yearsReleased", oldYR, newYR);
        }
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
        String oldValue = this.writer;
        this.writer = writer;
        pcs.firePropertyChange("writer", oldValue, writer);
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
        String oldValue = this.director;
        this.director = director;
        pcs.firePropertyChange("director", oldValue, director);
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
        Double oldValue = this.gross;
        this.gross = gross;
        pcs.firePropertyChange("gross", oldValue, gross);
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
        Integer oldValue = this.nominations;
        this.nominations = nominations;
        pcs.firePropertyChange("nominations", oldValue, nominations);
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
    
    public static String getTabDelimitedHeader() {
        StringBuilder output = new StringBuilder();
        String delim = "\t";
        
        output.append("IMDB#");
        output.append(delim);
        output.append("TITLE");
        output.append(delim);
        output.append("RELEASE_DATE");
        output.append(delim);
        output.append("DIRECTOR");
        output.append(delim);
        output.append("WRITER");
        output.append(delim);
        output.append("BOX-OFFICE");
        output.append(delim);
        output.append("OSCAR_NOMINATIONS");
        
        return output.toString();
    }

    /**
     * Returns a tab delimited string representation of this FavoriteMovie.
     * <p>The order of the fields in the string are:
     * <ul>
     *  <li>
     *      IMDB# - 7 digits max
     *  </li>
     *  <li>
     *      TITLE
     *  </li>
     *  <li>
     *      RELEASE_DATE - yyyy-MM-dd format
     *  </li>
     *  <li>
     *      DIRECTOR
     *  </li>
     *  <li>
     *      WRITER
     *  </li>
     *  <li>
     *      BOX-OFFICE
     *  </li>
     *  <li>
     *      OSCAR_NOMINATIONS
     *  </li>
     * </ul>
     * <p>
     * <b>Notes:</b>
     * <ul>
     *  <li>
     *      getTabDelimitedHeader() can be used to generate a tab delimited
     *      header that matches the order listed above. 
     *  </li>
     * </ul>
     * @return A tab delimited string representation of this FavoriteMovie.
     */
    public String toTabDelimited() {
        StringBuilder output = new StringBuilder();
        String delim = "\t";
        
        if (imdb == null) {
            output.append(" ");
        } else {
            output.append(String.format("%07d", imdb));
        }
        
        output.append(delim);
        output.append(String.format("%s", title == null ? " " : title));
        output.append(delim);
        output.append(String.format("%s", releaseDate == null ? " " : releaseDate.toString()));
        output.append(delim);
        output.append(String.format("%s", director == null ? " " : director));
        output.append(delim);
        output.append(String.format("%s", writer == null ? " " : writer));
        output.append(delim);
        if (gross == null) {
            output.append(" ");
        } else {
            output.append(String.format("%.2f", gross));
        }
        output.append(delim);
        if (nominations == null) {
            output.append(" ");
        } else {
            output.append(String.format("%02d", nominations));
        }
        
        return output.toString();
    }
    
    /**
     * Returns a String representation of this favorite movie.
     *
     * @return A String representation of this favorite movie.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        
        if (imdb == null) {
            output.append(String.format("IMDB: %s     ", "No IMDB Number"));
        } else {
            output.append(String.format("IMDB: %07d     ", imdb));
        }
        
        output.append(String.format("Title: %s     ", title));
        
        if (releaseDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            output.append(String.format("Release Date: %s     ", releaseDate.format(formatter)));
        } else {
            output.append(String.format("Release Date:                "));
        }
        
        output.append("Years in Release: ");
        
        if (releaseDate == null) {
            output.append(String.format("No Release Date     "));
        } else if (releaseDate.isAfter(LocalDate.now())) {
            output.append(String.format("Future Release     "));
        } else {
            output.append(String.format("%02d     ", getYearsReleased()));
        }
        
        if (director == null) {
            output.append(String.format("Director: %s     ", "No Director"));
        } else {
            output.append(String.format("Director: %s     ", director));
        }
        
        if (writer == null) {
            output.append(String.format("Writer: %s     ", "No Writer"));
        } else {
            output.append(String.format("Writer: %s     ", writer == null ? "" : writer));
        }
        
        if (gross == null) {
            output.append(String.format("Box Office: %s     ", "No Box Office"));
        } else {
            NumberFormat numFormatter = NumberFormat.getCurrencyInstance();
            output.append(String.format("Box Office: %s     ", numFormatter.format(gross)));
        }

        if (nominations == null) {
            output.append(String.format("Oscar Nominations: %s     ", "No Oscar Nominations"));
        } else {
            output.append(String.format("Oscar Nominations: % 2d", nominations));
        }
        
        return output.toString();
    }
    
    /**
     * Returns a new FavoriteMovie initialized from the passed in tab delimited string.
     * @param movie The tab delimited string that contains the values for the movie.
     * @return A new FavoriteMovie initialized from the passed in movie string.
     * @throws IllegalArgumentException indicates that movie is null or that
     * movie is poorly formatted. See toTabDelimited for the expected format.
     */
    public static FavoriteMovie fromString(String movie) {
        String delim = "\\t";
        FavoriteMovie answer = null;
        
        if (movie == null) {
            throw new IllegalArgumentException("movie cannot be null.");
        }
        
        String[] props = movie.split(delim);
        
        if (props.length != 7) {
            throw new IllegalArgumentException("movie appears to be corrupt.");
        }
        
        answer = new FavoriteMovie(props);
        
        return answer;
    }
    
    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener )
    {
        pcs.addPropertyChangeListener( listener );
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener )
    {
        pcs.removePropertyChangeListener( listener );
    }
}
