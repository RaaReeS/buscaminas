package buscaminas;

public class Buscaminas {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(6, 6, 3);
        tablero.inicializarTablero();
        System.out.println(tablero);
    }
}
