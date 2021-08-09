package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class NetworkDemo {
    public static void main(String[] args) {
        Network<String> net = new Network<>();
        
        net.addVertex("A");
        net.addVertex("B");
        net.addVertex("C");
        net.addVertex("D");
        net.addVertex("E");
        net.addVertex("K");
        net.addVertex("J");
        net.addVertex("I");
        net.addVertex("G");
        net.addVertex("H");

        try {
            net.addEdge("A","B",1);
            net.addEdge("B","C",3);
            net.addEdge("B","D",5);
            net.addEdge("C","D",1);
            net.addEdge("D","E",5);
            net.addEdge("A","K",1);
            net.addEdge("B","J",13);
            net.addEdge("J","I",1);
            net.addEdge("E","I",1);
            net.addEdge("I","H",2);
        } catch (ElementNotFoundException e) {
        }
        try {
            double n =net.shortestPathWeight("B","H");
            System.out.println("B Para H: " + n);
        } catch (ElementNotFoundException |  EmptyCollectionException e) {
        }
    }
}
