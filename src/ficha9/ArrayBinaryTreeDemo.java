/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha9;

import classes.ArrayBinaryTree;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class ArrayBinaryTreeDemo {

    


    public static void main(String[] args) {
//        String s1="A";
//        String s2="B";
//        String s3="C";
//        String s4="D";
//        String s5="E";

        Integer s1=1;
        Integer s2=2;
        Integer s3=3;
        Integer s4=4;
        Integer s5=5;

        ArrayBinaryTree<Integer> tree= new ArrayBinaryTree<>(4);

       Iterator<Integer> it=null;

        it = tree.iteratorLevelOrder();

        while(it.hasNext()){
            System.out.println("\n" +it.next());
        }
    
}
    

}
