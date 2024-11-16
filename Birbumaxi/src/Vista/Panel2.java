package Vista;

import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import conexionBase.conexionBD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2 extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final JTextField apellidoemp = new JTextField();
    public static final JTextField salarioemp = new JTextField();
    public static final JTextField idemp = new JTextField();
    public static final JTextField nombremp = new JTextField();
    public static String[] cargosOptions = { "Cajero", "Gerente" };
    public static final JComboBox<String> cargos = new JComboBox<>(cargosOptions);

    /**
     * Create the panel.
     */
    public Panel2() {
        setBackground(new Color(13, 71, 170));
        setLayout(null);

        JLabel lblListaDePersonal = new JLabel("ADMINISTRAR PERSONAL");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 30));
        lblListaDePersonal.setBounds(137, 26, 400, 29);
        add(lblListaDePersonal);

        JLabel lblIngreseAlgunCampo = new JLabel("Ingrese algun campo para buscar al personal:");
        lblIngreseAlgunCampo.setForeground(Color.WHITE);
        lblIngreseAlgunCampo.setFont(new Font("Roboto Medium", Font.ITALIC, 18));
        lblIngreseAlgunCampo.setBounds(23, 65, 400, 29);
        add(lblIngreseAlgunCampo);

        JLabel lblCdigo = new JLabel("ID:");
        lblCdigo.setForeground(Color.WHITE);
        lblCdigo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo.setBounds(23, 104, 73, 29);
        add(lblCdigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNombre.setBounds(23, 145, 73, 29);
        add(lblNombre);

        JLabel lblCdigo_1_1 = new JLabel("Cargo:");
        lblCdigo_1_1.setForeground(Color.WHITE);
        lblCdigo_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo_1_1.setBounds(23, 223, 73, 29);
        add(lblCdigo_1_1);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.WHITE);
        lblApellido.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblApellido.setBounds(23, 184, 73, 29);
        add(lblApellido);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setForeground(Color.WHITE);
        lblSalario.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblSalario.setBounds(23, 262, 73, 29);
        add(lblSalario);

        cargos.setForeground(new Color(128, 128, 128));
        cargos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        cargos.setBounds(106, 225, 175, 27);
        add(cargos);
        
        apellidoemp.setForeground(new Color(128, 128, 128));
        apellidoemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        apellidoemp.setBounds(106, 186, 175, 29);
        add(apellidoemp);
        apellidoemp.setColumns(10);

        salarioemp.setForeground(new Color(128, 128, 128));
        salarioemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        salarioemp.setColumns(10);
        salarioemp.setBounds(106, 264, 175, 29);
        add(salarioemp);

        idemp.setForeground(new Color(128, 128, 128));
        idemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        idemp.setColumns(10);
        idemp.setBounds(106, 104, 175, 29);
        add(idemp);


        nombremp.setForeground(new Color(128, 128, 128));
        nombremp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        nombremp.setColumns(10);
        nombremp.setBounds(106, 145, 175, 29);
        add(nombremp);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(idemp.getText().isEmpty() && !nombremp.getText().isEmpty()) {
        			buscar(nombremp.getText());
        		}else if(!idemp.getText().isEmpty() && nombremp.getText().isEmpty()) {
        			buscar(idemp.getText());
        		}else if(idemp.getText().isEmpty() && nombremp.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Debe ingresar el nombre o el id");
        		}else if(!idemp.getText().isEmpty() && !nombremp.getText().isEmpty()) {
        			buscar(idemp.getText());
        		}
        	}
        });
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Roboto Black", Font.BOLD, 24));
        btnBuscar.setBackground(new Color(51, 102, 255));
        btnBuscar.setBounds(116, 309, 149, 44);
        add(btnBuscar);

        JButton btnActualizarInformacin = new JButton("Actualizar Información");
        btnActualizarInformacin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(actualizar()) {
        			JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE!");
        		}else {
        			JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos");
        		}
        	}
        	
        });
        btnActualizarInformacin.setForeground(Color.WHITE);
        btnActualizarInformacin.setFont(new Font("Roboto Medium", Font.ITALIC, 17));
        btnActualizarInformacin.setBackground(new Color(51, 102, 255));
        btnActualizarInformacin.setBounds(324, 115, 221, 52);
        add(btnActualizarInformacin);

        JButton btnDespedirEmpleado = new JButton("Despedir Empleado");
        btnDespedirEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(despedir(idemp.getText())) {
        			JOptionPane.showMessageDialog(null, "EMPLEADO DESPEDIDO CORRECTAMENTE! :(");
        		}else {
        			JOptionPane.showMessageDialog(null, "No se pudo despedir al empleado");
        		}
        		
        	}
        });
        btnDespedirEmpleado.setForeground(Color.WHITE);
        btnDespedirEmpleado.setFont(new Font("Roboto Medium", Font.ITALIC, 17));
        btnDespedirEmpleado.setBackground(new Color(51, 102, 255));
        btnDespedirEmpleado.setBounds(324, 190, 221, 52);
        add(btnDespedirEmpleado);


    }
    public static void buscar(String palabraClave) {
        String sql = "SELECT id_empleado, nombre, apellido, cargo, salario FROM empleados WHERE nombre LIKE '%" + palabraClave + "%' OR id_empleado LIKE '%" + palabraClave + "%';";
        conexionBD conec = new conexionBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = conec.conexion();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idemp.setText(rs.getString("id_empleado"));
                nombremp.setText(rs.getString("nombre"));
                apellidoemp.setText(rs.getString("apellido"));
                cargos.setSelectedIndex(Integer.parseInt(rs.getString("cargo")) - 1);
                salarioemp.setText(rs.getString("salario"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al empleado");
            }
        } catch (Exception e) {
            System.out.println("Algo salió mal");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean actualizar() {
        String sql = "UPDATE empleados SET nombre=?, apellido=?, cargo=?, salario=? WHERE ID_empleado=?";
        PreparedStatement ps = null;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombremp.getText()); 
            ps.setString(2, apellidoemp.getText());
            ps.setInt(3, cargos.getSelectedIndex() + 1); 
            ps.setString(4, salarioemp.getText()); 
            ps.setString(5, idemp.getText()); 

            int i = ps.executeUpdate();
            if (i > 0) {
                return true; 
            } else {
                return false; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean despedir(String palabraClave) { 
        String sql = "SELECT estado FROM empleados WHERE nombre LIKE '%" + palabraClave + "%' OR id_empleado LIKE '%" + palabraClave + "%';";
        String sql2 = "UPDATE empleados SET estado=false WHERE nombre ='" + palabraClave + "' OR id_empleado =" + palabraClave + ";";
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = conn.prepareStatement(sql2);
                int i = ps.executeUpdate();
                if (i > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
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
        return false;
    }


}
