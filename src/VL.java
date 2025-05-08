import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VL {
    // Esta clase fue creada con GUI Form Designer
    private JPanel panelMain;
    private JTextField inputField;
    private JButton buscarButton;
    private JTextField resultadoLabel;

    private int[] datos = {4, 7, 1, 9, 3, 5}; // Arreglo base
    private Busqueda buscador = new BusquedaLineal(); // Usamos la implementación

    public VL() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(inputField.getText());
                    int resultado = buscador.buscar(datos, valor);

                    if (resultado != -1) {
                        resultadoLabel.setText("Valor encontrado en la posición: " + resultado);
                    } else {
                        resultadoLabel.setText("Valor no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Ingresa un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VL - Búsqueda Lineal");
        frame.setContentPane(new VL().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

