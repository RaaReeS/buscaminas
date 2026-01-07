package buscaminas;

public class Juego {

    private Tablero tablero;
    private boolean finJuego;

    public Juego(int filas, int columnas, int minas) {
        tablero = new Tablero(filas, columnas, minas);
        tablero.inicializarTablero();
        finJuego = false;
    }

    public boolean descubrirCasilla(int fila, int columna) {

        Casilla c = tablero.getCasilla(fila, columna);

        if (c.isVisible() || c.isBandera()) return false;

        c.setVisible(true);

        if (c.isMina()) {
            mostrarMinas();
            finJuego = true;
            System.out.println("Has perdido");
            return true;
        }

        if (c.isBlanco()) {
            descubrirBlancas(fila, columna);
        }

        return false;
    }

    private void descubrirBlancas(int fila, int columna) {

        for (int f = fila - 1; f <= fila + 1; f++) {
            for (int c = columna - 1; c <= columna + 1; c++) {

                if (f >= 0 && f < tablero.getNumFilas()
                        && c >= 0 && c < tablero.getNumColumnas()) {

                    Casilla cas = tablero.getCasilla(f, c);

                    if (!cas.isVisible() && !cas.isMina() && !cas.isBandera()) {
                        cas.setVisible(true);
                        if (cas.isBlanco()) {
                            descubrirBlancas(f, c);
                        }
                    }
                }
            }
        }
    }

    public void ponerBandera(int fila, int columna) {
        Casilla c = tablero.getCasilla(fila, columna);
        if (!c.isVisible()) c.setBandera(true);
    }

    public void quitarBandera(int fila, int columna) {
        tablero.getCasilla(fila, columna).setBandera(false);
    }

    private void mostrarMinas() {
        for (int i = 0; i < tablero.getNumFilas(); i++) {
            for (int j = 0; j < tablero.getNumColumnas(); j++) {
                Casilla c = tablero.getCasilla(i, j);
                if (c.isMina()) c.setVisible(true);
            }
        }
    }

    public boolean isFinJuego() {
        return finJuego;
    }

    public Tablero getTablero() {
        return tablero;
    }
}

