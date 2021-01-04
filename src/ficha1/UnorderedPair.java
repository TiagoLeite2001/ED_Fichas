/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;



/**
 *
 * @author tiago
 * @param <T>
 */
public class UnorderedPair<T extends Comparable> extends Pair<T> {
    
    private T firstItem;
    private T secondItem;

    public UnorderedPair() {
        setFirst(null);
        setSecond(null);
    }

    public UnorderedPair(T firstItem, T secondItem) {
        setFirst(firstItem);
        setSecond(secondItem);
    }
    
    public T getFirst(){
        return firstItem;
    }
    
    public void setFirst(T firstItem){
        this.firstItem = firstItem;
    }
    
    public T getSecond(){
        return secondItem;
    }
    
    public void setSecond(T secondItem){
        this.secondItem = secondItem;
    }
    
    public boolean elementosIguais(){
        if(firstItem == null || secondItem == null)return false;
        if(firstItem == secondItem) return true;
        return false;
        
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            UnorderedPair<T> otherPair
                    = (UnorderedPair<T>) otherObject;
            return (getFirst().equals(otherPair.getFirst())
                    && getSecond().equals(otherPair.getSecond()))
                    || (getFirst().equals(otherPair.getSecond())
                    && getSecond().equals(otherPair.getFirst()));
        }
    }
}
