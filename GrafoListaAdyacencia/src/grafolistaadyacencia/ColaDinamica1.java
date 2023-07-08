package grafolistaadyacencia;

public class ColaDinamica1 <T> {
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
    
    Nodo<T> raiz,fondo;
    public  ColaDinamica1(){
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
        Nodo<T> nuevo = new Nodo (dato);
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
             informacion = raiz.dato;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.next;
            }
            return  informacion;
        }
            return  informacion;
    }
@Override
    public String toString(){
        String cad = "";
        for (Nodo i = raiz; i!=null; i = i.next){
             cad +=i.dato+",";
        }
        return cad;
    }
}
