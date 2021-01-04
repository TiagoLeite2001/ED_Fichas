/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7;

import classes.DoubleLinkedList;
import classes.DoubleLinkedListSentinela;
import classes.LinkedList;
import exceptions.ElementNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class ImprimeListaLigadaRecursivamente {

    public static int fatorial(int n){
        if(n<=1)
            return 1;
        return n*fatorial(n-1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DoubleLinkedListSentinela doubleList = new DoubleLinkedListSentinela<>();
        try {
            doubleList.add(4);
            doubleList.add(40);
            doubleList.add(400);
            doubleList.add(4000);
        } catch (ElementNotFoundException ex) {
        }
        
        System.out.println(doubleList.imprimeComRecursividadeInicio(doubleList));
        
        System.out.println(doubleList.imprimeComRecursividadeFim(doubleList));
        
    }
    
}
