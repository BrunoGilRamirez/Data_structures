
package testldlc;


public class Nodo {
    private int dato;
    private Nodo sig;
    private Nodo ant;
    
    public Nodo(int dato){
        this.dato = dato;
        ant = sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    @Override
    public String toString(){
        return "<-"+dato+"->";
    }
}
