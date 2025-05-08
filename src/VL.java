import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VL {
    private JPanel panelMain;
    private JTextField inputField;
    private JButton buscarButton;
    private JLabel resultadoLabel;

    private int[] datos = {4, 7, 1, 9, 3, 5}; // Arreglo base
    private Busqueda buscador = new BusquedaLineal(); // Usamos la implementación

    public VL() {
        // Crear el panel principal y establecer el layout
        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS)); // Acomoda en vertical
        panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado

        // Inicializar componentes
        inputField = new JTextField(10);
        buscarButton = new JButton("Buscar");
        resultadoLabel = new JLabel("Resultado aparecerá aquí");
        resultadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Centrar texto y botón
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputField.getPreferredSize().height));
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        buscarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar los componentes al panel
        panelMain.add(new JLabel("Ingresa un número para buscar:"));
        panelMain.add(Box.createVerticalStrut(5));
        panelMain.add(inputField);
        panelMain.add(Box.createVerticalStrut(10));
        panelMain.add(buscarButton);
        panelMain.add(Box.createVerticalStrut(10));
        panelMain.add(resultadoLabel);

        // Acción del botón
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(inputField.getText());
                    int resultado = buscador.buscar(datos, valor);

                    if (resultado != -1) {
                        resultadoLabel.setText(" Valor encontrado en la posición: " + resultado);
                    } else {
                        resultadoLabel.setText(" Valor no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("⚠️ Ingresa un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VL - Búsqueda Lineal");
        VL vl = new VL();
        frame.setContentPane(vl.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setVisible(true);
    }
}
