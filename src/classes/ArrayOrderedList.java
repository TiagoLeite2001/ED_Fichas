/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotComparableException;
import interfaces.OrderedListADT;
import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.Iterator;


/**
 *
 * @author tiago
 * @param <T>
 */

public class ArrayOrderedList<T> implements OrderedListADT<T>{
    private int initialCapacity;
    private int size;
    private T[] array;
    
    public ArrayOrderedList(){
        this.initialCapacity = 50;
        this.size=0;
        this.array= (T[]) (new Object[initialCapacity]);
    }
    
     public boolean arrayFull(){
        return size==initialCapacity-1;
    }
    
    public void arrayExtend(){
        T[] newArray = (T[]) (new Object[initialCapacity*2]);
        
        for(int i=0; i<size-1;i++){
            newArray[i]=this.array[i];
        }
        
        this.array = newArray;
    }
    
       
    @Override
    public T add(T element) throws ElementNotFoundException, ElementNotComparableException {

        if (!(element instanceof Comparable)) {
            throw new ElementNotComparableException("Element is not comparable!!");
        }

        if (element == null) {
            throw new ElementNotFoundException("Element is null");
        }

        if (arrayFull() == true) {
            arrayExtend();
        }

        T result;

        if (this.size() > 0) {
            for (int i = 0; i < this.size; i++) {
                if (((Comparable) (element)).compareTo(this.array[i]) <= 0) {
                    for (int j = size + 1; j > i; j--) {
                        this.array[j] = this.array[j - 1];
                    }
                    this.array[i] = element;
                    result = this.array[i];
                    this.size++;
                    return result;
                } else {
                    if ((((Comparable) (element)).compareTo(this.array[i])) > 0 && (i == this.size - 1)) {
                        this.array[i+1] = element;
                        result = this.array[i+1];
                        this.size++;
                        return result;
                    }
                }
            }

        }
        this.array[this.size] = element;
        this.size++;

        result = this.array[this.size - 1];
        return result;

    }

    @Override
    public T removeFirst() throws EmptyCollectionException{
        if(this.size==0)
            throw new EmptyCollectionException("No elements");
        
        T result = this.array[size-1];
        
        for(int i=0; i<this.size; i++ ){
            this.array[i]=this.array[i+1];
        }
        
        this.size--;
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if(this.size==0)
            throw new EmptyCollectionException("No elements");
        
        T result = this.array[this.size-1];
        
        this.array[this.size-1]=null;
        
        this.size--;
        
        
        return result;
    }
    
    public int encontrado(T element) throws ElementNotFoundException{
        if(element==null)
            throw new ElementNotFoundException("Element is null");
        
        boolean p = false;
        int i = 0;

        while (p == false && i < size) {
            if (this.array[i].equals(element)) {
                p = true;
                break;
            }
            i++;
        }

        if(p==true)
            return i;
        return -1;
    }
    
    

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        int p = encontrado(element);
        
        if(p == -1)
            throw new ElementNotFoundException("Not found");
        
        T result = array[p];
        
        for(int i = p; i<this.size;i++){
            this.array[i]=this.array[i+1];
        }
        
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(this.size==0)
            throw new EmptyCollectionException("No elements");
        
        return this.array[0];
    }

    @Override
    public T last() throws EmptyCollectionException{
        if(this.size==0)
            throw new EmptyCollectionException("No elements");
        
        return this.array[this.size-1];
    }

    @Override
    public boolean contains(T target) throws ElementNotFoundException {
        if(encontrado(target)== -1)
            return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    public void removeOnArray(int pos){
        for(int i=pos; i<this.size;i++){
            this.array[i]=this.array[i+1];
        }
    } 

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<T>();
    }
    
    @Override
    public String toString(){
        String s= "";
        for(int i=0; i<size;i++){
            s+=array[i];
            s+="\n";
        }
        return s;
    }
    
    public class BasicIterator<T> implements Iterator<T>{
        int index;
        
        public BasicIterator(){
            this.index=0;
        }
        
        @Override
        public boolean hasNext() {
            return this.index <size();
        }

        @Override
        public T next() {
            return (T) array[index++];
        }

        @Override
        public void remove() {
            removeOnArray(this.index);
            this.index--;
            size--;
        }
        
    }
    
}
