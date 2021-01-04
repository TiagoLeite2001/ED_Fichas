/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha2;

import classes.LinkedList;
import exceptions.ElementNotFoundException;

/**
 *
 * @author tiago
 */
public class LinkedNodeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Element ele1 = new Element("primeiro");
        Element ele2 = new Element("segundo");
        Element ele3 = new Element("terceiro");
        Element ele4 = new Element("quarto");
        Element ele5 = new Element("quinto");
//        
        LinkedList<Integer> ll = new LinkedList();
        
        ll.add(4);
        ll.add(5);
        ll.add(8);
        ll.add(1);
        ll.add(3);
            
        System.out.println("SIZE");
        System.out.println(ll.getSize());
        System.out.println("----------");
        System.out.println("ALL");
        System.out.println(ll.toString());
        
        try {
            ll.remove(3);
        } catch (ElementNotFoundException ex) {
        }
        
        System.out.println("ALL");
        System.out.println(ll.toString());
        
        System.out.println("RECURSIVIDADE");
        System.out.println(ll.imprimeComRecursividade(ll));
//        
        
        int i = 9;
//        ll.reserve();
////        
//        System.out.println(ll.toStringReverse());
    }
    
}
