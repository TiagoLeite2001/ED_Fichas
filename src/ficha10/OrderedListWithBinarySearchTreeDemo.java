/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha10;

import classes.OrderedListWithBinarySearchTree;
import exceptions.ElementNotFoundException;

/**
 *
 * @author tiago
 */
public class OrderedListWithBinarySearchTreeDemo {
    public static void main(String[] args) {
        OrderedListWithBinarySearchTree<Integer> ex = new OrderedListWithBinarySearchTree<>();
        
        ex.addElement(6);
        ex.addElement(1);
        ex.addElement(23);
        ex.addElement(65);
        ex.addElement(4);
        ex.addElement(2);
        ex.addElement(3);
        
        try {
            ex.removeElement(4);
        } catch (ElementNotFoundException ex1) {
        }
        
        System.out.println(ex.toString());
        
    }
}
