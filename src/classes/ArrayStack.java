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
public class ArrayStack<T> implements StackADT<T>{
    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;
    
    /**
     * int that represents both the number of elements and the next
     * available position in the array
     */
    private int top;
    
    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;
    
    
    public ArrayStack(){
        top = 0;
        stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }
    
    @Override
    public void push(T element) {
        if(size() == stack.length)
            expandCapacity();
        
        stack[top] = element;
        top++;
    }
    
    public void expandCapacity(){
        T[] newStack = (T[])(new Object[stack.length*2]);
        
        for(int i = 0; i < stack.length; i++){
            newStack[i] = stack[i];
        }
       stack = newStack;
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        
        top--;
        T result = stack[top];
        stack[top] = null;
        
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException{
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        if(top == 0) return true;
        return false;
    }

    @Override
    public int size() {
        return top;
    }
    
    @Override
    public String toString(){
        String s = "";
        if (top == 0) System.out.println("Stack is empty!");
        
        for(int i = top-1; i >= 0; i--){
            s += ((T)stack[i]).toString() + " |";
        }
        return s;
    }
}
