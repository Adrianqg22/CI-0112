import java.util.Random;
import java.util.Scanner;
public class JuegoBatalla{
    //Atributos
    private static Robot [] robots;//Array de objetos `Robot` que contendrá a los robots participantes
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean estadoSimulacion;
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
            int defensa;
            int ataque;
            String nombre = scanner.next();
            do{
                System.out.println("Digite los puntos de vida del robot: "+ (i + 1));
                System.out.println("(Debe ser entre 50 y 100)");
                while(!scanner.hasNextInt()){
                    System.out.println("Eso no es un número entero. Intente de nuevo: ");
                    scanner.next();
                }
                puntosVida = scanner.nextInt();
                if(puntosVida <50 || puntosVida > 100){
                    System.out.println("Los puntos de vida del robot deben ser entre 50 y 100. Intente de nuevo.");
                }
            }while(puntosVida <50 || puntosVida > 100);
            
            do{
                System.out.println("Digite los puntos de defensa del robot: "+ (i + 1));
                System.out.println("(Debe ser entre 0 y 10)");
                while(!scanner.hasNextInt()){
                    System.out.println("Eso no es un número entero. Intente de nuevo: ");
                    scanner.next();
                }
                defensa = scanner.nextInt();
                if(defensa < 0 || defensa > 10){
                    System.out.println("Los puntos de defensa del robot deben ser entre 0 y 10. Intente de nuevo.");
                }
            }while(defensa <0 || defensa > 10);
            
            do{
                System.out.println("Digite la cantidad de daño que hara el robot: "+ (i + 1));
                System.out.println("(Debe ser entre 10 y 20)");
                while(!scanner.hasNextInt()){
                    System.out.println("Eso no es un número entero. Intente de nuevo: ");
                    scanner.next();
                }
                ataque = scanner.nextInt();
                if(ataque < 10 || ataque > 20){
                        System.out.println("La cantidad de daño que hara el robot debe ser un valor entre 10 y 20. Intente de nuevo.");
                    }
            }while(ataque < 10 || ataque > 20);
            robots[i] = new Robot(nombre, puntosVida, ataque, defensa);
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
    
    public static void opcionesSimulacion(){
        int opcion;
        do{
            System.out.println("\n----- ¡Bienvenido al simulador de batalla de robots! -----");
            System.out.println("Indique que accion desea realizar");
            System.out.println("1. Inicar/Reanudar simulación");
            System.out.println("2. Verificar estado de los robots");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
                
            switch(opcion){
                case 1:
                    iniciarBatalla();
                    break;
                case 2:
                    mostarEstadoRobots(robots);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }while(opcion != 3);
        
        System.out.println(mostrarGanador(robots));
    }
    
    public static void iniciarBatalla() {
        while (cantidadRobotsVivos(robots) > 1) {
            for (int i = 0; i < robots.length; i++) {
                Robot atacante = robots[i];
                
                if (!atacante.estaVivo()) {
                    continue; 
                }
                
                int indiceReceptor;
                do {
                    indiceReceptor = random.nextInt(robots.length);
                } while (indiceReceptor == i || !robots[indiceReceptor].estaVivo());
                
                Robot receptor = robots[indiceReceptor];
                atacante.atacar(receptor);
                controlSimulacion();
                
                if (!estadoSimulacion) {
                    return;
                }
            }
        }
        System.out.println(mostrarGanador(robots));
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
            System.out.println("Los puntos de defensa del robot " + robots[i].getNombre() + " es: " + robots[i].getPuntosDefensa());
        }
    }
    
    public static void controlSimulacion() {
        estadoSimulacion = false;
        System.out.println("¿Qué desea hacer ahora?");
        System.out.println("1. Continuar simulación");
        System.out.println("2. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Capturar el salto de línea pendiente
        if(opcion == 1){
            System.out.println("Continuando con la simulación");
            estadoSimulacion = true;
        } else if(opcion == 2){
            System.out.println("Regresando al menú...");
        }
    }
    
    public static void main(String[] args) {
        inicializarRobots();
        opcionesSimulacion();
    }
}
