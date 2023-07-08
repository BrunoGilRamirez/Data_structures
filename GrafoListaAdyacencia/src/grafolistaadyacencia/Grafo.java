package grafolistaadyacencia;

public class Grafo {
    private Vertice raiz;
    
    public Grafo(){
        raiz = null;
    }
    
    public Vertice buscarVertice(String nombre){
        Vertice i;
        for(i = raiz; i != null; i = i.getSig()){
            if(nombre.equals(i.getNombre())){
                return i;
            }
        }
        return null;
    }
    
    public void insertarVertice(String nombre){
        Vertice b = buscarVertice(nombre);
        Vertice v = new Vertice(nombre,1);
        Vertice i;
        if(b == null){
            if(raiz == null){
                raiz = v;
            }
            else{
                for(i = raiz; i.getSig()!= null; i = i.getSig());
                i.setSig(v);
            }
        }
    }
    public void insertarArco(String nombreOrigen, String nombreDestino){
        Vertice origen = buscarVertice(nombreOrigen);
        Vertice destino = buscarVertice(nombreDestino);
        int ban=0,ban2=0;
        VerticeAdyacente o = new VerticeAdyacente(nombreOrigen);
        VerticeAdyacente d = new VerticeAdyacente(nombreDestino);
        
        VerticeAdyacente i;
        
        if(origen != null && destino != null){
            if(origen.getRaiz() == null){
                origen.setRaiz(d);
            }
            else{
                for(i = origen.getRaiz(); i.getSig()!= null; i = i.getSig()); i.setSig(d);
            }
            if(destino.getRaiz() == null){
                destino.setRaiz(o);
            }
            else{
                for(i = destino.getRaiz(); i.getSig()!= null; i = i.getSig());
                
                i.setSig(o);
            }
        }
    }
    private void blank(){
         for(Vertice i = raiz; i != null; i = i.getSig()){
             i.estado=1;
         }
    }
    public String AnchuraPrimero(){
        String cad=""; ColaDinamica1<Vertice> c= new ColaDinamica1(); Vertice v,auxv,auxn; 
        for(Vertice i = raiz; i != null; i = i.getSig()){
            if(i.estado==1){
                i.estado=2; c.encolar(i); 
            }
            while(!c.vacia()){
                auxn=c.desencolar();
                cad+=auxn.nombre+" -> ";
                auxn.estado=3;
                for( VerticeAdyacente j = auxn.getRaiz(); j != null; j = j.getSig()){
                    auxv=buscarVertice(j.nombre);
                    if(auxv.estado==1){
                       auxv.estado=2; c.encolar(auxv); 
                    } 
                }
                
            }
        } 
        blank();
       return cad;
    }
    public String ProfundidadPrimero(){
        String cad=""; PilaDinamica<Vertice> p=new PilaDinamica(); Vertice auxv,auxn; PilaDinamica <Vertice> aux= new PilaDinamica();
        for(Vertice i = raiz; i != null; i = i.getSig()){
            
            if(i.estado==1){
                i.estado=2; p.push(i);
            }
            while(!p.vacia()){
            auxv=p.pop();
            if(auxv.estado!=3){
            cad+=auxv.nombre+" -> ";
            auxv.estado=3;
            for( VerticeAdyacente j = auxv.getRaiz(); j != null; j = j.getSig()){
               auxn=buscarVertice(j.nombre);
               if(auxn.estado==1||auxn.estado==2){
                  auxn.estado=2; aux.push(auxn);
               }  
            }
                
            while(!aux.vacia())  p.push(aux.pop());
            }    
            }
         }
        blank();
        return cad;
    }
    
    @Override
    public String toString(){
        Vertice i;
        VerticeAdyacente j;
        String cad = "";
        for(i = raiz; i != null; i = i.getSig()){
            cad += i.nombre+": ";
            for(j = i.getRaiz(); j != null; j = j.getSig()){
                cad += j.nombre;
            }
            cad+="\n";
        }
        return cad;
    }
    
    //lea desde archivo
    //eliminarVertice
    //eliminarArco.
    //Sugerencia: Hacerlo con LDL
    //Meter anchura y profundidad en el grafo con listas y en el grafo con matrices.
    
}
