/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import classes.DoubleLinkedOrderedList;
import exceptions.ElementNotComparableException;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class DoubleLinkedOrderedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DoubleLinkedOrderedList<Integer> list = new DoubleLinkedOrderedList<>();
        int i=9;
        try {
            list.add(1);
            list.add(660);
            list.add(18888);
            list.add(50);
            list.add(60);
            list.add(7);
            list.add(51);
            list.add(6);
            list.add(4);
            list.add(125);
        } catch (ElementNotComparableException ex) {
        }
        catch (ElementNotFoundException ex){}
            

//        try {
//            list.remove(5);
//        } catch (EmptyCollectionException ex) {
//        } catch (ElementNotFoundException ex) {
//        }
        System.out.println("Size");
        System.out.println(list.size());
//        
        System.out.println("To String");
        System.out.println(list.toString());
        
        Iterator<Integer> it  = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
