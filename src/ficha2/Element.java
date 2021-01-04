/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha2;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class Element {
    private String name;
    
    public Element(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean equals(Element t){
        if(t != null){
            if(this.equals(t)){
                return true;
            }
        }
            
        return false;
    }
    
    @Override
    public String toString(){
        String s = "\nName: " + getName();
        return s;
    }
}
