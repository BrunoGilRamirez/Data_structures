
package Req;


public class SLL {
    class Nodo {
        int d;
        int puntero=0;
        Nodo sig;
    } 
    Nodo raiz; int cont=0,ban=0;
    public SLL(){
        raiz = null;
    }
    public boolean esvacia(){
        return raiz==null;
    }
     
    public void insertar (int x) {
    	Nodo n = new Nodo();
        n.d = x; cont++;
        if (raiz==null){
            n.puntero=cont;
            n.sig= null;
            raiz = n;
            
        }
        else{
            n.puntero=cont;
            n.sig = raiz;
            raiz = n;
            
        }
    }
    public void insertorden(int x){
      int r;Nodo n = new Nodo(); n.d=x;cont++;
      if (raiz==null) {
            raiz=n;
        } else {
            if (x<raiz.d) {
                n.sig=raiz;
                raiz=n; n.puntero= cont;
            } else {
                Nodo mov=raiz;
                Nodo atras=raiz;
                while (x>=mov.d && mov.sig!=null) {
                    atras=mov;
                    mov=mov.sig;
                }
                if (x>=mov.d) {
                    mov.sig=n;
                    n.puntero= cont;
                } else {
                    n.sig=mov;
                    atras.sig=n;n.puntero= cont;
                }
            }
        }  
     r=cont;
        for( Nodo a=raiz;a!=null; a=a.sig) {
            if(r<=cont) a.puntero=r--;
        }
    }
    
     
     
    
    private Nodo Buscar (int dato){
        for( Nodo a=raiz;a!=null; a=a.sig){
            if (a.d==dato){
                return a;
            }
        }
        return null;   
    }
    private Nodo Buscaranterior(Nodo act){
        Nodo ant= null;
        if(act!= null){
            for( Nodo a=raiz;a!=act ; a=a.sig){
                ant= a;
                
            }
        }
        return ant;
    }
    public void eliminar(int dato){
        Nodo act = Buscar(dato);
        Nodo ant= Buscaranterior(act);
        if(act!=null){
            if(ant==null){
                raiz= raiz.sig;
            }else{
                ant.sig= act.sig;
            }
        }
    }
    public String impares(){
        int r=cont, punt=0; Nodo cort, peg=null; String aux;
        for( Nodo a=raiz;a!=null; a=a.sig){
            
            if((a.puntero%2)!=0){
                    cort=a; 
                for( Nodo b=raiz;b!=cort; b=b.sig){
                    
                        peg=b;
                    
                }
                if(peg==null){
                    raiz= raiz.sig;
                    cont--; ban=1;
                }else{
                    peg.sig=cort.sig; 
                    cont--; ban=1;
                }
            } 
        } aux= imprimir();
        r=cont;
        for( Nodo a=raiz;a!=null; a=a.sig) {
            if(r<=cont) a.puntero=r--;
        }
        return aux;
    }
   public String imprimir() {
        String aux=""; Nodo a; int punt= 0;
        
        for( a=raiz;a!=null; a=a.sig){
            punt++;
            //if(punt<=cont)a.puntero=punt;
          aux+="#"+a.puntero+": "+a.d+"\n";
          
        }
        
        return aux;
    } 
}
