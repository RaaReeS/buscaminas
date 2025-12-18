package buscaminas;

import entrada.Teclado;

/**
 *
 * @author Alumno
 */

public class Principal {

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println(" Eliga el tipo de operacion");
            System.out.println("1-> Descubrir");
            System.out.println("2-> Poner Bandera");
            System.out.println("3-> Quitar Bandera");
            System.out.print("Elige una opcion: ");
            opcion = Teclado.leerEntero("");

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la fila");
                    int fila = Teclado.leerEntero("");

                    System.out.println("Introduce la columna");
                    int columna = Teclado.leerEntero("");
                    break;

                case 2:
                    System.out.println("Introduce la fila");
                    fila = Teclado.leerEntero("");

                    System.out.println("Introduce la columna");
                    columna = Teclado.leerEntero("");
                    break;

                case 3:
                    System.out.println("Introduce la fila");
                    fila = Teclado.leerEntero("");

                    System.out.println("Introduce la columna");
                    columna = Teclado.leerEntero("");
                    break;
            }
        } while (opcion == 1 || opcion == 2 || opcion == 3);
    }
}
