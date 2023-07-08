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
public class vertex {
    String nombre,estado;
    int pos;
    
    public vertex(String n){
        nombre=n;
        pos=-1;
        estado=null;
    }
    @Override
    public String toString(){
        return nombre + " ";
        
    }
}
