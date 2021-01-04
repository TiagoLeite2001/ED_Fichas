/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha3;

import classes.LinkedStack;
import exceptions.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class LinkedStackDemo {
    public static void main(String[] args){
        LinkedStack<Integer> nums = new LinkedStack<>();
    
        nums.push(1);
        nums.push(2);
        nums.push(3);
        
        System.out.println(nums.toString());
        
        try {
            System.out.println(nums.peek());
            nums.pop();
            nums.pop();
            nums.pop();
        } catch (EmptyCollectionException ex) {
        }
        
        System.out.println(nums.toString());
        
        nums.push(4);
        
        System.out.println(nums.toString());
    } 
}
