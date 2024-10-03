import java.util.Random;
import java.util.Scanner;
public class TicTacToe{
    //Atributos de la clase
    char [][] tablero;
    char jugadorActual;
    char ultimoMovimiento;
    /**
     * Constructor que inicializa el tablero y selecciona al primer jugador
     */
    public TicTacToe(){
        iniciarJuego();
        seleccionarInicial();
    }
    
    /**
     * Inicializa el tablero con linea vacias
     */
    public void iniciarJuego(){
        tablero = new char [3][3];
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                tablero [i][j] = '-';//inicializa el tablero con "-"
            }
        }
    }
    
    /**
     * Imprime el estado actual del tablero
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
     * Selecciona al jugador inicial aleatoriamente
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
     * Permite al usuario realizar movimientos.
     */
    public void hacerMovimiento(){
        Scanner scanner = new Scanner(System.in);
        do{
            int fila;
            int columna;
            do{
                System.out.println("Realice el movimiento que desea realizar (fila)(columna)");
                System.out.println("Es el turno de: "+ jugadorActual);
                fila = scanner.nextInt();
                columna = scanner.nextInt();
            } while(fila < 0 || fila > 3 || columna < 0 || columna > 3 || tablero[fila][columna] != '-');
            tablero[fila][columna] = jugadorActual;
            estadoActual();
            if(esEmpate()){
               break; 
            }
            cambiarJugador();
        }while(!ganadorJuego());
        System.out.println("El ganador es: "+ ultimoMovimiento);
    }
    
    /**
     * Cambia al jugador actual por el siguiente.
     */
    private void cambiarJugador(){
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    
    public boolean ganadorJuego(){
        char ganador = ' ';
        boolean hayGanador = false;
        //Comprueba si hay ganador en las filas
        for(int i = 0; i < this.tablero.length; i++){
            if(revisarFilas() == true || revisarColumnas() == true || revisarDiagonales() == true){
                hayGanador = true;
                ganador = ultimoMovimiento;
            }
        }
        return hayGanador;
    }
    
    public boolean revisarFilas(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            // Comprueba ganador filas
            if(tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != '-'){
                ultimoMovimiento = tablero[i][0];
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }
    
    public boolean revisarColumnas(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            //Comprueba si hay ganador columnas
            if(tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != '-'){
                ultimoMovimiento = tablero[0][i];
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }
    
    public boolean revisarDiagonales(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            //Comprueba si hay ganador en las diagonales
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
    
    public boolean esEmpate(){
        boolean empate = false;
        if(!ganadorJuego() && tableroLleno()){
            System.out.println("No hay un ganador claro...");
            empate = true;
        }
        return empate;
    }
    
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
    
    public static void main(String [] args){
        TicTacToe juego = new TicTacToe();
        juego.iniciarJuego();
        juego.hacerMovimiento();
    }
}