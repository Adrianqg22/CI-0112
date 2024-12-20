
import javax.swing.*;

public class Interfaz extends JFrame{
    public Interfaz(){
        setTitle("Interfaz para estructuras de datos.");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        salirItem.addActionListener(e -> System.exit(0));

        JPanel panelInterfaz = new JPanel();
        panelInterfaz.setLayout(new BoxLayout(panelInterfaz, BoxLayout.Y_AXIS));

        JLabel estructuraLabel = new JLabel("Seleccione la estructura de datos que desee");
        estructuraLabel.setBounds(150, 100, 50, 50);
        String[] tipoDeEstructura =  {"Seleccione", "Arból de busqueda binaria", "Lista doblemente enlazada"};
        JComboBox<String> tipoDeEstructuraComboBox = new JComboBox<String>(tipoDeEstructura);
        tipoDeEstructuraComboBox.setBounds(150, 100, 50, 50);

        panelInterfaz.add(estructuraLabel);
        panelInterfaz.add(tipoDeEstructuraComboBox);
        add(panelInterfaz);
    }
}
