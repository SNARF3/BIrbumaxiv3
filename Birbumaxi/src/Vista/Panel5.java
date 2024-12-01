package Vista;
//ve a la linea 145
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
	public static final JComboBox tipoProducto = new JComboBox(tipos);
	public static final String[] productos = {"Frutas", "Verduras", "Carnes", "Lacteos", "Cereales", "Dulces", "Limpieza", "Aseo Personal"};
	public static final JComboBox<String> comboBox = new JComboBox<>(productos);
	private JTextField textFechaVencimiento;
	private JTextField demanda;
	private JTextField mantenerinventario;
	private JTextField producirordenar;

	/**
	 * Create the panel.
	 */
	public Panel5() {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre: ");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblNombreDelProducto.setBounds(102, 67, 98, 29);
		add(lblNombreDelProducto);
		
		nombre.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		nombre.setColumns(10);
		nombre.setBounds(199, 66, 138, 30);
		add(nombre);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
		lblPrecioDeCompra.setForeground(Color.WHITE);
		lblPrecioDeCompra.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeCompra.setBounds(10, 107, 179, 29);
		add(lblPrecioDeCompra);
		

		precioCompra.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioCompra.setColumns(10);
		precioCompra.setBounds(199, 106, 138, 30);
		add(precioCompra);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
		lblPrecioDeVenta.setForeground(Color.WHITE);
		lblPrecioDeVenta.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeVenta.setBounds(31, 147, 158, 29);
		add(lblPrecioDeVenta);
		

		precioVenta.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioVenta.setColumns(10);
		precioVenta.setBounds(199, 147, 138, 30);
		add(precioVenta);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCantidad.setBounds(91, 186, 98, 29);
		add(lblCantidad);
		

		stock.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		stock.setColumns(10);
		stock.setBounds(199, 185, 138, 30);
		add(stock);
		

		comboBox.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		comboBox.setBounds(459, 147, 149, 29);
		add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCategoria.setBounds(347, 147, 113, 29);
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
		lblTelefono.setBounds(347, 107, 113, 29);
		add(lblTelefono);
		
		telefono.setFont(new Font("Dialog", Font.PLAIN, 21));
		telefono.setColumns(10);
		telefono.setBounds(459, 106, 149, 30);
		add(telefono);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Dialog", Font.ITALIC, 21));
		lblTipo.setBounds(384, 186, 60, 29);
		add(lblTipo);
		tipoProducto.setFont(new Font("Dialog", Font.PLAIN, 21));

		tipoProducto.setBounds(459, 190, 149, 29);
		add(tipoProducto);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblProveedor.setBounds(347, 67, 113, 29);
		add(lblProveedor);
		
		proveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		proveedor.setColumns(10);
		proveedor.setBounds(459, 66, 149, 30);
		add(proveedor);
		
		JButton btnPedirNuevoProducto = new JButton("Pedir Nuevo Producto");
		btnPedirNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productos prod = new productos();
				//las variables que tienes que agregar esta en rojo
				if(prod.IngresoProducto(nombre.getText(),Double.parseDouble(precioCompra.getText()), Double.parseDouble(precioVenta.getText()), Double.parseDouble(stock.getText()), Double.parseDouble(demanda.getText()), textFechaVencimiento.getText(), proveedor.getText(), telefono.getText() ,comboBox.getSelectedIndex()+1, Double.parseDouble(mantenerinventario.getText()), Double.parseDouble(producirordenar.getText()), tipoProducto.getSelectedIndex()+1)) {
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
		btnPedirNuevoProducto.setBounds(363, 269, 245, 46);
		add(btnPedirNuevoProducto);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento:");
		lblFechaDeVencimiento.setForeground(Color.WHITE);
		lblFechaDeVencimiento.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblFechaDeVencimiento.setBounds(10, 278, 206, 29);
		add(lblFechaDeVencimiento);
		
		textFechaVencimiento = new JTextField();
		textFechaVencimiento.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		textFechaVencimiento.setColumns(10);
		textFechaVencimiento.setBounds(226, 277, 111, 30);
		add(textFechaVencimiento);
		
		JLabel lblDemanda = new JLabel("Demanda: ");
		lblDemanda.setForeground(Color.WHITE);
		lblDemanda.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblDemanda.setBounds(10, 227, 120, 29);
		add(lblDemanda);
		
		demanda = new JTextField();
		demanda.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		demanda.setColumns(10);
		demanda.setBounds(118, 226, 71, 30);
		add(demanda);
		
		mantenerinventario = new JTextField();
		mantenerinventario.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		mantenerinventario.setColumns(10);
		mantenerinventario.setBounds(322, 226, 71, 30);
		add(mantenerinventario);
		
		JLabel lblMantener = new JLabel("Mantener inventario: : ");
		lblMantener.setForeground(Color.WHITE);
		lblMantener.setFont(new Font("Roboto Medium", Font.ITALIC, 13));
		lblMantener.setBounds(199, 229, 130, 29);
		add(lblMantener);
		
		JLabel lblOrdenar = new JLabel("Ordenar: ");
		lblOrdenar.setForeground(Color.WHITE);
		lblOrdenar.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblOrdenar.setBounds(403, 227, 98, 29);
		add(lblOrdenar);
		
		producirordenar = new JTextField();
		producirordenar.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		producirordenar.setColumns(10);
		producirordenar.setBounds(511, 226, 97, 30);
		add(producirordenar);
		


	}
}
