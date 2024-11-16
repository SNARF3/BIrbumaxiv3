package Vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Modelo.ReportePedido;
import Modelo.ReporteVentas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel4 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Panel4(int t) {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el intervalo de fecha:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 0, 220, 26);
		add(lblNewLabel);
		
		JLabel lblMenor = new JLabel("Inferior:");
		lblMenor.setForeground(Color.WHITE);
		lblMenor.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblMenor.setBounds(32, 23, 81, 26);
		add(lblMenor);
		
		JLabel lblSuperior = new JLabel("Superior:");
		lblSuperior.setForeground(Color.WHITE);
		lblSuperior.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblSuperior.setBounds(32, 49, 81, 26);
		add(lblSuperior);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Black", Font.BOLD, 11));
		textField.setBounds(91, 28, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Black", Font.BOLD, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(91, 53, 96, 19);
		add(textField_1);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(coerenciaDeFecha(textField.getText(), textField_1.getText())) {
					LocalDate inicio = ingresarFecha(textField.getText());
					LocalDate fin = ingresarFecha(textField_1.getText());
					if(t == 1) {
						ReportePedido pe = new ReportePedido();
						pe.GenerarReporte(inicio, fin);
					} else {
						ReporteVentas ve = new ReporteVentas();
						ve.GenerarReporte(inicio, fin);
					}
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnGenerarReporte.setForeground(Color.WHITE);
		btnGenerarReporte.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnGenerarReporte.setFocusPainted(false);
		btnGenerarReporte.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnGenerarReporte.setBackground(new Color(21, 101, 192));
		btnGenerarReporte.setBounds(240, 9, 172, 55);
		add(btnGenerarReporte);

	}
	
	public static LocalDate ingresarFecha(String tiempo) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate f = null;
        try {
            LocalDate fecha = LocalDate.parse(tiempo, formatoFecha);
            return fecha;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Inténtelo de nuevo.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
        return f;
    }
	
	public static boolean coerenciaDeFecha (String inicio, String fin) {
		if(ingresarFecha(inicio) != null && ingresarFecha(fin) != null) {
			LocalDate finicio = ingresarFecha(inicio);
			LocalDate ffin = ingresarFecha(fin);
			if (finicio.isBefore(ffin) || finicio.isEqual(ffin)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "La fecha inferior debe ser antes de la fecha superior o igual", "MENSAJE", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} 
		return false;
	}
	

}
