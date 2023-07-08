package grafolistaadyacencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        
        String cad="",aux="",c=""; int n=0; 
        
            try{
            BufferedReader bf= new BufferedReader(new FileReader("grafo1.txt"));
            try {
                cad=bf.readLine();
                for(int i=0; i<cad.length();i++){
                    if(cad.charAt(i)!='['){
                        aux+=cad.charAt(i);
                        n++;
                    } else i=cad.length();
                }
            } catch (IOException ex) { Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);  }
        } catch (FileNotFoundException ex) { Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);}
        
            for(int i=0;i<aux.length();i++){
                g.insertarVertice(""+aux.charAt(i));
            }
            for(int i=n;i<cad.length();i++){
            if(((cad.charAt(i)!='[')&&(cad.charAt(i)!=']')&&(cad.charAt(i)!=','))){
                if((cad.charAt(i+1)!='[')&&(cad.charAt(i+1)!=']')&&(cad.charAt(i+1)!=',')){
                    c+=cad.charAt(i)+""+cad.charAt(i+1)+"\n";
                  g.insertarArco(""+cad.charAt(i), ""+cad.charAt(i+1));  
                }
                    
        }
        }
        
        System.out.println(g.toString());
        System.out.println("recorido anchura:\n"+g.AnchuraPrimero());
        System.out.println("Recorrido profundidad: "+g.ProfundidadPrimero());
    }
    
}
