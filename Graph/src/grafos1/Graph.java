package grafos1;

import Exceptions.NoExisteElementoException;
import ListaAdyacencia.VerticeAdyacente;
import ListaAdyacencia.Vetice;  
import PilasYColasDinamicas.ColaDinamica;

import java.io.Serializable;

public class Graph implements Serializable {
    public Vetice raiz;
    private boolean existeConexionEntreVerices;
    public String stringDFS;
    public String stringBFS;

    public Graph(){
        existeConexionEntreVerices = false;
        stringDFS = "";
        stringBFS = "";
    }

    public Vetice buscarVertice(String nombre){
        Vetice i;
        for (i = raiz; i != null; i = i.siguinete){
            if (i.nombre.equals(nombre))
                return i;
        }
        return null;
    }

    @SuppressWarnings("empty-statement")
    public void insertarVertice(String nombre) throws NoExisteElementoException{
        Vetice b = buscarVertice(nombre), i;
        if (b == null){
            Vetice v = new Vetice(nombre);
            if (raiz != null){
                for (i = raiz; i.siguinete != null; i = i.siguinete);
                i.siguinete = v;
            } else {
                raiz = v;
            }
        }
        else
            throw new NoExisteElementoException("Ya existe el elemento");
    }

    @SuppressWarnings("empty-statement")
    public void eliminarVertice(String nombre) throws NoExisteElementoException {
        Vetice b = buscarVertice(nombre), i;
        if (b == raiz) {
            eliminarConexionesDeVertice(b);
            raiz = raiz.siguinete;
            b.siguinete = null;
        }
        else {
            if (b != null) {
                eliminarConexionesDeVertice(b);
                for (i = raiz; i.siguinete != b; i = i.siguinete) ;
                i.siguinete = i.siguinete.siguinete;
                b.siguinete = null;
            }
            else
                throw new NoExisteElementoException();

        }
    }

    public void eliminarConexionesDeVertice(Vetice v){
        Vetice i;
        if (v.raiz != null){
            for (i = raiz; i.siguinete != null; i = i.siguinete) {
                try {
                    eliminarArco(v.nombre,i.nombre);
                }
                catch (NoExisteElementoException e){
                    System.out.println("\n");
                }

            }
        }

    }

    @SuppressWarnings("empty-statement")
    public void insertarArco (String nOrigen, String nDestino) throws NoExisteElementoException{
        Vetice bO, bD;
        VerticeAdyacente v1, v2, i;
        bO = buscarVertice(nOrigen);
        bD = buscarVertice(nDestino);

        if (bO!= null && bD != null){
            v1 = new VerticeAdyacente(nOrigen);
            v2 = new VerticeAdyacente(nDestino);
            if (bO.raiz != null){
                for (i = bO.raiz; i.siguiente != null; i = i.siguiente);
                i.siguiente = v2;
            }else{
                bO.raiz = v2;
            }
            if (bD.raiz != null){
                for (i = bD.raiz; i.siguiente != null; i = i.siguiente);
                i.siguiente = v1;
            }else{
                bD.raiz = v1;
            }
        }
        else
            throw new NoExisteElementoException();

    }

    public void eliminarArco(String nOrigen, String nDestino) throws NoExisteElementoException{
        Vetice bO, bD;
        VerticeAdyacente i;
        bO = buscarVertice(nOrigen);
        bD = buscarVertice(nDestino);
        if (bO!= null && bD != null){ // Si existen
            if (bO.raiz != null) {
                if (bO.raiz.nombre.equals(bD.nombre)) {
                    bO.raiz = bO.raiz.siguiente;
                } else {
                    for (i = bO.raiz; i.siguiente != null; i = i.siguiente) { // Se desconecta el nodo a eliminar
                        if (i.siguiente.nombre.equals(bD.nombre)) {
                            existeConexionEntreVerices = true;
                            i.siguiente = i.siguiente.siguiente;
                            break;
                        }
                    }
                    if (!existeConexionEntreVerices) {
                        existeConexionEntreVerices = false;
                        throw new NoExisteElementoException("No hay conexion entre estos elementos");
                    }
                }
            }else{
                throw new NoExisteElementoException("No hay conexiones entre estos elementos");
            }

            if (bD.raiz != null){
                if (bD.raiz.nombre.equals(bO.nombre)) {
                    bD.raiz = bD.raiz.siguiente;
                } else {
                    for (i = bD.raiz; i.siguiente != null; i = i.siguiente) {
                        if (i.siguiente.nombre.equals(bO.nombre)) {
                            existeConexionEntreVerices = true;
                            i.siguiente = i.siguiente.siguiente;
                            break;
                        }
                    }
                    if (!existeConexionEntreVerices) {
                        existeConexionEntreVerices = false;
                        throw new NoExisteElementoException("No hay conexion entre estos elementos");
                    }
                }
            }else{
                throw new NoExisteElementoException("No hay conexiones entre estos elementos");
            }
        }
        else
            throw new NoExisteElementoException();
    }

    public void BreadthFirstSearch (){
        ColaDinamica cola = new ColaDinamica();
        Vetice aux = raiz;
        Vetice aux2;
        VerticeAdyacente adyacente;
        if (aux.waiting){
            cola.encolar(aux);
            aux.waiting = false;
            while (!cola.isEmpty()){
                aux = cola.desencolar();
                stringBFS += aux;
                adyacente = aux.raiz;
                while (adyacente != null){
                    aux2 = buscarVertice(adyacente.nombre);
                    if (aux2.waiting){
                        cola.encolar(aux2);
                        aux2.waiting = false;
                    }
                    adyacente = adyacente.siguiente;
                }
            }
        }

    }

    public void depthFirstSearch(Vetice vertice) {
        Vetice aux;
        vertice.processed = true;
        stringDFS += vertice;
        VerticeAdyacente counter = vertice.raiz;
        while (counter != null){
            aux = buscarVertice(counter.nombre);
            if (!aux.processed)
                depthFirstSearch(aux);
            else
                counter = counter.siguiente;
        }
    }

    @Override
    public String toString(){
        String cadena = "";
        Vetice i;
        VerticeAdyacente j;
        for (i = raiz; i != null; i = i.siguinete){
            cadena += i;
            for (j = i.raiz; j != null; j = j.siguiente){
                cadena += j;
            }
            cadena += "\n";
        }
        return cadena;
    }

}
