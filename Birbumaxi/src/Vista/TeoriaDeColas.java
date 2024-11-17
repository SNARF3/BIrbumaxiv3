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

public class TeoriaDeColas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textid;
    private JTextField TextProducto;
    private JTextField textQ;
    private JTextField textD;
    private JTextField textT;
    private JTextField textCiclosanio;
    private JTextField textcostociclo;
    private JTextField texttm;
    private JTextField textta;
    private JTextField textreorden;
    private JTextField texttiempoespera;

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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\imageninventario.png"));
		lblNewLabel_1.setBounds(610, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TEORIA DE INVENTARIOS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 41));
		lblNewLabel_2.setBounds(10, 0, 520, 83);
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
        panel.setBounds(10, 66, 564, 538);
        contentPane.add(panel);
        panel.setLayout(null);
        
        textid = new JTextField();
        textid.setForeground(Color.GRAY);
        textid.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textid.setColumns(10);
        textid.setBounds(111, 54, 175, 29);
        panel.add(textid);
        
        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblId.setBounds(28, 54, 73, 29);
        panel.add(lblId);
        
        JLabel lblDatosDelProducto = new JLabel("Datos del producto:");
        lblDatosDelProducto.setForeground(Color.WHITE);
        lblDatosDelProducto.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblDatosDelProducto.setBounds(28, 10, 269, 29);
        panel.add(lblDatosDelProducto);
        
        TextProducto = new JTextField();
        TextProducto.setForeground(Color.GRAY);
        TextProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        TextProducto.setColumns(10);
        TextProducto.setBounds(111, 100, 175, 29);
        panel.add(TextProducto);
        
        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setForeground(Color.WHITE);
        lblProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblProducto.setBounds(28, 100, 81, 29);
        panel.add(lblProducto);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnBuscar.setBackground(new Color(21, 101, 192));
        btnBuscar.setBounds(320, 45, 157, 44);
        panel.add(btnBuscar);
        
        JLabel lblResultados = new JLabel("Resultados:");
        lblResultados.setForeground(Color.WHITE);
        lblResultados.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        lblResultados.setBounds(28, 148, 269, 29);
        panel.add(lblResultados);
        
        JLabel lblCantidadOptimaDe = new JLabel("Cantidad optima de pedido:");
        lblCantidadOptimaDe.setForeground(Color.WHITE);
        lblCantidadOptimaDe.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCantidadOptimaDe.setBounds(28, 184, 226, 29);
        panel.add(lblCantidadOptimaDe);
        
        textQ = new JTextField();
        textQ.setForeground(Color.GRAY);
        textQ.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textQ.setColumns(10);
        textQ.setBounds(281, 187, 146, 29);
        panel.add(textQ);
        
        JLabel lblDemandaOptima = new JLabel("Demanda Optima:");
        lblDemandaOptima.setForeground(Color.WHITE);
        lblDemandaOptima.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblDemandaOptima.setBounds(28, 223, 226, 29);
        panel.add(lblDemandaOptima);
        
        textD = new JTextField();
        textD.setForeground(Color.GRAY);
        textD.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textD.setColumns(10);
        textD.setBounds(281, 226, 146, 29);
        panel.add(textD);
        
        JLabel lblTiempoDeCiclo = new JLabel("Tiempo de ciclo de produccion:");
        lblTiempoDeCiclo.setForeground(Color.WHITE);
        lblTiempoDeCiclo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblTiempoDeCiclo.setBounds(28, 262, 269, 29);
        panel.add(lblTiempoDeCiclo);
        
        textT = new JTextField();
        textT.setForeground(Color.GRAY);
        textT.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textT.setColumns(10);
        textT.setBounds(281, 265, 146, 29);
        panel.add(textT);
        
        JLabel lblNumeroDeCiclos = new JLabel("Numero de ciclos al año:");
        lblNumeroDeCiclos.setForeground(Color.WHITE);
        lblNumeroDeCiclos.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNumeroDeCiclos.setBounds(28, 301, 226, 29);
        panel.add(lblNumeroDeCiclos);
        
        textCiclosanio = new JTextField();
        textCiclosanio.setForeground(Color.GRAY);
        textCiclosanio.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textCiclosanio.setColumns(10);
        textCiclosanio.setBounds(281, 304, 146, 29);
        panel.add(textCiclosanio);
        
        JLabel lblCostoTotalPor_2 = new JLabel("Costo total por ciclo:");
        lblCostoTotalPor_2.setForeground(Color.WHITE);
        lblCostoTotalPor_2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_2.setBounds(28, 418, 226, 29);
        panel.add(lblCostoTotalPor_2);
        
        textcostociclo = new JTextField();
        textcostociclo.setForeground(Color.GRAY);
        textcostociclo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textcostociclo.setColumns(10);
        textcostociclo.setBounds(281, 421, 146, 29);
        panel.add(textcostociclo);
        
        JLabel lblCostoTotalPor_1 = new JLabel("Costo total por mes:");
        lblCostoTotalPor_1.setForeground(Color.WHITE);
        lblCostoTotalPor_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_1.setBounds(28, 379, 269, 29);
        panel.add(lblCostoTotalPor_1);
        
        texttm = new JTextField();
        texttm.setForeground(Color.GRAY);
        texttm.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        texttm.setColumns(10);
        texttm.setBounds(281, 382, 146, 29);
        panel.add(texttm);
        
        JLabel lblCostoTotalPor = new JLabel("Costo total por año:");
        lblCostoTotalPor.setForeground(Color.WHITE);
        lblCostoTotalPor.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor.setBounds(28, 340, 226, 29);
        panel.add(lblCostoTotalPor);
        
        textta = new JTextField();
        textta.setForeground(Color.GRAY);
        textta.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textta.setColumns(10);
        textta.setBounds(281, 343, 146, 29);
        panel.add(textta);
        
        JLabel lblCostoTotalPor_1_1 = new JLabel("Punto de reorden:");
        lblCostoTotalPor_1_1.setForeground(Color.WHITE);
        lblCostoTotalPor_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_1_1.setBounds(28, 457, 269, 29);
        panel.add(lblCostoTotalPor_1_1);
        
        textreorden = new JTextField();
        textreorden.setForeground(Color.GRAY);
        textreorden.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        textreorden.setColumns(10);
        textreorden.setBounds(281, 460, 146, 29);
        panel.add(textreorden);
        
        JLabel lblCostoTotalPor_2_1 = new JLabel("Tiempo de espera efectivo:");
        lblCostoTotalPor_2_1.setForeground(Color.WHITE);
        lblCostoTotalPor_2_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCostoTotalPor_2_1.setBounds(28, 496, 226, 29);
        panel.add(lblCostoTotalPor_2_1);
        
        texttiempoespera = new JTextField();
        texttiempoespera.setForeground(Color.GRAY);
        texttiempoespera.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        texttiempoespera.setColumns(10);
        texttiempoespera.setBounds(281, 499, 146, 29);
        panel.add(texttiempoespera);
        
        JLabel lblUnidadeslote = new JLabel("unidades/lote");
        lblUnidadeslote.setForeground(Color.WHITE);
        lblUnidadeslote.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidadeslote.setBounds(432, 185, 106, 29);
        panel.add(lblUnidadeslote);
        
        JLabel lblUnidades = new JLabel("unidades");
        lblUnidades.setForeground(Color.WHITE);
        lblUnidades.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades.setBounds(432, 224, 106, 29);
        panel.add(lblUnidades);
        
        JLabel lblAociclo = new JLabel("año/ciclo");
        lblAociclo.setForeground(Color.WHITE);
        lblAociclo.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblAociclo.setBounds(432, 265, 106, 29);
        panel.add(lblAociclo);
        
        JLabel lblCicloa = new JLabel("ciclo/año");
        lblCicloa.setForeground(Color.WHITE);
        lblCicloa.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblCicloa.setBounds(432, 304, 106, 29);
        panel.add(lblCicloa);
        
        JLabel lblBolivianosao = new JLabel("Bolivianos/año");
        lblBolivianosao.setForeground(Color.WHITE);
        lblBolivianosao.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblBolivianosao.setBounds(432, 343, 106, 29);
        panel.add(lblBolivianosao);
        
        JLabel lblBolivianosao_1 = new JLabel("Bolivianos/mes");
        lblBolivianosao_1.setForeground(Color.WHITE);
        lblBolivianosao_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblBolivianosao_1.setBounds(432, 382, 106, 29);
        panel.add(lblBolivianosao_1);
        
        JLabel lblUnidadeslote_1_1 = new JLabel("Bolivianos/ciclo");
        lblUnidadeslote_1_1.setForeground(Color.WHITE);
        lblUnidadeslote_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidadeslote_1_1.setBounds(432, 423, 106, 29);
        panel.add(lblUnidadeslote_1_1);
        
        JLabel lblUnidades_1_1 = new JLabel("unidades");
        lblUnidades_1_1.setForeground(Color.WHITE);
        lblUnidades_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1.setBounds(432, 462, 106, 29);
        panel.add(lblUnidades_1_1);
        
        JLabel lblUnidades_1_1_1 = new JLabel("años");
        lblUnidades_1_1_1.setForeground(Color.WHITE);
        lblUnidades_1_1_1.setFont(new Font("Roboto Medium", Font.ITALIC, 15));
        lblUnidades_1_1_1.setBounds(432, 499, 106, 29);
        panel.add(lblUnidades_1_1_1);
        
        JButton calcular = new JButton("CALCULAR");
        calcular.setBackground(Color.GRAY);
        calcular.setBounds(330, 102, 120, 29);
        panel.add(calcular);
    }
}
