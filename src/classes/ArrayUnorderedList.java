/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.UnorderedListADT;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{
    private final int CAP=1;
    private int size;
    private T[] array;
    
    public ArrayUnorderedList(){
        this.size=0;
        this.array = (T[]) (new Object[CAP]);
                
    }
    
    public ArrayUnorderedList(int size){
        this.size=0;
        this.array = (T[]) (new Object[size]);
                
    }
    
    public boolean arrayFull(){
        return size == this.array.length-1;
    }
    
    public void arrayExtend(){
        T[] newArray = (T[]) (new Object[this.array.length*5]);
        
        for(int i=0; i < size; i++){
            newArray[i] = this.array[i];
        }
        
        this.array = newArray;
    }
    
    @Override
    public void addToFront(T element) {        
        if(arrayFull()==true){
            arrayExtend();
        }
        
        if (this.size > 0) {
            for (int i = size; i > 0; i--) {
                this.array[i] = this.array[i-1];
            }
            this.array[0]=element;
            this.size++;
        }
        else{
        
        this.array[0]=element;
        this.size++;
        
        }
    }

    @Override
    public void addToRear(T element) {
        if(arrayFull() == true){
            arrayExtend();
        }
        
        this.array[size] = element;
        
        this.size++;
        
    }

    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if(element==null)
            throw new ElementNotFoundException("Element is null");
        
        if(arrayFull()==true){
            arrayExtend();
        }
        
        int p = encontrado(target);
        
        if(p==-1)
            throw new ElementNotFoundException("Element not found!!!");
        
        for(int i=this.size+1; i>p; i--){
            this.array[i]=array[i-1];
        }
        this.array[p+1]=element;
        this.size++;
        
        T result = this.array[p+1];
        
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
        if(size==0)
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
        return new BasicIterator();
    }
    
    public class BasicIterator implements Iterator<T>{
        int index;
        
        public BasicIterator(){
            this.index=0;
        }
        
        @Override
        public boolean hasNext() {
            return array[index] != null && index < size;
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
    
    @Override
    public String toString(){
        String s= "";
        for(int i=0; i<size;i++){
            s+=array[i];
            s+="\n";
        }
        return s;
    }
    
}
