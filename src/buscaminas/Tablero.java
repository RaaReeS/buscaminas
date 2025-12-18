package buscaminas;

import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private int numMinas;
    private int numFilas;
    private int numColumnas;
    private Random random = new Random();

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.numFilas = numFilas;
        this.tablero = new Casilla[numFilas][numColumnas];

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    public void inicializarTablero() {
        while (numMinas != 0) {
            int random1 = random.nextInt(numFilas);
            int random2 = random.nextInt(numColumnas);
            if (tablero[random1][random2].isMina() == false)
                tablero[random1][random2].setMina(true);
        }

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

    public String toString() {
        String resultado = "";
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                resultado += tablero[i][j].toString();
            }
        }
        return resultado;
    }
}
