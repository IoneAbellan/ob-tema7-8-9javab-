package Ejercicios7_8_9;

public class Parte2 {

    public static void main(String[] args) {
        int arrayBi [][] = { {1, 2, 3, 4 , 5},
                            {10, 20, 30, 40, 50}};

        for (int i = 0; i < arrayBi.length; i++) {
            for (int j = 0; j < arrayBi[0].length; j++) {
                System.out.println("Caja: " + i + ", posicion: " + j + ", numero " + arrayBi[i][j]);
            }
        }
    }
}
// Ione Abellan Robledo
