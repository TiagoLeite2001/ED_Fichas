package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.Iterator;

public class NetworkDemo {
    public static void main(String[] args) {
        Network<String> net = new Network<>();
        
        net.addVertex("A");
        net.addVertex("B");
        net.addVertex("C");
        net.addVertex("D");
        net.addVertex("E");



        try {
            net.addEdge("A","B",6);
            net.addEdge("A","D",4);
            net.addEdge("E","B",1);
            net.addEdge("D","B",1);
            net.addEdge("D","C",5);
            net.addEdge("E","C",2);

        } catch (ElementNotFoundException e) {
        }


        try {
            double n =net.shortest("D","B");
            System.out.println("A Para B: " + n);


        } catch (ElementNotFoundException |  EmptyCollectionException e) {
        }
    }
}
