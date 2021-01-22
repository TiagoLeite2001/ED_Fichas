package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.Iterator;

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
        }


        try {
            double n =net.shortestPathWeight(1,5);
            System.out.println("1 Para 5: "+n);
            
            Iterator<Integer> it = net.iteratorShortestPath(1, 5);
            
            while(it.hasNext()){
                System.out.println(it.next());
            }

            double s =net.shortestPathWeight(1,3);
            System.out.println("1 Para 3: "+s);
            
            Iterator<Integer> it2 = net.iteratorShortestPath(1, 3);
            
            while(it2.hasNext()){
                System.out.println(it2.next());
            }

            double n2 =net.shortestPathWeight(1,2);
            System.out.println("1 Para 2: "+n2);
            
            Iterator<Integer> it3 = net.iteratorShortestPath(1, 2);
            
            while(it3.hasNext()){
                System.out.println(it3.next());
            }
        } catch (ElementNotFoundException |  EmptyCollectionException e) {
        }
    }
}
