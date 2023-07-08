/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafomatrices;


/**
 *
 * @author Paola
 */
public class Queue {
    
    Nodo raiz;
     
       public Queue(){
           raiz=null;
       }
       
     public void encolar(String dato){
         Nodo ultimo=raiz;
         Nodo nuevo=new Nodo(dato);
          if(raiz!=null){
               while(ultimo.siguiente!=null){
                            ultimo=ultimo.siguiente;
                    }
               ultimo.siguiente=nuevo;
              }
          else{
              raiz=nuevo;
          }   
     
     }
      
       public void desencolar(){
     
       raiz=raiz.siguiente;
     
       } 
       
       public String dato(){
        return raiz.dato;
       } 
       
        
      public boolean estaVacia(){
         if(raiz==null)
            return true;
        return false;
    }
       public String toString(){
        String cad=" ";
        
          for (Nodo i=raiz;i!=null;i = i.siguiente)
         
               cad+=i;
        
        return cad;
    }
     public int buscar(String nombre){
     Nodo i;
      for(i = raiz; i != null; i = i.siguiente){
          if(i.dato.equals(nombre)){
              return 1;
          }
      }
      return -1;
   }
      
    }
    



