/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiago
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String myString;
        Object myObject;
        List<?> c = new ArrayList<String>();
        // c.add("hello world"); // compile error
        // c.add(new Object()); // compile error
        ((List<String>) c).add("hello world");
        ((List<Object>) c).add(new Object()); // no compile error!
          myString = ((List<String>)c).get(0); // compile error
       // myString = (String) c.get(0);
      //  myObject = c.get(0);
      // myString = (String) c.get(1); // run-time error!

    }

}
