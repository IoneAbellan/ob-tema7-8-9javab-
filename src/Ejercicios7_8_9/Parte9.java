package Ejercicios7_8_9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Parte9 {

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
        //creo un array con los elementos del archivo separados por enters.
        String contenidoArray[] = contenido.split("\r\n");

        //creo un mapa y lo relleno con los elementos del array anterior los cuales separo el contenido por espacios, lo que hay antes del espacio será la clave y lo de después del espacio el valor.
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

        //Añado a una nueva lista todos los elementos que quiero comprar.
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

    private static Integer calcularPrecio(HashMap<String, Integer> objetos, List<String> carrito){
        Integer precioTotal = 0;

        //Compruebo los elementos que he añadido al carrito con los elementos del mapa original para conseguir el precio de cada elemento y sumarlos.
        for(String elemento : carrito){
            if(objetos.containsKey(elemento)){
                precioTotal += objetos.get(elemento);
            }
        }
        System.out.println("Este es el precio final: " + precioTotal);
        System.out.println(("Comprueba tu ticket de compra en tus archivos"));

        return precioTotal;
    }

    /* Este es el contenido del archivo inicial:
        Espada 20
        Escudo 12
        Bomba 6
        Arco 18
        Flecha 3
    */
}
