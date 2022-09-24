package Ejercicios7_8_9;

import java.util.ArrayList;

public class Parte6 {
    public static void main(String[] args) {
        //Buenas! Este ejercicio me ha parecido un poco complicado, espero haberlo hecho bien. He creado una lista nueva
        //  donde he añadido los numeros pares y luego se los he eliminado de la lista original.

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> numerosPares = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        for (Integer elemento : numeros) {
            if(elemento %2 == 0) {
                numerosPares.add(elemento);
            }
        }
        numeros.removeAll(numerosPares);

        System.out.println("En la lista hay: " + numeros);

    }
}
// Ione Abellan Robledo
