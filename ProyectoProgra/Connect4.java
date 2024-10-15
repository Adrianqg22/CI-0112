import java.util.Scanner;
import java.util.Random;

public class Connect4{
    private char [][] tablero;
    private char jugadorActual;
    private char ultimoMovimiento;
    public Connect4(){
        iniciarJuego();
        seleccionarInicial();
    }
    
    public void setTablero(){
        this.tablero = tablero;
    }
    
    public char[][] getTablero(){
        return this.tablero;
    }
    
    public void setJugadorActual(){
        this.jugadorActual = jugadorActual;
    }
    
    public char getJugadorActual(){
        return this.jugadorActual;
    }
    
    public void ultimoMovimiento(){
        this.ultimoMovimiento = ultimoMovimiento;
    }
    
    public char getUltimoMovimiento(){
        return this.ultimoMovimiento;
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
        }while(!ganadorJuego());
        System.out.println("El ganador es: "+ ultimoMovimiento);
    }
    
    public void caidaFicha(int columna){
        for(int i = this.tablero.length -1; i >= 0; i--){
            if(tablero[i][columna] == '-'){
                tablero[i][columna] = jugadorActual;
                break;
            }
        }
    }
    
    public boolean revisarFilas(){
        boolean ganador = false;
        char nombreGanador = ' ';
        for(int i = 1; i < this.tablero.length;i++){
            int contadorConsecutivos = 1;
            for(int j = 1; j < this.tablero.length;j++){
                if(tablero[i][j] == tablero[i][j-1] && tablero[i][j]!= '-'){
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
    
    public boolean revisarColumnas(){
        boolean ganador = false;
        char nombreGanador = ' ';
        for(int j = 0; j < this.tablero[0].length;j++){
            int contadorConsecutivos = 1;
            for(int i = 1; i < this.tablero.length;i++){
                if(tablero[i][j] == tablero[i-1][j] && tablero[i][j]!= '-'){
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
    
    public boolean revisarDiagonalIzquierda() {
        boolean ganador = false;
        char nombreGanador = ' ';
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
    
    public boolean ganadorJuego(){
        boolean ganador = false;
        char ganadorChar = ' ';
        for(int i = 0; i < this.tablero.length; i++){
            if(revisarFilas() == true || revisarDiagonalDerecha() == true || revisarDiagonalIzquierda() == true || revisarColumnas() == true || revisarFilas() == true){
                ganador = true;
                ganadorChar = ultimoMovimiento;
            }
        }
        return ganador;
    }
}