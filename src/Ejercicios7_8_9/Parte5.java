package Ejercicios7_8_9;

import java.util.ArrayList;
import java.util.LinkedList;

public class Parte5 {

    public static void main(String[] args) {
        ArrayList<String> listaCompra = new ArrayList<>();

        listaCompra.add("macarrones");
        listaCompra.add("cereales");
        listaCompra.add("leche");
        listaCompra.add("manzanas");
        for(String elemento : listaCompra) {
            System.out.println("En la lista hay: " + elemento);
        }

        LinkedList<String> listaCompraNueva = new LinkedList<String>(listaCompra);
        for(String elemento : listaCompraNueva) {
            System.out.println("En la lista nueva hay: " + elemento);
        }
    }
}
// Ione Abellan Robledo
