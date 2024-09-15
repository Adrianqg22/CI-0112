import java.util.Random;
public class Robot{
   private String nombre;
   private int puntosVida;
   private int ataque;
   private int defensa;
   private Random random;
   
   public Robot(String nombre, int puntosVida, int ataque, int defensa){
       this.nombre = nombre;
       this.random = new Random();
       this.puntosVida = puntosVida; // Vida entre 50 y 100
       this.defensa = defensa; // Defensa entre 0 y 10
       this.ataque = ataque; // Ataque entre 10 y 20
   }

   public String getNombre(){
       return nombre;
   }
   
   public int getPuntosVida(){
       return puntosVida;
   }
   
   public int getPuntosDefensa(){
       return defensa;
   }
   
   public void setPuntosVida(int puntosVida){
       if(puntosVida >= 50 && puntosVida <= 100){
           this.puntosVida = puntosVida;
       } else{
           System.out.println("Valor fuera del rango permitido (50 a 100).");
       }
   }
   
   public int getAtaque(){
       return ataque;
   }
   
   public void setAtaque(int ataque){
       if(ataque >= 10 && ataque <= 20){
           this.ataque = ataque;
       } else{
           System.out.println("Valor fuera del rango permitido (10 a 20).");
       }
   }
   
   public void atacar(Robot otroRobot){
        System.out.println(this.nombre + " ataca a " + otroRobot.getNombre());
        
        //Calcular el daño tomando en cuenta la defensa
        int dañoBloqueado = Math.min(otroRobot.defensa, this.ataque);
        int dañoReal = this.ataque - dañoBloqueado;
        
        //Restar el valor de ataque de la defensa
        otroRobot.defensa -= dañoBloqueado;
        if(otroRobot.defensa < 0){
            otroRobot.defensa = 0;
        }
        
        //Mostrar la cantidad de puntos de defensa bloqueados 
        if(dañoBloqueado > 0){
            System.out.println(otroRobot.getNombre() + " ha bloqueado " + dañoBloqueado + " puntos de ataque. Le quedan " + otroRobot.defensa + " puntos de defensa.");
        }
        
        otroRobot.puntosVida -= dañoReal;
        if(otroRobot.puntosVida < 0){
            otroRobot.puntosVida = 0;
        }
        
        // Actualización de los puntos de vida del robot
        System.out.println(otroRobot.getNombre() + " ahora tiene " + otroRobot.puntosVida + " puntos de vida.");
        
        // Verificar si el robot fue destruido
        if (otroRobot.puntosVida == 0) {
        System.out.println(otroRobot.getNombre() + " ha sido destruido.");
        }
   }
   
   public boolean  estaVivo(){
        return this.puntosVida > 0;
   }
}