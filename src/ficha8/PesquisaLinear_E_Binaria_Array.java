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
public class PesquisaLinear_E_Binaria_Array {
    public static void main(String[] args) {
//        Carro bmw = new Carro("BMW", "M3", 2000);
//        Carro opel = new Carro("OPEL", "CORSA", 2010);
//        Carro renault = new Carro("RENAULT", "ClIO", 2007);
//        Carro volvo = new Carro("VOLVO", "S60", 2013);
//        
//        Object[] array ={bmw, opel, renault, volvo};
//        
//        PesquisaLinear pL = new PesquisaLinear();
//        
//        
//        System.out.println("Exite bmw no array?");
//        System.out.println(pL.verificarSeExiste(bmw, array));
//        
//        System.out.println("Exite volvo no array?");
//        System.out.println(pL.verificarSeExiste(volvo, array));
//        
//        System.out.println("Exite bmw no array?");
//        System.out.println(pL.retornarSeExistir(bmw, array));
//        
//        System.out.println("Exite opel no array?");
//        System.out.println("AVISO: O array começao na posição 0");
//        System.out.println(pL.retornarSeExistirAPosicaoNoArray(opel, array));

        PesquisaBinariaArray<Integer> pB = new PesquisaBinariaArray<>();
        
        Integer[] array ={4, 7, 8, 9};
        
        int a=7;
        
        System.out.println("Encontrou o número "+ a +"?");
        if(pB.binarySearch(array, 0, 3, a))
            System.out.println("Sim, o número "+ a +" foi encontrado!");
        else
            System.out.println("Não, o número " + a + " não foi encontrado!");
        
    }
}
