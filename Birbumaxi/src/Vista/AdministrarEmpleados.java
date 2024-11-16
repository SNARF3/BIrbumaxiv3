package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdministrarEmpleados() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JPanel content = new JPanel();
		content.setBackground(new Color(255, 128, 0));
		content.setBounds(389, 33, 554, 449);
		contentPane.add(content);
		content.setLayout(new BorderLayout(0, 0)); // Añadido para asegurar layout adecuado

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(13, 71, 170));
		panel.setBounds(0, 0, 350, 517);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
		lblNewLabel.setBounds(10, 20, 330, 200);
		panel.add(lblNewLabel);
		
		JButton btnVerPersonal = new JButton("Ver Personal");
		btnVerPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel1 veremp = new Panel1();
				veremp.setSize(554, 449); // Ajuste del tamaño
				veremp.setLocation(0, 0); // Ajuste de la ubicación
				
				content.removeAll();
				content.add(veremp, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		btnVerPersonal.setForeground(Color.WHITE);
		btnVerPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnVerPersonal.setFocusPainted(false);
		btnVerPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnVerPersonal.setBackground(new Color(21, 101, 192));
		btnVerPersonal.setBounds(0, 230, 350, 44);
		panel.add(btnVerPersonal);
		
		JButton btnContratarPersonal = new JButton("Administrar Personal");
		btnContratarPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel2 mod = new Panel2();
				mod.setSize(554, 449); // Ajuste del tamaño
				mod.setLocation(0, 0); // Ajuste de la ubicación
				content.removeAll();
				content.add(mod, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		btnContratarPersonal.setForeground(Color.WHITE);
		btnContratarPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnContratarPersonal.setFocusPainted(false);
		btnContratarPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnContratarPersonal.setBackground(new Color(21, 101, 192));
		btnContratarPersonal.setBounds(0, 273, 350, 44);
		panel.add(btnContratarPersonal);
		
		JButton btnDespedirPersonal = new JButton("Contratar Personal");
		btnDespedirPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel3 con = new Panel3();
				con.setSize(554, 449); // Ajuste del tamaño
				con.setLocation(0, 0); // Ajuste de la ubicación
				content.removeAll();
				content.add(con, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		btnDespedirPersonal.setForeground(Color.WHITE);
		btnDespedirPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnDespedirPersonal.setFocusPainted(false);
		btnDespedirPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnDespedirPersonal.setBackground(new Color(21, 101, 192));
		btnDespedirPersonal.setBounds(0, 316, 350, 44);
		panel.add(btnDespedirPersonal);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGerente meng = new MenuGerente();
				meng.setVisible(true);
				dispose();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Roboto Medium", Font.BOLD, 20));
		btnAtras.setFocusPainted(false);
		btnAtras.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnAtras.setBackground(new Color(21, 101, 192));
		btnAtras.setBounds(10, 403, 151, 55);
		panel.add(btnAtras);
		

	}
}
