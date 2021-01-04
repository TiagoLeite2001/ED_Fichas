/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.QueueADT;
import exceptions.EmptyCollectionException;


/**
 *
 * @author tiago
 */
public class LinkedQueue<T> implements QueueADT<T>{
    private int count;
    private LinearNode<T> front;
    private LinearNode<T> rear;
    
    public LinkedQueue(){
        this.count = 0;
        this.front = null;
        this.rear = null;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> newElement = new LinearNode<>(element);
        
        if(count == 0){
            this.front = newElement;
            this.rear = newElement;
        } else {
            rear.setNext(newElement);
            rear = newElement;
        }
        this.count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException{
        
        if(count == 0) throw new EmptyCollectionException("Collection/List is empty!");
        
        LinearNode<T> result = this.front;
        
        if(count == 1){            
            this.rear = front = null;
        } else {          
            this.front = this.front.getNext();
            result.setNext(null);
        }
        
        this.count--;
        
        return result.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException{
        if(count == 0) throw new EmptyCollectionException("Collection/List is empty!");
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        if(this.count == 0){
            s += "List is empty!";
            return s;
        }
        
        LinearNode<T> current = this.front;
        
        while(current != null){
            s += current.getElement().toString() + " |";
            current = current.getNext();
        }
        
        return s;
    }
}
