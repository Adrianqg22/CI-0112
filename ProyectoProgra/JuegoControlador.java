/**
 *  @file JuegoControlador.java
 *  @brief Clase que contiene la interacción con el usuario y la selección del juego.
 *  
 *  La clase JuegoControlador permite al usuario seleccionar entre los juegos
 *  TicTacToe o Conecta 4, y luego maneja el flujo del juego seleccionado.
 */
import java.util.Scanner;
/**
 * @class JuegoControlador
 * @brief Controlador para seleccionar y manejar el juego actual.
 * 
 * Esta clase gestiona el menú de selección de juego y el flujo del juego,
 * permitiendo al usuario seleccionar el juego que quiere jugar.
 */
public class JuegoControlador {
    /**
     * @brief Referencia al juego actual que se está jugando.
     * Puede ser un objeto de tipo TicTacToe o Connect4.
     */
    private Object juegoActual;
    
    /**
     * @brief Objeto para leer la entrada del usuario.
     */
    private Scanner scanner;
    
    /**
     * @brief Constructor de la clase JuegoControlador.
     * 
     * Inicializa el controlador del juego sin ningún juego seleccionado.
     */
    public JuegoControlador() {
        this.juegoActual = null;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * @brief Muestra el menú principal para seleccionar el juego.
     * 
     * Imprime un menú con opciones para elegir TicTacToe, Conecta 4 o salir del programa.
     */
    public void mostrarMenu() {
        System.out.println("Selecciona el juego que deseas jugar:");
        System.out.println("1. TicTacToe");
        System.out.println("2. Conecta 4");
        System.out.println("3. Salir");
    }
    
    /**
     * @brief Permite al usuario seleccionar el juego.
     * 
     * Esta función permite al usuario seleccionar entre los juegos disponibles 
     * (TicTacToe o Conecta 4). El juego seleccionado será asignado a `juegoActual`.
     */
    public void seleccionarJuego() {
        boolean juegoSeleccionado = false;

        while (!juegoSeleccionado) {
            mostrarMenu();
            int seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    juegoActual = new TicTacToe();  // Selecciona TicTacToe
                    System.out.println("Has seleccionado TicTacToe.");
                    juegoSeleccionado = true;
                    break;
                case 2:
                    juegoActual = new Connect4();  // Selecciona Conecta 4
                    System.out.println("Has seleccionado Conecta 4.");
                    juegoSeleccionado = true;
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Selecciona de nuevo.");
                    break;
            }
        }
    }
    
    /**
     * @brief Maneja el flujo del juego actual.
     * 
     * Dependiendo del juego seleccionado, llama al método hacerMovimiento()
     * para manejar las jugadas del usuario.
     */
    public void jugar() {
        if (juegoActual == null) {
            System.out.println("Debes seleccionar un juego primero.");
            seleccionarJuego();
        }

        if (juegoActual instanceof TicTacToe) {
            ((TicTacToe) juegoActual).hacerMovimiento();
        } else if (juegoActual instanceof Connect4) {
            ((Connect4) juegoActual).hacerMovimiento();
        }
    }
    
    /**
     * @brief Procesa la entrada del usuario y ejecuta el juego seleccionado.
     * 
     * Si no hay ningún juego seleccionado, solicita al usuario que seleccione uno.
     * Luego, inicia el flujo del juego.
     */
    public void procesarEntradaUsuario() {
        if (juegoActual == null) {
            System.out.println("Selecciona un juego antes de continuar.");
            seleccionarJuego();
        }

        jugar();
    }
    
    /**
     * @brief Método principal para ejecutar el programa.
     * 
     * Inicializa el controlador del juego y procesa la entrada del usuario.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        JuegoControlador controlador = new JuegoControlador();
        controlador.procesarEntradaUsuario();
    }
}
