/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;

import classes.LinkedQueue;
import exceptions.EmptyCollectionException;


/**
 *
 * @author tiago
 */
public class Ficha4LinkedQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        
        System.out.println(linkedQueue.toString());
        
        try {
            linkedQueue.dequeue();
            System.out.println(linkedQueue.toString());
            System.out.println(linkedQueue.first());
            linkedQueue.dequeue();
        } catch (EmptyCollectionException ex) {}
        
        System.out.println(linkedQueue.toString());
        
        try {
            System.out.println(linkedQueue.first());
        } catch (EmptyCollectionException ex) {}
        
        try {
            linkedQueue.dequeue();
            System.out.println(linkedQueue.toString());
            System.out.println(linkedQueue.first());
        } catch (EmptyCollectionException ex) {}
    }
    
}
