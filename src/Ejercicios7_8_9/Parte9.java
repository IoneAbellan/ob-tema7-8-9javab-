package Ejercicios7_8_9;

import java.io.*;

public class Parte9 {
    // InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.

    public static void main(String[] args) {

    }

    public byte[] leerArchivo(String archivoInicial) {
        try {

            InputStream fichero = new FileInputStream(archivoInicial);
            byte[] datos = fichero.readAllBytes();
            //falta pasarlo a strings
        } catch (IOException e) {
            System.out.println("No se ha podido encontrar el archivo" + e.getMessage());
        }
        return datos;
    }
    public void escribirArchivo(String datos, String archivoDestino) {
        try {
            PrintStream info = new PrintStream(archivoDestino);
            info.write(datos);

        } catch(FileNotFoundException e) {
            System.out.println("El archivo destino no existe " + e.getMessage());
        }

    }
}
