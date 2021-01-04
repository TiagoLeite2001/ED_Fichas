/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import classes.DoubleLinkedUnorderedList;
import exceptions.ElementNotFoundException;

/**
 *
 * @author tiago
 */
public class DoubleLinkedUnorderedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();
        int i=9;
    
        try {
            list.addToFront(1);
            list.addToFront(2);
            list.addToRear(4);
            list.addAfter(3, 2);
        } catch (ElementNotFoundException ex) {        
            System.out.println("Nao tem");}
            
       
            

       
        System.out.println("Size");
        System.out.println(list.size());
        
        System.out.println("To String");
        System.out.println(list.toString());
    }
    
}
