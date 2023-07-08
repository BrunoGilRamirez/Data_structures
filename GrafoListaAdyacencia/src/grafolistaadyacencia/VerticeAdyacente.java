package grafolistaadyacencia;

public class VerticeAdyacente {
    public String nombre;
    public VerticeAdyacente sig;
    
    
    public VerticeAdyacente(String nombre){
        this.nombre = nombre;
        sig = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public VerticeAdyacente getSig() {
        return sig;
    }

    public void setSig(VerticeAdyacente sig) {
        this.sig = sig;
    }
    
    @Override
    public String toString(){
        return nombre+" -> ";
    }
}
