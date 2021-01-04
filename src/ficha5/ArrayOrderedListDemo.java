/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import classes.ArrayOrderedList;
import exceptions.ElementNotComparableException;
import exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class ArrayOrderedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
        ArrayOrderedList<Integer> list = new ArrayOrderedList<>();

        System.out.println("hi");
        try {
            list.add(16);
            list.add(18);
            list.add(32);
            list.add(44);
            list.add(41);
            list.add(40);
            list.add(28);
            list.add(45);
            list.add(47);
            list.add(6);
            list.add(39);
            list.add(34);
            list.add(23);
            list.add(10);
            

        } catch (ElementNotFoundException ex) {
        } catch (ElementNotComparableException ex) {
        }
        
        System.out.println("SIZE");
        System.out.println(list.size());
        System.out.println("-----");
        System.out.println(list.toString());

//        System.out.println("HAS NEXT");
//        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ){
//            System.out.println(it.next());
//        }
//        System.out.println("---------------");
        
//        System.out.println("HAS NEXT COM INT");
//        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ){
//            int i = it.next();
//            System.out.println(i);
//        }
//        System.out.println("-----------");
//        
//        System.out.println("REMOVE");
//        Iterator<Integer> it = list.iterator(); 
//        it.remove();
//        
//        for(Iterator<Integer> itInt = list.iterator(); itInt.hasNext(); ){
//            System.out.println(itInt.next());
//        }
//
//          ArrayOrderedList<String> listaStrings = new ArrayOrderedList<>();
//
//        System.out.println("hi");
//        try {
//            listaStrings.add("ho");
//            listaStrings.add("ho33");
//            listaStrings.add("ho");
//
//        } catch (ElementNotFoundException ex) {
//        } catch (ElementNotComparableException ex) {
//        }
//        
//        System.out.println(listaStrings.toString());
//
//        System.out.println("HAS NEXT");
//        for(Iterator<String> iteratorStrings = listaStrings.iterator(); iteratorStrings.hasNext(); ){
//            System.out.println(iteratorStrings.next());
//        }
//        System.out.println("---------------");
//        
//        System.out.println("HAS NEXT COM INT");
//        for(Iterator<String> itS = listaStrings.iterator(); itS.hasNext(); ){
//            String i = itS.next();
//            System.out.println(i);
//        }
//        System.out.println("-----------");
//        
//        System.out.println("REMOVE");
//        Iterator<String> itREMOVESTRING = listaStrings.iterator(); 
//        itREMOVESTRING.remove();
//        
//        for(Iterator<String> itString = listaStrings.iterator(); itString.hasNext(); ){
//            System.out.println(itString.next());
//        }
    }
    
}
