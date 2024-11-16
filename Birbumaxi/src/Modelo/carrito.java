package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexionBase.conexionBD;

public class carrito {
	public DefaultTableModel carritos(String[] columnas, ArrayList<Double> cantidad, ArrayList<String> producto) {
	    System.out.println("entra a la clase");
	    DefaultTableModel model = new DefaultTableModel(null, columnas);

	    if (cantidad.size() != producto.size()) {
	        JOptionPane.showMessageDialog(null, "Las listas de productos y cantidades no coinciden en tamaño.");
	        return model;
	    }

	    for (int i = 0; i < producto.size(); i++) {
	        String consulta = "SELECT id_producto, nombre, precio_venta, tipo FROM productos WHERE id_producto = ?";
	        conexionBD conec = new conexionBD();
	        Connection conn = conec.conexion();
	        String[] tabla = new String[4];
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            ps = conn.prepareStatement(consulta);
	            ps.setString(1, producto.get(i));
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                tabla[0] = rs.getString("id_producto");
	                tabla[1] = rs.getString("nombre");
	                tabla[2] = rs.getString("precio_venta");
	                tabla[3] = String.valueOf(cantidad.get(i));
	                model.addRow(tabla);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "No se pudo cargar la tabla: " + e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }

	    return model;
	}

    
}
