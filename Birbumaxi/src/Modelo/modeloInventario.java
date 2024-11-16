package Modelo;

import conexionBase.conexionBD;
import java.sql.*;

public class modeloInventario {

    public void calcularEOQ() {
        // Consulta para obtener todos los datos necesarios de la tabla productos
        String consulta = "SELECT id_producto, nombre, precio_compra,  producirOrdenar, MantenerInventario, Demanda FROM productos";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            // Encabezado en la consola
            System.out.printf(
                "%-15s %-20s %-10s %-15s %-15s %-10s %-15s %-15s %-20s %-15s %-15s%n", 
                "ID Producto", "Nombre", "Demanda", "Costo Ordenar", "Costo Mantener", "EOQ", 
                "Demanda Óptima", "Tiempo Ciclo", "N° Ciclos al Año", "Costo Total UT", "Costo Total Ciclo");
            System.out.println("---------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                // Obtener valores de la base de datos
                String idProducto = rs.getString("id_producto");
                String nombre = rs.getString("nombre");
                double c = rs.getDouble("precio_compra");
                double k = rs.getDouble("producirOrdenar");
                double h = rs.getDouble("MantenerInventario");
                double demanda = rs.getDouble("Demanda");
                
                

                // Calcular EOQ utilizando la fórmula
                double Q = Math.sqrt((2 * demanda * k) / h);

                // Cálculo de métricas adicionales
                double d = ((Q*Q)*H)/(2*k); // Demanda óptima se asume igual a la demanda anual
                double T = Q / d; // Tiempo de un ciclo de producción (años)
                double N = d / Q; // Número de ciclos por año
                double CTt = ((d * k) / Q) + (c*d) + ((h * Q) / 2); // Costo total por unidad de tiempo
                double CTcl = k + (c*Q) + ((h*(Q*Q))/(2*d)); // Costo total por ciclo

                // Mostrar los datos en la consola
                System.out.printf(
                    "%-15s %-20s %-10.2f %-15.2f %-15.2f %-10.2f %-15.2f %-15.2f %-20.2f %-15.2f %-15.2f%n", 
                    idProducto, nombre, demanda, k, h, Q, 
                    d, T, N, CTt, CTcl);
            }

        } catch (Exception e) {
            System.out.println("No se pudo cargar la tabla: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
                System.out.println("Conexiones cerradas");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
