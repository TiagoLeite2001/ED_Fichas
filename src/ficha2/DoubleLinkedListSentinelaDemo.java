package ficha2;

import classes.DoubleLinkedListSentinela;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiago
 */
public class DoubleLinkedListSentinelaDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    
        // TODO code application logic here
         DoubleLinkedListSentinela<Integer> doubleLinkedList = new DoubleLinkedListSentinela<>();
        
           
        try {
            doubleLinkedList.add(3);
            doubleLinkedList.add(3433);
            doubleLinkedList.add(3233);
            doubleLinkedList.add(555555555);
        } catch (ElementNotFoundException ex) {
        }
        System.out.println(doubleLinkedList.toString());

        try {
            doubleLinkedList.removeLastNode();
        } catch (EmptyCollectionException ex) {}
    
        System.out.println("\n DINHQJUDHUA");
        System.out.println(doubleLinkedList.toString());

    }
    
}
