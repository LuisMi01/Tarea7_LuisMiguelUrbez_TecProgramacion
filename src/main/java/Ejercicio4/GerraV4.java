package Ejercicio4;
import Ejercicio3.GuerraV3;

import java.util.Random;

public class GerraV4 {
    private static final int TAMANO = 10;
    private static final char AGUA = '~';
    private static final char BARCO = 'B';
    private static final char IMPACTO = 'X';

    private GuerraV3 jugador;
    private GuerraV3 computadora;
    private Random random;

    public static void main(String[] args) {
        GerraV4 juego = new GerraV4();
        juego.JuegoContraComputadora();
        juego.jugar();
    }
    public  void JuegoContraComputadora() {
        jugador = new GuerraV3();
        computadora = new GuerraV3();
        random = new Random();
        depositarBarcos();
    }

    private void depositarBarcos() {
        System.out.println("Deposita un barco en tu cuadrícula.");
        System.out.print("Fila (0-9): ");
        int fila = leerEntero();
        System.out.print("Columna (0-9): ");
        int columna = leerEntero();
        jugador.depositarBarco(fila, columna);
        System.out.println("Barco depositado en la posición (" + fila + ", " + columna + ").");

        System.out.println("La computadora está depositando su barco...");
        fila = random.nextInt(TAMANO);
        columna = random.nextInt(TAMANO);
        computadora.depositarBarco(fila, columna);
        System.out.println("Barco de la computadora depositado en la posición (" + fila + ", " + columna + ").");
    }

    public void jugar() {
        System.out.println("¡Comienza el juego contra la computadora!");
        boolean turnoJugador = true;
        boolean hundidoJugador = false;
        boolean hundidoComputadora = false;
        int disparosJugador = 0;
        int disparosComputadora = 0;
        while (!hundidoJugador && !hundidoComputadora) {
            if (turnoJugador) {
                System.out.println("Tu turno.");
                computadora.visualizacionJugador();
                System.out.print("Fila (0-9): ");
                int fila = leerEntero();
                System.out.print("Columna (0-9): ");
                int columna = leerEntero();
                if (computadora.disparar(fila, columna)) {
                    System.out.println("¡Impacto en el barco de la computadora!");
                    if (computadora.hundido()) {
                        System.out.println("¡Hundiste el barco de la computadora!");
                        hundidoComputadora = true;
                    }
                } else {
                    System.out.println("Agua...");
                }
                disparosJugador++;
            } else {
                System.out.println("Turno de la computadora.");
                int fila = random.nextInt(TAMANO);
                int columna = random.nextInt(TAMANO);
                if (jugador.disparar(fila, columna)) {
                    System.out.println("La computadora impactó tu barco en la posición (" + fila + ", " + columna + ").");
                    if (jugador.hundido()) {
                        System.out.println("La computadora hundió tu barco.");
                        hundidoJugador = true;
                    }
                } else {
                    System.out.println("La computadora disparó al agua en la posición (" + fila + ", " + columna + ").");
                }
                disparosComputadora++;
            }
            turnoJugador = !turnoJugador;
        }

        if (hundidoJugador) {
            System.out.println("¡Perdiste contra la computadora! Necesitaste " + disparosJugador + " disparos.");
        } else {
            System.out.println("¡Ganaste contra la computadora! La computadora necesitó " + disparosComputadora + " disparos.");

        }


    }

    private int leerEntero() {
        return 0;
    }
}
