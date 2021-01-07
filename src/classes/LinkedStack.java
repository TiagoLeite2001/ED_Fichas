/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.StackADT;
import exceptions.EmptyCollectionException;

/**
 *
 * @author tiago
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;

    public LinkedStack() {
        this.count = 0;
        this.top = null;
    }

    @Override
    public void push(T element) {
        LinearNode<T> newElem = new LinearNode<>(element);
        if (count == 0) {
            this.top = newElem;
        } else {
            newElem.setNext(top);
            this.top = newElem;
        }
        this.count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty!");
        }

        T result = top.getElement();
        this.top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String s = "";

        if (this.count == 0) {
            System.out.println("List is empty!");
        }

        LinearNode<T> current = this.top;

        while (current != null) {
            s += current.getElement().toString() + " |";
            current = current.getNext();
        }

        return s;

    }

}
