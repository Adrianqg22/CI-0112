/**
 * @file Connect4.java
 * @brief Implementación del juego Conecta 4.
 */

import java.util.Scanner;
import java.util.Random;

/**
 * @brief Clase Connect4 que representa el juego de Conecta 4.
 */
public class Connect4 {

    /**
     * @brief Matriz que representa el tablero del juego.
     */
    private char [][] tablero;

    /**
     * @brief Variable que representa al jugador actual ('◌' o '●').
     */
    private char jugadorActual;

    /**
     * @brief Variable que almacena el último movimiento realizado.
     */
    private char ultimoMovimiento;

    /**
     * @brief Constructor que inicializa el tablero y selecciona al primer jugador.
     */
    public Connect4(){
        iniciarJuego();
        seleccionarInicial();
    }

    /**
     * @brief Establece el tablero de juego.
     */
    public void setTablero(){
        this.tablero = tablero;
    }

    /**
     * @brief Devuelve el tablero actual.
     * @return Una matriz de caracteres que representa el tablero.
     */
    public char[][] getTablero(){
        return this.tablero;
    }

    /**
     * @brief Establece el jugador actual.
     */
    public void setJugadorActual(){
        this.jugadorActual = jugadorActual;
    }

    /**
     * @brief Devuelve el jugador actual.
     * @return Caracter que representa al jugador actual ('◌' o '●').
     */
    public char getJugadorActual(){
        return this.jugadorActual;
    }

    /**
     * @brief Establece el último movimiento realizado.
     */
    public void ultimoMovimiento(){
        this.ultimoMovimiento = ultimoMovimiento;
    }

    /**
     * @brief Devuelve el último movimiento realizado.
     * @return Caracter que representa el último movimiento ('◌' o '●').
     */
    public char getUltimoMovimiento(){
        return this.ultimoMovimiento;
    }

    /**
     * @brief Inicializa el tablero con espacios vacíos ('-').
     */
    public void iniciarJuego(){
        tablero = new char [6][7];
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length; j++){
                tablero[i][j] = '-';
            }
        }
    }

    /**
     * @brief Imprime el estado actual del tablero.
     */
    public void imprimirEstado(){
        System.out.println("Estado actual de la partida: ");
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @brief Selecciona aleatoriamente al jugador inicial ('◌' o '●').
     */
    public void seleccionarInicial(){
        Random random = new Random();
        int jugadorInicial = random.nextInt(2);
        if(jugadorInicial == 0){
            jugadorActual = '◌';
        }else{
            jugadorActual = '●';
        }
    }

    /**
     * @brief Cambia el turno al jugador contrario.
     */
    public void cambiarJugador(){
        jugadorActual = (jugadorActual == '◌') ? '●' : '◌';
    }

    /**
     * @brief Permite a los jugadores realizar movimientos.
     * 
     * Solicita una columna al jugador, coloca la ficha en la primera fila vacía y luego cambia de turno.
     */
    public void hacerMovimiento(){
        Scanner scanner = new Scanner(System.in);
        imprimirEstado();
        do{
            int columna;
            do{
                System.out.println("Realice el movimiento que desea realizar (columna)");
                System.out.println("Es el turno de: " + jugadorActual);
                columna = scanner.nextInt();
            } while(columna < 0 || columna > 7);
            caidaFicha(columna);
            imprimirEstado();
            cambiarJugador();
        }while(!ganadorJuego());
        System.out.println("El ganador es: " + ultimoMovimiento);
        scanner.close();
    }

    /**
     * @brief Coloca la ficha del jugador actual en la primera fila vacía de la columna seleccionada.
     * @param columna Número de la columna donde se quiere hacer el movimiento.
     */
    public void caidaFicha(int columna){
        for(int i = this.tablero.length - 1; i >= 0; i--){
            if(tablero[i][columna] == '-'){
                tablero[i][columna] = jugadorActual;
                break;
            }
        }
    }

    /**
     * @brief Revisa si hay cuatro fichas consecutivas en alguna fila.
     * @return true si hay un ganador en una fila, false en caso contrario.
     */
    public boolean revisarFilas(){
        boolean ganador = false;
        for(int i = 1; i < this.tablero.length; i++){
            int contadorConsecutivos = 1;
            for(int j = 1; j < this.tablero[i].length; j++){
                if(tablero[i][j] == tablero[i][j-1] && tablero[i][j] != '-'){
                    contadorConsecutivos++;
                    if(contadorConsecutivos == 4){
                        ganador = true;
                        ultimoMovimiento = tablero[i][j];
                        break;
                    }
                }
            }
        }
        return ganador;
    }

    /**
     * @brief Revisa si hay cuatro fichas consecutivas en alguna columna.
     * @return true si hay un ganador en una columna, false en caso contrario.
     */
    public boolean revisarColumnas(){
        boolean ganador = false;
        for(int j = 0; j < this.tablero[0].length; j++){
            int contadorConsecutivos = 1;
            for(int i = 1; i < this.tablero.length; i++){
                if(tablero[i][j] == tablero[i-1][j] && tablero[i][j] != '-'){
                    contadorConsecutivos++;
                    if(contadorConsecutivos == 4){
                        ganador = true;
                        ultimoMovimiento = tablero[i][j];
                        break;
                    }
                }
            }
        }
        return ganador;
    }

    /**
     * @brief Revisa si hay cuatro fichas consecutivas en una diagonal de izquierda a derecha.
     * @return true si hay un ganador en esta diagonal, false en caso contrario.
     */
    public boolean revisarDiagonalIzquierda() {
        boolean ganador = false;
        for (int i = 0; i < this.tablero.length - 3; i++) {
            for (int j = 0; j < this.tablero[i].length - 3; j++) {
                if (tablero[i][j] != '-' && tablero[i][j] == tablero[i + 1][j + 1] && tablero[i][j] == tablero[i + 2][j + 2] && tablero[i][j] == tablero[i + 3][j + 3]) {
                    ganador = true;
                    ultimoMovimiento = tablero[i][j];
                    break;
                }
            }
        }
        return ganador;
    }

    /**
     * @brief Revisa si hay cuatro fichas consecutivas en una diagonal de derecha a izquierda.
     * @return true si hay un ganador en esta diagonal, false en caso contrario.
     */
    public boolean revisarDiagonalDerecha() {
        boolean ganador = false;
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 3; j < tablero[i].length; j++) {
                if (tablero[i][j] != '-' && tablero[i][j] == tablero[i + 1][j - 1] && tablero[i][j] == tablero[i + 2][j - 2] && tablero[i][j] == tablero[i + 3][j - 3]) {
                    ganador = true;
                    ultimoMovimiento = tablero[i][j];
                    break;
                }
            }
        }
        return ganador;
    }

    /**
     * @brief Verifica si el juego tiene un ganador.
     * @return true si hay un ganador, false en caso contrario.
     */
    public boolean ganadorJuego(){
        boolean ganador = false;
        for(int i = 0; i < this.tablero.length; i++){
            if(revisarFilas() || revisarColumnas() || revisarDiagonalIzquierda() || revisarDiagonalDerecha()){
                ganador = true;
            }
        }
        return ganador;
    }
}