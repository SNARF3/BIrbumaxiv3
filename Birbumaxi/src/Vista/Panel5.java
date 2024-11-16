package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modelo.productos;

public class Panel5 extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final JTextField nombre = new JTextField();
	public static final JTextField precioCompra = new JTextField();
	public static final JTextField precioVenta = new JTextField();
	public static final JTextField stock = new JTextField();
	public static final JTextField proveedor = new JTextField();
	public static final JTextField telefono = new JTextField();
	public static final String[] tipos = {"Por Unidad", "Por kg"}; 
	public static final JComboBox tipo = new JComboBox(tipos);
	public static final String[] productos = {"Frutas", "Verduras", "Carnes", "Lacteos", "Cereales", "Dulces", "Limpieza", "Aseo Personal"};
	public static final JComboBox<String> comboBox = new JComboBox<>(productos);

	/**
	 * Create the panel.
	 */
	public Panel5() {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre: ");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblNombreDelProducto.setBounds(102, 73, 98, 29);
		add(lblNombreDelProducto);
		
		nombre.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		nombre.setColumns(10);
		nombre.setBounds(199, 72, 138, 30);
		add(nombre);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
		lblPrecioDeCompra.setForeground(Color.WHITE);
		lblPrecioDeCompra.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeCompra.setBounds(10, 111, 179, 29);
		add(lblPrecioDeCompra);
		

		precioCompra.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioCompra.setColumns(10);
		precioCompra.setBounds(199, 110, 138, 30);
		add(precioCompra);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
		lblPrecioDeVenta.setForeground(Color.WHITE);
		lblPrecioDeVenta.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeVenta.setBounds(31, 151, 158, 29);
		add(lblPrecioDeVenta);
		

		precioVenta.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioVenta.setColumns(10);
		precioVenta.setBounds(199, 151, 138, 30);
		add(precioVenta);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCantidad.setBounds(91, 190, 98, 29);
		add(lblCantidad);
		

		stock.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		stock.setColumns(10);
		stock.setBounds(199, 189, 138, 30);
		add(stock);
		

		comboBox.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		comboBox.setBounds(459, 151, 149, 29);
		add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCategoria.setBounds(347, 151, 113, 29);
		add(lblCategoria);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 688, 61);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPedidoDeNuevo = new JLabel("PEDIDO DE NUEVO PRODUCTO");
		lblPedidoDeNuevo.setBounds(110, 11, 447, 49);
		lblPedidoDeNuevo.setForeground(Color.WHITE);
		lblPedidoDeNuevo.setFont(new Font("Dialog", Font.ITALIC, 27));
		panel.add(lblPedidoDeNuevo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Dialog", Font.ITALIC, 21));
		lblTelefono.setBounds(347, 111, 113, 29);
		add(lblTelefono);
		
		telefono.setFont(new Font("Dialog", Font.PLAIN, 21));
		telefono.setColumns(10);
		telefono.setBounds(459, 110, 149, 30);
		add(telefono);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Dialog", Font.ITALIC, 21));
		lblTipo.setBounds(384, 190, 60, 29);
		add(lblTipo);
		tipo.setFont(new Font("Dialog", Font.PLAIN, 21));

		tipo.setBounds(459, 194, 149, 29);
		add(tipo);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblProveedor.setBounds(347, 73, 113, 29);
		add(lblProveedor);
		
		proveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		proveedor.setColumns(10);
		proveedor.setBounds(459, 72, 149, 30);
		add(proveedor);
		
		JButton btnPedirNuevoProducto = new JButton("Pedir Nuevo Producto");
		btnPedirNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productos prod = new productos();
				if(prod.IngresoProducto(nombre.getText(), tipo.getSelectedIndex()+1, Double.parseDouble(stock.getText()), Double.parseDouble(precioCompra.getText()), Double.parseDouble(precioVenta.getText()), comboBox.getSelectedIndex()+1, proveedor.getText(), telefono.getText())) {
					JOptionPane.showMessageDialog(null, "PRODUCTO AGREGADO CON EXITO!");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo agregar el producto :(");
				}
			}
		});
		btnPedirNuevoProducto.setForeground(Color.WHITE);
		btnPedirNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPedirNuevoProducto.setFocusPainted(false);
		btnPedirNuevoProducto.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnPedirNuevoProducto.setBackground(new Color(21, 101, 192));
		btnPedirNuevoProducto.setBounds(224, 242, 245, 46);
		add(btnPedirNuevoProducto);
		


	}
}
