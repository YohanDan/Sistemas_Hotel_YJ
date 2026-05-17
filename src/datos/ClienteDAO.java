
package datos;

import database.Conexion;
import datos.interfaces.CrudimpleInterface;
import entidades.Cliente;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class ClienteDAO implements CrudimpleInterface<Cliente>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    public ClienteDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Cliente> listar(String texto) {
        List<Cliente> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM cliente WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5)));
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
    public boolean insertar(Cliente obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO cliente(nombre, documento, telefono, tipoCliente) VALUES (?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getDocumento());
            ps.setInt(3, obj.getTelefono());
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
    public boolean actualizar(Cliente obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE cliente SET nombre=?, documento=?, telefono=?, WHERE ID_Cliente=?");
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getDocumento());
            ps.setInt(3, obj.getTelefono());
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
            ps = CON.conectar().prepareStatement("DELETE FROM cliente WHERE ID_Cliente=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(ID_Cliente) FROM cliente");
            rs = ps.executeQuery();
            while (rs.next()) {                
                totalRegistros = rs.getInt("COUNT(ID_Cliente)");
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
