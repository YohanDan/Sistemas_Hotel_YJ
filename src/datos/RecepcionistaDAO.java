/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import datos.interfaces.CrudimpleInterface;
import entidades.Recepcionista;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANY
 */
public class RecepcionistaDAO implements CrudimpleInterface<Recepcionista>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    public RecepcionistaDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Recepcionista> listar(String texto) {
        List<Recepcionista> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM recepcionista WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Recepcionista(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
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
    public boolean insertar(Recepcionista obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO recepcionista(nombre, documento, telefono, turno) VALUES (?,?,?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDocumento());
            ps.setString(3, obj.getTelefono());
            ps.setBoolean(4, obj.isTurno());
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
    public boolean actualizar(Recepcionista obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE recepcionista SET nombre=?, documento=?, telefono=?, WHERE ID_Recepcionista=?");
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
            ps = CON.conectar().prepareStatement("DELETE FROM recepcionista WHERE ID_Recepcionista=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(ID_Recepcionista) FROM recepcionista");
            rs = ps.executeQuery();
            while (rs.next()) {                
                totalRegistros = rs.getInt("COUNT(ID_Recepcionista)");
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
