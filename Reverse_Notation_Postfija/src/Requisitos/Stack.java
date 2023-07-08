package Requisitos;

public class Stack <T> {
    
    Node raiz;
    
    public Stack(){
        raiz = null;
    }

    public void push(T dato){
        Node nuevo = new Node(dato);
        if (raiz != null)
            nuevo.next = raiz;
        raiz = nuevo;
    }

    public T pop(){
        Node aux;
        T dato = null;
        if (raiz == null)
            System.out.println("La pila está vací­a");
        else {
            aux = raiz;
            dato = (T) aux.dato;
            raiz = raiz.next;
            aux.next = null;
        }
        return (T) dato;
    }
    public boolean vacia(){
        return raiz==null;
    }
    public String toString(){
        String cad = "";
        for (Node i = raiz; i!=null; i = i.next){
            cad +=i.dato+",";
        }
        return cad;
    }
}
