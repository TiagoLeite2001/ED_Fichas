/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha2;

import classes.DoubleLinkedList;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class DoubleLinkedDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        
        try {
            doubleLinkedList.add(3);
            doubleLinkedList.add(3433);
            doubleLinkedList.add(3233);
            doubleLinkedList.add(555555555);//will be removed;
        } catch (ElementNotFoundException ex) {
        }
        
        try {
            System.out.println("Removed was 555555555 right?");
            System.out.println(doubleLinkedList.removeFirstNode().getElement().toString());
            System.out.println("NICE!!");
        } catch (EmptyCollectionException ex) {
        }
        
        
        try {
            System.out.println("Removed was 3 right?");
            System.out.println(doubleLinkedList.removeLastNode().getElement().toString());
            System.out.println("NICE!!");
        } catch (EmptyCollectionException ex) {
        }
        
        System.out.println(doubleLinkedList.toString());
    }
    
}
