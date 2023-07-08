
package Req;


public class Queue {
 class Nodo {
        int d;
        Nodo sig;
    }
    
    private Nodo raiz,fondo;
    
    Queue() {
        raiz=null;
        fondo=null;
    }
    
    public boolean esvacia (){
        if (raiz == null)
            return true;
        else
            return false;
    }

    public void encolar (int info)
    {
        Nodo nuevo = new Nodo ();
        nuevo.d = info;
        nuevo.sig = null;
        if (esvacia ()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public int desencolar ()
    {
        if (!esvacia ())
        {
            int informacion = raiz.d;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else
            return Integer.MAX_VALUE;
    }

    public String imprimir() {
     String aux="";
        for( Nodo mov=raiz;mov!=null; mov=mov.sig){
          aux+=mov.d+"\n";  
        }
        return aux;
    }   
}
