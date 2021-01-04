/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

import classes.LinearNode;
import classes.LinkedList;

/**
 *
 * @author tiago
 */
public class PesquisaLinearLinkedList<T> {

    public PesquisaLinearLinkedList() {
    }

    public <T> boolean linearLinkedListSearch(LinkedList<T> linkedList, T target) {
        boolean found = false;
        
        LinearNode<T> current = linkedList.getHead();
        
        while(current.getNext() != null && !found){
            if(current.getElement().equals(target))
                found=true;
            else
                current = current.getNext();
        }
        
        return found;
    }
}
