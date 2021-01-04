/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author tiago
 */
public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    /** element stored at this node*/
    private T element;
    
    /** Creates an empty node.*/
    public DoubleNode(){
        next = null;
        prev=null;
        element = null;
    }
    
    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored */
    public DoubleNode(T elem){
        next = null;
        prev=null;
        element = elem;
    }
    
    /**
     * Returns the node that follows this one.
     * @return LinearNode<T> reference to next node
     */
    public DoubleNode<T> getNext(){
        return next;
    }
    
    public DoubleNode<T> getPrev(){
        return prev;
    }
    
    /**
    * Sets the node that follows this one.
    * @param node node to follow this one*/
    public void setNext(DoubleNode<T> node) {
        next = node;
    }
    
    public void setPrev(DoubleNode<T> node) {
        prev = node;
    }
    
    /**
    * Returns the element stored in this node.
    * @return T element stored at this node*/
    public T getElement() {
        return element;
    }
    
    /**
    * Sets the element stored in this node.
    * @param elem element to be stored at this node*/
    public void setElement(T elem) {
       element = elem;
    }
    
    
    @Override
    public String toString() {
        return "DoubleNode{" + "next:" + next + ", element:" + element + ", pre: "+ prev+'}';
    }
}
