import java.util.Random;
public class Robot{
   private String nombre;
   private int puntosVida;
   private int ataque;
   private int defensa;
   private Random random;
   
   public Robot(String nombre, int puntosVida, int ataque){
       this.nombre = nombre;
       this.random = new Random();
       this.puntosVida = puntosVida; // Vida entre 50 y 100
       this.ataque = ataque; // Ataque entre 10 y 20
   }

   public String getNombre(){
       return nombre;
   }
   
   public int getPuntosVida(){
       return puntosVida;
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
        otroRobot.puntosVida -= this.ataque;
        if(otroRobot.puntosVida < 0)otroRobot.puntosVida = 0;
               }
   
   public boolean  estaVivo(){
        return this.puntosVida > 0;
   }
}