package grafolistaadyacencia;

public class PilaDinamica <T> {
    public class Nodo <T>{
    T dato;
    Nodo next;
    public Nodo(T dato){
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
    Nodo <T> raiz;
    
    public PilaDinamica(){
        raiz = null;
    }

    public void push(T dato){
        Nodo <T> nuevo = new Nodo(dato);
        if (raiz != null)
            nuevo.next = raiz;
        raiz = nuevo;
    }

    public T pop(){
        Nodo <T>aux;
        T dato = null;
        if (raiz == null)
            System.out.println("La pila está vací­a");
        else {
            aux = raiz;
            dato = (T) aux.dato;
            raiz = raiz.next;
            aux.next = null;
        }
        return  dato;
    }
    public boolean find( T Dato){
        boolean ban=false;
        for (Nodo i = raiz; i!=null; i = i.next){
            if(raiz.equals(Dato)) ban=true;
        }
        return ban;
    }
    public boolean vacia(){
        return raiz==null;
    }
    public String toString(){
        String cad = "";
        for (Nodo i = raiz; i!=null; i = i.next){
            cad +=i.dato+",";
        }
        return cad;
    }
}
