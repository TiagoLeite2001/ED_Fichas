/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import classes.ArrayUnorderedList;
import exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class ArrayUnorderedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayUnorderedList<Integer> list = new ArrayUnorderedList<>();
        
        try {
            list.addToFront(2);
            list.addToFront(1);
            list.addToRear(4);
            list.addAfter(3,2);
            
        } catch (ElementNotFoundException ex) {
        }
        
        System.out.println(list.toString());
        
        System.out.println("HAS NEXT");
        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }
        System.out.println("---------------");
        
        System.out.println("HAS NEXT COM INT");
        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ){
            int i = it.next();
            System.out.println(i);
        }
        System.out.println("-----------");
        
        System.out.println("REMOVE");
        Iterator<Integer> it = list.iterator(); 
        it.remove();
        
        for(Iterator<Integer> its = list.iterator(); its.hasNext(); ){
            System.out.println(its.next());
        }
       
        
          
        }
    }


