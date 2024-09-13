import java.util.Random;
import java.util.Scanner;
public class JuegoBatalla{
    //Atributos
    private Robot [] robots;//Array de objetos `Robot` que contendrá a los robots participantes
    private Scanner scanner = new Scanner(System.in);
    private Random random;
    //Metodos
    public JuegoBatalla(String[] robotsParticipantes) {
        random = new Random();
        robots = new Robot[robotsParticipantes.length];
        for (int i = 0; i < robotsParticipantes.length; i++) {
            robots[i] = new Robot(robotsParticipantes[i]);
        }
    }
    
    
    public void inicializarRobots(){
        System.out.println("¿Cuantos robots desea crear?");
        int cantidadRobots = scanner.nextInt();
        int[] robotsParticipantes = new int[cantidadRobots];
        System.out.println("Brinde los datos para la creacion de los robots");
        for(int i = 0; i < robotsParticipantes.length; i++){
            System.out.println("Digite el nombre del robot: "+ robotsParticipantes[i]);
            String nombre
        }
    }
    
    public void iniciarBatalla(){
        int robotsVivos = robots.length;
        while(robotsVivos > 1){
            //Seleccion robots
            for(int i = 0; i < robots.length; i++){
                Robot atacante = robots[i];
                
            }
            
        }
    }

    public void mostrarGanador(){

    }
    public static void main(String[] args) {
        
    }
}
