package Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class LosClientes {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<String> clientes = new ArrayList<String>();
    public static void main(String[] args) {
        boolean salir = false;
        do {
            int opcion;

            System.out.println("--Menu--");
            System.out.println("1.- Mostrar clientes");
            System.out.println("2.- Añadir cliente");
            System.out.println("3.- salir");

            opcion = teclado.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("--Clientes--");
                        mostrarClientes();
                        break;
                    case 2:
                        anadirCliente();
                        break;
                    case 3:
                        salir = true;
                        break;

                    default:
                        System.out.println("Debe ingresar un numero entre el 1 y 7");
                }
            }
            catch (Exception e) {
                System.out.println("Debe ingresar un numero entre el 1 y 7");
            }
        }while (!salir);

    }


    static void mostrarClientes(){
        System.out.println("Se van a mostrar todos los clientes de la compañia");
        for(int i = 1; i < clientes.size(); i++){
            System.out.println("Cliente nº"+ i +" "+ clientes.get(i));
        }
    }

    static void anadirCliente(){
        System.out.println("¿Cual es el nombre y apellidos del cliente?");
        String nombre = teclado.next();
        clientes.add(nombre);
    }
}
