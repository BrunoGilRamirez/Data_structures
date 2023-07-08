/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafomatrices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Paola
 */
public class graph {
    int MA[][];
    vertex AV[];
    int nv;
   
    public graph(int n) {
     MA=new int[n][n];
     AV=new vertex[n];
     nv=0;
        }
  
     public int buscarVertice1(String nombre){
        int i;
        
        for(i=0;i<nv;i++){
            if(AV[i].nombre.equals(nombre))
            return i;
            }   
        return -1;
    }
    public void insertar (String nombre){
        vertex v = new vertex (nombre);
        int i = buscarVertice1(nombre);
        if(i==-1)
            AV[nv++]=v;
        else{
            System.out.println("El verice ya existe");
        }
    }
    public void insertarArco(String n1,String n2, int peso ){
     int i= buscarVertice1(n1);
     int j= buscarVertice1(n2);
    if(i!=-1&&j!=-1){
        MA[i][j]=peso;
        MA[j][i]=peso;
     }else{
       System.out.println("No fue posible insertar arco");
          }
    }
     public void eliminarArco(String n1,String n2 ){
     int i= buscarVertice1(n1);
     int j= buscarVertice1(n2);
         if(i!=-1&&j!=-1){
            MA[i][j]=10000;
            MA[j][i]=10000;
        }
    }
     
     
      public void eliminarVertice (String nombre){
        int i = buscarVertice1(nombre);
        int x=0,y=0;
        
        if(i!=-1) {
          AV[i].pos=-1;
           AV[i].nombre=" ";
        }      
         for(x=0;x<nv;x++){
             MA[i][x]=0;
             MA[x][i]=0;
         }
     
    }
      
    @Override
    public String toString(){
    String cad = "";
    int i,j;
 
     for(i = 0; i < nv; i++){
          
           cad += AV[i].nombre; 
          
           for(j = 0; j < nv; j++){
              cad += MA[i][j]; 
         }
           
          cad += "\n";    
         }
     
     return cad;
   }
    
 public void RecorridoAnchura(){
        Queue C;
	C = new Queue ();
      int i,j;
      String si;
   
            
        C.encolar(AV[0].nombre);
           AV[0].estado="Dentro";
                
        
       while(!C.estaVacia()){
                 si=C.dato();
                  System.out.println(si ); 
                   i = buscarVertice1(si);
                 C.desencolar();
                AV[0].estado="Procesado";
            
            for(j = 0; j < nv; j++){
                 if (MA[i][j]==1){
                   if(AV[j].estado==null){
                         C.encolar(AV[j].nombre);
                          AV[j].estado="Dentro";
                    }                     
                }
            }
               
       }
       for( i = 0; i< nv; i++){
            AV[i].estado=null;
        }
           
    }        
 public void RecorridoProfundidad(){
        Stack P;
	P = new Stack ();
        int i,j,x,d;
        String si;
        Nodo u;
   
            
        P.push(AV[0].nombre);
         P.raiz.estado="Dentro";   
       
          //for(x = 0; x < nv; x++){
         while(!P.estaVacia()){
               //System.out.println(P.raiz.estado ); 
                if(P.raiz.estado=="Procesado"){
                  P.pop();
             }else{ 
          
                 si=P.dato();
                  System.out.println(si ); 
                   i = buscarVertice1(si);
                 P.pop();
                  
                 
            for(j = nv; j > 0; j--){
                 if (MA[i][j]==1){
                   if(AV[j].estado!="Procesado"){
                         P.push(AV[j].nombre);
                          AV[j].estado="Dentro";
                          //System.out.println( AV[j].nombre);
                    }                     
                }
            }
             
             for(d = 0; d < nv; d++){
                  for(j = 0; j < nv; j++){
                      if(MA[d][j]==1){
                          if(AV[j].nombre.equals(si)){
                               AV[j].estado="Procesado";
                          ///System.out.println(AV[j].nombre);
                          }
                      }
                  }
             }
             
            for(u = P.raiz; u != null; u = u.siguiente){
                                   if(u.estado==null)
                                       u.estado="Dentro";
               
                                   if(u.dato.equals(si))
                                       u.estado="Procesado";
                   }
         
          }
        }
       for( x = 0; x< nv; x++){
       for( i = 0; i< nv; i++){
            AV[i].estado=null;
            AV[x].estado=null;
        }
       }
           
    }
 
 
  
   
 
 public void lectura(String direccion){ 
      Scanner teclado = new Scanner(System.in);
        File f = new File(direccion);
        Scanner entrada = null;
        String cadena,var1,var2,var3=" - ";
        int di;
        try {
            
            entrada = new Scanner(f);
           String v,ver,var;
                System.out.println("Cuantos vertices va a ingresar?" );
                di = teclado.nextInt();
       
             
               for (int i=0;i<di;i++) {  
                 var=entrada.nextLine();
                 insertar(var);
             }
               
             
             while (entrada.hasNext()) {
                 cadena = entrada.nextLine();
                  
             while (entrada.hasNext()) {
                 var1=st.nextToken();//es Orifen
                 var2=st.nextToken(var3);//es Destino
        
                }
                    
                }
            
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            
            entrada.close();
        }
     }
}
   

