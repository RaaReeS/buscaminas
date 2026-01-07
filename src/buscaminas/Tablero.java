package buscaminas;

import java.util.Random;

public class Tablero {

    private Casilla[][] tablero;
    private int numMinas;
    private int numFilas;
    private int numColumnas;
    private Random random = new Random();

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;

        tablero = new Casilla[numFilas][numColumnas];

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    public void inicializarTablero() {
        int minasColocadas = 0;

        // Colocar minas
        while (minasColocadas < numMinas) {
            int f = random.nextInt(numFilas);
            int c = random.nextInt(numColumnas);

            if (!tablero[f][c].isMina()) {
                tablero[f][c].setMina(true);
                minasColocadas++;
            }
        }

        // Calcular numeros
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {

                if (!tablero[i][j].isMina()) {
                    int contador = 0;

                    for (int f = i - 1; f <= i + 1; f++) {
                        for (int c = j - 1; c <= j + 1; c++) {
                            if (f >= 0 && f < numFilas && c >= 0 && c < numColumnas) {
                                if (tablero[f][c].isMina()) {
                                    contador++;
                                }
                            }
                        }
                    }

                    tablero[i][j].setNumero(contador);

                    if (contador == 0) {
                        tablero[i][j].setBlanco(true);
                    }
                }
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                sb.append(tablero[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

