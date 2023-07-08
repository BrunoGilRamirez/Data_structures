package ldl;

public class Principal {

    public static void main(String[] args) {
        LDL l1 = new LDL();
        
        
        l1.insertar(10);
        l1.insertar(2);
        l1.insertar(3);
        l1.insertar(3);
        l1.insertar(4);
        l1.insertar(512);
        //l1.insertar(1);
        System.out.println("mediana: "+ l1.mediana());
        
        System.out.println(l1);
        /*l1.eliminar(3);
        System.out.println(l1);
        l1.eliminar(5);
        System.out.println(l1);
        l1.eliminar(1);
        System.out.println(l1);*/
    }
    
}
