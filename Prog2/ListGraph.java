package Prog2;

import java.io.Serializable;
import java.util.*;

public class ListGraph<T> implements Graph<T>, Serializable {

    //lista med noder?
    ArrayList<ArrayList<Integer>> graphList = new ArrayList<ArrayList<Integer>>(5);
    
    
    public void add(T node){
        // Takes a node as argument and add it to the graph. If it already exists - then don't change anything

        //compare node with other nodes
            //if it doesnt exist, add to graph
    }
    
    public void remove(T node){
        // receives a node and removes it from the graph. If the node is missing in The graph should exclude NoSuchElementException from the java.util package generated. 
        
        //When a node is removed, its edges should also be removed, and because the graph is misaligned, the edges should also be removed from the other nodes.
    }
    
    public void connect(T node1, T node2, String name, int weight){
        // Takes 2 nodes, a connection name and connection's weight(? they probably mean how much time does it take to use that "connection"?).
        
        // Then it connects everything here. If one of the nodes does not exist - NoSuchElementException from java.util should be thrown.
        
        // If the weight is negative - IllegalArgumentException should be thrown. 
        // if there is already a connection - IllegalStateException should be thrown because MAXIMUM ONE CONNECTION BETWEEN TWO NODES IS ALLOWED.
    }
    
    public void disconnect(T node1, T node2){
        // the method takes two nodes and removes the edge that connects these nodes.
        
        // If any of the nodes are missing in the graph, the exception NoSuchElementException from the java.util package must be generated.
        // If there is no border between these two nodes, the IllegalStateException exception should be generated. (Here, the getEdgeBetween method can certainly be useful.)
    }
    
    public void setConnectionWeight(T node1, T node2, int weight){
        // takes two nodes and an integer (the new weight of the connection) and sets this weight as the new weight of the connection between these two nodes.

        // If any of the nodes are missing in the graph or there is no border between these two nodes, the exception NoSuchElementException from the java.util package must be generated.
        // If the weight is negative, the IllegalArgumentException exception should be generated.
        
    }
    
    public Set<T> getNodes(){
        //returnerar en kopia av mängden av alla noder
    }
    
    public Collection<Edge<T>> getEdgesFrom(T node){
        //the method takes a node and returns a copy of the collection of all edges leading from this node. 
            //kolla föreläsning 6s kod!
        
        //If the node is missing in the graph, the exception should be NoSuchElementException is generated.
    }
    
    public Edge<T> getEdgeBetween(T node1, T node2){
        //takes two nodes and returns the edge between these nodes. 
        
        //If any of the nodes are missing in the graph, the exception should be NoSuchElementException is generated. 
        
        //If there is no border between the nodes are returned null.
    }
    
    @Override
    public String toString(){
        // toString - returns a long string with strings taken from the toString methods of the nodes and the toString methods of the edges.
        // Preferably with line breaks so that you get information about one node per line for improved readability.

    }
    
    public boolean pathExists(T from, T to){
        // takes two nodes and returns true if there is a path through the graph from one node to the other (possibly over many other nodes), otherwise false is returned.
        
        // If any of the nodes are not in the graph, false is also returned. Uses an aid method for depth-first search through a graph.
    }
    
    public List<Edge<T>> getPath(T from, T to){
        //takes two nodes and returns a list (java.util.List) with borders which represents a path between these nodes through the graph, or null if there is no path between these two nodes. 

        //In the simplest variant it is therefore sufficient that the method returns some path between the two nodes, 
        //but voluntarily one can make a solution where returns the shortest path (in the number of edges that must be crossed) or the fastest route (taking into account taken to the weights of the edges).
    }
}