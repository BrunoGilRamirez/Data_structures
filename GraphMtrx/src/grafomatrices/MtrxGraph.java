/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafomatrices;

import java.util.Scanner;

/**
 *
 * @author Paola
 */
public class MtrxGraph {

  
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner teclado = new Scanner(System.in);
		int opc,peso=0;
                String nombre,nombre1,nombre2,direccion;
                graph A;
                A = new graph(20); 
               
         do{
        
            System.out.println("Menú");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1.- Cargar grafo");
            System.out.println("2.- Insertar vertice");
            System.out.println("3.- Eliminar vertice");
            System.out.println("4.- Insertar Arco ");
            System.out.println("5.- Eliminar Arco ");
            System.out.println("6.- Imprimir grafo ");
            System.out.println("7.- Recorrido primero en anchura ");
            System.out.println("8.- Recorrido primero en profundidad ");
            System.out.println("9.- Salir");
            opc = teclado.nextInt();
            
            switch(opc){
            
                case 1: {
                  
                  System.out.println("Ingrese la direccion del archivo:");
                        direccion = teclado.next();
                        A.lectura(direccion);
                    
                    
                break;
                }
                case 2:{
                   System.out.println("Ingrese el nombre del vertice a insertar:");
                    nombre = teclado.next();
                    A.insertar(nombre);
                break;
                }
                case 3:{
                    System.out.println("Ingrese el nombre del vertice a eliminar:");
                    nombre = teclado.next();
                    A.eliminarVertice(nombre);
                   
                   
                    
                break;
                }
                case 4:{
                   System.out.println("Ingrese la primera direccion del arco");
                    nombre1 = teclado.next();
                    System.out.println("Ingrese la segunda direccion del arco");
                    nombre2 = teclado.next();
                    System.out.println("Ingrese el peso del arco");
                    peso = teclado.nextInt();
                    A.insertarArco(nombre1, nombre2,peso);
                    
                    break;
                }
                case 5:{
                    System.out.println("Ingrese la primera direccion del arco a eliminar");
                    nombre1 = teclado.next();
                    System.out.println("Ingrese la segunda direccion del arco a eliminar");
                    nombre2 = teclado.next();
                    A.eliminarArco(nombre1, nombre2);
                
                    break;
                }
                case 6:{
                   System.out.println("Su grafo es:");
                     System.out.println(A);
                    break;
                }
                case 7:{
                   System.out.println("El recorrido primero en anchura es: ");
                     A.RecorridoAnchura();
                    break;
                }
                case 8:{
                   System.out.println("El recorrido primero en profundidad es: ");
                     A.RecorridoProfundidad();
                    break;
                }
                case 9:{
                   
                    break;
                }
            }
        }while(opc != 9 );   
    }
    }
    

    

