/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha3;

import classes.ArrayStack;
import exceptions.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class ArrayStackDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<Integer> nums = new ArrayStack<>(5);
        
        nums.push(1);
        nums.push(2);
        nums.push(3);
        
        System.out.println(nums.toString());

        try {
            nums.pop();
        } catch (EmptyCollectionException ex) {
        }
        
        System.out.println(nums.toString());
        try {
            System.out.println(nums.peek());
        } catch (EmptyCollectionException ex) {
        }
        
        System.out.println(nums.size());
        
        nums.push(3);
        nums.push(4);
        nums.push(5);
        nums.push(6);
        
        System.out.println(nums.toString());
    }
    
}
