/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.UnorderedListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tiago
 * @param <T>
 */
public class DoubleLinkedUnorderedList<T> implements UnorderedListADT<T>{
    private int count;
    private DoubleNode<T> head,tail;
    private int modcount;

    public DoubleLinkedUnorderedList() {
        this.head = new DoubleNode<>();
        this.tail= new DoubleNode<>();
        this.count = 0;
        this.head.setNext(tail);
        this.tail.setPrev(head);
        this.modcount = 0;
    }
    
    @Override
    public void addToFront(T element) {
        DoubleNode<T> newElement = new DoubleNode<>(element);
        
        head.getNext().setPrev(newElement);
        newElement.setNext(head.getNext());
        head.setNext(newElement);
        newElement.setPrev(head);
        
        this.count++;
        this.modcount++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode<T> newElement = new DoubleNode<>(element);
        
        tail.getPrev().setNext(newElement);
        newElement.setPrev(tail.getPrev());
        tail.setPrev(newElement);
        newElement.setNext(tail);
        
        this.count++;
        this.modcount++;
    }

    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException{
        DoubleNode<T> newElement = new DoubleNode<>(element);
        DoubleNode<T> current = this.head.getNext();
        
        while (current != tail && !current.getElement().equals(target)) {
            current = current.getNext();
        }

        if (current == tail) throw new ElementNotFoundException("Element not found!");
        
        current.getNext().setPrev(newElement);
        newElement.setNext(current.getNext());
        current.setNext(newElement);
        newElement.setPrev(current);
        
        this.count++;
        this.modcount++;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");

        T elementToRemove = null;

        elementToRemove = head.getNext().getElement();

        head.setNext(head.getNext().getNext());
        head.getNext().setPrev(head);
        
        this.count--;
        this.modcount++;
        
        return elementToRemove;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");

        T elementToRemove = null;

        elementToRemove = tail.getPrev().getElement();

        tail.setPrev(tail.getPrev().getPrev());
        tail.getPrev().setNext(tail);

        this.count--;
        this.modcount++;
        
        return elementToRemove;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) throw new EmptyCollectionException("Collection is empty!");
        
        DoubleNode<T> current = this.head.getNext();
        T elementToRemove = null;

        while (current != tail && !current.getElement().equals(element)) {
            current = current.getNext();
        }

        if (current == tail) {
            throw new ElementNotFoundException("Element not found!");
        }
        elementToRemove = current.getElement();

        (current.getPrev()).setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        this.count--;
        this.modcount++;
        
        return elementToRemove;
    }
    
    

    @Override
    public T first() {
        return this.head.getNext().getElement();
    }

    @Override
    public T last() {
        return this.tail.getPrev().getElement();
    }

    @Override
    public boolean contains(T target) {
        DoubleNode<T> current = this.head.getNext();

        while (current != tail && !current.getElement().equals(target)) {
            current = current.getNext();
        }

        return current != tail;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }
    
    @Override
    public String toString() {
        String s = "";

        if (isEmpty()) {
            System.out.println("List is empty");
        }

        DoubleNode<T> current = this.head.getNext();

        while (current != tail) {
            s += current.getElement().toString() + " |";
            current = current.getNext();
        }
        return s;
    }
    
    private class BasicIterator implements Iterator<T>{
        private int expectedModcount;
        private DoubleNode<T> current;
        private boolean okToRemove;
        
        public BasicIterator(){
            current = head.getNext();
            okToRemove = false;
            this.expectedModcount = modcount;
        }
        
        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() throws NoSuchElementException{
            if(!hasNext()) throw new NoSuchElementException("No such element!");
            okToRemove = true;
            
            T next = current.getElement();
            current = current.getNext();
            return next;
        }

        @Override
        public void remove(){
            if(expectedModcount != modcount) throw new ConcurrentModificationException("Canno't use the same method at same time!");
            if(!okToRemove) throw new IllegalStateException("Can't remove!");
            DoubleNode<T> previous = current.getPrev();
            DoubleNode<T> next = current.getNext();
                    
            previous.setNext(next);
            next.setPrev(previous);
            this.expectedModcount++;
            modcount++;
            okToRemove = false;
        }
        
    }
    
}
