package Ejercicio3;
import java.util.Scanner;
public class Jugar {
    public static void main(String[] args) {
        GuerraV3 cuadricula = new GuerraV3();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la micro guerra de barcos!");

        // Depositar barco
        System.out.println("Deposita un barco en la cuadrícula.");
        System.out.print("Fila (0-9): ");
        int fila = scanner.nextInt();
        System.out.print("Columna (0-9): ");
        int columna = scanner.nextInt();
        cuadricula.depositarBarco(fila, columna);
        System.out.println("Barco depositado en la posición (" + fila + ", " + columna + ").");

        boolean hundido = false;
        int disparos = 0;
        while (!hundido) {
            cuadricula.visualizacion();
            System.out.print("Disparo " + (disparos+1) + ". Fila (0-9): ");
            fila = scanner.nextInt();
            System.out.print("Disparo " + (disparos+1) + ". Columna (0-9): ");
            columna = scanner.nextInt();
            if (cuadricula.disparar(fila, columna)) {
                System.out.println("¡Hundido!");
                hundido = true;
            } else {
                System.out.println("Agua...");
            }
            disparos++;
        }

        System.out.println("Fin del juego. Has necesitado " + disparos + " disparos.");
    }
}
