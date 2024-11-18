package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
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
import javax.swing.table.TableColumn;

import Modelo.VentasFactura;
import Modelo.carrito;
import Modelo.productos;
import Modelo.desplegarPorCategoria;
import conexionBase.conexionBD;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;

public class Pedidos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public int categoria;
    public static final JTextField busqueda = new JTextField();
    public static String productoSeleccionado="";
    public final static ArrayList<String> productos= new ArrayList<>(); 
    public String[] columnNames = {"ID Producto", "Nombre", "Stock", "Precio"};
    public DefaultTableModel model = new DefaultTableModel(null, columnNames);
    public String[] columnasNombres = {"ID Producto", "Nombre", "Stock", "Precio", "Cantidad"};
    public DefaultTableModel tabla2= new DefaultTableModel(null, columnasNombres);
    public ArrayList<Double> cantidades= new ArrayList<>();
    public static String eliminarProd="";
    public static final JTextField nombre = new JTextField();
    public static final JTextField stockAct = new JTextField();
    public static final JTextField precioCompra = new JTextField();
    public static final JTextField StockReq = new JTextField();
    public static final JTextField total = new JTextField();
    public static final String[] cat = {"Frutas", "Verduras", "Carnes", "Lacteos", "Cereales", "Dulces", "Limpieza", "Aseo Personal"};
    public static final JComboBox categ = new JComboBox(cat);
    public static final String[] columnas = {"ID", "Nombre"};
    public DefaultTableModel modelo = new DefaultTableModel(null, columnas);
    public static final JTextField textFechaVencimiento = new JTextField();
    /**
     * Create the frame.
     */
    public Pedidos() {
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
        

        
        JButton btnCerrarSesion = new JButton("Atras");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuGerente meng = new MenuGerente();
        		meng.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setBounds(10, 675, 156, 37);

        panel.add(btnCerrarSesion);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Black", Font.BOLD, 22));
        btnCerrarSesion.setBackground(new Color(51, 102, 255));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
        lblNewLabel.setBounds(10, 10, 330, 184);
        panel.add(lblNewLabel);
        
        
        categ.setBounds(20, 194, 156, 28);
        panel.add(categ);

  

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 233, 330, 431);
        panel.add(scrollPane);


        

        JTable prod = new JTable(modelo);
        ajustar(prod, 0, 50);
        scrollPane.setViewportView(prod);
       
        
        
        JButton btnCargar = new JButton("Cargar");
        btnCargar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		productos produc = new productos();
        		modelo=produc.tabla(categ.getSelectedIndex()+1, columnas);
        		ajustar(prod, 0, 50);
        		prod.setModel(modelo);
        		ajustar(prod, 0, 50);
        	}
        });
        
        prod.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Verificar que el evento no es intermedio
                // Obtener la fila seleccionada
                int selectedRow = prod.getSelectedRow();
                if (selectedRow != -1) { // Si se ha seleccionado una fila válida
                    // Obtener ID del producto de la fila seleccionada
                    Object selectedId = prod.getValueAt(selectedRow, 0); // ID del producto
                    if (selectedId != null) {
                        productoSeleccionado = selectedId.toString();
                        System.out.println("Producto seleccionado: " + productoSeleccionado);
                    }
                }
            }
        });
        btnCargar.setForeground(Color.WHITE);
        btnCargar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnCargar.setFocusPainted(false);
        btnCargar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnCargar.setBackground(new Color(248, 118, 2));
        btnCargar.setBounds(212, 194, 128, 28);
        panel.add(btnCargar);
        
        
        JPanel content = new JPanel();
        content.setBackground(new Color(13, 71, 170));
        content.setBounds(390, 377, 679, 320);
        contentPane.add(content);
		content.setLayout(new BorderLayout(0, 0));
        
        JButton botonPedirNuevo = new JButton("Pedir nuevo Producto");
        botonPedirNuevo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Panel5 mod = new Panel5();
				mod.setSize(679, 320); // Ajuste del tamaño
				mod.setLocation(0, 0); // Ajuste de la ubicación
				content.removeAll();
				content.add(mod, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
        	}
        });
        botonPedirNuevo.setForeground(Color.WHITE);
        botonPedirNuevo.setFont(new Font("Dialog", Font.BOLD, 18));
        botonPedirNuevo.setFocusPainted(false);
        botonPedirNuevo.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        botonPedirNuevo.setBackground(new Color(21, 101, 192));
        botonPedirNuevo.setBounds(387, 323, 350, 44);
        contentPane.add(botonPedirNuevo);
        
        JButton botonModificar = new JButton("Modificar Producto Existente");
        botonModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Panel6 mod = new Panel6();
				mod.setSize(679, 320); 
				mod.setLocation(0, 0); 
				content.removeAll();
				content.add(mod, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
        	}
        });
        botonModificar.setForeground(Color.WHITE);
        botonModificar.setFont(new Font("Dialog", Font.BOLD, 18));
        botonModificar.setFocusPainted(false);
        botonModificar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        botonModificar.setBackground(new Color(21, 101, 192));
        botonModificar.setBounds(735, 323, 334, 44);
        contentPane.add(botonModificar);
        
                
       JLabel lblNewLabel_3_1 = new JLabel("Pedido de Producto:");
                lblNewLabel_3_1.setBounds(360, 7, 330, 30);
                contentPane.add(lblNewLabel_3_1);
                lblNewLabel_3_1.setForeground(Color.WHITE);
                lblNewLabel_3_1.setFont(new Font("Roboto Black", Font.BOLD, 27));
                
                JLabel lblBusquedaPorId = new JLabel("ID:");
                lblBusquedaPorId.setBounds(487, 48, 30, 29);
                contentPane.add(lblBusquedaPorId);
                lblBusquedaPorId.setForeground(Color.WHITE);
                lblBusquedaPorId.setFont(new Font("Roboto Light", Font.ITALIC, 18));
                
                busqueda.setBackground(new Color(192, 192, 192));
                busqueda.setBounds(539, 48, 166, 30);
                contentPane.add(busqueda);
                busqueda.setFont(new Font("Roboto Light", Font.BOLD, 21));
                busqueda.setColumns(10);
                


                
                JLabel lblNombreProducto = new JLabel("Nombre Producto:");
                lblNombreProducto.setForeground(Color.WHITE);
                lblNombreProducto.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblNombreProducto.setBounds(360, 88, 157, 29);
                contentPane.add(lblNombreProducto);
                

                nombre.setBackground(new Color(192, 192, 192));
                nombre.setEditable(false);
                nombre.setFont(new Font("Dialog", Font.BOLD, 21));
                nombre.setColumns(10);
                nombre.setBounds(539, 88, 166, 30);
                contentPane.add(nombre);
                
                JLabel lblStockActual = new JLabel("Stock Actual:");
                lblStockActual.setForeground(Color.WHITE);
                lblStockActual.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblStockActual.setBounds(401, 128, 157, 29);
                contentPane.add(lblStockActual);
                
                JLabel lblPrecioCompra = new JLabel("Precio Compra:");
                lblPrecioCompra.setForeground(Color.WHITE);
                lblPrecioCompra.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblPrecioCompra.setBounds(382, 170, 157, 29);
                contentPane.add(lblPrecioCompra);
                

                stockAct.setBackground(new Color(192, 192, 192));
                stockAct.setEditable(false);
                stockAct.setFont(new Font("Dialog", Font.BOLD, 21));
                stockAct.setColumns(10);
                stockAct.setBounds(539, 126, 166, 30);
                contentPane.add(stockAct);
                
                precioCompra.setBackground(new Color(192, 192, 192));
                precioCompra.setEditable(false);
                precioCompra.setFont(new Font("Dialog", Font.BOLD, 21));
                precioCompra.setColumns(10);
                precioCompra.setBounds(539, 168, 166, 30);
                contentPane.add(precioCompra);
                
                JLabel lblCantidadRequerida = new JLabel("Cantidad Requerida:");
                lblCantidadRequerida.setForeground(Color.WHITE);
                lblCantidadRequerida.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblCantidadRequerida.setBounds(353, 210, 205, 29);
                contentPane.add(lblCantidadRequerida);

                StockReq.setBackground(new Color(255, 255, 255));
                StockReq.setFont(new Font("Dialog", Font.BOLD, 21));
                StockReq.setColumns(10);
                StockReq.setBounds(539, 210, 166, 30);
                contentPane.add(StockReq);
                
                JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
                lblTotalAPagar.setForeground(Color.WHITE);
                lblTotalAPagar.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblTotalAPagar.setBounds(401, 250, 126, 29);
                contentPane.add(lblTotalAPagar);
                
                total.setBackground(new Color(192, 192, 192));
                total.setFont(new Font("Dialog", Font.BOLD, 21));
                total.setColumns(10);
                total.setBounds(539, 250, 166, 30);
                contentPane.add(total);
                

                JButton calcular = new JButton("CALCULAR");
                JButton btnPagar = new JButton("Pagar");


                calcular.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                	    
                	    if (StockReq.getText().trim().isEmpty()) {
                	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico.");
                	        return;
                	    }
                        revisarTipo();
                        calcularTotal();
                        btnPagar.setEnabled(true);
                    }
                });


                btnPagar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                        if (actualizarStock()) {
=======
<<<<<<< HEAD
                        if (actualizarStock()) {                        	
=======
                        if (actualizarStock()) {
>>>>>>> e3e3bdb2aad1836a43703dfcfcbcf931d2ba1381
>>>>>>> dc30b876b0aa175bd246b151efbea763f52accfc
                        	JOptionPane.showMessageDialog(null, "Compra Realizada");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo Realizar la compra");
                        }
                    }
                });


                btnPagar.setEnabled(false);	
                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.setBounds(735, 40, 157, 44);
                contentPane.add(btnBuscar);

                btnBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buscar();
                        btnPagar.setEnabled(false);
                    }
                });
                btnBuscar.setForeground(Color.WHITE);
                btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
                btnBuscar.setFocusPainted(false);
                btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
                btnBuscar.setBackground(new Color(21, 101, 192));


                btnPagar.setForeground(Color.WHITE);
                btnPagar.setFont(new Font("Dialog", Font.BOLD, 18));
                btnPagar.setFocusPainted(false);
                btnPagar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
                btnPagar.setBackground(new Color(0, 204, 0));
                btnPagar.setBounds(912, 268, 157, 44);
                contentPane.add(btnPagar);

                calcular.setBackground(new Color(128, 128, 128));
                calcular.setBounds(735, 250, 120, 29);
                contentPane.add(calcular);
                
                JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento (AA/MM/DD):");
                lblFechaDeVencimiento.setForeground(Color.WHITE);
                lblFechaDeVencimiento.setFont(new Font("Dialog", Font.ITALIC, 18));
                lblFechaDeVencimiento.setBounds(735, 180, 312, 29);
                contentPane.add(lblFechaDeVencimiento);
                
                textFechaVencimiento.setFont(new Font("Dialog", Font.BOLD, 21));
                textFechaVencimiento.setColumns(10);
                textFechaVencimiento.setBackground(Color.WHITE);
                textFechaVencimiento.setBounds(783, 208, 183, 30);
                contentPane.add(textFechaVencimiento);
    }
   
    public static void revisarTipo() {
    	
    	String consultaver= "SELECT tipo from productos WHERE id_producto=?";
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        double Stockr=Double.parseDouble(StockReq.getText());
        try {
            ps1=conn.prepareStatement(consultaver);
            ps1.setInt(1, Integer.parseInt(busqueda.getText()));
            rs1=ps1.executeQuery();
        	if(rs1.next()) {
            	int tipo=Integer.parseInt(rs1.getString("tipo"));
            	if(tipo==1) {
            		StockReq.setText(String.valueOf(Math.round(Stockr)));

            	}else {
            		StockReq.setText(String.valueOf(Stockr));
            	}
        	}
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "No se pudo realizar la compra, catch(revisar Tipo)");
   
        }finally {
            try {
                if (rs1 != null) rs1.close();
                if (ps1 != null) ps1.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
 
    public static boolean actualizarStock() {
        String consultaIDProveedor = 
            "SELECT ID_proveedor FROM pedidosReporte WHERE ID_producto = ? LIMIT 1";


        String consultaInsert = 
            "INSERT INTO pedidosReporte (ID_producto, ID_proveedor, fecha, Fecha_Vencimiento, cantidad, Stock, Estado) " +
            "VALUES (?, ?, NOW(), ?, ?, ?, ?)";

        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Paso 1: Obtener el ID_proveedor
            ps = conn.prepareStatement(consultaIDProveedor);
            ps.setInt(1, Integer.parseInt(productoSeleccionado)); // Asigna el ID_producto
            rs = ps.executeQuery();

            int idProveedor = -1;
            if (rs.next()) {
                idProveedor = rs.getInt("ID_proveedor"); // Extrae el ID_proveedor
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un proveedor para el producto seleccionado.");
                return false; // Si no se encuentra un proveedor, se cancela la operación
            }

            // Cierra el ResultSet y PreparedStatement para reusarlos
            rs.close();
            ps.close();

            // Paso 2: Insertar en pedidosReporte
            ps = conn.prepareStatement(consultaInsert);
            ps.setInt(1, Integer.parseInt(productoSeleccionado)); // ID_producto
            ps.setInt(2, idProveedor);                            // ID_proveedor
            ps.setString(3, textFechaVencimiento.getText());                        // Fecha_Vencimiento
            ps.setDouble(4, Double.parseDouble(StockReq.getText()));   // cantidad
            ps.setDouble(5, Double.parseDouble(StockReq.getText()));   // Stock (igual a cantidad)
            ps.setBoolean(6, true);                               // Estado

            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void buscar() {
        String sql = 
            "SELECT productos.id_producto, productos.nombre, productos.precio_compra, " +
            "(SELECT SUM(pedidosReporte.Stock) " +
            " FROM pedidosReporte " +
            " WHERE pedidosReporte.id_producto = productos.id_producto " +
            " AND pedidosReporte.Estado = true) AS totalStock " +
            "FROM productos " +
            "WHERE productos.id_producto = ?";

        conexionBD conec = new conexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = conec.conexion();

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sql);
            ps.setString(1, productoSeleccionado); // Asignar el ID del producto
            rs = ps.executeQuery();

            // Procesar el resultado
            if (rs.next()) {
                // Actualizar los campos con los datos obtenidos
                busqueda.setText(rs.getString("id_producto"));                // ID del producto
                nombre.setText(rs.getString("nombre"));                       // Nombre del producto
                precioCompra.setText(rs.getString("precio_compra"));          // Precio de compra
                stockAct.setText(rs.getString("totalStock"));                 // Sumatoria del Stock
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto o no hay pedidos activos.");
            }
        } catch (Exception e) {
            System.out.println("Algo salió mal: " + e.getMessage());
        } finally {
            try {
                // Liberar recursos
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public static void calcularTotal() {
	    String stockReqText = StockReq.getText().trim(); 
	    
	    if (StockReq.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico.");
	        return;
	    }
	    
	    try {
	        double stockReq = Double.parseDouble(stockReqText);
	        double precioCompraValue = Double.parseDouble(precioCompra.getText());
	        
	        if (stockReq <= 0 || precioCompraValue <= 0) {
	            JOptionPane.showMessageDialog(null, "Los valores deben ser mayores que cero.");
	            return;
	        }
	        
	        double totalPago = stockReq * precioCompraValue;
	        total.setText(String.valueOf(totalPago));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
	    }
	}
    public static void ajustar(JTable table, int colIndex, int ancho) {
        TableColumn column = table.getColumnModel().getColumn(colIndex);
        column.setPreferredWidth(ancho);
        column.setMinWidth(ancho);
        column.setMaxWidth(ancho);
    }
}

