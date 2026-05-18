
package datos;

import database.Conexion;
import datos.interfaces.CrudimpleInterface;
import entidades.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AdministradorDAO implements CrudimpleInterface<Administrador>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    public AdministradorDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Administrador> listar(String texto) {
        List<Administrador> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM administrador WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Administrador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
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
    
    @Override
    public boolean insertar(Administrador obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO administrador(nombre, documento, telefono, cargo) VALUES (?,?,?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDocumento());
            ps.setString(3, obj.getTelefono());
            ps.setBoolean(4, obj.isCargo());
            if (ps.executeUpdate()> 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Administrador obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE administrador SET nombre=?, documento=?, telefono=?, WHERE ID_Administrador=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDocumento());
            ps.setString(3, obj.getTelefono());
            ps.setInt(4, obj.getId());
            if (ps.executeUpdate()> 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("DELETE FROM administrador WHERE ID_Administrador=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()> 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(ID_Administrador) FROM administrador");
            rs = ps.executeQuery();
            while (rs.next()) {                
                totalRegistros = rs.getInt("COUNT(ID_Administrador)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;
    }
}
