package Prog2;

import java.io.Serializable;
import java.util.*;

//public class ListGraph<T> implements Graph<T>, Serializable {
public class ListGraph {

    //Map med noder
    private final Map<City, Set<Edge>> nodes = new HashMap<>();
        
    public void add(City city){
        // Takes a node as argument and add it to the graph. If it already exists - then don't change anything
        //compare node with other nodes
            //if it doesnt exist(absent), add to graph
            
            nodes.putIfAbsent(city, new HashSet<>());
    }
    
    public void remove(City node){
        // receives a node and removes it from the graph. If the node is missing in The graph should exclude NoSuchElementException from the java.util package generated. 
        
        //When a node is removed, its edges should also be removed, and because the graph is misaligned, the edges should also be removed from the other nodes.
    }
    
    public void connect(City cityOne, City cityTwo, String name, double weight){

        //If one of the nodes does not exist - NoSuchElementException from java.util should be thrown.
        if(!nodes.containsKey(cityOne) || !nodes.containsKey(cityTwo)){
            throw new NoSuchElementException("HashMap does not contain one of the cities!");
        }
        // If the weight is negative - IllegalArgumentException should be thrown.
        if(weight < 0){
            throw new IllegalArgumentException("Weight is negative!");
        }
        // if there is already a connection between the cities - IllegalStateException
        if(getEdgeBetween(cityOne, cityTwo) != null){
            throw new IllegalStateException("Edge already exists between " + cityOne + " and " + cityTwo + "!");
        }
        
        /* //adds the cities to the hashMap
        add(cityOne);
        add(cityTwo); */

        // Then we get the cities edges
        Set<Edge> cityOneEdges = nodes.get(cityOne); 
        Set<Edge> cityTwoEdges = nodes.get(cityTwo);
        
        //add the new edge in the Sets
        cityOneEdges.add(new Edge<>(cityTwo, name, weight));
        cityTwoEdges.add(new Edge<>(cityOne, name, weight));
    }
    
    public void disconnect(City node1, City node2){
        // the method takes two nodes and removes the edge that connects these nodes.
        
        // If any of the nodes are missing in the graph, the exception NoSuchElementException from the java.util package must be generated.
        // If there is no border between these two nodes, the IllegalStateException exception should be generated. (Here, the getEdgeBetween method can certainly be useful.)
    }
    
    public void setConnectionWeight(City node1, City node2, int weight){
        // takes two nodes and an integer (the new weight of the connection) and sets this weight as the new weight of the connection between these two nodes.

        // If any of the nodes are missing in the graph or there is no border between these two nodes, the exception NoSuchElementException from the java.util package must be generated.
        // If the weight is negative, the IllegalArgumentException exception should be generated.
        
    }
    
    public Map<City, Set<Edge>> getNodes(){
        //returnerar en kopia av mängden av alla noder

        // Creating a new object
        // for class Map to clone a map
        Map<City, Set<Edge>> newNodeMap
            = new HashMap<City, Set<Edge>>();
  
        // using putAll method
        newNodeMap.putAll(nodes);

        return newNodeMap;
    }
    
    public Collection<Edge<City>> getEdgesFrom(City node){
        
        //the method takes a node and returns a copy of the collection of all edges leading from this node. 
            //kolla föreläsning 6s kod!
        
        //If the node is missing in the graph, the exception should be NoSuchElementException is generated.
    }
    
    private Edge<City> getEdgeBetween(City cityOne, City cityTwo){
        //If any of the nodes are missing in the graph, the exception should be NoSuchElementException is generated.
        if(!nodes.containsKey(cityOne) || !nodes.containsKey(cityTwo)){
            throw new NoSuchElementException("One of those cities is not in the map");
        }
        
        //takes two nodes and returns the edge between these nodes. 
        for (Edge<City> edge : nodes.get(cityOne)){
            if(edge.getDestination().equals(cityTwo))
                return edge;
        }
        
        //If there is no border between the nodes are returned null.
        return null;
    }
    
    @Override
    public String toString(){
        // toString - returns a long string with strings taken from the toString methods of the nodes and the toString methods of the edges.
        // Preferably with line breaks so that you get information about one node per line for improved readability.
        String s = nodes.toString();
        return s;
    }
    
    public boolean pathExists(City from, City to){
        // takes two nodes and returns true if there is a path through the graph from one node to the other (possibly over many other nodes), otherwise false is returned.
        return true;
        // If any of the nodes are not in the graph, false is also returned. Uses an aid method for depth-first search through a graph.
    }
    
    // public List<Edge<City>> getPath(City from, City to){
    //     //takes two nodes and returns a list (java.util.List) with borders which represents a path between these nodes through the graph, or null if there is no path between these two nodes. 
        
    //     //In the simplest variant it is therefore sufficient that the method returns some path between the two nodes, 
    //     //but voluntarily one can make a solution where returns the shortest path (in the number of edges that must be crossed) or the fastest route (taking into account taken to the weights of the edges).
    // }
}