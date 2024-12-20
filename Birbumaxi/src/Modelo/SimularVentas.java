package Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import conexionBase.conexionBD;

public class SimularVentas {
	public void EmpezarSimulacion () {
        LocalDateTime fechaHoraAleatoria = generarFechaHoraAleatoria();
        String fchita = formatearFechaHora(fechaHoraAleatoria);
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Double> cantidades =  new ArrayList<>();
        double monto = simularProductoCantidad(productos, cantidades);
        VentasFactura vf = new VentasFactura(cantidades, productos);
        int facturaID = vf.RealizarVenta("'" + fchita + "'");
        simularCliente(facturaID);
        FacturaEnPDF fpdf = new FacturaEnPDF(facturaID);
        BigDecimal bd = new BigDecimal(Double.toString(monto));
        bd = bd.setScale(2, RoundingMode.CEILING);
        fpdf.GenerarReporte(bd.doubleValue());
    }
	public static void simularCliente (int facturaID) {
		int nit = generarNumeroAleatorioNit(6, 7);
		ClienteFactura cf = new ClienteFactura("", "", nit);
		if(cf.buscarCliente()) {
			cf.datosEncontrados();
		} else {
			cf.setNombre(SimularNombre());
			cf.setCorreo(SimularCorreo(cf.getNombre()));
			cf.ingresarClienteNuevo();
		}
		int idCliente = cf.datosEncontrados();
		cf.agregarFactura(facturaID, 1,idCliente);
	}
	public static String SimularNombre () {
		Random n = new Random();
		String[] opciones = {"Alvarez",
				"Dorado",
				"Villaroel",
				"García",
	            "Martínez",
	            "López",
	            "González",
	            "Hernández",
	            "Rodríguez",
	            "Pérez",
	            "Sánchez",
	            "Ramírez",
	            "Torres",
	            "Flores",
	            "Rivera",
	            "Gómez",
	            "Díaz",
	            "Álvarez"}; 
		int pos = n.nextInt(opciones.length);
		String nombre = opciones[pos];
		return nombre;
	}
	public static String SimularCorreo (String nombre) {
		String correo = nombre;
		String[] simbolos = {
            "!",
            ".",
            ",",
            "-",
            "_",
            "#",
            "$",
            "%",
            "&",
            "*",
            "+"
        };
		
		Random r = new Random();
		int ran = r.nextInt(simbolos.length);
		correo += simbolos[ran];
		ran = r.nextInt(1000);
		correo += ran + "@gmail.com";
		return correo;
	}
	
	public static int generarNumeroAleatorioNit(int minCifras, int maxCifras) {
        int min = (int) Math.pow(10, minCifras - 1);
        int max = (int) Math.pow(10, maxCifras) - 1;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
	
	public static double simularProductoCantidad (ArrayList<String> productos, ArrayList<Double> cantidades) {
		Random random = new Random(); 
		double total = 0.0;
		int compra = random.nextInt(7) + 3;
		ArrayList<VentasSimularProductos> baseDatos = new ArrayList<>();
		ArrayList<Integer> ides = new ArrayList<>();
		baseDatos = obtenerDatos();
		
		for(int i = 0; i < compra; i++) {
			int id = random.nextInt(baseDatos.size());
			if(!ides.contains(id)) {
				if(baseDatos.get(id).getTipo() == 2) {
					double cantidad = generarNumeroAleatorio(0.5, 3.5);
					if(cantidad <= baseDatos.get(id).getStock()) {
						actualizarStock(cantidad, "" + baseDatos.get(id).getNumero());
						productos.add("" + baseDatos.get(id).getNumero());
						cantidades.add(cantidad);
						ides.add(id);
						total += cantidad * baseDatos.get(id).getPrecio();
						baseDatos.remove(id);
					} else {
						i--;
					}
				} else {
					double cantidad = generarNumeroAleatorioTipo2(1.0, 4.0);
					if(cantidad <= baseDatos.get(id).getStock()) {
						actualizarStock(cantidad, "" + baseDatos.get(id).getNumero());
						productos.add("" + baseDatos.get(id).getNumero());
						cantidades.add(cantidad);
						ides.add(id);
						total += cantidad * baseDatos.get(id).getPrecio();
						baseDatos.remove(id);
					} else {
						i--;
					}
				}
			}
		}
		return total;
	}
	
	
	public static double generarNumeroAleatorioTipo2(double min, double max) {
        int minInt = (int) Math.ceil(min);
        int maxInt = (int) Math.floor(max);
        int numeroEntero = ThreadLocalRandom.current().nextInt(minInt, maxInt + 1);
        return (double) numeroEntero;
    }
	
	 public static double generarNumeroAleatorio(double min, double max) {
	        double numero = ThreadLocalRandom.current().nextDouble(min, max);
	        BigDecimal bd = new BigDecimal(Double.toString(numero));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        return bd.doubleValue();
	   }
	
	 public static void actualizarStock(double cantidad, String idProducto) {
	        String consulta = "SELECT p.stock, p.id_pedido\r\n"
	        		+ "FROM pedidosReporte p\r\n"
	        		+ "JOIN (\r\n"
	        		+ "    SELECT ID_pedido\r\n"
	        		+ "    FROM pedidosReporte\r\n"
	        		+ "    WHERE ID_producto = " + idProducto + "\r\n"
	        		+ "    AND Estado = true\r\n"
	        		+ "    AND stock > 0.0\r\n"
	        		+ "    ORDER BY ABS(DATEDIFF(CURDATE(), Fecha_Vencimiento)) ASC\r\n"
	        		+ "    LIMIT 1\r\n"
	        		+ ") subquery\r\n"
	        		+ "ON p.ID_pedido = subquery.ID_pedido\r\n"
	        		+ "WHERE p.ID_producto = " + idProducto + " AND p.Estado = true;\r\n"
	        		+ "";
	        double stock = 0.0;
	        int idpedido = 0;
	        conexionBD conec = new conexionBD();
	        Connection conn = conec.conexion();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            ps = conn.prepareStatement(consulta);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                stock = rs.getDouble("p.stock");
	                idpedido = rs.getInt("p.id_pedido");
	            }

	            double actual;
	                actual = stock - cantidad; // Restar cantidad al stock existente
	            if(actual < 0) {
	            	String act = "UPDATE pedidosReporte SET stock = " + 0 + " WHERE id_pedido = " + idpedido + ";";
	                ps = conn.prepareStatement(act);
	                int v = ps.executeUpdate();
	                if (v > 0) {
	                    System.out.println("Actualizado");
	                } else {
	                    System.out.println("No Actualizado");
	                }
	                cantidad = (-1.0) * actual;
	                actualizarStock(cantidad, idProducto);
	            } else {
	            	String act = "UPDATE pedidosReporte SET stock = " + actual + " WHERE id_pedido = " + idpedido + ";";
	                ps = conn.prepareStatement(act);
	                int v = ps.executeUpdate();
	                if (v > 0) {
	                    System.out.println("Actualizado");
	                } else {
	                    System.out.println("No Actualizado");
	                }
	            }

	            

	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "No se pudo actualizar el stock");
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	private static ArrayList<VentasSimularProductos> obtenerDatos (){
		ArrayList<VentasSimularProductos> inv = new ArrayList<>();
		String consulta= "select p.ID_producto, p.nombre, p.precio_venta, p.tipo, sum(pr.stock) as st\r\n"
				+ "from productos as p, pedidosReporte as pr\r\n"
				+ "where p.ID_producto = pr.ID_Producto\r\n"
				+ "group by p.ID_producto;";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				int num = Integer.parseInt(rs.getString("ID_producto"));
				String nombre = rs.getString("nombre");
				double precio = Double.parseDouble(rs.getString("precio_venta"));
				int tipo = Integer.parseInt(rs.getString("tipo"));
				double stock = Double.parseDouble(rs.getString("st"));
				VentasSimularProductos datos = new VentasSimularProductos(num, nombre, precio, tipo, stock);
				inv.add(datos);
				num++;
			}
		}catch(Exception e) {
			
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
		return inv;
	}
	
	public static String formatearFechaHora(LocalDateTime fechaHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return fechaHora.format(formatter);
    }
	
	public static LocalDateTime generarFechaHoraAleatoria() {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime hace2Semanas = ahora.minusWeeks(2);
        long ahoraEpoch = ahora.atZone(ZoneId.systemDefault()).toEpochSecond();
        long hace2SemanasEpoch = hace2Semanas.atZone(ZoneId.systemDefault()).toEpochSecond();
        long fechaAleatoriaEpoch = ThreadLocalRandom.current().nextLong(hace2SemanasEpoch, ahoraEpoch);
        LocalDateTime fechaAleatoria = LocalDateTime.ofEpochSecond(fechaAleatoriaEpoch, 0, ZoneId.systemDefault().getRules().getOffset(ahora));
        int horaInicio = 8;  // 8:00 AM
        int horaFin = 22;    // 10:00 PM
        int horaAleatoria = ThreadLocalRandom.current().nextInt(horaInicio, horaFin + 1);
        int minutoAleatorio = ThreadLocalRandom.current().nextInt(0, 60);
        LocalDateTime fechaHoraAleatoria = fechaAleatoria.with(LocalTime.of(horaAleatoria, minutoAleatorio));

        return fechaHoraAleatoria;
    }
}
