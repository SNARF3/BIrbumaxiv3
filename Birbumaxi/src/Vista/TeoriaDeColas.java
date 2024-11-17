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
import Modelo.teoriaColas;

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

public class TeoriaDeColas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cajeros;
    private JTextField textT;
    private JTextField textFactorDeUtilizacion;
    private JTextField textLq;
    private JTextField textLs;
    private JTextField textProbabilidadColaVacia;
    private JTextField textWsMinutos;
    private JTextField textWqMinutos;
    private JTextField textWsHoras;
    private JTextField textWqHoras;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textn;
    private JTextField textField_3;

    /**
     * Create the frame.
     */
    public TeoriaDeColas() {
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\imagencolas.png"));
		lblNewLabel_1.setBounds(610, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TEORIA DE COLAS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 41));
		lblNewLabel_2.setBounds(113, 0, 361, 83);
		contentPane.add(lblNewLabel_2);
		
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
		btnCerrarSesion.setBounds(61, 598, 143, 39);
		contentPane.add(btnCerrarSesion);

        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnCerrarSesion.setBackground(new Color(21, 101, 192));
        btnCerrarSesion.setBounds(27, 614, 143, 39);
        contentPane.add(btnCerrarSesion);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 71, 170));
        panel.setBounds(20, 66, 564, 538);
        contentPane.add(panel);
        panel.setLayout(null);
        
        cajeros = new JTextField();
        cajeros.setForeground(Color.GRAY);
        cajeros.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        cajeros.setColumns(10);
        cajeros.setBounds(355, 23, 81, 37);
        panel.add(cajeros);

        teoriaColas teo = teoriaColas.calcularTeoriaColas();
        
        
        JLabel lblDatosDelProducto = new JLabel("Numero de cajeros contratados:");
        lblDatosDelProducto.setForeground(Color.WHITE);
        lblDatosDelProducto.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblDatosDelProducto.setBounds(28, 26, 317, 29);
        panel.add(lblDatosDelProducto);
        
        // Configuración del botón "Simular"
        JButton btnSimular = new JButton("Simular");
        btnSimular.setForeground(Color.WHITE);
        btnSimular.setFont(new Font("Dialog", Font.BOLD, 18));
        btnSimular.setFocusPainted(false);
        btnSimular.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnSimular.setBackground(new Color(21, 101, 192));
        btnSimular.setBounds(370, 92, 157, 44);
        panel.add(btnSimular);

        // Acción al presionar el botón "Simular"
        btnSimular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teo != null) {
                    try {
                        // Actualizar los campos de texto con los valores de `teo`
                        textT.setText(String.format("%.2f", teo.getS())); // Número de servidores
                        textFactorDeUtilizacion.setText(String.format("%.2f", teo.getRho())); // Factor de utilización
                        textLq.setText(String.format("%.2f", teo.getLq())); // Número promedio de clientes en cola
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel, "Error al calcular los valores: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "El objeto teoría de colas no está inicializado.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        JLabel lblResultados = new JLabel("Simulacion:");
        lblResultados.setForeground(Color.WHITE);
        lblResultados.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblResultados.setBounds(28, 65, 269, 29);
        panel.add(lblResultados);
        
        JLabel lblTiempoDeCiclo = new JLabel("Cajeros a simular:");
        lblTiempoDeCiclo.setForeground(Color.WHITE);
        lblTiempoDeCiclo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblTiempoDeCiclo.setBounds(28, 101, 165, 29);
        panel.add(lblTiempoDeCiclo);
        
        textT = new JTextField();
        textT.setForeground(Color.GRAY);
        textT.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textT.setColumns(10);
        textT.setBounds(194, 101, 146, 29);
        panel.add(textT);

        
        
        JLabel lblNumeroDeCiclos = new JLabel("Factor de utilizacion (ρ):");
        lblNumeroDeCiclos.setForeground(Color.WHITE);
        lblNumeroDeCiclos.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNumeroDeCiclos.setBounds(28, 172, 226, 29);
        panel.add(lblNumeroDeCiclos);
        
        textFactorDeUtilizacion = new JTextField();
        textFactorDeUtilizacion.setForeground(Color.GRAY);
        textFactorDeUtilizacion.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textFactorDeUtilizacion.setColumns(10);
        textFactorDeUtilizacion.setBounds(290, 172, 81, 29);
        panel.add(textFactorDeUtilizacion);
        
        JLabel lblCostoTotalPor_2 = new JLabel("Clientes en cola (Lq):");
        lblCostoTotalPor_2.setForeground(Color.WHITE);
        lblCostoTotalPor_2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_2.setBounds(28, 286, 226, 29);
        panel.add(lblCostoTotalPor_2);
        
        textLq = new JTextField();
        textLq.setForeground(Color.GRAY);
        textLq.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textLq.setColumns(10);
        textLq.setBounds(290, 289, 146, 29);
        panel.add(textLq);
        
        JLabel lblCostoTotalPor_1 = new JLabel("Clientes en sistema (Ls):");
        lblCostoTotalPor_1.setForeground(Color.WHITE);
        lblCostoTotalPor_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_1.setBounds(28, 247, 269, 29);
        panel.add(lblCostoTotalPor_1);
        
        textLs = new JTextField();
        textLs.setForeground(Color.GRAY);
        textLs.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textLs.setColumns(10);
        textLs.setBounds(290, 250, 146, 29);
        panel.add(textLs);
        
        JLabel lblCostoTotalPor = new JLabel("Probabilidad de cola vacia (Po):");
        lblCostoTotalPor.setForeground(Color.WHITE);
        lblCostoTotalPor.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor.setBounds(28, 208, 269, 29);
        panel.add(lblCostoTotalPor);
        
        textProbabilidadColaVacia = new JTextField();
        textProbabilidadColaVacia.setForeground(Color.GRAY);
        textProbabilidadColaVacia.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textProbabilidadColaVacia.setColumns(10);
        textProbabilidadColaVacia.setBounds(290, 211, 81, 29);
        panel.add(textProbabilidadColaVacia);
        
        JLabel textEsperaenSistema = new JLabel("Espera en sistema (Ws):");
        textEsperaenSistema.setForeground(Color.WHITE);
        textEsperaenSistema.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        textEsperaenSistema.setBounds(28, 334, 269, 29);
        panel.add(textEsperaenSistema);
        
        textWsMinutos = new JTextField();
        textWsMinutos.setForeground(Color.GRAY);
        textWsMinutos.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textWsMinutos.setColumns(10);
        textWsMinutos.setBounds(251, 337, 81, 29);
        panel.add(textWsMinutos);
        
        JLabel lblCostoTotalPor_2_1 = new JLabel("Espera en cola (Wq):");
        lblCostoTotalPor_2_1.setForeground(Color.WHITE);
        lblCostoTotalPor_2_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_2_1.setBounds(28, 373, 226, 29);
        panel.add(lblCostoTotalPor_2_1);
        
        textWqMinutos = new JTextField();
        textWqMinutos.setForeground(Color.GRAY);
        textWqMinutos.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textWqMinutos.setColumns(10);
        textWqMinutos.setBounds(251, 376, 81, 29);
        panel.add(textWqMinutos);
        
        JLabel lblCicloa = new JLabel("%");
        lblCicloa.setForeground(Color.WHITE);
        lblCicloa.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblCicloa.setBounds(381, 172, 29, 29);
        panel.add(lblCicloa);
        
        JLabel lblBolivianosao = new JLabel("%");
        lblBolivianosao.setForeground(Color.WHITE);
        lblBolivianosao.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblBolivianosao.setBounds(381, 209, 29, 29);
        panel.add(lblBolivianosao);
        
        JLabel lblBolivianosao_1 = new JLabel("Clientes");
        lblBolivianosao_1.setForeground(Color.WHITE);
        lblBolivianosao_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblBolivianosao_1.setBounds(448, 250, 106, 29);
        panel.add(lblBolivianosao_1);
        
        JLabel lblUnidadeslote_1_1 = new JLabel("Clientes");
        lblUnidadeslote_1_1.setForeground(Color.WHITE);
        lblUnidadeslote_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidadeslote_1_1.setBounds(448, 291, 106, 29);
        panel.add(lblUnidadeslote_1_1);
        
        JLabel lblUnidades_1_1 = new JLabel("minutos");
        lblUnidades_1_1.setForeground(Color.WHITE);
        lblUnidades_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1.setBounds(335, 339, 62, 29);
        panel.add(lblUnidades_1_1);
        
        JLabel lblUnidades_1_1_1 = new JLabel("minutos");
        lblUnidades_1_1_1.setForeground(Color.WHITE);
        lblUnidades_1_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1_1.setBounds(335, 376, 62, 29);
        panel.add(lblUnidades_1_1_1);
        
        JLabel lblResultados_2 = new JLabel("Resultados:");
        lblResultados_2.setForeground(Color.WHITE);
        lblResultados_2.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblResultados_2.setBounds(28, 140, 269, 29);
        panel.add(lblResultados_2);
        
        textWsHoras = new JTextField();
        textWsHoras.setForeground(Color.GRAY);
        textWsHoras.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textWsHoras.setColumns(10);
        textWsHoras.setBounds(408, 337, 81, 29);
        panel.add(textWsHoras);
        
        JLabel lblUnidades_1_1_2 = new JLabel("horas");
        lblUnidades_1_1_2.setForeground(Color.WHITE);
        lblUnidades_1_1_2.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1_2.setBounds(492, 339, 62, 29);
        panel.add(lblUnidades_1_1_2);
        
        textWqHoras = new JTextField();
        textWqHoras.setForeground(Color.GRAY);
        textWqHoras.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textWqHoras.setColumns(10);
        textWqHoras.setBounds(408, 376, 81, 29);
        panel.add(textWqHoras);
        
        JLabel lblUnidades_1_1_1_1 = new JLabel("horas");
        lblUnidades_1_1_1_1.setForeground(Color.WHITE);
        lblUnidades_1_1_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1_1_1.setBounds(492, 376, 62, 29);
        panel.add(lblUnidades_1_1_1_1);
        
        JLabel textEsperaenSistema_1 = new JLabel("λ:");
        textEsperaenSistema_1.setForeground(Color.WHITE);
        textEsperaenSistema_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        textEsperaenSistema_1.setBounds(445, 172, 44, 29);
        panel.add(textEsperaenSistema_1);
        
        textField = new JTextField();
        textField.setBackground(new Color(185, 249, 233));
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textField.setColumns(10);
        textField.setBounds(473, 175, 81, 29);
        panel.add(textField);
        
        JLabel lblCostoTotalPor_2_1_1 = new JLabel("μ:");
        lblCostoTotalPor_2_1_1.setForeground(Color.WHITE);
        lblCostoTotalPor_2_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_2_1_1.setBounds(444, 211, 29, 29);
        panel.add(lblCostoTotalPor_2_1_1);
        
        textField_1 = new JTextField();
        textField_1.setBackground(new Color(185, 249, 233));
        textField_1.setForeground(Color.GRAY);
        textField_1.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(473, 214, 81, 29);
        panel.add(textField_1);
        
        JLabel lblCantidadDeClientes_1 = new JLabel("cantidad de clientes (n):");
        lblCantidadDeClientes_1.setForeground(Color.WHITE);
        lblCantidadDeClientes_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCantidadDeClientes_1.setBounds(29, 449, 198, 29);
        panel.add(lblCantidadDeClientes_1);
        
        JLabel lblProbabilidadDen = new JLabel("Probabilidad de \"n\" clientes en cola:");
        lblProbabilidadDen.setForeground(Color.WHITE);
        lblProbabilidadDen.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblProbabilidadDen.setBounds(29, 497, 342, 29);
        panel.add(lblProbabilidadDen);
        
        textn = new JTextField();
        textn.setForeground(Color.GRAY);
        textn.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textn.setColumns(10);
        textn.setBounds(231, 449, 81, 29);
        panel.add(textn);
        
        textField_3 = new JTextField();
        textField_3.setForeground(Color.GRAY);
        textField_3.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(345, 497, 81, 29);
        panel.add(textField_3);
        
        JLabel lblBolivianosao_2 = new JLabel("%");
        lblBolivianosao_2.setForeground(Color.WHITE);
        lblBolivianosao_2.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblBolivianosao_2.setBounds(437, 497, 29, 29);
        panel.add(lblBolivianosao_2);
        
        JButton btnPn = new JButton("Calcular");
        btnPn.setForeground(Color.WHITE);
        btnPn.setFont(new Font("Dialog", Font.BOLD, 18));
        btnPn.setFocusPainted(false);
        btnPn.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnPn.setBackground(new Color(21, 101, 192));
        btnPn.setBounds(335, 449, 105, 38);
        panel.add(btnPn);
        
        JLabel lblResultados_2_1 = new JLabel("Clientes en cola:");
        lblResultados_2_1.setForeground(Color.WHITE);
        lblResultados_2_1.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblResultados_2_1.setBounds(28, 410, 269, 29);
        panel.add(lblResultados_2_1);
    }
}
