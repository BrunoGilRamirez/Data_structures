package ListaAdyacencia;

import java.io.Serializable;

public class Vetice implements Serializable {
    public String nombre;
    public Vetice siguinete;
    public VerticeAdyacente raiz;
    public boolean processed;
    public boolean waiting;

    public Vetice( String nombre){
        this.nombre = nombre;
        siguinete = null;
        raiz = null;
        processed = false;
        waiting = true;
    }

    @Override
    public String toString() {
        return nombre +" : ";
    }
}

