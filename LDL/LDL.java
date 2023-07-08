package ldl;

public class LDL {
    private Nodo raiz;
    private int cont;//es la variable global que nos contara cuantos nodos hay.
    
    public LDL(){
        raiz = null;
    }
    public boolean isEmpty(){
        return raiz == null;
    }
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato); cont++;//aumento el contador en cada insercion
        if(raiz != null){
            nuevo.setSig(raiz);
            raiz.setAnt(nuevo);
        }
        raiz = nuevo;
    }
    public float mediana(){
        int  tem; float med=0;// es un metodo de tipo flotante, pues al ser una lista de tamaño par, salen decimales al hacer la operacion de mediana
        
        for(Nodo i = raiz; i != null; i = i.getSig()){// se va a ordenar el contenido de la lista por el metodo de la burbuja aplicado a listas dinamicas
            Nodo j= raiz;//es un nodo que hara la funcion de ir adelantado con respecto de h para comparar el nodo en h y el nodo en j que si fueran indices seria p/e: h=2 j=3
            for(Nodo h = raiz; h != null; h = h.getSig()){// segundo for para acomodar el elemento temporal
                if(j!=null)j= j.getSig(); //si j no esta al final de la lista avanza una posicion.
                if(j!=null){ //se hace por si j.getdato es un puntero nulo.  
                if (h.getDato()>j.getDato()){
                    tem= h.getDato(); //h es mayor al dato que tiene adelante lo guarda en temp
                    h.setDato(j.getDato());//se guarda en h lo que tiene j para mandarlo a una posicion atras. 
                    j.setDato(tem);  //y lo que originalmente tenia h se mueve adelante en la posicion de j.
                }
                }
            }
        } 
        int mit,p, aux;// mit es para almacenar la mitad de la lista, p es un contador que nos ayudara a llevar la cuenta de los elementos y nodos de la lista
        if(cont %2==0){//si es par entonces
            mit= cont/2;  //obtiene la posicion media de la lista 
            p=1;//inicia el contador
            for(Nodo i = raiz; i != null; i = i.getSig()){
                if(p==mit){ //si encuenta la mitad de la lista
                   
                   aux=i.getDato(); eliminar(aux);//entonces guarda en aux el dato en esa posicion, manda a eliminar ese nodo
                   i=i.getSig(); //avanza para obtener el siguiente elemento 
                    med= (aux+i.getDato()); med= med/2;//los suma primero y luego los divide, esto para que no me redondee el resultado. 
                    eliminar(i.getDato()); //y elimina el nodo con el segundo dato que usamos. 
                } p++;//si no due así continua su busqueda. 
            }
            
        }else {// si es impar
          mit= (cont/2)+1;//obtiene la mitad
          p=1;//inicia el contador
          for(Nodo i = raiz; i != null; i = i.getSig()){//inicia el for
              if(p==mit) {med= i.getDato(); } p++;//encuentra la mitad de la lista y obtiene el dato de la mediana. Si no fue asi, continua con su camino el contador 
          }
        }
        
        
        return med;//al final retorna la mediana. 
    }
    public void eliminar(int dato){
        Nodo actual;
        for(actual = raiz; actual != null && actual.getDato()!= dato; actual = actual.getSig());
        
        if(actual != null){
            if(raiz == actual){
                if(actual.getSig()!= null){
                    actual.getSig().setAnt(null);
                    
                }
                raiz = actual.getSig();
               
            }
            else{
                if(actual.getSig()!= null){
                    actual.getSig().setAnt(actual.getAnt());
                }
                actual.getAnt().setSig(actual.getSig());        
            }
        }
    }
    
    @Override
    public String toString(){
        String cad = ""; 
       
        int ip=1;
        for(Nodo i = raiz; i != null; i = i.getSig()){
            cad+=(ip++)+"# "+i.getDato()+"\n";
           
        }
        
        return cad;
    }
}
