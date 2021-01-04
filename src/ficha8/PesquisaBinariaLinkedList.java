/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

import java.awt.LinearGradientPaint;
import classes.DoubleNode;
/**
 *
 * @author tiago
 */
public class PesquisaBinariaLinkedList<T extends Comparable<? super T>> {
    //IMPOSSIVEL
    public PesquisaBinariaLinkedList() {
    }

    public DoubleNode<T> findMidle(DoubleNode<T> head, DoubleNode<T> tail) {
        DoubleNode<T> fastNode = new DoubleNode<>();
        DoubleNode<T> mid = new DoubleNode<>();

        fastNode = head;
        mid = head;

        while (fastNode != tail) {
            fastNode = fastNode.getNext();
            if (fastNode != null) {
                fastNode = fastNode.getNext();
            }
            if (mid.getNext() != null) {
                mid = mid.getNext();
            }
        }
        return mid;
    }

    public boolean binarySearch(DoubleNode<T> head, DoubleNode<T> tail, T target) {
        boolean found = false;
        int i = 0;
        DoubleNode<T> mid = findMidle(head, tail);
        
        while (found == false) {
            if (mid.getElement().equals(target)) {
                found = true;
            } else if (mid.getElement().compareTo(target) > 0) {
                mid = findMidle(head, mid);
            } else if (mid.getElement().compareTo(target) < 0) {
                mid = findMidle(mid, tail);
            }
        }
        return found;
    }
}
