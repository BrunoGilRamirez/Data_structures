
public class SLLC {
  class Nodo {
        int dat;
        int p;
        Nodo sig;
    }  
  private Nodo raiz;
  private int cont;
  public SLLC(){
      raiz=null;cont=0;
  }
  public boolean isEmpty(){
      return raiz==null; 
  }
  public void insert (int dato){
      Nodo nuevo = new Nodo(); 
      nuevo.dat = dato; nuevo.p=++cont;
        if (raiz==null) {
             nuevo.sig=nuevo;            
                       
            
        } else{
          nuevo.sig=raiz.sig;
          raiz.sig=nuevo;
      } 
      raiz=nuevo;  
  }
  public void insertarParesImpares(int dato){
        Nodo nuevo = new Nodo(); nuevo.dat=dato;
        Nodo aux;
        nuevo.p=cont++;
        if(raiz != null){
            if(dato%2 == 1){
                nuevo.sig=raiz.sig;
                raiz.sig=nuevo;
                raiz=nuevo;
            }
            else{
                aux = raiz.sig;
                nuevo.sig=aux;
                raiz.sig=nuevo;
            }
        }
        else
            raiz=nuevo;
        ordenar();
    }
  public String primos(){
      String aux=""; Nodo ant=null, act=raiz; int j=0,cont1=cont; 
     while(j!=cont){
         if(prban(act.sig.dat)){
             ant = act;
             act=act.sig;
            
             if(ant==act){
                 raiz=null;
                 
             }else{
                 raiz=ant;
                 ant.sig=act.sig;
             }
              cont1--;
         }
         act=act.sig; 
         j++;
     }
     if(ant==null){
         aux="No hay primos ajua";
     }else
     aux=toString(); cont=cont1;
     ordenar();
     
      return aux;
  }
  private boolean prban (int numero){
      int ban=0; 
      for(int i = 1; i <= numero; i++){
            if((numero % i) == 0)ban++;
        }
      return ban==2;
  }
  public String eliminar(int dato){
     Nodo ant=null, act=raiz,c; String cad;
     if(!isEmpty()){
     do{ 
         
         if(act.sig.dat==dato){
             ant = act;
             act=act.sig;
            
             if(ant==act){
                 raiz=null;
                 
             }else{
                 raiz=ant;
                 ant.sig=act.sig;
             }
             act=raiz; cont--;
         }else{
             act=act.sig; 
             c=act.sig;
         }
     }while(act!=raiz); }
     cad= toString();
     ordenar();
     if(ant==null) cad="no se encontro el elemto en la lista";
  return cad;
  }
  private void ordenar(){
      if (!isEmpty()) {
            Nodo reco=raiz; int j=0;
            reco=reco.sig;
            do {
                reco.p=++j;
                reco = reco.sig;                
            } while (reco!=raiz.sig);
            System.out.println();
        }
  }
  @Override
  public String toString(){
      String cad="";  
      if (!isEmpty()) {
            Nodo reco=raiz;
            reco=reco.sig;
            do {
                cad+=reco.p+"# "+reco.dat + "\n";
                reco = reco.sig;                
            } while (reco!=raiz.sig);
            System.out.println();
        }else{
          cad="Lista vacia";
      }
      return cad;
  } 
}
