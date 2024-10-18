/**
 * @file TicTacToe.java
 * @brief Implementación del juego TicTacToe.
 */
import java.util.Random;
import java.util.Scanner;

/**
 * @brief Clase TicTacToe que representa el juego del gato (tres en raya).
 */
public class TicTacToe {

    /**
     * @brief Matriz que representa el tablero de juego.
     */
    private char [][] tablero;

    /**
     * @brief Variable que representa el jugador actual ('X' o 'O').
     */
    private char jugadorActual;

    /**
     * @brief Almacena el último movimiento realizado.
     */
    private char ultimoMovimiento;

    /**
     * @brief Constructor que inicializa el tablero y selecciona al primer jugador.
     */
    public TicTacToe(){
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
     * @return Caracter que representa al jugador actual ('X' o 'O').
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
     * @return Caracter que representa el último movimiento ('X' o 'O').
     */
    public char getUltimoMovimiento(){
        return this.ultimoMovimiento;
    }
    
    /**
     * @brief Inicializa el tablero con espacios vacíos ('-').
     */
    public void iniciarJuego(){
        tablero = new char [3][3];
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                tablero [i][j] = '-'; // Inicializa el tablero con "-"
            }
        }
    }
    
    /**
     * @brief Imprime el estado actual del tablero.
     */
    public void estadoActual(){
        System.out.println("Estado actual de la partida: ");
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * @brief Selecciona aleatoriamente al jugador inicial ('X' o 'O').
     */
    public void seleccionarInicial(){
        Random random = new Random();
        int jugadorInicial = random.nextInt(2);
        if(jugadorInicial == 0){
            jugadorActual = 'O';
        }else{
            jugadorActual = 'X';
        }
    }
    
    /**
     * @brief Permite a los jugadores realizar movimientos.
     * 
     * Realiza los movimientos, alterna entre los jugadores y verifica si el juego ha terminado.
     */
    public void hacerMovimiento(){
        Scanner scanner = new Scanner(System.in);
        estadoActual();
        do{
            int fila;
            int columna;
            do{
                System.out.println("Realice el movimiento que desea realizar (fila)(columna)");
                System.out.println("Es el turno de: "+ jugadorActual);
                fila = scanner.nextInt();
                columna = scanner.nextInt();
            } while(fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != '-');
            tablero[fila][columna] = jugadorActual;
            estadoActual();
            if(esEmpate()){
               break; 
            }
            cambiarJugador();
        }while(!juegoTerminado());
        System.out.println("El ganador es: "+ ultimoMovimiento);
        scanner.close();
    }
    
    /**
     * @brief Cambia al jugador actual.
     */
    private void cambiarJugador(){
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    
    /**
     * @brief Verifica si hay un ganador.
     * @return true si hay un ganador, false en caso contrario.
     */
    public boolean ganadorJuego(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            if(revisarFilas() == true || revisarColumnas() == true || revisarDiagonales() == true){
                hayGanador = true;
                ganador = ultimoMovimiento;
            }
        }
        return hayGanador;
    }
    
    /**
     * @brief Verifica si hay un ganador en las filas.
     * @return true si hay un ganador en alguna fila, false en caso contrario.
     */
    public boolean revisarFilas(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            if(tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != '-'){
                ultimoMovimiento = tablero[i][0];
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }
    
    /**
     * @brief Verifica si hay un ganador en las columnas.
     * @return true si hay un ganador en alguna columna, false en caso contrario.
     */
    public boolean revisarColumnas(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            if(tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != '-'){
                ultimoMovimiento = tablero[0][i];
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }
    
    /**
     * @brief Verifica si hay un ganador en las diagonales.
     * @return true si hay un ganador en alguna diagonal, false en caso contrario.
     */
    public boolean revisarDiagonales(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            if(tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != '-'){
                ultimoMovimiento = tablero[0][0];
                hayGanador = true;
                break;
            }else if(tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != '-'){
                ultimoMovimiento = tablero[0][2];
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }
    
    /**
     * @brief Verifica si el juego ha terminado en empate.
     * @return true si es empate, false en caso contrario.
     */
    public boolean esEmpate(){
        boolean empate = false;
        if(!ganadorJuego() && tableroLleno()){
            System.out.println("No hay un ganador claro...");
            empate = true;
        }
        return empate;
    }
    
    /**
     * @brief Verifica si el tablero está lleno.
     * @return true si el tablero está lleno, false si aún hay espacios vacíos.
     */
    public boolean tableroLleno(){
        boolean tableroLLeno = false;
        for(int i = 0; i < this.tablero.length; i++ ){
            for(int j = 0; j < this.tablero.length; j++){
                if(tablero[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * @brief Verifica si el juego ha terminado.
     * @return true si el juego ha terminado, false en caso contrario.
     */
    public boolean juegoTerminado(){
        boolean termino = false;
        if(ganadorJuego() || esEmpate()){
            termino = true;
        }
        return termino;
    }
    
    /**
     * @brief Reinicia el juego de TicTacToe.
     * 
     * Este método restablece el tablero a su estado inicial, 
     * selecciona de nuevo al jugador inicial y muestra un 
     * mensaje indicando que el juego ha sido reiniciado.
     */
    public void reiniciarJuego() {
        tablero = new char[3][3]; // Reinicia el tablero
        iniciarJuego();
        seleccionarInicial(); // Restablece el jugador actual al inicio
        System.out.println("El juego de TicTacToe ha sido reiniciado.");
    }
}