/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha11;

import classes.PriorityQueueNode;
import classes.PriorityQueueWithArrayHeap;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class PriorityQueueWithArrayHeapDemo {
    public static void main(String[] args) {
        PriorityQueueWithArrayHeap<Integer> q = new PriorityQueueWithArrayHeap<>();
        
        q.addElement(1, 1);
        q.addElement(2, 2);
        q.addElement(3 , 3);
        q.addElement(4, 4);
      
        
        
        System.out.println("ESPERADO");
        System.out.println("10, 1, 20, 5");
        System.out.println("");
        
       Iterator<PriorityQueueNode<Integer>> it = q.iteratorLevelOrder();
       while(it.hasNext()){
           System.out.println(it.next());
       }
       
       
       
        
    }
}
