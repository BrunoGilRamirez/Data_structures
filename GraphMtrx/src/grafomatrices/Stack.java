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
public class Stack {
    Nodo raiz;
       
       public Stack(){
           raiz=null;
       }
       
     public void push(String dato){
         Nodo nuevo=new Nodo(dato);
          if(raiz==null)
             raiz=nuevo;
          else{
             nuevo.siguiente=raiz;
             raiz=nuevo;
          } 
     }
     
      public void pop(){
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

}
