/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

import classes.LinkedList;

/**
 *
 * @author tiago
 */
public class PesquisaLinearLinkedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Car bmw = new Car("BMW", "M3", 2000);
        Car opel = new Car("OPEL", "CORSA", 2010);
        Car renault = new Car("RENAULT", "CLIO", 2007);
        Car volvo = new Car("VOLVO", "S60", 2013);
        Car lada = new Car("LADA", "1", 1969);
        
        PesquisaLinearLinkedList<Car> pLL = new PesquisaLinearLinkedList<>();
        LinkedList<Car> lL = new LinkedList<>();
        
        lL.add(renault);
        lL.add(opel);
        lL.add(bmw);
        lL.add(volvo);
        
        System.out.println("Existe algum elemento opel na LinkedList?");
        System.out.println(pLL.linearLinkedListSearch(lL, opel));
        
        System.out.println("Existe algum elemento lada na LinkedList?");
        System.out.println(pLL.linearLinkedListSearch(lL, lada));
        
        
    }

}
