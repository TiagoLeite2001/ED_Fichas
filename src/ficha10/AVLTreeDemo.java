/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha10;

import classes.AVLTree;
import classes.AVLTreeNode;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        AVLTree<Integer> avlRight = new AVLTree<>();
        
        avlRight.addElement(100);
        avlRight.addElement(50);
        avlRight.addElement(150);
        avlRight.addElement(5);
        avlRight.addElement(60);
        avlRight.addElement(140);
        avlRight.addElement(133);
        avlRight.addElement(45);
        avlRight.addElement(3454);
        avlRight.addElement(1);
        avlRight.addElement(7);
        avlRight.addElement(143);
        avlRight.addElement(15);
        avlRight.addElement(4);
        avlRight.addElement(20);
        avlRight.addElement(14);
        avlRight.addElement(11);
        avlRight.addElement(1338);
        avlRight.addElement(2);
        avlRight.addElement(25);
        avlRight.addElement(55);
        avlRight.addElement(33);
        avlRight.addElement(17);
        avlRight.addElement(140);
        
        try {
            avlRight.removeElement(55);
            avlRight.removeElement(45);
            avlRight.removeElement(100);
            avlRight.removeElement(20);
        } catch (ElementNotFoundException ex) {
        }
       
        System.out.println("6 elementos");
        System.out.println("PRE ORDER");
        Iterator<Integer> it = avlRight.iteratorPreOrder();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("6 elementos");
        System.out.println("LEVEL ORDER");
        Iterator<Integer> it2 = avlRight.iteratorLevelOrder();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        

        
}
}
