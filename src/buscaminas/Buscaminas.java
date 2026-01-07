package buscaminas;

import entrada.Teclado;

public class Buscaminas {

    public static void main(String[] args) {

        int filas = Teclado.leerEntero("Filas: ");
        int columnas = Teclado.leerEntero("Columnas: ");
        int minas = Teclado.leerEntero("Minas: ");

        Juego juego = new Juego(filas, columnas, minas);

        while (!juego.isFinJuego()) {

            imprimirTablero(juego);

            System.out.println("1. Descubrir");
            System.out.println("2. Poner bandera");
            System.out.println("3. Quitar bandera");
            int opcion = Teclado.leerEntero("Opcion: ");

            int f = Teclado.leerEntero("Fila: ") - 1;    
            int c = Teclado.leerEntero("Columna: ") - 1;    

            // ver si esta en rango
            if (f < 0 || f >= juego.getTablero().getNumFilas() ||
                c < 0 || c >= juego.getTablero().getNumColumnas()) {
                System.out.println("Fila o columna fuera de rango. Intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    juego.descubrirCasilla(f, c);
                    break;
                case 2:
                    juego.ponerBandera(f, c);
                    break;
                case 3:
                    juego.quitarBandera(f, c);
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }

        imprimirTablero(juego);
    }

    // enseñar tablero 
    public static void imprimirTablero(Juego juego) {
        Tablero tablero = juego.getTablero();

        for (int i = 0; i < tablero.getNumFilas(); i++) {
            for (int j = 0; j < tablero.getNumColumnas(); j++) {
                Casilla c = tablero.getCasilla(i, j);
                System.out.printf("%-2s", c.toString());
            }
            System.out.println();
        }
    }
}
