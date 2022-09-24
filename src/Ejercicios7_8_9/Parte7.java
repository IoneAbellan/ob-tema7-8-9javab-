package Ejercicios7_8_9;

import java.util.Scanner;

public class Parte7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
         int numero = scanner.nextInt();
         try{
             dividePorCero(numero);
         } catch (ArithmeticException e){
             System.out.println("Esto no puede hacerse");
         } finally {
             System.out.println("Demo de codigo");
         }
    }
    public static int dividePorCero(int numero) throws ArithmeticException{
        int resultado = numero / 0;
        return resultado;
    }
}
//Ione Abellan Robledo

