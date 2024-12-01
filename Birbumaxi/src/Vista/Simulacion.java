package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Modelo.SimularVentas;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField numSimulaciones;

    /**
     * Create the frame.
     */
    public Simulacion() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 682, 437);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(31, 205, 184));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
        lblNewLabel.setBounds(27, 10, 330, 200);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("SIMULACION");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 54));
        lblNewLabel_2.setBounds(24, 179, 361, 95);
        contentPane.add(lblNewLabel_2);

        JLabel lblBusquedaPorId = new JLabel("Ingrese la cantidad de simulaciones:");
        lblBusquedaPorId.setForeground(Color.WHITE);
        lblBusquedaPorId.setFont(new Font("Roboto Light", Font.ITALIC, 18));
        lblBusquedaPorId.setBounds(24, 266, 333, 29);
        contentPane.add(lblBusquedaPorId);

        numSimulaciones = new JTextField();
        numSimulaciones.setFont(new Font("Roboto Light", Font.BOLD, 21));
        numSimulaciones.setColumns(10);
        numSimulaciones.setBounds(27, 305, 166, 43);
        contentPane.add(numSimulaciones);

        JButton btnSimular = new JButton("Simular");
        btnSimular.setForeground(Color.WHITE);
        btnSimular.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        btnSimular.setFocusPainted(false);
        btnSimular.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnSimular.setBackground(new Color(21, 101, 192));
        btnSimular.setBounds(223, 305, 156, 43);
        btnSimular.addActionListener(e -> {
            String input = numSimulaciones.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese la cantidad de simulaciones.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int cantidadSimulaciones = Integer.parseInt(input);
                    for(int i = 0; i < cantidadSimulaciones; i++) {
                    	SimularVentas simu = new SimularVentas();
                    	simu.EmpezarSimulacion();
                    	System.out.println("Simulacion: " + i);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número entero válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        contentPane.add(btnSimular);

        JButton btnAtras = new JButton("Atras");
        btnAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuGerente meng = new MenuGerente();
        		meng.setVisible(true);
        		dispose();
        	}
        });
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFont(new Font("Roboto Medium", Font.BOLD, 15));
        btnAtras.setFocusPainted(false);
        btnAtras.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnAtras.setBackground(new Color(21, 101, 192));
        btnAtras.setBounds(27, 358, 97, 32);
        contentPane.add(btnAtras);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\imagensimulacion.jpg"));
        lblNewLabel_1.setBounds(395, 0, 275, 400);
        contentPane.add(lblNewLabel_1);
    }


}
