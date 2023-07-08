
package testldlc;


public class TestLDLC {

   
    public static void main(String[] args) {
        LDLC l = new LDLC();
        l.insertar(36);
        l.insertar(57);
        l.insertar(62);
        l.insertar(4);
        System.out.println(l);
        l.eliminar(57);
        System.out.println(l);
        l.eliminar(4);
        System.out.println(l);

    }
    
}
