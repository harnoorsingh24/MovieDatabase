import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Project3 {
    Scanner userInput = new Scanner(System.in);
    int getCommandCounter = 0, findCommandCounter = 0;

    /**
     * Main Program
     * @param arguments Not used in this program
     */
    public static void main(String[] arguments) {
        Project3 project3 = new Project3();
        Scanner input = new Scanner(System.in);

        System.out.println("What is the movie table size: ");
        int tableSize = input.nextInt();
        HashMap movieListHolder = new HashMap(tableSize);
        project3.fileReader(movieListHolder);

        /**
         * While loop that goes through all the commands the user enters until they type "q" to quit and end up hitting the break
         */
        while(true){
            System.out.println("Please enter a command: ");
            String userInput = input.next();

            if(userInput.equalsIgnoreCase("A"))
                project3.addMovie(movieListHolder);

            else if(userInput.equalsIgnoreCase("G"))
                project3.getMovie(movieListHolder);

            else if(userInput.equalsIgnoreCase("F"))
                project3.findMovie(movieListHolder);

            else if(userInput.equalsIgnoreCase("L"))
                movieListHolder.print();

            else if(userInput.equalsIgnoreCase("O"))
                System.out.println((double)movieListHolder.count()/movieListHolder.list.length);

            else if(userInput.equalsIgnoreCase("Q"))
            {
                project3.quit(movieListHolder);
                break;
            }
        }
    }

    /**
     * Read in the file the user sends in and go through that file creating all the movie objects
     * @param movieList The Hashmap that will store all the movies
     */
    public void fileReader(HashMap movieList){
        String title = null;
        int yearReleased = 0, runningTime = 0;
        File file = new File("C:\\Users\\harno\\IdeaProjects\\Project3\\src\\movies.txt");
        try{
            Scanner reader = new Scanner(file);
            try{
                while(reader.hasNextLine()){
                    title = reader.nextLine();
                    yearReleased = reader.nextInt();
                    runningTime = reader.nextInt();
                    reader.nextLine();
                    Movie temp = new Movie(title, yearReleased, runningTime);
                    movieList.insertMovie(temp);
                }
            }
            catch(NoSuchElementException e){
                Movie temp = new Movie(title, yearReleased, runningTime);
                movieList.insertMovie(temp);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Add a movie to the hashmap that stores all the movies
     * @param movieListHolder The Hashmap that will store all the movies
     */
    public void addMovie(HashMap movieListHolder){
        System.out.println("Input Movie title, year released, and run time:");
        String title = userInput.nextLine();
        int releaseYear = userInput.nextInt();
        int runTime = userInput.nextInt();
        Movie movie = new Movie(title, releaseYear, runTime);
        movieListHolder.insertMovie(movie);
    }

    /**
     * Get a specific movie from the movie hashmap. Keep track of the get commands
     * @param movieListHolder The Hashmap that will store all the movies
     */
    public void getMovie(HashMap movieListHolder){
        System.out.println("Input movie title:");
        String title = userInput.nextLine();
        Movie movie = new Movie(title);
        movieListHolder.get(movie);
        getCommandCounter++;

    }

    /**
     * Find a movie from the hashmap that stores all the movies. Keep track of the find commands.
     * @param movieListHolder The Hashmap that will store all the movies
     */
    public void findMovie(HashMap movieListHolder){
        System.out.println("Input movie title:");
        String title = userInput.nextLine();
        Movie movie = new Movie(title);
        movieListHolder.findMovie(movie);
        findCommandCounter++;

    }

    /**
     * Stop running all the commands, and print out the number of times the user prompted for get or find commands
     * @param movieListHolder The Hashmap that will store all the movies
     */
    public void quit(HashMap movieListHolder){
        System.out.println("Get Commands: " + getCommandCounter);
        System.out.println("Find Commands: " + findCommandCounter);
        System.out.println("Total Movies Visited: " + movieListHolder.getVisited());

    }
}
