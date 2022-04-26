package Prog2;
import java.io.Serializable;
import java.util.*;

public class Edge<T> implements Serializable {
    /*The Edge class should represent an edge, that is, one direction of a connection
    between two nodes. Values for all instance variables in this class should be passed as
    argument to the constructor.*/
    
    private final City destination;
    private final String name;
    private final double weight; //"length"

    public Edge (City destination, String name, double weight){
        //this.destinationFromNode = destinationFromNode;
        this.destination = Objects.requireNonNull(destination);
        this.name = Objects.requireNonNull(name);

        if (Double.isNaN(weight))
            throw new IllegalArgumentException("weight assigned for Edge is Not a Number (NaN)");

        this.weight = weight;
    }

    public City getDestination(){
        //return the node that the edge points at
        return destination;
    }

    public String getName(){
        //returns the edge name
        return name;
    }

    public double getWeight(){
        //returns the edge weight
        return weight;
    }

    //IS IT WORKING????
    public boolean equals(Object edgeToCompare){
        if(edgeToCompare instanceof Edge edge){
            return Object.equals(name, edge.name) && Object.equals(destination, edge.destination);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public String toString(){
        //returns a string with edge information.
        return "Edge[" + name + " to " + destination + "( weight: " + weight + " )]";
    }
}