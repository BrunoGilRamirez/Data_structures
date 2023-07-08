
package testldlc;

public class LDLC {
    private Nodo raiz;
    private Nodo fin;

    
    public LDLC(){
        raiz = fin = null;
    }
    public boolean isEmpty(){
        return raiz == null; 
    }
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato);

        if (raiz == null) {//primer nodo
            nuevo.setSig(nuevo);
            nuevo.setAnt(nuevo);
            raiz = nuevo;
        }
        else{
            fin = raiz.getAnt();  //asigna el nodo fin
            nuevo.setSig(raiz);  //apunta al ultimo
            nuevo.setAnt(fin);
            raiz.setAnt(nuevo); //el primero apunta al principio
            fin.setSig(nuevo);
            raiz = nuevo;
            
        }
    }
    public void eliminar(int dato){
        if(raiz !=null){
            Nodo aux= raiz;
            Nodo ant=null;
            while(aux.getSig()!=raiz){
                if(aux.getDato() == dato){
                    if(ant==null){
                        if(aux.getSig()==raiz)
                            raiz=null;
                        else{
                            ant=aux.getAnt();
                            ant.setSig(aux.getSig());
                            aux=aux.getSig();
                            aux.setAnt(ant);
                            raiz=aux;
                            ant=null;
                        }
                    }
                    else{
                        aux.setAnt(null);
                        ant.setSig(aux.getSig());
                        aux=aux.getSig();
                        aux.setAnt(ant);
                    }
                }
                else{
                    ant=aux;
                    aux=aux.getSig();
                }
            }
        }           
    }
    @Override
    public String toString(){
        Nodo i = raiz;
        String cad = "";
        if(!isEmpty()){
            do{
                cad += i.getSig();
                i = i.getSig();
            }while(i != raiz);
        }
        
    return cad;
    }
    
}
