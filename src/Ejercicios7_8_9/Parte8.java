package Ejercicios7_8_9;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Parte8 {

    public static void main(String[] args) {
        String fileIn = "C:/Users/ione/Desktop/prueba.txt";
        String fileOut = "/C:/Users/ione/Desktop/prueba2.txt";
        copiarArchivo(fileIn, fileOut);
    }

    public static void copiarArchivo(String fileIn, String fileOut) {
        try {
            InputStream fichero = new FileInputStream(fileIn);
            byte[] datos = fichero.readAllBytes();

            PrintStream info = new PrintStream(fileOut);
            info.write(datos);

        } catch (Exception e) {
            System.out.println(("No se ha podido realizar la operación " + e.getMessage()));
        }
    }
}
//Ione Abellan Robledo
