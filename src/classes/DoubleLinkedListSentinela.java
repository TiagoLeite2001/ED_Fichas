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
public class DoubleLinkedListSentinela<T> {
    private int count;
    private DoubleNode<T> head,tail;
    
    public DoubleLinkedListSentinela(){
        this.count=0;
        this.head= new DoubleNode<>();
        this.tail= new DoubleNode<>();
        this.head.setNext(tail);
        this.tail.setPrev(head);
    }
    
    public DoubleNode<T> add(T element) throws ElementNotFoundException {
        DoubleNode<T> newDoubleNode = new DoubleNode<>(element);

        if (element == null) {
            throw new ElementNotFoundException("Element is null");
        }
        
        if(this.count==0){
            newDoubleNode.setNext(head.getNext());
            newDoubleNode.setPrev(head);
            head.setNext(newDoubleNode);
            tail.setPrev(newDoubleNode);
            count++;
            
            return newDoubleNode;
        }
            newDoubleNode.setNext(head.getNext());
            newDoubleNode.setPrev(head);
            head.getNext().setPrev(newDoubleNode);
            head.setNext(newDoubleNode);
        
        this.count++;

        return newDoubleNode;
    }
    
    public void removeFirstNode() throws EmptyCollectionException{
        if(this.count == 0)
            throw new EmptyCollectionException("The collection is empty");
        
        DoubleNode<T> current = this.head.getNext();
        
        this.head.setNext(current.getNext());
        current.setPrev(this.head);
        
        this.count--;
    }
    
    public void removeLastNode()throws EmptyCollectionException{
        if(this.count == 0)
            throw new EmptyCollectionException("The collection is empty");
        
        DoubleNode<T> current = this.tail.getPrev().getPrev();
        
        current.setNext(tail);
        this.tail.setPrev(current);
        
        this.count--;
    }
    
    public boolean empty(){
        return this.count == 0;
    }
    
    private String imprimeRecursividadeInicio(DoubleNode<T> node){
        String s = "";
        if(node.getElement() == null){
            return s;
        }else{
            s += (node.getElement().toString()) + "\n" + imprimeRecursividadeInicio(node.getNext()) ;
        }
        return s;
    }
    
    public String imprimeComRecursividadeInicio(DoubleLinkedListSentinela<T> list){
         return imprimeRecursividadeInicio(list.head.getNext());
    }
    
     private String imprimeRecursividadeFim(DoubleNode<T> node){
        String s = "";
        if(node.getElement() == null){
            return s;
        }else{
            s += (node.getElement().toString()) + "\n" + imprimeRecursividadeFim(node.getPrev()) ;
        }
        return s;
    }
     
    public String imprimeComRecursividadeFim(DoubleLinkedListSentinela<T> list){
         return imprimeRecursividadeFim(list.tail.getPrev());
    }
  
//    public DoubleNode<T> getTail(){
//        return this.tail;
//    }
    
    @Override
    public String toString() {
        DoubleNode<T> current = this.head.getNext();
        
        String s = "";

        while (current != this.tail) {
            s += current.getElement().toString();
            s += "\n";
            current = current.getNext();
        }

        return s;
    }

}

