
package proyecto;


public class Nodo {
    String pais,capital,direccion,resp;
    
    Nodo anterior,siguiente;
    
       public Nodo (String pais, String capital, String direccion,String resp,String resp1){
         this.pais=pais;
          this.capital=capital; 
          this.direccion=direccion;
          this.resp=resp;
          anterior=siguiente=null;
        }
        @Override
       public String toString(){
            return "<-"+pais+capital+direccion+resp+"->";
    
       }
}
