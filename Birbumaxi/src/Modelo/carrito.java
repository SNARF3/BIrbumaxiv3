package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexionBase.conexionBD;

public class carrito {

    public DefaultTableModel carritos(String[] columnas, Map<String, Double> productosConCantidad) {
        System.out.println("Entra a la clase");
        DefaultTableModel model = new DefaultTableModel(null, columnas);

        if (productosConCantidad == null || productosConCantidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el carrito.");
            return model;
        }

        String consulta = "SELECT id_producto, nombre, precio_venta, tipo FROM productos WHERE id_producto = ?";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return model;
        }

        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            for (Map.Entry<String, Double> entry : productosConCantidad.entrySet()) {
                String idProducto = entry.getKey();
                Double cantidad = entry.getValue();

                ps.setString(1, idProducto);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String[] fila = new String[4];
                        fila[0] = rs.getString("id_producto");
                        fila[1] = rs.getString("nombre");
                        fila[2] = rs.getString("precio_venta");
                        fila[3] = String.valueOf(cantidad);
                        model.addRow(fila);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al procesar producto " + idProducto + ": " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta SQL: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return model;
    }
}
