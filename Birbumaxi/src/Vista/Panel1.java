package Vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Modelo.empleado;
import conexionBase.conexionBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Panel1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable personal;

    /**
     * Create the panel.
     */
    public Panel1() {
        setBackground(new Color(13, 71, 170));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 49, 559, 400);
        add(scrollPane);
        String[] datos={"ID","Nombre", "Apellido", "CI", "Correo","Cargo", "Salario"};
        DefaultTableModel empleados= desplegarEmpleados(datos);
        
        personal = new JTable(empleados);
        ajustar(personal, 0, 30);
        ajustar(personal, 1, 60);
        ajustar(personal, 2, 60);
        ajustar(personal, 3, 65);
        ajustar(personal, 5, 55);
        ajustar(personal, 6, 60);
        

        // Establecer el borde para el JTable
        personal.setBorder(new LineBorder(new Color(0, 0, 0)));
        personal.setGridColor(Color.BLACK);

        JTableHeader header = personal.getTableHeader();
        header.setBackground(new Color(21, 101, 192));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(16f)); 
        header.setBorder(new LineBorder(Color.BLACK, 1));

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ((DefaultTableCellRenderer)component).setBorder(new LineBorder(Color.BLACK));
                return component;
            }
        };

        for (int i = 0; i < personal.getColumnCount(); i++) {
            personal.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        scrollPane.setViewportView(personal);

        JLabel lblListaDePersonal = new JLabel("LISTA DE PERSONAL BIRBUMAXI");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 30));
        lblListaDePersonal.setBounds(24, 10, 517, 29);
        add(lblListaDePersonal);
    }
	public DefaultTableModel desplegarEmpleados(String[] nombresColumnas) {
		
		DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
		conexionBD conec = new conexionBD();
		PreparedStatement ps= null;
		ResultSet rs=null;
		Connection conn=conec.conexion();
		String[] datos = new String[7];
		try {
			ps=conn.prepareStatement("SELECT ID_empleado, Nombre, Apellido, ci, usurario, cargo, Salario from empleados WHERE estado=1;");
			rs=ps.executeQuery();
			while(rs.next()) {
				datos[0]= rs.getString("ID_empleado");
				datos[1]=rs.getString("Nombre");
				datos[2]=rs.getString("Apellido");
				datos[3]= rs.getString("ci");
				datos[4]=rs.getString("usurario");;
				datos[5]=rs.getString("cargo");
				datos[6]=rs.getString("Salario");
				modelo.addRow(datos);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "NO SE PUDO CARGAR LA TABLA");
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
		return modelo;
		
	}
    public static void ajustar(JTable table, int colIndex, int ancho) {
        TableColumn column = table.getColumnModel().getColumn(colIndex);
        column.setPreferredWidth(ancho);
        column.setMinWidth(ancho);
        column.setMaxWidth(ancho);
    }
}
