import java.util.Random;
import java.util.Scanner;
public class JuegoBatalla{
    //Atributos
    private static Robot [] robots;//Array de objetos `Robot` que contendrá a los robots participantes
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    //Metodos
    public static void inicializarRobots(){
        int cantidadRobots;
        do{
            System.out.println("¿Cuántos robots desea crear? (Debe ser entre 2 y 10)");
            cantidadRobots = scanner.nextInt();
             if (cantidadRobots < 2 || cantidadRobots > 10) {
                 System.out.println("El número de robots debe ser entre 2 y 10. Intente de nuevo.");
            }
        } while(cantidadRobots < 2 || cantidadRobots > 10);
        robots = new Robot[cantidadRobots];
        System.out.println("Brinde los datos para la creacion de los robots");
        for(int i = 0; i < robots.length; i++){
            System.out.println("Digite el nombre del robot: "+ (i + 1));
            int puntosVida;
            int ataque;
            String nombre = scanner.next();
            do{
                System.out.println("Digite los puntos de vida del robot: "+ (i + 1));
                System.out.println("(Debe ser entre 50 y 100)");
                puntosVida = scanner.nextInt();
                if(puntosVida <50 || puntosVida > 100){
                    System.out.println("Los puntos de vida del robot deben ser entre 50 y 100. Intente de nuevo.");
                }
            }while(puntosVida <50 || puntosVida > 100);
            do{
                System.out.println("Digite la cantidad de daño que hara el robot: "+ (i + 1));
                System.out.println("(Debe ser entre 10 y 20)");
                ataque = scanner.nextInt();
                if(ataque < 10 || ataque > 20){
                    System.out.println("La cantidad de daño que hara el robot debe ser un valor entre 10 y 20. Intente de nuevo.");
                }
            }while(ataque < 10 || ataque > 20);
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
                int receptor;
                do {
                receptor = random.nextInt(robots.length);
                } while(receptor == i);  // Evita que un robot ataque a sí mismo
                Robot receptorR = robots[receptor];
                atacante.atacar(receptorR);
            }
        }
    }

    public static String mostrarGanador(Robot[] robots) {
        // Verificar si hay solo un robot vivo
        if (cantidadRobotsVivos(robots) == 1) {
            for (int i = 0; i < robots.length; i++) {
                if (robots[i].getPuntosVida() > 0) {
                    return "El ganador es: " + robots[i].getNombre();  // Retorna el nombre del ganador directamente
                }
            }
        }
        return "No hay un ganador claro.";  // En caso de que no haya un ganador (por ejemplo, si la batalla aún continúa)
    }
    
    public static void mostarEstadoRobots(Robot[] robots){
        for(int i = 0; i < robots.length; i++){
            System.out.println("Los puntos de vida del robot " + robots[i].getNombre() + " es: " + robots[i].getPuntosVida());
        }
    }
    
    public static void main(String[] args) {
        inicializarRobots();
        iniciarBatalla();
        System.out.println(mostrarGanador(robots));
        mostarEstadoRobots(robots);
    }
}
