package grafolistaadyacencia;

public class Vertice {
    public String nombre;
    public Vertice sig;
    public VerticeAdyacente raiz;
    public int estado;
    
    public Vertice(String nombre, int estado){
        this.nombre = nombre;
        this.estado=estado; 
        sig = null;
        raiz = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vertice getSig() {
        return sig;
    }

    public void setSig(Vertice sig) {
        this.sig = sig;
    }

    public VerticeAdyacente getRaiz() {
        return raiz;
    }

    public void setRaiz(VerticeAdyacente raiz) {
        this.raiz = raiz;
    }
    @Override
    public String toString(){
        return nombre+": ";
    }
    
}
