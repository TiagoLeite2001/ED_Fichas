/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;
import interfaces.BinarySearchTreeADT;

/**
 *
 * @author tiago
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    public void expandCapacity() {
        T[] newArray = (T[]) new Object[tree.length*2];

        for (int i = 0; i < tree.length; i++) {
            newArray[i] = tree[i];
        }
        tree = newArray;
    }

    /**
     * Adds the specified object to this binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right. Also note that the index of the left child of the current
     * index can be found by doubling the current index and adding 1. Finding
     * the index of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the search tree
     */
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    public int findIndex(Comparable<T> targetElement, int n) throws ElementNotFoundException {
        int result = 0;

        if (n > tree.length) {
            throw new ElementNotFoundException("Element not found");
        }
        if (tree[n] == null) {
            throw new ElementNotFoundException("Element not found");
        }
        
        if (targetElement.compareTo(tree[n]) == 0) {
            result = n;
            return result;
        } else if (targetElement.compareTo(tree[n]) > 0) {
            int p = n * 2 + 2;
            result = findIndex(targetElement, p);
            return result;
        } else if (targetElement.compareTo(tree[n]) > 0) {
            int p = n * 2 + 1;
            result = findIndex(targetElement, p);
            return result;
        }
        return 0;
    }


    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        if (!isEmpty()) {
            Comparable<T> element = (Comparable<T>) targetElement;
            
            for(int i =0; i< tree.length; i++){
                if(element.equals(this.tree[i])){
                    this.tree[i] = replacement(i);
                    this.count--;
                    return targetElement;
                }
            }
        } else
            throw new ElementNotFoundException("Not found");
        return null;
    }

    protected T replacement(int index) {
        if(this.tree[index * 2 + 1] == null && this.tree[index * 2 + 2] == null){
            this.tree[index] = null;
            return null;
        }
        if(this.tree[index * 2 + 1] != null && this.tree[index * 2 + 2] == null){
            T left = this.tree[index * 2 +1];
            this.tree[index * 2 + 1]= null;
            return left;
        }
        if(this.tree[index * 2 + 1] == null && this.tree[index * 2 + 2] != null){
            T right = this.tree[index * 2 +2];
            this.tree[index * 2 + 2]= null;
            return right;
        }
        else{
            T right = this.tree[index * 2 + 2];
            T leftDoRight = this.tree[(index * 2 + 2) * 2 + 1];

            if(leftDoRight != null){
                int currentIndex = (index * 2 + 2) * 2 + 1;
                while(leftDoRight != null){
                    currentIndex = currentIndex * 2 + 1;
                    leftDoRight = this.tree[currentIndex];
                }
                leftDoRight = this.tree[(currentIndex - 1) / 2];
                currentIndex = (currentIndex - 1) / 2;
                this.tree[currentIndex] = null;
                return leftDoRight;
            }
            else{
                this.tree[index * 2 + 2] = null;
                return right;
            }
        }

    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMin() throws ElementNotFoundException {
        int temp = 0;
        if (!isEmpty()) {

            while (tree[temp] != null) {
                temp = temp * 2 + 1;
            }
            temp = (temp - 1) / 2;

            tree[temp] = null;
            count--;
            return tree[temp];
        } else
            throw new ElementNotFoundException("Not found");
    }

    @Override
    public T removeMax() throws ElementNotFoundException {
        int temp = 0;
        if (!isEmpty()) {

            while (tree[temp] != null) {
                temp = temp * 2 + 2;
            }
            temp = (temp - 2) / 2;

            tree[temp] = null;
            count--;
            return tree[temp];
        } else
            throw new ElementNotFoundException("Not found");
    }

    @Override
    public T findMin() {
        int temp = 0;
        if (!isEmpty()) {

            while (tree[temp] != null) {
                temp = temp * 2 + 1;
            }
            temp = (temp - 1) / 2;

            return tree[temp];
        }
        return null;
    }

    @Override
    public T findMax() {
        int temp = 0;
        if (!isEmpty()) {

            while (tree[temp] != null) {
                temp = temp * 2 + 2;
            }
            temp = (temp - 2) / 2;

            return tree[temp];
        }

        return null;

    }
}
