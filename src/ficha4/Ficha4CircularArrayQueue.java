/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;

import classes.CircularArrayQueue;
import exceptions.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class Ficha4CircularArrayQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularArrayQueue<Integer> myCircArrQueue= new CircularArrayQueue<>();
        
        myCircArrQueue.enqueue(1);
        System.out.println(myCircArrQueue.toString());
        myCircArrQueue.enqueue(2);
        myCircArrQueue.enqueue(3);
        myCircArrQueue.enqueue(4);
        myCircArrQueue.enqueue(5);
        System.out.println(myCircArrQueue.toString());
        try {
            myCircArrQueue.dequeue();
            myCircArrQueue.dequeue();
            myCircArrQueue.dequeue();
            myCircArrQueue.dequeue();
            myCircArrQueue.dequeue();
        } catch (EmptyCollectionException ex) {}
        System.out.println(myCircArrQueue.toString());
        
        myCircArrQueue.enqueue(0);
        myCircArrQueue.enqueue(2);
        myCircArrQueue.enqueue(9);
        System.out.println(myCircArrQueue.toString());
        try {
            System.out.println(myCircArrQueue.first());
            myCircArrQueue.dequeue();
            System.out.println(myCircArrQueue.first());
        } catch (EmptyCollectionException ex) {}
        
    }
    
}
