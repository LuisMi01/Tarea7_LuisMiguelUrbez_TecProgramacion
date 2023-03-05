package Ejercicio1;

import java.util.Random;

public class Datos {
    private int numCaras;
    private int ultimaCara;
    public static void main(String[] args) {
        Datos dado6 = new Datos();
        Datos dado10 = new Datos(10);
        Datos dado12 = new Datos(12);

        int sum = 0;
        while (sum < 20) {
            sum = dado6.tirar() + dado10.tirar() + dado12.tirar();
            System.out.println("Suma: " + sum);
        }
    }
    public Datos() {
        this.numCaras = 6;

    }

    public Datos(int numCaras) {
        this.numCaras = numCaras;
    }


    public int tirar() {
        Random rand = new Random();
        this.ultimaCara = rand.nextInt(this.numCaras) + 1;
        System.out.println("Ultima cara: " );
        return this.ultimaCara;
    }




    public int getNumCaras() {
        return this.numCaras;
    }

    public int getUltimaCara() {
        return this.ultimaCara;
    }

    public void setNumCaras(int numCaras) {
        this.numCaras = numCaras;
    }
}
