package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

import java.util.Iterator;

public class Net {
    public static void main(String[] args) {


        Network<Integer> net = new Network<>();

        Integer a = 0;
        Integer b = 1;
        Integer c = 2;
        Integer d = 3;
        Integer e = 4;
        Integer f = 5;
        Integer g = 6;
        Integer h = 7;
        Integer j = 8;
        Integer k = 9;
        Integer l = 10;
        Integer m = 11;
        Integer n = 12;
        Integer o = 13;
        Integer p = 14;

        net.addVertex(a);
        net.addVertex(b);
        net.addVertex(c);
        net.addVertex(d);
        net.addVertex(e);
        net.addVertex(f);

        net.addVertex(g);
        net.addVertex(h);
        net.addVertex(k);
        net.addVertex(l);
        net.addVertex(j);

        net.addVertex(m);
        net.addVertex(n);
        net.addVertex(o);
        net.addVertex(p);


        try {
            net.addEdge(b,a,5);
            net.addEdge(c,d,1);
            net.addEdge(e,f,5);
            net.addEdge(a,d,2);
            net.addEdge(e,b,2);
            net.addEdge(p,a,5);
            net.addEdge(p,g,1);
            net.addEdge(e,g,5);
            net.addEdge(g,o,2);
            net.addEdge(o,b,2);
            net.addEdge(o,n,5);
            net.addEdge(n,d,1);
            net.addEdge(n,f,5);
            net.addEdge(f,d,2);
            net.addEdge(d,l,2);


            double nee =net.shortestPathWeight(p,b);
            System.out.println("p Para a: " + nee);

        } catch (ElementNotFoundException | EmptyCollectionException er) {
            System.out.println(er);
        }



    }
}
