/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.BinarySearchTreeADT;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class AVLTree<T> implements BinarySearchTreeADT<T> {

    private int height;
    private int count;
    AVLTreeNode<T> root;

    public AVLTree() {
        this.height = 0;
        this.count = 0;
        this.root = new AVLTreeNode<>();
    }

    @Override
    public void addElement(T element) {
        AVLTreeNode<T> temp = new AVLTreeNode<>(element);
        if (isEmpty()) {
            this.root = temp;

        } else {
            boolean added = false;
            Comparable<T> ele = (Comparable) element;

            AVLTreeNode<T> current = this.root;
            AVLTreeNode<T> prev = current;

            while (!added) {
                if (ele.compareTo(current.getElement()) >= 0) {
                    if (current.right == null) {
                        prev = current;
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null) {
                        prev = current;
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
        this.count++;
        updateTree();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                AVLTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                } else {
                    current = root.right;
                }
                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;

                        if (current == parent.left) {
                            parent.left = replacement(current);
                        } else {
                            parent.right = replacement(current);
                        }
                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.element) < 0) {
                            current = current.left;
                        } else {
                            current = current.right;
                        }
                    }
                }

                if (!found) {
                    throw new ElementNotFoundException("binary search tree");
                }
            }
        }
        updateTree();
        
        this.setHeight(this.root.getHeight());

        return result;
    }

    protected AVLTreeNode<T> replacement(AVLTreeNode<T> node) {
        AVLTreeNode<T> result = null;

        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            AVLTreeNode<T> current = node.right;
            AVLTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            if (node.right == current) {
                current.left = node.left;
            } else {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        boolean removed = true;
        T temp = null;

        try {
            temp = removeElement(targetElement);
        } catch (ElementNotFoundException ex) {
            throw new ElementNotFoundException("not found");
        }

        while (removed) {
            try {
                temp = removeElement(targetElement);
            } catch (ElementNotFoundException ex) {
                removed = false;
            }
        }
    }

    @Override
    public T removeMin() throws ElementNotFoundException {
        AVLTreeNode<T> current = this.root;
        AVLTreeNode<T> prev = current;

        while (current.left != null) {
            prev = current;
            current = current.left;
        }

        prev.left = null;

        return current.getElement();
    }

    public void updateHeight() {
        this.root.getHeight();
    }

    public int getHeight() {
        return this.root.getHeight();
    }

    @Override
    public T removeMax() throws ElementNotFoundException {
        AVLTreeNode<T> current = this.root;
        AVLTreeNode<T> prev = current;

        while (current.right != null) {
            prev = current;
            current = current.right;
        }

        prev.right = null;

        return current.getElement();
    }

    @Override
    public T findMin() {
        AVLTreeNode<T> current = this.root;

        while (current.left != null) {
            current = current.left;
        }
        return current.getElement();
    }

    @Override
    public T findMax() {
        AVLTreeNode<T> current = this.root;

        while (current.right != null) {
            current = current.right;
        }
        return current.getElement();
    }

    @Override
    public T getRoot() {
        return this.root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    public AVLTreeNode<T> getRootNode() {
        return this.root;
    }

    @Override
    public boolean contains(T targetElement) {
        boolean found = false;

        try {
            T find = find(targetElement);
            if (find != null) {
                found = true;
            }
        } catch (ElementNotFoundException ex) {
        }

        return found;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T result = null;
        
        result = find(this.root, targetElement);
        
        if(result == null){
            throw new ElementNotFoundException("NOt found");
        }
        
        return result;
    }

    public T find(AVLTreeNode<T> current, T targetElement) {
        T result = null;
        Comparable<T> element = (Comparable<T>) targetElement;

        if (current.getElement().equals(targetElement)) {
            return current.getElement();
        } else if (element.compareTo(current.getElement()) > 0) {
            result = find(current.right, targetElement);
        } else {
            result = find(current.left, targetElement);
        }
        return result;
    }

    public void rotation(AVLTreeNode<T> prev, AVLTreeNode<T> root) {
        if(root.getFatorB() == -2 && root.left.getFatorB() == -1){
            rotationRight(prev, root);
        }
        else if(root.getFatorB() == 2 && root.right.getFatorB() == 1){
            rotationLeft(prev, root);
        }
        else if(root.getFatorB() == 2 && root.right.getFatorB() == -1 ){
            rotationRightLeft(prev, root);
        }
        else if(root.getFatorB() == -2 && root.left.getFatorB() == 1 ){
            rotationLeftRight(prev, root);
        }
    }
    
    public void rotationRight(){
        AVLTreeNode<T> oldRoot = this.root;
        AVLTreeNode<T> oldLeft = this.root.left;
        AVLTreeNode<T> oldLeftRight = this.root.left.right;
        
        this.root = oldLeft;
        this.root.right = oldRoot;
        this.root.right.left = oldLeftRight;
    }
    
    public void rotationRight(AVLTreeNode<T> prev, AVLTreeNode<T> root){
        if(root.equals(this.root)){
            rotationRight();
        }
        else{
        AVLTreeNode<T> oldRoot = root;
        AVLTreeNode<T> oldLeft = root.left;
        AVLTreeNode<T> oldLeftRight = root.left.right;

        if(prev.right.equals(root)){
            prev.right = oldLeft;
            prev.right.right=oldRoot;
            prev.right.right.left = oldLeftRight;
        }
        else{
            prev.left = oldLeft;
            prev.left.right=oldRoot;
            prev.left.right.left = oldLeftRight;
        }
        }
    }
    
    public void rotationRightLeft(){
        AVLTreeNode<T> oldRoot = this.root.right;
        AVLTreeNode<T> oldLeft = this.root.right.left;
        AVLTreeNode<T> oldLeftRight = this.root.right.left.right;
        
        this.root.right = oldLeft;
        this.root.right.right = oldRoot;
        this.root.right.right.left = oldLeftRight;
        
        rotationLeft();
    }
    
    public void rotationRightLeft(AVLTreeNode<T> prev, AVLTreeNode<T> root){
        if(root.equals(this.root)){
            rotationRightLeft();
        }
        else{
            int i = 0;
            if(prev.left.equals(root)){
                i = 1;
            }
            rotationRight(root, root.right);
            
            if(i == 1){
            rotationLeft(prev, prev.left);
            }
            else{
                rotationLeft(prev, prev.right);
            }
        }
    }
    
    public void rotationLeftRight(AVLTreeNode<T> prev, AVLTreeNode<T> root){
        if(root.equals(this.root)){
            rotationLeftRight();
        }
        else{
            int i = 0;
            if(prev.left.equals(root)){
                i = 1;
            }
            rotationLeft(root, root.left);
            
            if(i == 1){
            rotationRight(prev, prev.left);
            }
            else{
                rotationRight(prev, prev.right);
            }
        }
          
    }
    
    public void rotationLeftRight(){
        AVLTreeNode<T> oldRoot = this.root.left;
        AVLTreeNode<T> oldRight = this.root.left.right;
        AVLTreeNode<T> oldRightLeft = this.root.left.right.left;
        
        this.root.left = oldRight;
        this.root.left.left = oldRoot;
        this.root.left.left.right = oldRightLeft;
        
        rotationRight();
    }
    
    public void rotationLeft(){
        AVLTreeNode<T> oldRoot = this.root;
        AVLTreeNode<T> oldRight = this.root.right;
        AVLTreeNode<T> oldRightLeft = this.root.right.left;
        
        this.root = oldRight;
        this.root.left = oldRoot;
        this.root.left.right = oldRightLeft;
    }
    
    public void rotationLeft(AVLTreeNode<T> prev, AVLTreeNode<T> root){
        if(root.equals(this.root)){
            rotationLeft();
        }
        else{
        AVLTreeNode<T> oldRoot = root;
        AVLTreeNode<T> oldRight = root.right;
        AVLTreeNode<T> oldRightLeft = root.right.left;

        if(prev.right.equals(root)){
            prev.right = oldRight;
            prev.right.left=oldRoot;
            prev.right.left.right = oldRightLeft;
        }
        else{
            prev.left = oldRight;
            prev.left.left = oldRoot;
            prev.left.left.right = oldRightLeft;
        }
        }
    }
    
    public void updateTree(){
        AVLTreeNode<T> current = this.root;
        
        if (current.left != null) {
            update(current, current.left);
        }

        if (current.right != null) {
            update(current,current.right);
        }
        
        current.updateHeight();
        current.updateFatorBalanceamento();

        if (current.needsRotation() == true) {
            rotation(current, current);
            updateTree();
        }
    }
    
    public void update(AVLTreeNode<T> prev, AVLTreeNode<T> current){
        int i = 0;
        
        if (current.left != null) {
            update(current, current.left);
        }

        if (current.right != null) {
            update(current, current.right);
        }
        
        current.updateHeight();
        current.updateFatorBalanceamento();
        
        if(current.needsRotation() == true){
            rotation(prev, current);
        }
    }
    
    
    protected void inorder(AVLTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root.
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preorder(AVLTreeNode<T> node, ArrayUnorderedList<T> tempList) throws ElementNotFoundException {
        if (node != null) {
            tempList.addToRear(node.element);
            preorder(node.left, tempList);
            preorder(node.right, tempList);
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        try {
            preorder(root, tempList);
        } catch (ElementNotFoundException ex) {
        }

        return tempList.iterator();
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postorder(AVLTreeNode<T> node, ArrayUnorderedList<T> tempList) throws ElementNotFoundException {
        if (node != null) {
            postorder(node.left, tempList);
            postorder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        try {
            postorder(root, tempList);
        } catch (ElementNotFoundException ex) {
        }
        return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        LinkedQueue<AVLTreeNode<T>> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>(this.count);

        nodes.enqueue(root);

        while (nodes.size() != 0) {
            try {
                AVLTreeNode<T> current = nodes.dequeue();
                if (current != null) {
                    results.addToRear(current.element);
                    nodes.enqueue(current.left);
                    nodes.enqueue(current.right);
                }
            } catch (EmptyCollectionException ex) {
            }
        }
        return results.iterator();
    }

}
