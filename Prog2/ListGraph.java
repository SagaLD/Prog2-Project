package Prog2;

import java.io.Serializable;
import java.util.*;

public class ListGraph<T> implements Graph<T>, Serializable {

    //Map med noder
    private final Map<T, Set<Edge>> nodes = new HashMap<>();

    public void add(T node){
        // Takes a node as argument and add it to the graph. If it already exists - then don't change anything
        //compare node with other nodes
        //if it doesnt exist(absent), add to graph

        nodes.putIfAbsent(node, new HashSet<>());
    }

    public void remove(T node){
        // receives a node and removes it from the graph. If the node is missing in The graph it should throw NoSuchElementException from the java.util package generated.
        if(!nodes.containsKey(node)){
            throw new NoSuchElementException("No such node in the map");
        }
        //When a node is removed, its edges should also be removed, and because the graph is misaligned, the edges should also be removed from the other nodes.
        //remove edges from other nodes
        T[] mapArray = (T[]) nodes.entrySet().toArray();

        for(T city : mapArray){
            for(Edge edge : nodes.get(city)){
                if(edge.getDestination().equals(node)){
                    disconnect(city, (T) node);
                }
            }
        }

        //remove node
        nodes.remove(node);

    }

    public void connect(T cityOne, T cityTwo, String name, int weight){

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

        // Then we get the cities edges
        Set<Edge> cityOneEdges = nodes.get(cityOne);
        Set<Edge> cityTwoEdges = nodes.get(cityTwo);

        //add the new edge in the Sets
        cityOneEdges.add(new Edge(cityTwo, name, weight));
        cityTwoEdges.add(new Edge(cityOne, name, weight));
    }

    public void disconnect(T nodeOne, T nodeTwo){
        // the method takes two nodes and removes the edge that connects these nodes.

        // If any of the nodes are missing in the graph, the exception NoSuchElementException from the java.util package must be generated.
        if(!nodes.containsKey(nodeOne) || !nodes.containsKey(nodeTwo)){
            throw new NoSuchElementException("One of the nodes does not exist");
        }
        // If there is no edge between these two nodes, the IllegalStateException exception should be generated. (Here, the getEdgeBetween method can certainly be useful.)
        if(getEdgeBetween(nodeOne, nodeTwo) == null){
            throw new IllegalStateException("No edge between nodes");
        }

        // for (Edge<City> edge : nodes.get(nodeOne)){
        //     if(edge.getDestination().equals(nodeTwo)){
        //         Set<Edge> nodeOneEdges = nodes.get(nodeOne);
        //         nodeOneEdges.remove(edge);

        //         Set<Edge> nodeTwoEdges = nodes.get(nodeTwo);
        //         nodeTwoEdges.remove(edge);
        //     }
        // }

        Edge edgeOne = getEdgeBetween(nodeOne, nodeTwo);
        Edge edgeTwo = getEdgeBetween(nodeTwo, nodeOne);
        nodes.get(nodeOne).remove(edgeOne);
        nodes.get(nodeOne).remove(edgeTwo);
    }

    public void setConnectionWeight(T node1, T node2, int weight){
        // takes two nodes and an integer (the new weight of the connection) and sets this weight as the new weight of the connection between these two nodes.

        // If any of the nodes are missing in the graph or there is no border between these two nodes, the exception NoSuchElementException from the java.util package must be generated.
        // If the weight is negative, the IllegalArgumentException exception should be generated.

    }

    public Set<T> getNodes(){
        //returnerar en kopia av mängden av alla noder

        //Convert Map keys to Set
        Set<T> keySet = (Set<T>) new HashSet<T>(nodes.keySet());
        //keySet.forEach(key -> System.out.println(key));

        return (Set<T>) keySet;
    }

    public Collection<Edge> getEdgesFrom(T node){
        //If the node is missing in the graph, the exception should be NoSuchElementException is generated.
        if(!nodes.containsKey(node)){
            throw new NoSuchElementException("No such node in the map");
        }

        //the method takes a node and returns a copy of the collection of all edges leading from this node.
        return nodes.get(node);
    }

    public Edge getEdgeBetween(T cityOne, T cityTwo){
        //If any of the nodes are missing in the graph, the exception should be NoSuchElementException is generated.
        if(!nodes.containsKey(cityOne) || !nodes.containsKey(cityTwo)){
            throw new NoSuchElementException("One of those cities is not in the map");
        }

        //takes two nodes and returns the edge between these nodes.
        for (Edge edge : nodes.get(cityOne)){
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
        return nodes.toString();
    }

    public boolean pathExists(T from, T to){
        // takes two nodes and returns true if there is a path through the graph from one node to the other (possibly over many other nodes), otherwise false is returned.
        return true;
        // If any of the nodes are not in the graph, false is also returned. Uses an aid method for depth-first search through a graph.
    }

    public List<Edge> getPath(T from, T to){
        //takes two nodes and returns a list (java.util.List) with borders which represents a path between these nodes through the graph, or null if there is no path between these two nodes.

        //In the simplest variant it is therefore sufficient that the method returns some path between the two nodes,
        //but voluntarily one can make a solution where returns the shortest path (in the number of edges that must be crossed) or the fastest route (taking into account taken to the weights of the edges).
        return new ArrayList<>();
    }
}