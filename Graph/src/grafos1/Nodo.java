package PilasYColasDinamicas;

import ListaAdyacencia.Vetice;

import java.io.Serializable;

public class Nodo implements Serializable {
    Vetice vertice;
    Nodo next;
    public Nodo(Vetice vertice){
        this.vertice = vertice;
        next = null;
    }

    public String toString(){
        String cad = "";
        cad+=" ->";
        cad+= vertice;
        return cad;
    }
}
