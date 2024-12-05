package Modelo;

import conexionBase.conexionBD;
import java.sql.*;

// Clase EOQ
public class EOQ {
    private String nombre;
    private double Q;
    private double d;
    private double T;
    private double N;
    private double CTt;
    private double CTta;
    private double CTcl;
    private double R;
    private double Le;

    // Constructor
    public EOQ(String nombre,double Q, double d, double T, double N, double CTt, double CTta, double CTcl, double R, double Le) {
        this.nombre = nombre;
        this.Q = Q;
        this.d = d;
        this.T = T;
        this.N = N;
        this.CTt = CTt;
        this.CTta = CTta;
        this.CTcl = CTcl;
        this.R = R;
        this.Le = Le;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    
    public double getQ() {
        return Q;
    }

    public double getD() {
        return d;
    }

    public double getT() {
        return T;
    }

    public double getN() {
        return N;
    }

    public double getCTt() {
        return CTt;
    }

    public double getCTta() {
        return CTta;
    }

    public double getCTcl() {
        return CTcl;
    }

    public double getR() {
        return R;
    }

    public double getLe() {
        return Le;
    }

    @Override
    public String toString() {
        return String.format("Q: %.2f, d: %.2f, T: %.2f, N: %.2f, CTt: %.2f, CTta: %.2f, CTcl: %.2f, R: %.2f, Le: %.2f",
                             Q, d, T, N, CTt, CTta, CTcl, R, Le);
    }

// Función para calcular EOQ
    public static EOQ calcularEOQ(int idProductoParametro) {
        // Consulta para obtener los datos necesarios de la tabla productos dependiendo del id_producto
        String consulta = "SELECT id_producto, nombre, precio_compra, producirOrdenar, MantenerInventario, Demanda " +
                        "FROM productos WHERE id_producto = ?";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        EOQ eoq = null;

        try {
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, idProductoParametro); // Pasamos el id_producto a la consulta
            rs = ps.executeQuery();
            
            if (rs.next()) {
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
                double d = ((Q*Q)*h)/(2*k); // Demanda óptima se asume igual a la demanda anual
                double T = Q / d; // Tiempo de un ciclo de producción (años)
                double N = d / Q; // Número de ciclos por año
                double CTt = ((d * k) / Q) + (c*d) + ((h * Q) / 2); // Costo total por unidad de tiempo
                double CTta = CTt * 12;
                double CTcl = k + (c*Q) + ((h*(Q*Q))/(2*d)); // Costo total por ciclo
                
                double L = T - 0.05;
                double n = Math.floor(L / T);
                double Le = L - (n*T);
                double R = Le * d;

                // Crear el objeto EOQ con los valores calculados
                eoq = new EOQ(nombre, Q, d, T, N, CTt, CTta, CTcl, R, Le);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener datos de la base de datos: " + e.getMessage());
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
        return eoq;
    }
}
