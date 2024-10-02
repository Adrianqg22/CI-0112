import java.util.Random;
import java.util.Scanner;
public class TicTacToe{
    //Atributos de la clase
    char [][] tablero;
    char jugadorActual;
    
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
            } while(fila < 0 || fila > 3 || columna < 0 || columna > 3);
            tablero[fila][columna] = jugadorActual;
            estadoActual();
            cambiarJugador();
        }while(!revisarColumnas());
    }
    
    /**
     * Cambia al jugador actual por el siguiente.
     */
    private void cambiarJugador(){
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    
    public boolean ganadorJuego(){
        char ganador = 'a';
        boolean hayGanador = false;
        //Comprueba si hay ganador en las filas
        for(int i = 0; i < this.tablero.length; i++){
            if(tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]){
                ganador = tablero[i][0];
                hayGanador = true;
                System.out.println("El ganador es: "+ ganador);
            }
                //Comprueba ganador columnas
            if(tablero[0][i] == tablero[0][i] && tablero[0][i] == tablero[0][i]){
                ganador = tablero[0][i];
                hayGanador = true;
                System.out.println("El ganador es: "+ ganador);
            }
                //comprueba ganador diagonal
            if(tablero[i][i] == tablero[i][i] && tablero[i][i] == tablero[i][i]){
                ganador = tablero[i][i];
                hayGanador = true;
                System.out.println("El ganador es: "+ ganador);
            }
                //Comprueba la otra diagonal
            if(tablero[i][i] == tablero[i][i] && tablero[i][i] == tablero[i][i]){
                ganador = tablero[i][0];
                hayGanador = true;
                System.out.println("El ganador es: "+ ganador);
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
                ganador = tablero[i][0];
                hayGanador = true;
                i = this.tablero.length;
            }
        }
        if(hayGanador){
            System.out.println("El ganador es: "+ ganador);
        }
        return hayGanador;
    }
    
    public boolean revisarColumnas(){
        char ganador = ' ';
        boolean hayGanador = false;
        for(int i = 0; i < this.tablero.length; i++){
            //Comprueba si hay ganador columnas
            if(tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != '-'){
                ganador = tablero[0][i];
                hayGanador = true;
                i = this.tablero.length;
            }
        }
        if(hayGanador){
            System.out.println("El ganador es: "+ ganador);
        }
        return hayGanador;
    }
    
    public static void main(String [] args){
        TicTacToe juego = new TicTacToe();
        juego.iniciarJuego();
        juego.hacerMovimiento();
    }
}