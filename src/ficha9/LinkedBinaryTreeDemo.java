/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha9;

import classes.BinaryTreeNode;
import classes.LinkedBinaryTree;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class LinkedBinaryTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTreeNode<String> node1 = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> node2 = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> node3 = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> node4 = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> node5 = new BinaryTreeNode<>("E");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>(node1);
        
        System.out.println(tree.contains("A"));
        
        System.out.println("IN ORDER");
        Iterator<String> itr = tree.iteratorInOrder();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("---------------");
        
        System.out.println("PRE ORDER");
        Iterator<String> itr2 = tree.iteratorPreOrder();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
        System.out.println("---------------");
        
        System.out.println("POST ORDER");
        Iterator<String> itr3 = tree.iteratorPostOrder();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }
        System.out.println("---------------");
        
        System.out.println("LEVEL ORDER");
        Iterator<String> itr4 = tree.iteratorLevelOrder();
        while(itr4.hasNext()){
            System.out.println(itr4.next());
        }
        System.out.println("---------------");
    }
    
}
