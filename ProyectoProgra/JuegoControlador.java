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
     * @class JuegoControlador
     * @brief Controlador para seleccionar y manejar el juego actual.
     * 
     * Este controlador maneja explícitamente los juegos TicTacToe y Connect4
     */
    private TicTacToe ticTacToe;
    private Connect4 connect4;
    private Scanner scanner;

    /**
     * @brief Constructor de la clase JuegoControlador.
     * 
     * Inicializa el controlador del juego sin ningún juego seleccionado.
     */
    public JuegoControlador() {
        this.ticTacToe = null;
        this.connect4 = null;
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
                    ticTacToe = new TicTacToe();
                    connect4 = null;
                    System.out.println("Has seleccionado TicTacToe.");
                    juegoSeleccionado = true;
                    break;
                case 2:
                    connect4 = new Connect4();
                    ticTacToe = null;
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
     * Esta función ejecuta el juego actualmente seleccionado (TicTacToe o Connect4).
     */
    public void jugar() {
        if (ticTacToe != null) {
            ticTacToe.hacerMovimiento();
        } else if (connect4 != null) {
            connect4.hacerMovimiento();
        } else {
            System.out.println("Debes seleccionar un juego primero.");
            seleccionarJuego();
            jugar();
        }
    }

    /**
     * @brief Pregunta al usuario si desea jugar de nuevo.
     * 
     * @return true si el usuario desea jugar de nuevo, false en caso contrario.
     */
    public boolean deseaJugarDeNuevo() {
        System.out.println("¿Desea jugar de nuevo? 1 para sí, cualquier otro número para no.");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            if (ticTacToe != null) {
                ticTacToe.reiniciarJuego();  // Reinicia TicTacToe
                jugar();
            } else if (connect4 != null) {
                connect4.reiniciarJuego();   // Reinicia Connect4
                jugar();
            }
            return true;
        } else {
            scanner.close();
            System.out.println("Gracias por jugar.");
            System.exit(0);
            return false;
        }
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
        controlador.seleccionarJuego();
        controlador.jugar();

        while (controlador.deseaJugarDeNuevo()) {
            // El bucle continuará hasta que el usuario decida no jugar más
        }
    }
}

