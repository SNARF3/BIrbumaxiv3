package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botonReportes;

	public MenuGerente() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 205, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\mikon\\Imagengerente.jpg"));
		lblNewLabel_1.setBounds(609, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MENU GERENTE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 54));

		lblNewLabel_2.setBounds(10, 127, 468, 128);

		lblNewLabel_2.setBounds(74, 135, 468, 192);

		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\mikon\\logo330x200.png"));

		lblNewLabel.setBounds(116, -12, 330, 200);

		lblNewLabel.setBounds(113, 0, 330, 200);

		contentPane.add(lblNewLabel);
		
		JButton botonRealizarPedido = new JButton("Realizar Pedido");
		botonRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos pedido = new Pedidos();
				pedido.setVisible(true);
				dispose();
			}
		});
		botonRealizarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonRealizarPedido.setForeground(Color.WHITE);
		botonRealizarPedido.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonRealizarPedido.setFocusPainted(false);
		botonRealizarPedido.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonRealizarPedido.setBackground(new Color(21, 101, 192));

		botonRealizarPedido.setBounds(74, 280, 422, 51);

		botonRealizarPedido.setBounds(74, 280, 422, 64);

		contentPane.add(botonRealizarPedido);
		
		JButton botonSimularVentas = new JButton("Simular Ventas");
		botonSimularVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Simulacion sim = new Simulacion();
				sim.setVisible(true);
				dispose();
			}
		});
		botonSimularVentas.setForeground(Color.WHITE);
		botonSimularVentas.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonSimularVentas.setFocusPainted(false);
		botonSimularVentas.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonSimularVentas.setBackground(new Color(21, 101, 192));

		botonSimularVentas.setBounds(73, 348, 422, 64);

		botonSimularVentas.setBounds(74, 344, 422, 64);
		botonSimularVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		contentPane.add(botonSimularVentas);
		
		botonReportes = new JButton("Reportes");
		botonReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes reportes = new Reportes();
				reportes.setVisible(true);
				dispose();
			}
		});
		botonReportes.setForeground(Color.WHITE);
		botonReportes.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonReportes.setFocusPainted(false);
		botonReportes.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonReportes.setBackground(new Color(21, 101, 192));

		botonReportes.setBounds(73, 414, 422, 64);

		botonReportes.setBounds(74, 407, 422, 64);
		botonReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		contentPane.add(botonReportes);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				log.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnCerrarSesion.setBackground(new Color(21, 101, 192));

		btnCerrarSesion.setBounds(39, 609, 143, 39);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.setBounds(74, 610, 143, 39);
		btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnCerrarSesion);
	

		JButton botonAdmEmpleados = new JButton("Administrar Personal");
		botonAdmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarEmpleados adm = new AdministrarEmpleados();
				adm.setVisible(true);
				dispose();
			}
		});
		botonAdmEmpleados.setForeground(Color.WHITE);
		botonAdmEmpleados.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonAdmEmpleados.setFocusPainted(false);
		botonAdmEmpleados.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonAdmEmpleados.setBackground(new Color(21, 101, 192));

		botonAdmEmpleados.setBounds(74, 545, 422, 64);

		botonAdmEmpleados.setBounds(74, 471, 422, 64);
		botonAdmEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		contentPane.add(botonAdmEmpleados);
		
		JButton botonTeoriaInventarios = new JButton("Teoria de \r\ninventarios");
		botonTeoriaInventarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeoriaDeInventarios inv = new TeoriaDeInventarios();
				inv.setVisible(true);
				dispose();
			}
		});
		botonTeoriaInventarios.setForeground(Color.WHITE);
		botonTeoriaInventarios.setFont(new Font("Roboto Medium", Font.BOLD, 18));
		botonTeoriaInventarios.setFocusPainted(false);
		botonTeoriaInventarios.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonTeoriaInventarios.setBackground(new Color(21, 101, 192));
		botonTeoriaInventarios.setBounds(74, 533, 207, 64);
		botonTeoriaInventarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(botonTeoriaInventarios);
		
		JButton botonTeoriaDeColas = new JButton("Teoria de colas");
		botonTeoriaDeColas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeoriaDeColas col = new TeoriaDeColas();
				col.setVisible(true);
				dispose();
			}
		});
		botonTeoriaDeColas.setForeground(Color.WHITE);
		botonTeoriaDeColas.setFont(new Font("Roboto Medium", Font.BOLD, 18));
		botonTeoriaDeColas.setFocusPainted(false);
		botonTeoriaDeColas.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonTeoriaDeColas.setBackground(new Color(21, 101, 192));
		botonTeoriaDeColas.setBounds(280, 533, 216, 64);
		contentPane.add(botonTeoriaDeColas);
		
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				log.setVisible(true);
				dispose();
			}
		});
	}
}
