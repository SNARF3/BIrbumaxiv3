package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.VentasFactura;
import Modelo.carrito;
import Modelo.desplegarPorCategoria;
import conexionBase.conexionBD;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Ventas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cantidad;
    public int categoria;
    private JTextField busqueda;
    public static String productoSeleccionado="";
    public static final ArrayList<String> productos= new ArrayList<>(); 
    public String[] columnNames = {"ID Producto", "Nombre", "Precio"};
    public DefaultTableModel model = new DefaultTableModel(null, columnNames);
    public String[] columnasNombres = {"ID Producto", "Nombre", "Precio", "Cantidad"};
    public DefaultTableModel tabla2= new DefaultTableModel(null, columnasNombres);
    public static final ArrayList<Double> cantidades= new ArrayList<>();
    public static String eliminarProd="";
    /**
     * Create the frame.
     */
    public Ventas() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1111, 758);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 71, 170));
        panel.setBounds(0, 0, 350, 758);
        contentPane.add(panel);
        panel.setLayout(null);
        
        // Botón Frutas
        JButton botonFrutas = new JButton("Frutas");
        botonFrutas.setForeground(Color.WHITE);
        botonFrutas.setFont(new Font("Dialog", Font.BOLD, 18));
        botonFrutas.setBackground(new Color(21, 101, 192));
        botonFrutas.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonFrutas.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonFrutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonFrutas.setBounds(0, 364, 175, 44);
        // Evento de entrada del mouse (hover)
        botonFrutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonFrutas.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonFrutas.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonFrutas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Frutas
                System.out.println("Has presionado: Frutas");
                categoria=1;
            }
        });
        panel.add(botonFrutas);
        
        // Botón Verduras
        JButton botonVerduras = new JButton("Verduras");
        botonVerduras.setForeground(Color.WHITE);
        botonVerduras.setFont(new Font("Dialog", Font.BOLD, 18));
        botonVerduras.setBackground(new Color(21, 101, 192));
        botonVerduras.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonVerduras.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonVerduras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerduras.setBounds(174, 364, 175, 44);
        // Evento de entrada del mouse (hover)
        botonVerduras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonVerduras.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonVerduras.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonVerduras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Verduras
                System.out.println("Has presionado: Verduras");
                categoria=2;
            }
        });
        panel.add(botonVerduras);
        
        // Botón Carnes
        JButton botonCarnes = new JButton("Carnes");
        botonCarnes.setForeground(Color.WHITE);
        botonCarnes.setFont(new Font("Dialog", Font.BOLD, 18));
        botonCarnes.setBackground(new Color(21, 101, 192));
        botonCarnes.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCarnes.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCarnes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCarnes.setBounds(174, 403, 175, 44);
        // Evento de entrada del mouse (hover)
        botonCarnes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCarnes.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCarnes.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonCarnes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Carnes
                System.out.println("Has presionado: Carnes");
                categoria=3;
            }
        });
        panel.add(botonCarnes);
        
        // Botón Lácteos
        JButton botonLacteos = new JButton("Lácteos");
        botonLacteos.setForeground(Color.WHITE);
        botonLacteos.setFont(new Font("Dialog", Font.BOLD, 18));
        botonLacteos.setBackground(new Color(21, 101, 192));
        botonLacteos.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLacteos.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLacteos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLacteos.setBounds(0, 405, 175, 44);
        // Evento de entrada del mouse (hover)
        botonLacteos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonLacteos.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonLacteos.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonLacteos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Lácteos
                System.out.println("Has presionado: Lácteos");
                categoria=4;
            }
        });
        panel.add(botonLacteos);
        
        // Botón Cereales
        JButton botonCereales = new JButton("Cereales");
        botonCereales.setForeground(Color.WHITE);
        botonCereales.setFont(new Font("Dialog", Font.BOLD, 18));
        botonCereales.setBackground(new Color(21, 101, 192));
        botonCereales.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCereales.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCereales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCereales.setBounds(0, 446, 175, 44);
        // Evento de entrada del mouse (hover)
        botonCereales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCereales.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCereales.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonCereales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Cereales
                System.out.println("Has presionado: Cereales");
                categoria=5;
            }
        });
        panel.add(botonCereales);
		
     // Botón Dulces
        JButton botonDulces = new JButton("Dulces");
        botonDulces.setForeground(Color.WHITE);
        botonDulces.setFont(new Font("Dialog", Font.BOLD, 18));
        botonDulces.setBackground(new Color(21, 101, 192));
        botonDulces.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonDulces.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonDulces.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonDulces.setBounds(174, 446, 175, 44);
        // Evento de entrada del mouse (hover)
        botonDulces.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonDulces.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonDulces.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonDulces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Dulces
                System.out.println("Has presionado: Dulces");
                categoria=6;
            }
        });
        panel.add(botonDulces);

        // Botón Limpieza
        JButton botonLimpieza = new JButton("Limpieza");
        botonLimpieza.setForeground(Color.WHITE);
        botonLimpieza.setFont(new Font("Dialog", Font.BOLD, 18));
        botonLimpieza.setBackground(new Color(21, 101, 192));
        botonLimpieza.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLimpieza.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLimpieza.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpieza.setBounds(0, 489, 175, 44);
        // Evento de entrada del mouse (hover)
        botonLimpieza.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonLimpieza.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonLimpieza.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonLimpieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Limpieza
                System.out.println("Has presionado: Limpieza");
                categoria=7;
            }
        });
        panel.add(botonLimpieza);

        // Botón Aseo Personal
        JButton botonAseoPer = new JButton("Aseo Personal");
        botonAseoPer.setForeground(Color.WHITE);
        botonAseoPer.setFont(new Font("Dialog", Font.BOLD, 18));
        botonAseoPer.setBackground(new Color(21, 101, 192));
        botonAseoPer.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonAseoPer.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonAseoPer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonAseoPer.setBounds(174, 489, 175, 44);
        // Evento de entrada del mouse (hover)
        botonAseoPer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonAseoPer.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonAseoPer.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonAseoPer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Aseo Personal
                System.out.println("Has presionado: Aseo Personal");
                categoria=8;
            }
        });
        panel.add(botonAseoPer);
        
        JLabel lblNewLabel_3 = new JLabel("Cantidad/Kg:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        lblNewLabel_3.setBounds(10, 547, 157, 30);
        panel.add(lblNewLabel_3);
        
        cantidad = new JTextField();
        cantidad.setForeground(new Color(0, 0, 0));
        cantidad.setFont(new Font("Roboto Light", Font.BOLD, 18));
        cantidad.setColumns(10);
        cantidad.setBackground(Color.WHITE);
        cantidad.setBounds(174, 543, 169, 44);
        panel.add(cantidad);

        
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		login log = new login();
        		log.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setBounds(72, 661, 192, 44);

        panel.add(btnCerrarSesion);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Black", Font.BOLD, 22));
        btnCerrarSesion.setBackground(new Color(51, 102, 255));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(387, 11, 682, 290);
        contentPane.add(scrollPane);


        
        JTable table = new JTable(model);
        table.setFont(new Font("Roboto Light", Font.BOLD, 18));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setFocusable(false); // Deshabilitar el enfoque para evitar la edición por teclado

        
        JLabel lblNewLabel_3_1 = new JLabel("Busqueda de Producto:");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Roboto Black", Font.BOLD, 27));
        lblNewLabel_3_1.setBounds(10, 205, 330, 30);
        panel.add(lblNewLabel_3_1);
        
        busqueda = new JTextField();
        busqueda.setFont(new Font("Roboto Light", Font.BOLD, 21));
        busqueda.setBounds(7, 284, 166, 43);
        panel.add(busqueda);
        busqueda.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                desplegarPorCategoria desp = new desplegarPorCategoria();
                model=desp.datos(categoria, columnNames, busqueda.getText());
                table.setModel(model);
        	}
        });
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnBuscar.setBackground(new Color(21, 101, 192));
        btnBuscar.setBounds(183, 283, 157, 44);
        panel.add(btnBuscar);
        
        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		imprimirdatos();
        		VentasFactura v = new VentasFactura(cantidades, productos);
        		for(int i = 0; i < productos.size(); i++) {
        			actualizarStock(cantidades.get(i), productos.get(i));
        		}
        		int facturaID = v.RealizarVenta("CONVERT_TZ(NOW(), @@global.time_zone, 'America/La_Paz')");
        		Factura factura = new Factura(facturaID, productos, cantidades);
        		factura.setVisible(true);
        		cantidades.clear();
        		productos.clear();
        		dispose();
        	}
        });
        btnRealizarVenta.setForeground(Color.WHITE);
        btnRealizarVenta.setFont(new Font("Roboto Black", Font.BOLD, 24));
        btnRealizarVenta.setBackground(new Color(51, 102, 255));
        btnRealizarVenta.setBounds(839, 663, 230, 49);
        contentPane.add(btnRealizarVenta);
        
        JScrollPane pedidos = new JScrollPane();
        pedidos.setBounds(387, 352, 678, 301);
        contentPane.add(pedidos);
        
        
        JTable pedidosRealizados = new JTable(tabla2);
        pedidosRealizados.setFont(new Font("Roboto Light", Font.BOLD, 18));
        pedidosRealizados.setForeground(Color.BLACK);
        pedidosRealizados.setBackground(Color.WHITE);
        pedidosRealizados.setRowHeight(30);
        pedidos.setColumnHeaderView(pedidosRealizados);
        pedidos.setViewportView(pedidosRealizados);
        
        // Agregar la tabla al JScrollPane
        scrollPane.setViewportView(table);
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Verificar que el evento no es intermedio
                // Obtener la fila seleccionada
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Si se ha seleccionado una fila válida
                    // Obtener ID del producto de la fila seleccionada
                    Object selectedId = table.getValueAt(selectedRow, 0); // ID del producto
                    if (selectedId != null) {
                        productoSeleccionado = selectedId.toString();
                        System.out.println("Producto seleccionado: " + productoSeleccionado);
                    }
                }
            }
        });

        
        JButton btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la cantidad ingresada por el usuario
                String cantidadString = cantidad.getText().trim();


                if (!cantidadString.isEmpty()) {

                    try {
                        double cantidadDouble = Double.parseDouble(cantidadString);


                        if (cantidadDouble <= 0 || cantidadDouble > stockCalculo()) {
                            JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                        } else {
                        	
                            if (productos.contains(productoSeleccionado)) {
                                // Producto ya en la lista, sumar cantidad
                            	System.out.println("hasta aca bien");
                                if(CantidadesMod(cantidadDouble, 1)) {
                                	System.out.println("hasta aca bien");
                                    // Llamar a la función para actualizar la tabla
                                    carrito carr = new carrito();
                                    System.out.println("hasta aca bien");
                                    tabla2 = carr.carritos(columnasNombres, cantidades, productos);
                                    System.out.println("hasta aca bien");
                                    pedidosRealizados.setModel(tabla2);
                                    System.out.println("hasta aca bien");
                                    
                                }
                           }else{
                                if(CantidadesMod(cantidadDouble, 0)) {
                                	productos.add(productoSeleccionado);
                                	System.out.println("hasta aca bien");
                                    // Llamar a la función para actualizar la tabla
                                    carrito carr = new carrito();
                                    System.out.println("hasta aca bien");
                                    tabla2 = carr.carritos(columnasNombres, cantidades, productos);
                                    System.out.println("hasta aca bien");
                                    pedidosRealizados.setModel(tabla2);
                                    System.out.println("hasta aca bien");
                                }
                           }
                     
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                }
                busqueda.setText("");
                cantidad.setText("");
                desplegarPorCategoria desp = new desplegarPorCategoria();
                model=desp.datos(categoria, columnNames, busqueda.getText());
                table.setModel(model);
            }
        });

        btnAgregarProducto.setForeground(Color.WHITE);
        btnAgregarProducto.setFont(new Font("Roboto Black", Font.BOLD, 21));
        btnAgregarProducto.setBackground(new Color(51, 102, 255));
        btnAgregarProducto.setBounds(52, 602, 230, 49);
        panel.add(btnAgregarProducto);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
        lblNewLabel.setBounds(10, 10, 330, 200);
        panel.add(lblNewLabel);
        
        JLabel lblBusquedaPorId = new JLabel("Busqueda por ID o Nombre:");
        lblBusquedaPorId.setForeground(Color.WHITE);
        lblBusquedaPorId.setFont(new Font("Roboto Light", Font.ITALIC, 18));
        lblBusquedaPorId.setBounds(10, 245, 275, 29);
        panel.add(lblBusquedaPorId);
        
        JLabel lblBusquedaPorTipo = new JLabel("Busqueda por Tipo:");
        lblBusquedaPorTipo.setForeground(Color.WHITE);
        lblBusquedaPorTipo.setFont(new Font("Roboto Light", Font.ITALIC, 18));
        lblBusquedaPorTipo.setBounds(10, 337, 282, 29);
        panel.add(lblBusquedaPorTipo);

        pedidosRealizados.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Verificar que el evento no es intermedio
                // Obtener la fila seleccionada
                int selectedRow = pedidosRealizados.getSelectedRow();
                if (selectedRow != -1) { // Si se ha seleccionado una fila válida
                    // Obtener datos de la fila seleccionada
                	eliminarProd = (String) pedidosRealizados.getValueAt(selectedRow, 0); // ID del producto
                    System.out.println(productoSeleccionado);
                }
            }
        });
        
        JButton btnEliminarDelCarrito = new JButton("Eliminar del Carrito");
        btnEliminarDelCarrito.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		eliminarCantidad();
        		carrito carr = new carrito();
                tabla2 = carr.carritos(columnasNombres, cantidades, productos);
                pedidosRealizados.setModel(tabla2);
        	}
        });
        btnEliminarDelCarrito.setForeground(Color.WHITE);
        btnEliminarDelCarrito.setFont(new Font("Dialog", Font.BOLD, 24));
        btnEliminarDelCarrito.setBackground(new Color(245, 28, 16));
        btnEliminarDelCarrito.setBounds(384, 663, 317, 49);
        contentPane.add(btnEliminarDelCarrito);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Carrito:");
        lblNewLabel_3_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.BOLD, 27));
        lblNewLabel_3_1_1.setBounds(387, 312, 330, 30);
        contentPane.add(lblNewLabel_3_1_1);

	}
    public static double stockCalculo() {
        double stock = 0;
        String consulta = "SELECT stock from productos WHERE id_producto=" + productoSeleccionado + ";";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                stock = rs.getDouble("stock");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el stock");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stock;
    }

    public static void actualizarStock(double cantidad, String idProducto) {
        String consulta = "SELECT stock from productos WHERE id_producto=" + idProducto + ";";
        double stock = 0.0;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                stock = rs.getDouble("stock");
            }

            double actual;
                actual = stock - cantidad; // Restar cantidad al stock existente

            String act = "UPDATE productos SET stock = " + actual + " WHERE id_producto = " + idProducto + ";";
            ps = conn.prepareStatement(act);
            int v = ps.executeUpdate();
            if (v > 0) {
                System.out.println("Actualizado");
            } else {
                System.out.println("No Actualizado");
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

	public int eliminar() {
		int posicion=0;
		for(int i=0; i<productos.size(); i++) {
			if(eliminarProd.equals(productos.get(i))) {
				posicion=i;
				productos.remove(posicion);
			}else {
				continue;
			}
		}
		return posicion;

	}
	public void eliminarCantidad() {
	    int posicion = eliminar();
	    if (posicion != -1) {
	        cantidades.remove(posicion);
	    }
	}

	public int sacarPosicion() {
		int posicion=0;
		for(int i=0; i<productos.size(); i++) {
			if(productoSeleccionado.equals(productos.get(i))) {
				posicion=i;
			}else {
				continue;
			}
		}
		return posicion;
	}


	public int posicion1() {
		try {
			int posicion;
			posicion=productos.indexOf(productoSeleccionado);
			return posicion;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "valor raro");
			return 0;
		}

	}
	public boolean CantidadesMod(double cantidad, int Ingreso) {
	    System.out.println("hasta aca bien");
	    
	    String sql = "SELECT tipo FROM productos WHERE id_producto=" + productoSeleccionado + ";";
	    conexionBD conec = new conexionBD();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String tipo = "";
	    Connection conn = conec.conexion();
	    System.out.println("hasta aca crea la conexion");
	    
	    try {
	        System.out.println("entra al try");
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        System.out.println("hace el query");
	        
	        if (rs.next()) {
	            System.out.println("verifica");
	            tipo = rs.getString("tipo");
	            System.out.println("sale");
	        }
	        
	        int posicion = sacarPosicion();
	        System.out.println("la posicion es: " + posicion);
	        System.out.println("entra a la seccion de if");
	        
	        if (tipo.equals("1")) {
	            System.out.println("entra al tipo 1");
	            if (cantidad % 1 != 0) {
	                System.out.println("no da la operacion");
	                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero para este tipo de producto.");
	                System.out.println("se verifica y esta mal");
	                return false;
	            } else {
	                System.out.println("entra al tipo 1 y verifica que es un entero");
	                if (Ingreso == 0) {
	                    System.out.println("entra a settear");
	                    cantidades.add(cantidad);
	                    System.out.println("se verifica");
	                    return true;
	                } else if (Ingreso == 1) {
	                    System.out.println("entra a settear ingreso tipo 1");
	                    cantidades.set(posicion, cantidades.get(posicion) + cantidad);
	                    System.out.println("se verifica");
	                    return true;
	                }
	            }
	            System.out.println("sale del tipo 1");
	        } else if (tipo.equals("2")) {
	            System.out.println("entra al tipo 2");
	            if (Ingreso == 0) {
	                cantidades.add(cantidad);
	                System.out.println("se verifica");
	                return true;
	            } else if (Ingreso == 1) {
	                cantidades.set(posicion, cantidades.get(posicion) + cantidad);
	                System.out.println("se verifica");
	                return true;
	            }
	        } else {
	            System.out.println("sale del metodo");
	            return false;
	        }
	        System.out.println("no se verifica ninguno");
	        return false;

	    } catch (Exception e) {
	        System.out.println("salta el catch");
	        JOptionPane.showMessageDialog(null, "no se hace la consulta" + e);
	        return false;

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
	public void imprimirdatos() {
		for(int i=0; i<productos.size(); i++) {
			System.out.println("productos: "+ productos.get(i));
		}
		for(int i=0; i<cantidades.size(); i++) {
			System.out.println("cantidades: "+ cantidades.get(i));
		}
	}

}



