import java.util.Scanner;

/**
 *  @file JuegoControlador.java
 *  @brief Clase que contiene la interacción con el usuario y la selección del juego.
 *  
 *  La clase JuegoControlador permite al usuario seleccionar entre los juegos
 *  TicTacToe o Conecta 4, y luego maneja el flujo del juego seleccionado.
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

        do {
            mostrarMenu();
            int seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    juegoActual = new TicTacToe();
                    System.out.println("Has seleccionado TicTacToe.");
                    juegoSeleccionado = true;
                    break;
                case 2:
                    juegoActual = new Connect4();  // Asegúrate de que esta clase existe
                    System.out.println("Has seleccionado Conecta 4.");
                    juegoSeleccionado = true;
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Selecciona de nuevo.");
                    break;
            }
        } while (!juegoSeleccionado);
    }

    /**
     * @brief Maneja el flujo del juego actual.
     * 
     * Dependiendo del juego seleccionado, llama al método hacerMovimiento()
     * para manejar las jugadas del usuario.
     */
    public void jugar() {
        if (juegoActual instanceof TicTacToe) {
            ((TicTacToe) juegoActual).hacerMovimiento();
        } else if (juegoActual instanceof Connect4) {
            ((Connect4) juegoActual).hacerMovimiento();
        }
    }

    /**
     * @brief Pregunta al usuario si desea jugar de nuevo.
     * 
     * @return true si el usuario desea jugar de nuevo, false en caso contrario.
     */
    public boolean deseaJugarDeNuevo() {
        System.out.println("¿Desea jugar de nuevo? (1. Sí / 2. No)");
        int opcion = scanner.nextInt();
        return opcion == 1;
    }

    /**
     * @brief Procesa la entrada del usuario y ejecuta el juego seleccionado.
     * 
     * Si no hay ningún juego seleccionado, solicita al usuario que seleccione uno.
     * Luego, inicia el flujo del juego y pregunta si desea jugar de nuevo.
     */
    public void procesarEntradaUsuario() {
        while (true) {
            if (juegoActual == null) {
                seleccionarJuego();
            }
            jugar();
            if (!deseaJugarDeNuevo()) {
                System.out.println("Gracias por jugar.");
                break;
            }
            juegoActual = null; 
        }
        scanner.close(); 
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

