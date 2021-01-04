/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha11;

import classes.ArrayHeap;
import exceptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class ArrayHeapDemo {

    public static void main(String[] args) {
        ArrayHeap<String> ah1 = new ArrayHeap<>();

        ah1.addElement("D");
        //ah1.addElement("A");
        ah1.addElement("B");
        ah1.addElement("C");

        String a1 = "";
        try {
            a1 = ah1.findMin();
            a1 = ah1.removeMin();
        } catch (EmptyCollectionException ex) {
        }
        //System.out.println(a1);

        Iterator<String> it1 = ah1.iteratorPreOrder();
        while (it1.hasNext()) {

            System.out.println(it1.next());
        }

        ArrayHeap<Integer> ah = new ArrayHeap<>();
//
//        ah.addElement(5);
//        ah.addElement(2);
//        ah.addElement(6);
//        ah.addElement(1);
//        ah.addElement(4);
//        ah.addElement(7);
//        ah.addElement(29);
//        ah.addElement(62);
//        ah.addElement(13);
//        ah.addElement(44);
//        ah.addElement(53);
//        ah.addElement(21);
//        ah.addElement(67);
//        ah.addElement(16);
//        ah.addElement(411);
//
//        int a = 0;
//        try {
//            System.out.println("min");
//            a = ah.findMin();
//            ah.removeMin();
//        } catch (EmptyCollectionException ex) {
//        }
//        System.out.println(a);
//        System.out.println("Iterator");
//
//        Iterator<Integer> it = ah.iteratorLevelOrder();
//        while (it.hasNext()) {
//
//            System.out.println(it.next());
//        }
//      
//
//        System.out.println("pre");
//        Iterator<Integer> it2 = ah.iteratorPreOrder();
//        while (it2.hasNext()) {
//
//            System.out.println(it2.next());
//        }

    }

}
