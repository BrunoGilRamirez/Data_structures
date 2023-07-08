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
public class Nodo {
    String dato,estado;
    Nodo siguiente;
    
       public Nodo (String dato){
         this.dato=dato;
          siguiente=null;
         estado=null;
        }
        @Override
       public String toString(){
            return dato +"->";
    
       }    
}
