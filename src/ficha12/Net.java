package ficha12;

import classes.Network;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

import java.util.Iterator;

public class Net {
    public static void main(String[] args) {


        Network<Integer> net = new Network<>();

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        Integer e = 5;
        Integer f = 6;
        Integer g = 7;
        Integer h = 8;
        Integer j = 9;
        Integer k = 10;
        Integer l = 11;
        Integer m = 12;
        Integer n = 13;
        Integer o = 14;
        Integer p = 15;

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


            double nee =net.shortest(p,a);
            System.out.println("p Para l: " + nee);

        } catch (ElementNotFoundException | EmptyCollectionException er) {
            System.out.println(er);
        }



    }
}
