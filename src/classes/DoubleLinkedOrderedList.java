/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotComparableException;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.OrderedListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tiago
 */
public class DoubleLinkedOrderedList<T extends Comparable> implements OrderedListADT<T> {

    private int count;
    private int modcount = 0;
    private DoubleNode<T> head, tail;

    public DoubleLinkedOrderedList() {
        this.head = new DoubleNode<T>();
        this.tail = new DoubleNode<T>();
        this.head.setNext(tail);
        this.tail.setPrev(head);
    }

    @Override
    public T add(T element) throws ElementNotFoundException, ElementNotComparableException {
        if (!(element instanceof Comparable)) {
            throw new ElementNotComparableException("Element is null");
        }

        DoubleNode<T> newDoubleNode = new DoubleNode<>(element);
        DoubleNode<T> current = this.head.getNext();

        if (size() == 0) {
            this.head.setNext(newDoubleNode);
            newDoubleNode.setPrev(this.head);
            newDoubleNode.setNext(this.tail);
            this.tail.setPrev(newDoubleNode);
            this.count++;
        } else {
            while (current != this.tail) {
                if (current.getElement().compareTo(element) > 0) {
                    break;
                } else {
                    current = current.getNext();
                }
            }
            current.getPrev().setNext(newDoubleNode);
            newDoubleNode.setPrev(current.getPrev());
            current.setPrev(newDoubleNode);
            newDoubleNode.setNext(current);
            this.count++;
        }

        return newDoubleNode.getElement();
    }

    public T removeFirst() throws EmptyCollectionException {
        if(size()==0)
            throw new EmptyCollectionException("Vazio");
        
        this.head= this.head.getNext();
        this.head.setPrev(null);
        
        return this.head.getElement();
    }

    public T removeLast() throws EmptyCollectionException {
        if(this.count == 0)
            throw new EmptyCollectionException("The collection is empty");
        
        DoubleNode<T> current = this.tail.getPrev().getPrev();
        
        current.setNext(tail);
        this.tail.setPrev(current);
        
        this.count++;
        
        return current.getElement();
    }
    
    @Override
    public T remove(T targetElement)
            throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List");
        }

        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = head;

        while (current != null && !found) {
            if (targetElement.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("List");
        }

        if (size() == 1) {
            head = tail = null;
        } else if (current.equals(head)) {
            head = current.getNext();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        count--;

        return current.getElement();
    }

    public T first() throws EmptyCollectionException {
        return this.head.getNext().getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        return this.tail.getPrev().getElement();
    }

    @Override
    public boolean contains(T target) throws ElementNotFoundException {
        boolean found = false;
        
        DoubleNode<T> current = this.head;
        
        while(!found && current.getNext().getElement() != null){
            if(current.getElement().equals(target))
                found = true;
            else
                current = current.getNext();
        }
        
        return found;
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedOrderedList.BasicIterator();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

    public void setTail(DoubleNode<T> tail) {
        this.tail = tail;
    }
    
    

    @Override
    public String toString() {
        DoubleNode<T> current = this.head.getNext();

        String s = "";

        while (current != this.tail) {
            s += (current.getElement()).toString();
            s += "\n";
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
