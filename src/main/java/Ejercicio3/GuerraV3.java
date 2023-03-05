package Ejercicio3;

import java.util.Arrays;

public class GuerraV3 {
    private final int TAMANO = 10;
    private final char AGUA = '~';
    private final char BARCO = 'B';
    private final char IMPACTO = 'X';

    private char[][] tabla;

    public GuerraV3() {
        tabla = new char[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            Arrays.fill(tabla[i], AGUA);
        }
    }

    public void depositarBarco(int fila, int columna) {
        tabla[fila][columna] = BARCO;
    }

    public boolean disparar(int fila, int columna) {
        if (tabla[fila][columna] == BARCO) {
            tabla[fila][columna] = IMPACTO;
            return true;
        }
        return false;
    }

    public void visualizacion() {
        System.out.print("  ");
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void visualizacionJugador() {
        System.out.print("  ");
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                if (tabla[i][j] == IMPACTO) {
                    System.out.print(tabla[i][j] + " ");
                } else {
                    System.out.print(AGUA + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean hundido() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tabla[i][j] == BARCO) {
                    return false;
                }
            }
        }
        return true;
    }
}
