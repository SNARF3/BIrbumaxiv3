package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ClienteFactura;
import Modelo.EnviarEmailFactura;
import Modelo.FacturaEnPDF;
import Modelo.VentasFactura;
import Modelo.carrito;
import conexionBase.conexionBD;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Factura extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombre;
    private JTextField nitci;
    private JTextField correo;
    private JTable detalleFactura;

    public Factura(int FacturaID, ArrayList<String> productos, ArrayList<Double>cantidad) {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 995, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);

		ClienteFactura cfa = new ClienteFactura("", "", 0);

        JLabel sucursal = new JLabel("Sucursal #1");
        sucursal.setBounds(10, 10, 101, 29);
        sucursal.setForeground(Color.WHITE);
        sucursal.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        contentPane.add(sucursal);

        String[] datos= { "Nombre", "Cantidad", "Precio Unitario", "Subtotal" };
        // Crear la tabla para el detalle de la factura
        

        
        VentasFactura vf = new VentasFactura(cantidad, productos);
        DefaultTableModel tablaFac = vf.carritoFactura(datos, FacturaID);
        detalleFactura = new JTable(tablaFac);
        detalleFactura.setFont(new Font("Roboto Light", Font.BOLD, 18));
        detalleFactura.setForeground(Color.BLACK);
        detalleFactura.setBackground(Color.WHITE);
        detalleFactura.setRowHeight(30);
        detalleFactura.setFocusable(false); // Deshabilitar el enfoque para evitar la edición por teclado
        JScrollPane scrollPane = new JScrollPane(detalleFactura);
        scrollPane.setBounds(43, 341, 900, 232);
        contentPane.add(scrollPane);
        
        JLabel avenida = new JLabel("Av. Hernando Siles");
        avenida.setForeground(Color.WHITE);
        avenida.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        avenida.setBounds(10, 33, 223, 29);
        contentPane.add(avenida);

        JLabel calle = new JLabel("Calle 3 de Obrajes");
        calle.setForeground(Color.WHITE);
        calle.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        calle.setBounds(10, 59, 223, 29);
        contentPane.add(calle);

        JLabel telefono = new JLabel("Telefono: 72036743");
        telefono.setForeground(Color.WHITE);
        telefono.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        telefono.setBounds(10, 87, 244, 29);
        contentPane.add(telefono);

        JLabel ciudad = new JLabel("La Paz - Bolivia");
        ciudad.setForeground(Color.WHITE);
        ciudad.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        ciudad.setBounds(10, 115, 244, 29);
        contentPane.add(ciudad);

        JLabel lblFactura = new JLabel("FACTURA");
        lblFactura.setForeground(Color.WHITE);
        lblFactura.setFont(new Font("Roboto Black", Font.BOLD, 77));
        lblFactura.setBounds(288, 87, 417, 140);
        contentPane.add(lblFactura);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo220x150.png"));
        lblNewLabel.setBounds(751, 10, 220, 150);
        contentPane.add(lblNewLabel);

        JLabel lblnitci = new JLabel("NIT/CI:");
        lblnitci.setForeground(Color.WHITE);
        lblnitci.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblnitci.setBounds(43, 219, 120, 29);
        contentPane.add(lblnitci);

        JLabel lblnombre = new JLabel("Nombre/Razon Social:");
        lblnombre.setForeground(Color.WHITE);
        lblnombre.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblnombre.setBounds(43, 258, 211, 29);
        contentPane.add(lblnombre);

        nombre = new JTextField();
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto Light", Font.BOLD, 18));
        nombre.setBounds(252, 260, 254, 29);
        contentPane.add(nombre);
        nombre.setColumns(10);

        nitci = new JTextField();
        nitci.setForeground(new Color(0, 0, 0));
        nitci.setFont(new Font("Roboto Light", Font.BOLD, 18));
        nitci.setBackground(new Color(255, 255, 255));
        nitci.setColumns(10);
        nitci.setBounds(122, 219, 183, 29);
        contentPane.add(nitci);

        String[] metodos = { "Tarjeta", "Efectivo" };
        JComboBox<String> metodoPago = new JComboBox<>(metodos);
        metodoPago.setFont(new Font("Roboto Light", Font.BOLD, 18));
        metodoPago.setBackground(new Color(13, 71, 170));
        metodoPago.setBounds(689, 258, 254, 29);
        contentPane.add(metodoPago);

        JLabel lblmetodo = new JLabel("Metodo de pago:");
        lblmetodo.setForeground(Color.WHITE);
        lblmetodo.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblmetodo.setBounds(689, 219, 211, 29);
        contentPane.add(lblmetodo);

        JLabel lblcorreo = new JLabel("Correo Electronico:");
        lblcorreo.setForeground(Color.WHITE);
        lblcorreo.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblcorreo.setBounds(43, 299, 211, 29);
        contentPane.add(lblcorreo);

        correo = new JTextField();
        correo.setForeground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto Light", Font.BOLD, 18));
        correo.setColumns(10);
        correo.setBounds(252, 301, 254, 29);
        contentPane.add(correo);
        
        nitci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nit = nitci.getText();
                int nitInt = validarNit(nit);
                if(nitInt > 0) {
                	cfa.setNit(nitInt);
                    if (cfa.buscarCliente()) {
                        cfa.datosEncontrados();
                        nombre.setText(cfa.getNombre());
                        correo.setText(cfa.getCorreo());
                    } else {
                        nombre.setText("");
                        correo.setText("");
                    }
                }
                
            }
        });

        JLabel lblma = new JLabel("Monto a pagar: " + EncontrarPrecio(FacturaID));
        lblma.setForeground(Color.WHITE);
        lblma.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblma.setBounds(43, 583, 229, 29);
        contentPane.add(lblma);

        JLabel lblmp = new JLabel("Monto pagado: " );
        lblmp.setForeground(Color.WHITE);
        lblmp.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblmp.setBounds(43, 622, 190, 29);
        contentPane.add(lblmp);

        JTextArea montop = new JTextArea();
        montop.setForeground(new Color(255, 255, 255));
        montop.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        montop.setBackground(new Color(255, 128, 0));
        montop.setBounds(215, 622, 177, 29);
        contentPane.add(montop);
        
        if(metodoPago.getSelectedIndex() == 0) { // Tarjeta
            montop.setText(EncontrarPrecio(FacturaID));
        }
        
        metodoPago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(metodoPago.getSelectedIndex() == 0) { // Tarjeta
                    montop.setText(EncontrarPrecio(FacturaID));
                } else { // Efectivo
                    montop.setText("");
                }
            }
        });

        JButton btnFacturar = new JButton("Facturar");
        btnFacturar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(validarNit(nitci.getText()) >= 0 && !nombre.getText().isEmpty() && !correo.getText().isEmpty()) {
        			cfa.setNit(validarNit(nitci.getText()));
        			if(!cfa.buscarCliente()) {
        				System.out.println("Entra");
        				cfa.setNombre(nombre.getText());
            			cfa.setCorreo(correo.getText());
        				cfa.ingresarClienteNuevo();
        			}
        			if(validard(montop.getText()) >= Double.parseDouble(EncontrarPrecio(FacturaID))) {
        				int idcliente = cfa.datosEncontrados();
        				cfa.agregarFactura(FacturaID, metodoPago.getSelectedIndex() + 1, idcliente);
        				FacturaEnPDF facPDF = new FacturaEnPDF (FacturaID);
        				facPDF.GenerarReporte(validard(montop.getText()));
        				EnviarEmailFactura ev = new EnviarEmailFactura(cfa.getCorreo());
        				ev.EnviarCorreo();
            			Ventas v = new Ventas();
            			v.setVisible(true);
            			dispose();
        			} else {
        				JOptionPane.showMessageDialog(null, "Dinero Insuficiente o formato no valido", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        			}
        			
        		} else {
        			JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        		}
        	}
        });
        btnFacturar.setForeground(Color.WHITE);
        btnFacturar.setFont(new Font("Roboto Medium", Font.BOLD, 25));
        btnFacturar.setFocusPainted(false);
        btnFacturar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnFacturar.setBackground(new Color(21, 101, 192));
        btnFacturar.setBounds(741, 589, 202, 46);
        contentPane.add(btnFacturar);

    }

    public static int validarNit(String v) {
		int s = -1;
        try {
            s = Integer.parseInt(v);
            if(s >= 0){
            	return s;
            } else {
                JOptionPane.showMessageDialog(null, "Debe ser un NIT valido", "MENSAJE", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ser un NIT valido", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
        return s;
	}
    
    public static String EncontrarPrecio(int id) {
        String consulta = "SELECT total FROM factura WHERE id_factura = " + id + ";";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        double num = 0;

        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                num = rs.getDouble("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(num);
    }

    
    public static double validard(String v) {
		double s = 0.0;
        try {
            s = Double.parseDouble(v);
            if(s > 0){
            	return s;
            } else {
                JOptionPane.showMessageDialog(null, "Debe ser un valor numerico positivo", "MENSAJE", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ser un valor numerico", "MENSAJE", JOptionPane.WARNING_MESSAGE);
        }
        return s;
	}
}
 