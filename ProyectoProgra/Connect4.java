import java.util.Scanner;
import java.util.Random;

public class Connect4{
    private char [][] tablero;
    private char jugadorActual;
    
    public Connect4(){
        iniciarJuego();
        seleccionarInicial();
    }
    
    public void iniciarJuego(){
        tablero = new char [6][7];
        for(int i = 0; i< this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length;j++){
                tablero[i][j] = '-';
            }
        }
    }
    
    public void imprimirEstado(){
        System.out.println("Estado actual de la partida: ");
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[i].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void seleccionarInicial(){
        Random random = new Random();
        int jugadorInicial = random.nextInt(2);
        if(jugadorInicial == 0){
            jugadorActual = '◌';
        }else{
            jugadorActual = '●';
        }
    }
    
    public void cambiarJugador(){
        jugadorActual = (jugadorActual == '◌') ? '●' : '◌';
    }
    
    public void hacerMovimiento(){
        Scanner scanner = new Scanner(System.in);
        do{
            int columna;
            do{
                System.out.println("Realice el movimiento que desea realizar (columna)");
                System.out.println("Es el turno de: "+ jugadorActual);
                columna = scanner.nextInt();
            } while(columna < 0 || columna > 7 );
            caidaFicha(columna);
            imprimirEstado();
            cambiarJugador();
        }while(!revisarFilas());
    }
    
    public void caidaFicha(int columna){
        for(int i = this.tablero.length -1; i >= 0; i--){
            if(tablero[i][columna] == '-'){
                tablero[i][columna] = jugadorActual;
                break;
            }else{
                tablero[i-1][columna] = jugadorActual;
                break;
            }
        }
    }
    
    public boolean revisarFilas(){
        boolean ganador = false;
        int contadorConsecutivos = 1;
        for(int i = 1; i < this.tablero.length;i++){
            if(tablero[i] == tablero[i-1] && tablero[i] != '-'){
                contadorConsecutivos++;
                if(contadorConsecutivos == 4){
                    ganador = true;
                    break;
                }
            }
        }
        return ganador;
    }
    
    public static void main(String [] args){
        Connect4 juego = new Connect4();
        juego.imprimirEstado();
        juego.hacerMovimiento();
    }
}
