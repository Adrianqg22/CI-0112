import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal(){
        setTitle("Formulario de Usuario");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");
				
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

		JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);
        
        JLabel etiquetaTelefono = new JLabel("Telefono");
        JTextField campoTelefono = new JTextField(20);

        JButton botonGuardar = new JButton("Guardar");

        botonGuardar.addActionListener(e -> {
            String nombre  = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();

            try {
                FileWriter writer = new FileWriter("datos_usuario.txt", true);
                write.write("Npmbre: " + nombre +)
            } catch (IOException ex) {
            }

        }

        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator(); //Separador visual 
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);
        salirItem.addActionListener(e -> System.exit(0));

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        add(panelFormulario);
    }
    
    public static void main(String [] args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);// Mostrar la ventana
        
        
    }
}
