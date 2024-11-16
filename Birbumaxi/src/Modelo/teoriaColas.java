package Modelo;

import conexionBase.conexionBD;
import java.sql.*;

public class teoriaColas {

    // Método que aplica la teoría de colas dependiendo de la cantidad de cajeros
    public static void calcularTeoriaColas() {
        // Parámetros promedio de un supermercado
        double tasaLlegada = 10;  // tasa promedio de llegada de clientes por unidad de tiempo
        double tasaServicio = 12; // tasa promedio de servicio por cajero

        // Consulta para contar cuántos cajeros (empleados con cargo = 0) hay
        String consultaCajeros = "SELECT COUNT(*) AS totalCajeros FROM empleados WHERE cargo = 0";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtener el número de cajeros
            ps = conn.prepareStatement(consultaCajeros);
            rs = ps.executeQuery();
            int totalCajeros = 0;

            if (rs.next()) {
                totalCajeros = rs.getInt("totalCajeros");
            }

            // Aplicar teoría de colas según el número de cajeros
            if (totalCajeros == 1) {
                System.out.println("Teoría de colas para un servidor (M/M/1):");
                aplicarTeoriaColas1(tasaLlegada, tasaServicio);
            } else if (totalCajeros > 1) {
                System.out.println("Teoría de colas para varios servidores (M/M/c):");
                aplicarTeoriaColasMultiples(totalCajeros, tasaLlegada, tasaServicio);
            } else {
                System.out.println("No hay cajeros en el sistema.");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar los cajeros: " + e.getMessage());
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

    // Fórmulas para M/M/1 (un servidor)
    private static void aplicarTeoriaColas1(double tasaLlegada, double tasaServicio) {
        // Utilizamos la fórmula M/M/1
        double rho = tasaLlegada / tasaServicio; // Utilización del servidor
        double po = 1-rho;
        double Ls = rho / (1 - rho); // Número promedio de clientes en el sistema
        double Lq = (tasaLlegada*tasaLlegada) / (tasaServicio*(tasaServicio-tasaLlegada)); // Número promedio de clientes en la cola
        double Ws = 1 / (tasaServicio - tasaLlegada); // Tiempo promedio en el sistema
        double Wq = tasaLlegada / (tasaServicio*(tasaServicio-tasaLlegada)); // Tiempo promedio en la cola

        System.out.printf("Utilización del servidor (ρ): %.2f%n", rho);
        System.out.printf("Número promedio de clientes en el sistema (L): %.2f%n", L);
        System.out.printf("Número promedio de clientes en la cola (Lq): %.2f%n", Lq);
        System.out.printf("Tiempo promedio en el sistema (W): %.2f%n", W);
        System.out.printf("Tiempo promedio en la cola (Wq): %.2f%n", Wq);
    }

    // Fórmulas para M/M/c (varios servidores)
    private static void aplicarTeoriaColasMultiples(int totalCajeros, double tasaLlegada, double tasaServicio) {
        // Utilizamos la fórmula M/M/c
        double m = tasaLlegada / tasaServicio;

        double rho = tasaLlegada / (totalCajeros * tasaServicio); // Utilización del sistema
        double P0 = calcularP0(totalCajeros, tasaLlegada, tasaServicio); // Probabilidad de que no haya clientes en el sistema
        double Lq = (P0 * Math.pow(m, totalCajeros) * rho) / (factorial(totalCajeros) * (Math.pow((1-rho), 2))); // Número promedio de clientes en la cola
        double Wq = Lq / tasaLlegada; // Tiempo promedio en la cola
        double Ws = Wq + (1/tasaServicio); // Tiempo promedio en el sistema
        double Ls = tasaLlegada * (Wq+(1/tasaServicio)); // Número promedio de clientes en el sistema
        
        
        

        System.out.printf("Utilización del sistema (ρ): %.2f%n", rho);
        System.out.printf("Número promedio de clientes en el sistema (L): %.2f%n", Ls);
        System.out.printf("Número promedio de clientes en la cola (Lq): %.2f%n", Lq);
        System.out.printf("Tiempo promedio en el sistema (W): %.2f%n", Ws);
        System.out.printf("Tiempo promedio en la cola (Wq): %.2f%n", Wq);
    }

    // Función que calcula P0 para M/M/c
    private static double calcularP0(int totalCajeros, double tasaLlegada, double tasaServicio) {
        double m = tasaLlegada / tasaServicio;
        double rho = tasaLlegada / (totalCajeros * tasaServicio); 

        double sumatoria = 0;

        for (int i = 0; i < totalCajeros; i++) {
            sumatoria += Math.pow(m, i) / factorial(i);
        }

        double P0 = 1 / (sumatoria + (Math.pow(m, totalCajeros) / factorial(totalCajeros)) * (1 / (1 - rho)));
        return P0;
    }

    // Función que calcula el factorial de un número
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

}
