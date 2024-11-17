package Controlador;


import java.math.BigDecimal;
import java.math.RoundingMode;

import Modelo.EnviarEmailFactura;
import Modelo.FacturaEnPDF;
import Vista.Factura;
<<<<<<< HEAD
import Vista.Reportes;
=======
import Vista.MenuGerente;
>>>>>>> bd183f97243b07818663bfafe7af8cd46b353c2e
import Vista.Ventas;

//import Vista.MenuGerente;

import Vista.login;

public class menuPrincipal {

	public static void main(String[] args) {
<<<<<<< HEAD
		//login ventana1 = new login();
		//ventana1.setVisible(true);
		/*MenuGerente menug = new MenuGerente();
		menug.setVisible(true);*/
=======
		/*login ventana1 = new login();
		ventana1.setVisible(true);*/
		MenuGerente menug = new MenuGerente();
		menug.setVisible(true);
>>>>>>> bd183f97243b07818663bfafe7af8cd46b353c2e
		//MenuGerente menug = new MenuGerente();
		//menug.setVisible(true);
		//Ventas v = new Ventas();
		//v.setVisible(true);
		//Factura fa = new Factura(4);
		//fa.setVisible(true);
		Reportes r = new Reportes();
		r.setVisible(true);
	}
}