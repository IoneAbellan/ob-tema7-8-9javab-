package Ejercicios7_8_9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Parte9 {
    // InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.

    public static void main(String[] args) {
        String archivoInicial = "D:/Programacion/CursoIniciacion/JavaBasico/Ejercicio9_inicial.txt";
        String archivoFinal = "D:/Programacion/CursoIniciacion/JavaBasico/Ejercicio9_Final.txt";


        System.out.println("Hola! Estos son los productos que tenemos:");

        String contenido = leerArchivo(archivoInicial);
        HashMap<String, Integer> objetos = rellenarMapa(contenido);

        List<String> carrito = rellenarCarrito(objetos);

        Integer precioFinal = calcularPrecio(objetos, carrito);

        escribirArchivo(carrito, precioFinal, archivoFinal);



    }

    private static Integer calcularPrecio(HashMap<String, Integer> objetos, List<String> carrito){
        Integer precioTotal = 0;
        for(String elemento : carrito){
            if(objetos.containsKey(elemento)){
                precioTotal += objetos.get(elemento);
            }
        }
        System.out.println("Este es el precio final: " + precioTotal);

        return precioTotal;
    }

    public static String leerArchivo(String archivoInicial) {
        String contenido = "";
        try {
            InputStream fichero = new FileInputStream(archivoInicial);
            //Ahora imprimo el archivo
            byte[] datos = fichero.readAllBytes();
            for (byte dato : datos) {
                //System.out.println((char)dato);
                contenido = contenido.concat(Character.toString((char)dato));
            }
            System.out.println(contenido);

        } catch (IOException e) {
            System.out.println("No se ha podido encontrar el archivo" + e.getMessage());
        }
        return contenido;
    }

    public static void escribirArchivo(List<String> datos, Integer precioFinal, String archivoDestino) {
        try {
            PrintStream info = new PrintStream(archivoDestino);
            info.write("Ticket de compra: \r\n".getBytes());
            info.write(datos.toString().getBytes());
            info.write("\r\nPrecio final: \r\n".getBytes());
            info.write(String.valueOf(precioFinal).getBytes());

        } catch(FileNotFoundException e) {
            System.out.println("El archivo destino no existe " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static HashMap<String, Integer> rellenarMapa(String contenido) {
        String contenidoArray[] = contenido.split("\r\n");

        HashMap<String, Integer> listaObjetos = new HashMap<>();
        for(String linea : contenidoArray){
            String objeto[] = linea.split(" ");
            listaObjetos.put(objeto[0].toLowerCase(), Integer.valueOf(objeto[1]));
        }
        return listaObjetos;
    }

    private static List<String> rellenarCarrito(HashMap<String, Integer> objetos) {
        List<String> carrito = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Escribe el nombre de lo que quieres comprar:");
        do{
            input = scanner.nextLine().toLowerCase();
            if(objetos.containsKey(input.toLowerCase())){
                carrito.add(input);
                System.out.println("Quieres seguir comprando? Si no quieres, pulsa n");
            }else{
                System.out.println("Ese objeto no existe, vuelve a intentarlo.");
            }

        } while (!input.equalsIgnoreCase("n"));
        return carrito;
    }
}
