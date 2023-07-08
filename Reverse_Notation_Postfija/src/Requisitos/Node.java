package Requisitos;

public class Node <T>{
    T dato;
    Node next;
    public Node(T dato){
        this.dato = dato;
        next = null;
    }
    
    @Override
    public String toString(){
        String cad = "";
        cad+="->";
        cad+= dato;
        return cad;
    }
}
