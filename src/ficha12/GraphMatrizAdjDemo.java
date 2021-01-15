/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha12;

import classes.Graph;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class GraphMatrizAdjDemo {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        
     

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);

        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(2,3);
        g.addEdge(4,5);
        g.addEdge(5,3);

        
        
        
//            Iterator<Integer> it = g.iteratorShortestPath(a,e);
//            while(it.hasNext()){
//                System.out.println(it.next());
           
            int i=0;
            /*Iterator<Integer> it2 = g.iteratorBFS(0);
            while(it2.hasNext()){
                System.out.println(it2.next());
            }*/

        Iterator<Integer> it = null;
        try {
            it = g.iteratorShortestPath(3,4);
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        while(it.hasNext()){
                System.out.println(it.next());
            }
        
        
    }
    }

