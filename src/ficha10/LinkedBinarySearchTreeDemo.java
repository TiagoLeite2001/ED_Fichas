/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha10;

import classes.LinkedBinarySearchTree;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class LinkedBinarySearchTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

//        tree.addElement(8);
//        tree.addElement(4);
//        tree.addElement(12);
//
//        tree.addElement(2);
//        tree.addElement(6);
//        tree.addElement(10);
//        tree.addElement(14);
//        tree.addElement(1);
//        tree.addElement(3);
//        tree.addElement(5);
//        tree.addElement(7);
//        tree.addElement(9);
//        tree.addElement(11);
//        tree.addElement(13);
//        tree.addElement(15);

        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(15);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(13);

//        try {
//            System.out.println("REMOVE ELEMENT EQUALS TO 3");
//            tree.removeAllOccurrences(3);
//        } catch (ElementNotFoundException ex) {
//            System.out.println("Element not found");
//            
//        }
        try {
            tree.removeElement(12);
        } catch (ElementNotFoundException ex) {
            System.out.println("Element not found!");
        }

//        System.out.println("FIND MIN");
//        System.out.println(tree.findMin());
//        System.out.println("\n");
//        
//        System.out.println("FIND MAX");
//        System.out.println(tree.findMax());
//        System.out.println("\n");
//        
//        
//        System.out.println("Remover MIN");
//        tree.removeMin();
//        System.out.println("\n");
//        
//        System.out.println("Remover MAX");
//        tree.removeMax();
//        System.out.println("\n");
//        
        Iterator<Integer> it = tree.iteratorInOrder();
        System.out.println("PRINT ALL");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
