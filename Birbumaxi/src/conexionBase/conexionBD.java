package conexionBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://mysql-1c6e891c-birbumaxi.f.aivencloud.com:12816/birbumaxi?serverTimezone=UTC&useSSL=false";
    public static final String user = "avnadmin";
    public static final String password = "AVNS_CQfOii9cx6Rpn9lSJwV";

    public static Connection conexion() {
        Connection conn = null;
        try {
            Class.forName(driver); 
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return conn;
    }
}
