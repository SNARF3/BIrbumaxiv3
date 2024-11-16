package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Modelo.ReporteFinanzas;
import Modelo.ReporteInventario;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panelIntervalos; // Declarar panelIntervalos como variable de clase

    /**
     * Create the frame.
     */
    public Reportes() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 996, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\Imagenreporte.jpg"));
		lblNewLabel_1.setBounds(610, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
		lblNewLabel.setBounds(118, 10, 330, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("REPORTES\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 54));
		lblNewLabel_2.setBounds(138, 156, 330, 140);
		contentPane.add(lblNewLabel_2);
		
		JButton btnGenerarReporteDe = new JButton("Generar Reporte de Inventario");
		btnGenerarReporteDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteInventario rep = new ReporteInventario();
				rep.GenerarReporte();
			}
		});
		btnGenerarReporteDe.setForeground(Color.WHITE);
		btnGenerarReporteDe.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnGenerarReporteDe.setFocusPainted(false);
		btnGenerarReporteDe.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnGenerarReporteDe.setBackground(new Color(21, 101, 192));
		btnGenerarReporteDe.setBounds(71, 279, 422, 64);
		contentPane.add(btnGenerarReporteDe);
		
		JButton btnCerrarSesion = new JButton("Atras");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		MenuGerente menuGerente = new MenuGerente();
        		menuGerente.setVisible(true);
        		dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnCerrarSesion.setBackground(new Color(21, 101, 192));
		btnCerrarSesion.setBounds(29, 603, 143, 39);
		contentPane.add(btnCerrarSesion);
		


        panelIntervalos = new JPanel(); // Inicializar panelIntervalos
        panelIntervalos.setBackground(new Color(255, 128, 0));
        panelIntervalos.setBounds(71, 515, 422, 75);
        contentPane.add(panelIntervalos);


        btnGenerarReporteDe.setForeground(Color.WHITE);
        btnGenerarReporteDe.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        btnGenerarReporteDe.setFocusPainted(false);
        btnGenerarReporteDe.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnGenerarReporteDe.setBackground(new Color(21, 101, 192));
        btnGenerarReporteDe.setBounds(71, 260, 422, 64);
        contentPane.add(btnGenerarReporteDe);

        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnCerrarSesion.setBackground(new Color(21, 101, 192));
        btnCerrarSesion.setBounds(27, 614, 143, 39);
        contentPane.add(btnCerrarSesion);

        JButton btnGenerarReporteDiario = new JButton("Generar Reporte de Pedidos");
        btnGenerarReporteDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Panel4 panel4 = new Panel4(1);
                panel4.setSize(422, 75); // Ajuste del tamaño
                panel4.setLocation(0, 0); // Ajuste de la ubicacion

                limpiarPanelIntervalos();
                panelIntervalos.setLayout(new BorderLayout());
                panelIntervalos.add(panel4, BorderLayout.CENTER);
                panelIntervalos.revalidate();
                panelIntervalos.repaint();

            }
        });
        btnGenerarReporteDiario.setForeground(Color.WHITE);
        btnGenerarReporteDiario.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        btnGenerarReporteDiario.setFocusPainted(false);
        btnGenerarReporteDiario.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnGenerarReporteDiario.setBackground(new Color(21, 101, 192));
        btnGenerarReporteDiario.setBounds(71, 324, 422, 64);
        contentPane.add(btnGenerarReporteDiario);

        JButton btnGenerarReporteFinanciero = new JButton("Generar Reporte Financiero");
        btnGenerarReporteFinanciero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ReporteFinanzas fina = new ReporteFinanzas();
            	fina.GenerarReporte();
                limpiarPanelIntervalos(); //limpia el panel de fechas
            }
        });
        btnGenerarReporteFinanciero.setForeground(Color.WHITE);
        btnGenerarReporteFinanciero.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        btnGenerarReporteFinanciero.setFocusPainted(false);
        btnGenerarReporteFinanciero.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnGenerarReporteFinanciero.setBackground(new Color(21, 101, 192));
        btnGenerarReporteFinanciero.setBounds(71, 387, 422, 64);
        contentPane.add(btnGenerarReporteFinanciero);

        JButton btnGenerarReporteDe_1 = new JButton("Generar Reporte de Ventas");
        btnGenerarReporteDe_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Panel4 panel4 = new Panel4(2);
                panel4.setSize(422, 75); // Ajuste del tamaño
                panel4.setLocation(0, 0); // Ajuste de la ubicacion

                limpiarPanelIntervalos();
                panelIntervalos.setLayout(new BorderLayout());
                panelIntervalos.add(panel4, BorderLayout.CENTER);
                panelIntervalos.revalidate();
                panelIntervalos.repaint();
            }
        });
        btnGenerarReporteDe_1.setForeground(Color.WHITE);
        btnGenerarReporteDe_1.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        btnGenerarReporteDe_1.setFocusPainted(false);
        btnGenerarReporteDe_1.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnGenerarReporteDe_1.setBackground(new Color(21, 101, 192));
        btnGenerarReporteDe_1.setBounds(71, 451, 422, 64);
        contentPane.add(btnGenerarReporteDe_1);
    }

    //Metodo para limpiar el panel
    private void limpiarPanelIntervalos() {
        panelIntervalos.removeAll();
        panelIntervalos.revalidate();
        panelIntervalos.repaint();
    }
}
