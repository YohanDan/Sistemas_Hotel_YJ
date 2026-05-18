/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import datos.interfaces.HabimpleInterface;
import entidades.Habitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DANY
 */
public class HabitacionDAO implements HabimpleInterface<Habitacion>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    public HabitacionDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Habitacion> listar(String tipo, String estado) {
        List<Habitacion> registros = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder("SELECT * FROM habitacion WHERE 1=1");
            
            if (tipo != null) {
                sql.append(" AND tipo LIKE ?");
            }
            if (estado != null) {
                sql.append(" AND estado LIKE ?");
            }
            ps = CON.conectar().prepareStatement(sql.toString());
            
            int index = 1;
            
            if (tipo != null) {
                ps.setString(index++, "%" + tipo + "%");
            }
            if (estado != null) {
                ps.setString(index++, "%" + estado + "%");
            }
            
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Habitacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }
}
