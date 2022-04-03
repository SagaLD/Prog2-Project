package Prog2;
import java.io.Serializable;

public class ListGraph<T> implements Graph<T>, Serializable {

    public void add(T node){
        
    }
    
    public void connect(T node1, T node2, String name, int weight){
        
    }
    
    public void setConnectionWeight(T node1, T node2, int weight){
        
    }
    
    public Set<T> getNodes(){
        //return set;
    }
    
    public Collection<Edge<T>> getEdgesFrom(T node){
        //return collection;
    }
    
    public Edge<T> getEdgeBetween(T node1, T node2){
        //return edge;
    }
    
    public void disconnect(T node1, T node2){
        
    }
    
    public void remove(T node){
        
    }
    
    public boolean pathExists(T from, T to){
        //return boolean;
    }
    
    public List<Edge<T>> getPath(T from, T to){
        //return list;
    }
}