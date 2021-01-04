/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

/**
 *
 * @author tiago
 */
public class PesquisaBinariaArray<T> {

    public PesquisaBinariaArray() {}

    /**
     * Searches the specified array of objects using a binary search algorithm.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public <T extends Comparable<? super T>> boolean
            binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2; // determine the midpoint
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = binarySearch(data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }
}
