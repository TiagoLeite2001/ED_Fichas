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
public class CircularArrayQueue<T> implements QueueADT<T>{
    private final int DEFAULT_CAPACITY = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int count;
    
    public CircularArrayQueue(){
        this.count = 0;
        this.front = 0;
        this.rear = 0;
        this.queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    
    public CircularArrayQueue(int initialCapacity){
        this.count = 0;
        this.queue = (T[]) (new Object[initialCapacity]);
    }
    
    @Override
    public void enqueue(T element) {
        if(size() == this.queue.length) expandCapacity();
        this.queue[this.rear] = element;
        this.rear = (this.rear+1) % this.queue.length;
        this.count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(count == 0) throw new EmptyCollectionException("Collection/List is empty!");
         
        T temp = this.queue[this.front];
        
        this.queue[this.front] = null;
        this.front = (this.front+1) % this.queue.length;
        this.count--;
        return temp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(count == 0) throw new EmptyCollectionException("Collection/List is empty!");
        return this.queue[this.front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }
    
    public void expandCapacity(){
        T[] newQueue = (T[])(new Object[queue.length*2]);
        
        for(int i = 0; i < queue.length; i++){
            newQueue[i] = queue[i];
        }
       queue = newQueue;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        if(this.count == 0){
            s += "List is empty";
            return s;
        }
        
        int temp = this.front;
        while(temp != this.rear){
             s += this.queue[temp].toString() + " |";
             temp++;
        }
        return s;
    }
}
