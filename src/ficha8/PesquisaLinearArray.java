/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha8;

/**
 *
 * @author tiago
 */
public class PesquisaLinearArray<T> {
    
    private T target;
    private Object[] array;
    
    public PesquisaLinearArray(){
        this.target = null;
        this.array = null;
    }
    
    public boolean verificarSeExiste(T target, Object[] array){
        this.target = target;
        this.array = array;
        
        int p = encontrado();
        if(p==-1){
            return false;
        }  
        return true;
    }
    
    private int encontrado(){
        for(int i=0; i<array.length;i++){
            if(array[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
    
    public T retornarSeExistir(T target, Object[] array){
        this.target = target;
        this.array = array;
        
        int p = encontrado();
        if(p==-1){
            return null;
        }  
        return (T)(array[p]);
    }
    
    public int retornarSeExistirAPosicaoNoArray(T target, Object[] array){
        this.target = target;
        this.array = array;
        
        int p = encontrado();
        if(p==-1){
            return -1;
        }  
        return p;
    }
}
