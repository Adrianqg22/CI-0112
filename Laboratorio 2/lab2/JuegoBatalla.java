import java.util.Random;
import java.util.Scanner;
public class JuegoBatalla{
    //Atributos
    private static Robot [] robots;//Array de objetos `Robot` que contendrá a los robots participantes
    private static Scanner scanner = new Scanner(System.in);
    private static Random random;
    //Metodos
    public static void inicializarRobots(){
        System.out.println("¿Cuantos robots desea crear?");
        int cantidadRobots = scanner.nextInt();
        robots = new Robot[cantidadRobots];
        System.out.println("Brinde los datos para la creacion de los robots");
        for(int i = 0; i < robots.length; i++){
            System.out.println("Digite el nombre del robot: "+ i + 1);
            String nombre = scanner.next();
            System.out.println("Digite los puntos de vida del robot: "+ i + 1);
            int puntosVida = scanner.nextInt();
            System.out.println("Digite la cantidad de daño que hara el robot: "+ i + 1);
            int ataque = scanner.nextInt();
            robots[i] = new Robot(nombre, puntosVida, ataque);
        }
    }
    
    public static int cantidadRobotsVivos(Robot[] robots){
        int contador = 0;
        for(int i = 0; i < robots.length; i++){
            if(robots[i].getPuntosVida()>0){
                contador++;
            }
        }
        return contador;
    }
    
    public static void iniciarBatalla(){
        while(cantidadRobotsVivos(robots) > 1){
            //Seleccion robots
            for(int i = 0; i < robots.length; i++){
                Robot atacante = robots[i];
                int receptor = random.nextInt(0, robots.length);
                Robot receptorR = robots[receptor];
                atacante.atacar(receptorR);
            }
        }
    }

    public void mostrarGanador(){

    }
    public static void main(String[] args) {
        inicializarRobots();
        iniciarBatalla();
    }
}
