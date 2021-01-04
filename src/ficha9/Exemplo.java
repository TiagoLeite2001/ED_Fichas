/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha9;

import classes.ArrayUnorderedList;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class Exemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayUnorderedList<Integer> list = new ArrayUnorderedList<>();
        list.addToRear(4);
        list.addToRear(43);
        list.addToRear(435);
        list.addToRear(4356);
        
        Iterator it = list.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
    
}
