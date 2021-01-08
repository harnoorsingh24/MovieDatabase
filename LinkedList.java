/**
 * Create a linked list node to store information about movies.
 */
class Node{
    Node next;
    Movie value;
    Node(Movie movie){
        this.next = null;
        this.value = movie;
    }
}

/**
 * Make a linked list for the hashtable to store multiple movies in a cell
 */
public class LinkedList {
    int moviesVisited = 0;
    Node front;
    LinkedList(){
        Node front = null;
    }

    /**
     * Add a movie to the linked list
     * @param movie Movie being added
     */
    public void addMovie(Movie movie) {
        Node newNode = new Node(movie);
        if(front == null)
            front = newNode;
        else
            newNode.next = front.next;
        front.next = newNode;
    }

    /**
     * Remove a movie from the linkedlist
     * @param movie Movie being removed
     * @return MOvie that was removed
     */
    public Movie removeMovie(Movie movie){
        Node temp = front, tempAltered = front;
        do{
            if(temp.value.getTitle().equals(movie.getTitle())){
                if(temp != tempAltered){
                    tempAltered.next = temp.next;
                    break;
                }
                front = front.next = null;
                break;
            }
            if(temp != tempAltered){
                tempAltered = tempAltered.next;
            }
            temp = temp.next;
            moviesVisited++;
        }while (temp != front);
        return temp.value;
    }

    /**
     * Find a specific movie the user wants
     * @param movie Movie being found
     * @return Movie if found
     */
    public Movie findMovie(Movie movie){
        Node x = front;
        if(x != null){
            do{
                if(x.value.getTitle().equals(movie.getTitle()))
                    return x.value;
                moviesVisited++;
                x = x.next;
            }while (x != front);
        }
        return null;
    }

    /**
     * Print all the movies in the linked list
     */
    public void printAll(){
        Node temp = front;
        if(temp != null){
            do{
                System.out.println(temp.value);
                temp = temp.next;
            }while (temp != front);
        }
    }

    /**
     * Count all the movies visited the linked list
     * @return Number of movies in the linked list that were visited
     */
    public int count(){
        Node temp = front;
        int count = 0;
        if(temp != null){
            do{
                count++;
                temp = temp.next;
            }while (temp != front);
        }
        return count;
    }
}
