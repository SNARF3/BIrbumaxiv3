package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import conexionBase.conexionBD;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Panel6 extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final JTextField nombreproducto = new JTextField();
	public static final JTextField precioCompra = new JTextField();
	public static final JTextField precioVenta = new JTextField();
	public static final JTextField proveedor = new JTextField();
	public static final JTextField idProducto = new JTextField();
	public static final String[] productos = {"Frutas", "Verduras", "Carnes", "Lacteos", "Cereales", "Dulces", "Limpieza", "Aseo Personal"};
	public static final JComboBox<String> comboBox = new JComboBox<>(productos);

	/**
	 * Create the panel.
	 */
	public Panel6() {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto: ");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblNombreDelProducto.setBounds(10, 109, 220, 29);
		add(lblNombreDelProducto);
		

		nombreproducto.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		nombreproducto.setColumns(10);
		nombreproducto.setBounds(229, 110, 206, 30);
		add(nombreproducto);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
		lblPrecioDeCompra.setForeground(Color.WHITE);
		lblPrecioDeCompra.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeCompra.setBounds(40, 148, 179, 29);
		add(lblPrecioDeCompra);
		

		precioCompra.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioCompra.setColumns(10);
		precioCompra.setBounds(229, 148, 206, 30);
		add(precioCompra);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
		lblPrecioDeVenta.setForeground(Color.WHITE);
		lblPrecioDeVenta.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeVenta.setBounds(61, 189, 158, 29);
		add(lblPrecioDeVenta);
		

		precioVenta.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioVenta.setColumns(10);
		precioVenta.setBounds(229, 189, 206, 30);
		add(precioVenta);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblProveedor.setBounds(106, 229, 113, 29);
		add(lblProveedor);
		

		proveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		proveedor.setColumns(10);
		proveedor.setBounds(229, 228, 206, 30);
		add(proveedor);
		
		JButton btnPedirNuevoProducto = new JButton("Modificar Producto");
		btnPedirNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(actualizar()) {
					JOptionPane.showMessageDialog(null, "Producto Actualizado Correctamente!");
				}else {
					JOptionPane.showMessageDialog(null, "xd");
				}
			}
		});
		btnPedirNuevoProducto.setForeground(Color.WHITE);
		btnPedirNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPedirNuevoProducto.setFocusPainted(false);
		btnPedirNuevoProducto.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnPedirNuevoProducto.setBackground(new Color(21, 101, 192));
		btnPedirNuevoProducto.setBounds(214, 265, 245, 46);
		add(btnPedirNuevoProducto);
		

		comboBox.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		comboBox.setBounds(458, 179, 211, 40);
		add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCategoria.setBounds(505, 148, 113, 29);
		add(lblCategoria);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 698, 61);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPedidoDeNuevo = new JLabel("MODIFICACION DE PRODUCTO");
		lblPedidoDeNuevo.setBounds(146, 11, 411, 35);
		lblPedidoDeNuevo.setForeground(Color.WHITE);
		lblPedidoDeNuevo.setFont(new Font("Dialog", Font.ITALIC, 27));
		panel.add(lblPedidoDeNuevo);
		
		idProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		idProducto.setColumns(10);
		idProducto.setBounds(229, 72, 206, 30);
		add(idProducto);
		
		JLabel lblIdDelProducto = new JLabel("ID del Producto:");
		lblIdDelProducto.setForeground(Color.WHITE);
		lblIdDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblIdDelProducto.setBounds(64, 71, 166, 29);
		add(lblIdDelProducto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar(idProducto.getText());
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnBuscar.setBackground(new Color(21, 101, 192));
		btnBuscar.setBounds(481, 84, 158, 46);
		add(btnBuscar);

	}
    public static void buscar(String palabraClave) {
        String sql = "SELECT productos.id_producto, productos.nombre, productos.precio_compra, productos.precio_venta, productos.categoria, Pedidos.nombre_P FROM productos, Pedidos WHERE productos.id_producto =" + palabraClave + " AND productos.id_producto=Pedidos.id_producto;";
        conexionBD conec = new conexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = conec.conexion();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idProducto.setText(rs.getString("productos.id_producto"));
                nombreproducto.setText(rs.getString("productos.nombre"));
                precioCompra.setText(rs.getString("productos.precio_compra"));
                precioVenta.setText(rs.getString("productos.precio_venta"));
                proveedor.setText(rs.getString("Pedidos.nombre_P"));
                comboBox.setSelectedIndex(Integer.parseInt(rs.getString("productos.categoria"))-1);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al empleado");
            }
        } catch (Exception e) {
            System.out.println("Algo salió mal");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean actualizar() {
        String sql = "UPDATE productos SET nombre=?, precio_compra=?, precio_venta=?, categoria=? WHERE ID_producto=?";
        String sql2 = "UPDATE Pedidos SET nombre_P=? WHERE id_producto=?";
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombreproducto.getText());
            ps.setString(2, precioCompra.getText());
            ps.setString(3, precioVenta.getText());
            ps.setInt(4, comboBox.getSelectedIndex() + 1);
            ps.setInt(5, Integer.parseInt(idProducto.getText()));
            int i = ps.executeUpdate();

            if (i > 0) {
                ps1 = conn.prepareStatement(sql2);
                ps1.setString(1, proveedor.getText());
                ps1.setInt(2, Integer.parseInt(idProducto.getText()));
                int j = ps1.executeUpdate(); 

                if (j > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios crj!");
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (ps1 != null) ps1.close(); 
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
