/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 *
 * @author tiago
 */
public class DoubleLinkedList<T> {
    private int count;
    private DoubleNode<T> head,tail;
    
    public DoubleLinkedList(){
        this.head= new DoubleNode<>();
        this.tail= new DoubleNode<>();
    }
    
    public DoubleNode<T> add(T element) throws ElementNotFoundException {
        DoubleNode<T> newNode = new DoubleNode<>();

        if (element == null) {
            throw new ElementNotFoundException("Element is null");
        }

        if (this.count == 0) {
            this.head = newNode;
            this.tail=newNode;
            this.head.setElement(element);
            this.count++;

            return newNode;
        } else {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
            this.head.setElement(element);
            this.count++;

            return newNode;
        }
    }
    
    public DoubleNode<T> removeFirstNode() throws EmptyCollectionException{
        
        if(this.count == 0)
            throw new EmptyCollectionException("The collection is empty");
        
        DoubleNode<T> removed = this.head;
        
        this.head.getNext().setPrev(null);
        
        this.head=this.head.getNext();
        
        return removed;
    }
    
    public DoubleNode<T> removeLastNode()throws EmptyCollectionException{
        if(this.count == 0)
            throw new EmptyCollectionException("The collection is empty");
        
        DoubleNode<T> current = this.head;
        DoubleNode<T> prev;
        
        while (current.getNext() != null) {
            current = current.getNext();
        }
        prev = current.getPrev();
        current.setPrev(null);
        prev.setNext(null);
        
        this.count--;
        
        return current;
    }
    
    public boolean empty(){
        return this.count == 0;
    }
    
    private String imprimeRecursividadeInicio(DoubleNode<T> node){
        //NAO É SENTINELA
        String s = "";
        if(node == null){
            return s;
        }else{
            s += (node.getElement().toString()) + "\n" + imprimeRecursividadeInicio(node.getNext()) ;
        }
        return s;
    }
    
    public String imprimeComRecursividadeDoInicio(DoubleLinkedList<T> list){
         return imprimeRecursividadeInicio(list.head);
    }
    
     private String imprimeRecursividadeFim(DoubleNode<T> node){
        //NAO É SENTINELA
        String s = "";
        if(node == null){
            return s;
        }else{
            s += (node.getElement().toString()) + "\n" + imprimeRecursividadeFim(node.getNext()) ;
        }
        return s;
    }
     
    public String imprimeComRecursividadeDoFim(DoubleLinkedList<T> list){
         return imprimeRecursividadeFim(list.head);
    }
    
    @Override
    public String toString() {
        DoubleNode<T> current = this.head;
        
        String s = "";

        while (current != null) {
            s += (current.getElement()).toString();
            s += "\n";
            current = current.getNext();
        }

        return s;
    }

}
