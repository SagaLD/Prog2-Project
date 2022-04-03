package Prog2;
import java.io.Serializable;
import java.util.*;

public class Edge<T> implements Serializable {
    /*The Edge class should represent an edge, that is, one direction of a connection
    between two nodes. Values for all instance variables in this class should be passed as
    argument to the constructor.*/
    
    private T destinationToNode;
    //private T destinationFromNode;
    private String name;
    private int weight;

    public Edge (T destinationToNode, String name, int weight){
        //this.destinationFromNode = destinationFromNode;
        this.destinationToNode = destinationToNode;
        this.name = name;
        this.weight = weight;
    }

    public T getDestination(){
        //return the node that the edge points at
        return destinationToNode;
    }

    public int getWeight(){
        //returns the edge weight
        return weight;
    }

    public void setWeight(int newWeight){
        //takes an integer and sets the weight of the edge to this integer. If the weight is negative, the IllegalArgumentException exception should be generated.
        if (newWeight < 0)
            throw new IllegalArgumentException();

        this.weight = newWeight;
    }

    public String getName(){
        //returns the edge name
        return name;
    }

    public String toString(){
        //returns a string with edge information.
        return "Edge " + name + " to " + destinationToNode + "( weight: " + weight + " )";
    }
}