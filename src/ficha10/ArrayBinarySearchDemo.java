package ficha10;

import classes.ArrayBinarySearchTree;
import exceptions.ElementNotFoundException;

import java.util.Iterator;

public class ArrayBinarySearchDemo {
    public static void main(String[] args) {
        ArrayBinarySearchTree<Integer> array = new ArrayBinarySearchTree<>();

        array.addElement(10);
        array.addElement(5);
        array.addElement(15);
        array.addElement(3);
        array.addElement(7);
        array.addElement(13);

//        
        System.out.print("Size:");
        System.out.println(array.size());
        System.out.println("------------");
        try {
            array.removeElement(15);
        } catch (ElementNotFoundException ex) {
        }
        System.out.print("New Size:");
        System.out.println(array.size());

//        try {
//            array.removeMin();
//            array.removeMax();
//        } catch (ElementNotFoundException e) { }
//        System.out.println(array.findMax());
//        System.out.println(array.findMin());

//        System.out.println("\n");
//
        Iterator<Integer> it = array.iteratorLevelOrder();

        while (it.hasNext())
            System.out.println(it.next());
    }
}
