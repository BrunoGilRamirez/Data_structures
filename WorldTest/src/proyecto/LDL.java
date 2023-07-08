
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LDL {
   
      public Nodo raiz;
     public LDL(){
         raiz=null;
     }
   public boolean estaVacia(){
       return raiz==null;
   } 
   public void insertar(String pais, String capital,String direccion,String resp,String resp1){
       int cont=0;
       Nodo nuevo= new Nodo(pais,capital,direccion,resp,resp1);
          if(raiz!=null){
              raiz.anterior=nuevo;
              nuevo.siguiente=raiz;
          }
          raiz=nuevo;
      }
   
   public void limpiar(){
       raiz=null;
   }
   public Nodo actual(int posicion){
       Nodo actual2=null;
       Nodo actual;
       int pos=1;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(pos==posicion){
               actual2=actual;
           }
               pos++;
               
       }  
       
       return actual2;
   }
 
    public Nodo actual1(int posicion){
       Nodo actual2=null;
       Nodo actual;
       int pos=0;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(pos==posicion){
               actual2=actual;
           }
               pos++;
               
       }  
       
       return actual2;
   }
     public int evaluar(){
       
       Nodo actual;
       int cal=0;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(actual.resp.equals(actual.capital)){
               cal=cal+1;
               eliminar(actual.pais);
           }
               
       }  
       
       return cal;//retorna la calificacion 
   }
   
      
      
      public void limpiarcap(){
       
       Nodo actual;

       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(!actual.resp.equals(" ")){
              actual.resp="";
           }
               
       }  
       
   }
   
   public String capital(int posicion){
       String cap=" ";
       Nodo actual;
       int pos=0;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(pos==posicion){
               cap=actual.capital;
           }
               pos++;
               
       }  
       
       return cap;
   }
     public String direccion(int posicion){
       String dire=" ";
       Nodo actual;
       int pos=0;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(pos==posicion){
               dire=actual.direccion;
           }
               pos++;
               
       }  
       
       return dire;
   }
   
      public String pais(int posicion){
       String pais="";
       Nodo actual;
       int pos=0;
       for(actual=raiz;actual!=null;actual=actual.siguiente){
           if(pos==posicion){
               pais=actual.pais;
           }
               pos++;
               
       }  
       
       return pais;
   }
   
   
     public void eliminar(String pais){
       Nodo actual;
          for(actual=raiz;actual!=null&&!actual.pais.equals(pais);actual=actual.siguiente);     
              if(actual==raiz){
                  if(actual.siguiente!=null)
                              
                           actual.siguiente.anterior=null;
              
                           raiz=actual.siguiente;
                               
                             }else{
                                   if(actual.siguiente!=null){
                                       actual.siguiente.anterior=actual.anterior;
                                   }
                                        actual.anterior.siguiente=actual.siguiente;
                      }
                                 
              }
           
           
           
 @Override
   
public String toString(){
        String cad=" ";
          for (Nodo i=raiz;i!=null;i = i.siguiente)
               cad+=i;
        
        return cad;
    }
public void lectura(String direccion){ 
      Scanner teclado = new Scanner(System.in);
        File f = new File(direccion);

        Scanner entrada = null;
        String cadena,aux,var3=" - ";
        int di,di1,var1;
          int a=0; 
         String  [ ] Array = new String[10000];
         String [ ] Array1 = new String[10000];
         String [ ] Array2 = new String[10000];
        try {
            
            
            entrada = new Scanner(f);
           String v,ver,var= " ";
               
               for (int i=0;i<5;i++) {
                   Array[i]=entrada.nextLine();//lee los paises
                   System.out.println(Array[i]);
               }
                 
           
               for (int i=0;i<5;i++) {  
                  Array1[i]=entrada.nextLine();System.out.println(Array1[i]);//lee capitales
           }
            
               for (int i=0;i<5;i++) {  
                  Array2[i]=entrada.nextLine();System.out.println("d "+Array[i]);//contiene el nombre de las imagenes 
           }
                
               
                 for (int i=0;i<5;i++) {  
              insertar(Array[i],Array1[i],Array2[i],"","");
              
                }
                 
                     
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            
            entrada.close();
        }
}
}