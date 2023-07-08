package Requisitos;

public class Queue <T> {
    Node raiz,fondo;
    
    public  Queue(){
        raiz = null;
        fondo=null;
    }
 public boolean vacia (){
        if (raiz == null)
            return true;
        else
            return false;
    }
    public void encolar(T dato){
        Node nuevo = new Node(dato);
        nuevo.next = null;
        if (vacia ()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.next = nuevo;
            fondo = nuevo;
        }
    }

    public T desencolar(){
        T informacion= null;
        if (!vacia ())
        {
             informacion = (T) raiz.dato;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.next;
            }
            return informacion;
        }
            return informacion;
    }

    public String toString(){
        String cad = "";
        for (Node i = raiz; i!=null; i = i.next){
             cad +=i.dato+",";
        }
        return cad;
    }
}
