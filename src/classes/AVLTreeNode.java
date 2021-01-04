/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author tiago
 */
public class AVLTreeNode<T> {

    int fatorBalanceamento;
    int height;
    T element;
    AVLTreeNode<T> left;
    AVLTreeNode<T> right;

    public AVLTreeNode() {
        this.fatorBalanceamento = 0;
        int height = 0;
        this.left = null;
        this.right = null;
    }

    public AVLTreeNode(T element) {
        this.fatorBalanceamento = 0;
        int height = 0;
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }
    
    public void setHeight(int newHeight){
        this.height = newHeight;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public void updateFatorBalanceamento(){
        if(this.left == null && this.right == null){
            this.fatorBalanceamento = 0;
        }
        
        else if(this.left != null && this.right != null ){
            
            this.left.updateHeight();
            this.right.updateHeight();
            
            this.fatorBalanceamento = this.right.getHeight() - this.left.getHeight();
        }
        else if(this.left != null && this.right == null){
            
            this.left.updateHeight();
            
            this.fatorBalanceamento = -1 - this.left.getHeight();
        }
        else if(this.left == null && this.right != null){
            
            this.right.updateHeight();
            
            this.fatorBalanceamento = this.right.getHeight() + 1;
        }
    }
    
    public void updateFB(AVLTreeNode<T> node) {
        if (node.right == null && node.left == null) {
            node.fatorBalanceamento = 0;
        } 
        else if (node.left != null && node.right == null) {
            node.left.updateHeight();
            node.fatorBalanceamento = -1 - node.left.getHeight();
        } 
        else if (node.left == null && node.right != null) {
            node.right.updateHeight();
            node.fatorBalanceamento = node.right.getHeight() + 1;
        } 
        else {
            node.left.updateHeight();
            node.right.updateHeight();
            
            node.fatorBalanceamento = node.right.getHeight() - node.left.getHeight();
        }

    }
    
    public T getElement() {
        return this.element;
    }

    public AVLTreeNode<T> getLeft() {
        return this.left;
    }

    public AVLTreeNode<T> getRight() {
        return this.right;
    }
    
    public int getFatorB(){
        return this.fatorBalanceamento;
    }
    
    public boolean needsRotation(){
        if(this.getFatorB() < -1 || this.getFatorB() > 1){
            return true;
        }
        return false;
    }
    
    public void updateHeight(){
        int maxH = 0;
        int currH = 0;
        
        if(this.left != null){
            currH++;
            if(currH > maxH){
                maxH = currH;
            }
            maxH = updateHeight(this.left, maxH, currH);
            
        }
        
        if(this.right != null){
            if(this.left == null){currH++;}
            if(currH > maxH){
                maxH = currH;
            }
            maxH = updateHeight(this.right, maxH, currH);
        }
        
        this.height =  maxH;
    }
    
    public int updateHeight(AVLTreeNode<T> node, int maxHeight, int currentHeight){
        int maxH = maxHeight;
        int currH = currentHeight;
        
        if(node.left != null){
            currH++;
            if(currH > maxH){
                maxH = currH;
            }
            maxH = updateHeight(node.left, maxH, currH);
        }
        
        if(node.right != null){
            if(node.left == null){ currH++;}
            if(currH > maxH){
                maxH = currH;
            }
            maxH = updateHeight(node.right, maxH, currH);
        }
        return maxH;
    }

}
