package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Modelo.empleado;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel3 extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final JTextField apellidoemp = new JTextField();
    public static final JTextField salarioemp = new JTextField();
    public static final JTextField CI = new JTextField();
    public static final JTextField nombremp = new JTextField();
    public static String[] cargosOptions = { "Cajero", "Gerente" };
    public static final JComboBox<String> cargos = new JComboBox<>(cargosOptions);

    /**
     * Create the panel.
     */
    public Panel3() {
        setBackground(new Color(13, 71, 170));
        setLayout(null);

        JLabel lblListaDePersonal = new JLabel("CONTRATAR PERSONAL");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 23));
        lblListaDePersonal.setBounds(0, 21, 313, 29);
        add(lblListaDePersonal);

        JLabel lblIngreseAlgunCampo = new JLabel("Rellene los datos de la persona a contratar: ");
        lblIngreseAlgunCampo.setForeground(Color.WHITE);
        lblIngreseAlgunCampo.setFont(new Font("Roboto Medium", Font.ITALIC, 14));
        lblIngreseAlgunCampo.setBounds(10, 69, 400, 29);
        add(lblIngreseAlgunCampo);

        JLabel lblCdigo = new JLabel("CI:");
        lblCdigo.setForeground(Color.WHITE);
        lblCdigo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo.setBounds(10, 108, 73, 29);
        add(lblCdigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNombre.setBounds(10, 149, 73, 29);
        add(lblNombre);

        JLabel lblCdigo_1_1 = new JLabel("Cargo:");
        lblCdigo_1_1.setForeground(Color.WHITE);
        lblCdigo_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo_1_1.setBounds(10, 227, 73, 29);
        add(lblCdigo_1_1);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.WHITE);
        lblApellido.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblApellido.setBounds(10, 188, 73, 29);
        add(lblApellido);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setForeground(Color.WHITE);
        lblSalario.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblSalario.setBounds(10, 266, 73, 29);
        add(lblSalario);


        cargos.setForeground(new Color(128, 128, 128));
        cargos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        cargos.setBounds(93, 229, 175, 27);
        add(cargos);

        


        apellidoemp.setForeground(new Color(128, 128, 128));
        apellidoemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        apellidoemp.setBounds(93, 190, 175, 29);
        add(apellidoemp);
        apellidoemp.setColumns(10);


        salarioemp.setForeground(new Color(128, 128, 128));
        salarioemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        salarioemp.setColumns(10);
        salarioemp.setBounds(93, 268, 175, 29);
        add(salarioemp);


        CI.setForeground(new Color(128, 128, 128));
        CI.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        CI.setColumns(10);
        CI.setBounds(93, 108, 175, 29);
        add(CI);


        nombremp.setForeground(new Color(128, 128, 128));
        nombremp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        nombremp.setColumns(10);
        nombremp.setBounds(93, 149, 175, 29);
        add(nombremp);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\imagenpcontrato.jpg"));
        lblNewLabel.setBounds(295, 0, 260, 449);
        add(lblNewLabel);
        
        JButton btnBuscar = new JButton("Contratar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		empleado emp = new empleado(nombremp.getText(), generarCorreo(), generarContrasenia(), cargos.getSelectedIndex()+1 , apellidoemp.getText(), CI.getText(), Double.parseDouble(salarioemp.getText()));
        		if(emp.contratar()) {
        			JOptionPane.showMessageDialog(null, "CONTRATO REALIZADO EXITOSAMENTE!");
        		}else {
        			JOptionPane.showMessageDialog(null, "No se pudo realizar el contraro! :(");
        		}
        	}
        });
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Roboto Black", Font.BOLD, 24));
        btnBuscar.setBackground(new Color(51, 102, 255));
        btnBuscar.setBounds(49, 319, 175, 44);
        add(btnBuscar);

    }
    public String generarContrasenia() {
    	return "Birbu"+CI.getText();
    }
    public String generarCorreo() {
    	if(cargos.getSelectedIndex()==0) {
    		return nombremp.getText()+apellidoemp.getText()+"@birbuemp.com";
    	}else if(cargos.getSelectedIndex()==1) {
    		return nombremp.getText()+apellidoemp.getText()+"@birbuadmin.com";
    	}else {
    		return "";
    	}
    }
}
