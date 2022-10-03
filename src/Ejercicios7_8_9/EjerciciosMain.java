package Ejercicios7_8_9;

import java.util.Scanner;

public class EjerciciosMain {

    public static void main(String[] args) {
        System.out.println("Introduce un texto: ");
        Scanner scaner = new Scanner(System.in);

        String texto = scaner.nextLine();
        System.out.println(EjerciciosMain.reverse(texto));
    }
    public static String reverse(String texto){

        String textoReverse = "";
        for (int i = texto.length()-1; i > -1; i--) {
            textoReverse = textoReverse.concat(String.valueOf(texto.charAt(i)));
        }
        return textoReverse;
    }
}
// Ione Abellan Robledo
