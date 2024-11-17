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
		for(VentasSimularProductos venp : baseDatos) {
			ides.add(venp.getNumero());
		}
		
		for(int i = 0; i < compra; i++) {
			int id = random.nextInt(ides.size());
			if(ides.contains(id + 1)) {
				if(baseDatos.get(id).getTipo() == 2) {
					double cantidad = generarNumeroAleatorio(0.5, 3.5);
					if(cantidad <= baseDatos.get(id).getStock()) {
						actualizarStock("" + baseDatos.get(id).getNumero(), cantidad);
						productos.add("" + baseDatos.get(id).getNumero());
						cantidades.add(cantidad);
						ides.remove(id);
						total += cantidad * baseDatos.get(id).getPrecio();
						baseDatos.remove(id);
					} else {
						i--;
					}
				} else {
					double cantidad = generarNumeroAleatorioTipo2(1.0, 4.0);
					if(cantidad <= baseDatos.get(id).getStock()) {
						actualizarStock("" + baseDatos.get(id).getNumero(), cantidad);
						productos.add("" + baseDatos.get(id).getNumero());
						cantidades.add(cantidad);
						ides.remove(id);
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
	
	private static void actualizarStock (String id, double cantidad) {
		String consulta= "SELECT stock from productos WHERE id_producto="+id+";" ;
    	double stock = 0.0;
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			if(rs.next()) {
				stock=Double.parseDouble(rs.getString(1));
			}
			
			double actual;
			actual = stock - cantidad;
			
			String act = "update productos set stock =" + actual + " where ID_producto = " + id + ";";
			ps = conn.prepareStatement(act);
			int v = ps.executeUpdate();
			if (v > 0) {
				System.out.println("Actualizado");
			} else {
				System.out.println("No Actualizado");
			}
		} catch(Exception e) {
			e.printStackTrace();
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
	}
	
	private static ArrayList<VentasSimularProductos> obtenerDatos (){
		ArrayList<VentasSimularProductos> inv = new ArrayList<>();
		String consulta= "select ID_producto, nombre, precio_venta, tipo, stock\r\n"
				+ "from productos;";
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
				double stock = Double.parseDouble(rs.getString("stock"));
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
