/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;



/**
 *
 * @author tiago
 */
public class LinkedList<T> {
    private int count;
    private LinearNode<T> head, tail;
    
    public LinkedList(){
        this.count = 0;
        this.head = new LinearNode<>();
        this.tail = new LinearNode<>();
        this.head.setNext(this.tail);
    }
    
   
    public void add(T element){
        LinearNode<T> newNode = new LinearNode<>(element); 
        
        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);
        
        this.count++;
    }
    
    public int getSize(){
        return this.count;
    }
    
    public boolean find(T element){
        LinearNode<T> current = this.head.getNext();
        
        while(current != this.tail){
            if(current.getElement().equals(element))
                return true;
        }
        return false;
    }

    public void remove(T element) throws ElementNotFoundException{
        LinearNode<T> current = this.head.getNext();
        LinearNode<T> prev = this.head;
        
        boolean find = find(element);
        
        if(find == true){
            while(current != this.tail){
                if(current.getElement().equals(element)){
                    prev.setNext(current.getNext());
                    this.count--;
                    break;
                }
                current = current.getNext();
                prev = current;
                    
            }
        }
        else
            throw new ElementNotFoundException("Element Not Found!");
        
    }
    
    private String imprimeRecursividade(LinearNode<T> node){
        String s = "";
        if(node == null || node == this.tail){
            return s;
        }else{
            s += (node.getElement().toString()) + "\n" + imprimeRecursividade(node.getNext()) ;
        }
        return s;
    }
    
    public String imprimeComRecursividade(LinkedList<T> list){
         return imprimeRecursividade(list.head.getNext());
    }
    
    public LinearNode<T> getHead() {
        return this.head;
    }

    public void reserve() {
        LinearNode<T> futureNext = new LinearNode<>();
        LinearNode<T> prev = this.head;
        LinearNode<T> current = prev.getNext();

        while (current != null) {
            futureNext = current.getNext();
            current.setNext(prev);
            prev = current;
            current = futureNext;
        }
    }
    
    public String toStringReverse() {
        
        LinearNode<T> current = this.tail.getNext();
        String s = "";
        
        while(current != this.head){
            s += current.getElement().toString();
            s += "\n";
            current = current.getNext();
        }
        
        return s;
    }
    
    @Override
    public String toString() {
        
        LinearNode<T> current = this.head.getNext();
        String s = "";
        
        while(current != this.tail){
            s += current.getElement().toString();
            s += "\n";
            current = current.getNext();
        }
        
        return s;
    }

}
