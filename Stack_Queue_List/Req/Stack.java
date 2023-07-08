
package Req;

import javax.swing.JOptionPane;


public class Stack {
    class Nodo {
        int d;
        Nodo sig;
    }
    int tam;
    private Nodo cima;
    
    public Stack () {
        cima=null;
        tam=0;
    }
    
    public void apilar (int x) {
    	Nodo n = new Nodo();
        n.d = x;
        if (cima==null)
        {
            n.sig = null;
            cima = n;
        }
        else
        {
            n.sig = cima;
            cima = n;
        }
        tam++;
    }
    
    public int desapilar (){
        if (cima!=null){
            int informacion = cima.d;
            cima = cima.sig;
            return informacion;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }
    
    public boolean esvacia(){
        return cima==null; 
    }
    
    
    
    public String imprimir() {
        String aux=""; 
        
        for(Nodo a=cima;a!=null; a=a.sig){
          aux+=a.d+"\n";  
        }
        
        return aux;
    }
    
}
