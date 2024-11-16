package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecVentas1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SecVentas1() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 194);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnAceptar.setFocusPainted(false);
		btnAceptar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnAceptar.setBackground(new Color(21, 101, 192));
		btnAceptar.setBounds(62, 86, 142, 55);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel_3 = new JLabel("Selecciona un producto");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 19));
		lblNewLabel_3.setBounds(26, 20, 235, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("del inventario primero");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Roboto Medium", Font.BOLD, 19));
		lblNewLabel_3_1.setBounds(36, 46, 235, 30);
		contentPane.add(lblNewLabel_3_1);
	}
}
