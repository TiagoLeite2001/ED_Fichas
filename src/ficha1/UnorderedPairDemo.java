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
public class UnorderedPairDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s2 = "bom dia";
        String s1 = "boa noite";
        
        UnorderedPair<String> par = new UnorderedPair<>(s1, s1);
        UnorderedPair<String> par2 = new UnorderedPair<>(s2, s1);
        
        boolean t = par.equals(par2);
        boolean t1 = par.elementosIguais();
        boolean t2 = par2.elementosIguais();
        
        System.out.println("False Equals: " + t);
        System.out.println("TRUE  par elem: " + t1);
        System.out.println("False par2 elem: " + t2);
    }
    
}
