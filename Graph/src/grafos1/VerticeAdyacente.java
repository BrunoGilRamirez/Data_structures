package ListaAdyacencia;

import java.io.Serializable;

public class VerticeAdyacente implements Serializable {

    public String nombre;
    public VerticeAdyacente siguiente;

    public VerticeAdyacente (String nombre){
        this.nombre = nombre;
        siguiente = null;
    }

    @Override
    public String toString() {
        return nombre + " ->";
    }
}
