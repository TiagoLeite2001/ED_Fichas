/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;

/**
 *
 * @author tiago
 */
public class PairDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
       
        
        Pair<String> par = new Pair<>("ti", "toni");
        
        String s = par.max();
        
        System.out.println(s);
    }
    
}
