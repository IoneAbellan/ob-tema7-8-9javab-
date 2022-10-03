package Ejercicios7_8_9;

import java.util.Vector;

public class Parte3y4 {
    public static void main(String[] args) {
        Vector<String> listaCompra = new Vector(5);
        listaCompra.add("colacao");
        listaCompra.add("leche");
        listaCompra.add("azucar");
        listaCompra.add("pollo");
        listaCompra.add("cereales");

        System.out.println("Lista inicial: " + listaCompra);

        listaCompra.remove(2);
        listaCompra.remove(1);

        System.out.println("ListaCompra");
    }
}
/*
4.Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.

 Un Vector dobla su capacidad una vez se sobrepasa. Cada vez que se produce esto, el vector actual se clona con el doble de cpacidad.
    Esto le requiere un trabajo extra a nuestro ordenador por lo que si debe repetirse muchas veces puede hacer que el programa vaya lento.
    Por lo que es preferible, que si se conoce el numero aproximado de elementos que va a tener, en este caso 1000, se le asigne una
    capacidad inicial personalizada.
*/
// Ione Abellan Robledo