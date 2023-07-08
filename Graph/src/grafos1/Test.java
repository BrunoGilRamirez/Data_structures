package grafos1;

import Exceptions.NoExisteElementoException;

import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main (String [] args) throws IOException, ClassNotFoundException {
        Graph grafo = new Graph();
        Scanner in = new Scanner(System.in);
        int option = 0;
        String nombre, origen, destino;
        while (option != 7) {
        System.out.println("Ingrese una opción");
        System.out.println("1.Abrir desde un archivo");
        System.out.println("2.Insertar un vertice");
        System.out.println("3.Eliminar un vertice");
        System.out.println("4.Insertar un arco");
        System.out.println("5.Eliminar un arco");
        System.out.println("6.Imprimir el grafo");
        System.out.println("7.Salir");
        System.out.println("8.Guardar como unico archivo");
        System.out.println("9.Recorrido primero en anchura");
        System.out.println("10.Recorrido primero en profundidad");
        System.out.print("> ");
        try {
            option = in.nextInt();
            in.nextLine();
        }
        catch (java.util.InputMismatchException e){}

            switch (option) {
                case 1:
                    try {
                        System.out.println("Ingrese el nombre de un archivo(Grafo,Grafo1,Grafo2)");
                        nombre = in.nextLine();
                        FileInputStream entrada = new FileInputStream("Grafos/" + nombre +".txt");
                        ObjectInputStream reader = new ObjectInputStream(entrada);
                        //Lectura de objeto
                        System.out.println("------------ Contenido de "+nombre+".txt ---------------");
                        grafo = (Graph) reader.readObject();
                        System.out.println(grafo);
                    }
                    catch (java.io.InvalidClassException e){
                        System.out.println("\nNo hay archivos disponibles o el archivo se ha corrompido\n");
                    }
                    break;
                case 2:
                    System.out.println("Nombre vertice (Insertar): ");
                    nombre = in.nextLine();
                    try {
                        grafo.insertarVertice(nombre);
                        System.out.println(grafo);
                    }
                    catch (NoExisteElementoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Nombre vertice (Eliminar): ");
                    nombre = in.nextLine();
                    try {
                        grafo.eliminarVertice(nombre);
                        System.out.println(grafo);
                    }
                    catch (NoExisteElementoException e){
                        System.out.println(e.getMessage());
                    }
                    catch (NullPointerException ex){
                        System.out.println("No existe el elemento\n");
                    }
                    break;


                case 4:
                    System.out.println("Vertice origen (Insertar)");
                    System.out.println("Nombre: ");
                    origen = in.nextLine();
                    System.out.println("Vertice destino (Insertar)");
                    System.out.println("Nombre: ");
                    destino = in.nextLine();
                    try {
                        grafo.insertarArco(origen, destino);
                        System.out.println(grafo);
                    }
                    catch (NoExisteElementoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Vertice origen (Eliminar)");
                    System.out.println("Nombre: ");
                    origen = in.nextLine();
                    System.out.println("Vertice destino (Eliminar)");
                    System.out.println("Nombre: ");
                    destino = in.nextLine();
                    try {
                        grafo.eliminarArco(origen,destino);
                        System.out.println(grafo);
                    }
                    catch (NoExisteElementoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(grafo);
                    break;

                case 7:
                    System.out.println("\n");
                    break;

                case 8:
                    File grafoTxt = new File("Grafos/"+"Grafo3.txt");
                    FileOutputStream fileOS = new FileOutputStream(grafoTxt); // Se pasa el archivo
                    ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
                    objectOS.writeObject(grafo); // Se esecribe
                    objectOS.close(); // Se cierra el archivo
                    System.out.println(grafo);
                    System.out.println("Se guardó correctamente\n");
                    break;

                case 9:
                    grafo.stringBFS = "";
                    System.out.println("En anchura: ");
                    grafo.BreadthFirstSearch();
                    System.out.println(grafo.stringBFS);
                    break;

                case 10:
                    grafo.stringDFS = "";
                    System.out.println("En profundidad: ");
                    grafo.depthFirstSearch(grafo.raiz);
                    System.out.println(grafo.stringDFS);
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;

            }
        }
    }
}
