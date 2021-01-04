/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha3;

import classes.ArrayStack;
import exceptions.EmptyCollectionException;

/**
 *
 * @author tiago
 */
public class PostFixCalculator{
    public static void main(String[] args){
        String[] strArr = args[0].split("");
        try {
            System.out.println(calculator(strArr));
        } catch (EmptyCollectionException ex) {}
    }
   
    public static double calculator(String[] strArr) throws EmptyCollectionException{
         
        ArrayStack<Double> operands = new ArrayStack<>();
        
        for(String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;
                    switch(str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;  
            }
        }
        return operands.pop();
    }
}
