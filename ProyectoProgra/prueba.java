
public class prueba{
    private char[][] panel;
    private char jugadorAct;
    public prueba(int fila, int col){
        this.panel = new char[fila][col];
        this.jugadorAct = 'x';
    }
    
    public void iniciarJuego(){
        //llena la matriz con guiones para empezar el juego.
        for (int i = 0; i < panel.length; i++) {
                for (int j = 0; j < panel[i].length; j++) {
                    panel[i][j] = '-';
                }
            }
        //empieza el que elige la x
        this.jugadorAct = jugadorAct;
    }
    
    public void imprimir(){
         for (int i = 0; i < panel.length; i++) {
                for (int j = 0; j < panel[i].length; j++) {
                    System.out.println (panel[i][j]);
                }
            }
    }
    
     public void setPanel(char[][] panel ){
        this.panel = panel;
    }   
    
     public prueba(char[][] panel){
        this.panel = panel;
    }  
}