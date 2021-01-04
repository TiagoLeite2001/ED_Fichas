/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author tiago
 */
public class NoSuchElementException extends Exception{
    public NoSuchElementException(String s){
        super(s);
    }

    public NoSuchElementException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
