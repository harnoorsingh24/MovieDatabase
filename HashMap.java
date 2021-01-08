/**
 * HashTable class that stroes all the movies.
 */
public class HashMap {
    LinkedList[] list;
    int visited = 0;

    /**
     * Construtor that creates a hashtable and initializes it to a size the user gives
     * @param size the size of the hashtable
     */
    HashMap(int size){
        list = new LinkedList[size];
        create();
    }

    private void create(){
        for(int i = 0; i < list.length; i++){
            list[i] = new LinkedList();
        }
    }

    /**
     * Insert a movie into the hashmap
     * @param movie Movie being inserted
     */
    public void insertMovie(Movie movie){
        int pos = movie.getHashKey(list);
        list[pos].addMovie(movie);
    }

    /**
     * get a movie from the hashmap
     * @param movie movie that the user is getting
     */
    public void get(Movie movie){
        int pos = movie.getHashKey(list);
        list[pos].removeMovie(movie);
    }

    /**
     * Find a specific movie asked for by the user
     * @param movie Movie being found
     */
    public void findMovie(Movie movie){
        for(int i = 0; i < list.length; i++){
            if(list[i].findMovie(movie) != null){
                System.out.println(list[i].findMovie(movie));
                return;
            }
        }
        System.out.println("MOVIE NOT FOUND");
    }

    /**
     * print all the movies in the hashmap
     */
    public void print(){
        for(int i = 0; i < list.length; i++){
            list[i].printAll();
        }
    }

    /**
     * Count the movies visited in the hashtable.
     * @return number of movies visited
     */
    public int count(){
        int count = 0;
        for(int i = 0; i < list.length; i++){
            count = count + list[i].count();
        }
        return count;
    }

    /**
     * get the number of movies visited
     * @return the integer of the number of movies visited in the hashmap
     */
    public int getVisited(){
        for(int i = 0; i < list.length; i++){
            visited = visited + list[i].moviesVisited;
        }
        return visited;
    }
}
