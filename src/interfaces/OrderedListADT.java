/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.ElementNotComparableException;
import exceptions.ElementNotFoundException;

/**
 *
 * @author tiago
 * @param <T>
 */
public interface OrderedListADT<T> extends ListADT<T>{
 /**
 * Adds the specified element to this list at
 * the proper location
 *
 * @param element the element to be added to this list
     * @return 
     * @throws exceptions.ElementNotFoundException
 */
 public T add (T element) throws ElementNotFoundException, ElementNotComparableException;
}