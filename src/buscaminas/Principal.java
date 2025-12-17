package buscaminas;

import java.util.Scanner;


/**
 *
 * @author Alumno
 */


public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int opcion;

        do {
            System.out.println(" Eliga el tipo de operacion");
            System.out.println("1-> Descubrir");
            System.out.println("2-> Poner Bandera");
            System.out.println("3-> Quitar Bandera");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la fila");
                    int fila = teclado.nextLine();

                    System.out.println("Introduce la columna");
                    int columna = teclado.nextLine();
                    

                case 2:
                    System.out.println("Introduce la fila");
                    int fila = teclado.nextLine();

                    System.out.println("Introduce la columna");
                    int columna = teclado.nextLine();

                case 3:
                    System.out.println("Introduce la fila");
                    int fila = teclado.nextLine();

                    System.out.println("Introduce la columna");
                    int columna = teclado.nextLine();
            }
        }
    }
}

