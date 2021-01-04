///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ficha4;
//
//import classes.CircularArrayQueue;
//import exceptions.EmptyCollectionException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author tiago
// */
//public class Encoder {
//    private char[] key;
//    private String message;
//    private CircularArrayQueue<Character> inMessage;
//    
//    public Encoder(String message, char[] key){
//        this.key = key;
//        this.message = message;
//        this.inMessage = new CircularArrayQueue<>(this.message.length());
//    }
//    
//    public String encode(){
//        String messageNotSpaces = message.trim();
//        
//        CircularArrayQueue<Character> outMessage = new CircularArrayQueue<>(messageNotSpaces.length());
//        CircularArrayQueue<Integer> inKey = new CircularArrayQueue<>(this.key.length);
//        
//        for(int i = 0; i < this.key.length; i++){
//   /////
//   ////
//////// inKey.enqueue(key[i]);
//        }
//        
//        for(int i = 0; i < messageNotSpaces.length(); i++){
//            char temp = messageNotSpaces.charAt(i);
//            inMessage.enqueue(temp);
////        }
////        
////        int current=0;
////        while(current != this.message.length()){
////            try {
////                char carac;
////                carac = inMessage.dequeue();                
////                
////                
////                } catch (EmptyCollectionException ex) {}
////        }
////        
////    }
////    
//    
//}
