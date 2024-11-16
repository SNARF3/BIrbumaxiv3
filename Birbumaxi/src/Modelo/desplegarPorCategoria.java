package Modelo;

import conexionBase.conexionBD;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class desplegarPorCategoria {
	public DefaultTableModel datos(int categoria, String[] columnas, String palabra) {
		DefaultTableModel model = new DefaultTableModel(null, columnas);
		
		String consulta= "SELECT ID_producto, nombre, precio_venta from productos WHERE categoria="+categoria+" AND ( id_producto LIKE '%"+ palabra+"%' OR nombre LIKE '%"+palabra+"%');" ;
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		String[] tabla = new String[4];
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				tabla[0]= rs.getString("id_producto");
				tabla[1]= rs.getString("nombre");
				tabla[2]= rs.getString("precio_venta");
				model.addRow(tabla);
			}
			return model;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "no se puedo cargar la tabla");

		}finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	            System.out.println("conexiones cerradas");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
		return model;
	}
	
}
