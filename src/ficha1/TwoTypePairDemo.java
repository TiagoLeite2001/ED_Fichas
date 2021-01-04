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
public class TwoTypePairDemo {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        
        
        

            TwoTypePair<Integer, Integer> par1 = new TwoTypePair<Integer, Integer> (a, b);

            TwoTypePair<Integer, Integer> par2 = new TwoTypePair<Integer, Integer> (a, b);

            par1.getFirst();

            par1.getSecond();

            par1.toString();

            par1.setFirst(b);

            par1.setSecond(b);

            par1.equals(par2);
            
         
    }

     
    
    
    
}
