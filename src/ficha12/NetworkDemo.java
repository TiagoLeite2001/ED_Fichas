package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class NetworkDemo {
    public static void main(String[] args) {
        Network<Integer> net = new Network<>();

        net.addVertex(1);
        net.addVertex(2);
        net.addVertex(3);
        net.addVertex(4);
        net.addVertex(5);

        try {
            net.addEdge(1,2,250);
            net.addEdge(1,4,45);
            net.addEdge(2,4,50);
            net.addEdge(2,3,77);
            net.addEdge(2,5,52);
            net.addEdge(4,5,20);
            net.addEdge(5,3,105);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }


        try {
            double n =net.shortestPathWeight(1,3);
            System.out.println(n);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
    }
}
