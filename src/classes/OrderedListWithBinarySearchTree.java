/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author tiago
 * @param <T>
 */
public class OrderedListWithBinarySearchTree<T> extends LinkedBinarySearchTree<T>{
    
    public OrderedListWithBinarySearchTree(){
        super();
    }
    
    public void addElement(T element){
        super.addElement(element);
    }
    
    public T removeElement(T element) throws ElementNotFoundException{
       return super.removeElement(element);
    }
    
    public String toString(){
        String s = "\n";
        Iterator<T> it = this.iteratorInOrder();
        
        while(it.hasNext()){
            s += "\n " + it.next();
        }
        
        return s;
    }
    
}
