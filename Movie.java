import java.io.*;
import java.util.*;

/**
 * Movie Class for Project 3.  This class provides an object
 * that will hold one movie and its corresponding information.
 *
 * @author Jerry Heuring
 *
 */

public class Movie {
    private int yearReleased, runningTime;
    private String title;

    /**
     * Default constructor.  It initializes to the empty string
     * for a title and 0's for runningTime and yearReleased.
     */
    public Movie() {
        this ("", 0, 0);
    }


    /**
     * Default constructor.  It initializes to the empty string
     * for a title and 0's for runningTime and yearReleased.
     */
    public Movie(String title){
        this.title = title.trim();
        yearReleased = 0;
        runningTime = 0;
    }

    /**
     * Complete Constructor -- takes all fields.
     * @param title         The title of this movie
     * @param yearReleased  The year that this movie was released.
     * @param runningTime   The number of minutes that this movie runs.
     */
    public Movie (String title, int yearReleased, int runningTime) {
        this.title        = title.trim();
        this.yearReleased = yearReleased;
        this.runningTime  = runningTime;
    }

    /**
     * A copy constructor...
     * @param m  the movie that this movie is to copy
     */
    public Movie (Movie m) {
        this.title        = m.getTitle().trim();
        this.yearReleased = m.getYearReleased();
        this.runningTime  = m.getRunningTime();
    }

    /**
     *
     * @return The year that this movie was released
     */
    public int getYearReleased() {
        return yearReleased;
    }

    /**
     *
     * @return  The running time in minutes of this movie
     */
    public int getRunningTime() {
        return runningTime;
    }

    /**
     *
     * @return  The title of this movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method gets the first letter of each word in the
     * title and finds their values.  The values are returned to
     * the caller in an integer array.
     *
     * @return an array with the numeric values of all the initial
     *           letters of the words.
     */
    private int[] getFirstLetterCodes() {
        String [] words;
        int [] result;
        words = title.split(" ");
        result = new int[words.length];
        for (int wordNbr = 0; wordNbr < words.length; wordNbr++) {
            if (words.length != 0 && words[wordNbr].length() > 0) {
                result[wordNbr] = Character.valueOf(words[wordNbr].charAt(0));
            }
        }
        return result;
    }


    /**
     * This routine is to be supplied by the student.  The hash key is
     * generated for this movie and returned to the caller.
     * @return  The hash key for this movie.
     */
    public int getHashKey(LinkedList[] array) {
        int result = 0;
        for(int i = 0; i < getFirstLetterCodes().length; i++){
            result += (getFirstLetterCodes()[i] * 128);
        }
        result %= array.length;
        return result;
    }

    /**
     * Convert this movie to a string.
     */
    public String toString() {
        return "\""+title + "\" Released in : " + yearReleased + " Running Time : " + runningTime + " minutes";
    }
}