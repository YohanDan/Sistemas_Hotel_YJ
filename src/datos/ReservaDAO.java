
package datos;

import database.Conexion;
import datos.interfaces.ResimpleInterface;
import entidades.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ReservaDAO implements ResimpleInterface<Reserva>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    
    public ReservaDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Reserva> listar(String texto) {
        List<Reserva> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM reserva WHERE ID_Reserva LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
    public boolean insertar(Reserva obj) {
            resp = false;
        try {
            
            ps = CON.conectar().prepareStatement("SELECT tipo FROM habitacion WHERE numero = ?");
            ps.setString(1, obj.getNumHabitacion());
            rs = ps.executeQuery();
            String tipoHabitacion = "";
            if (rs.next()) {
                tipoHabitacion = rs.getString("tipo");
            }
            ps.close();
            rs.close();
            
            
            ps = CON.conectar().prepareStatement(
                "INSERT INTO reserva(numHabitacion, nomCliente, nomRecepcionista, tipo, estado) VALUES (?,?,?,?,?)"
            );
            ps.setString(1, obj.getNumHabitacion());
            ps.setString(2, obj.getNomCliente());
            ps.setString(3, obj.getNomRecepcionista());
            ps.setString(4, tipoHabitacion);
            ps.setString(5, "Reservado");

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
            
            ps = CON.conectar().prepareStatement("UPDATE habitacion SET estado = 'Reservado' WHERE numero = ?");
            ps.setString(1, obj.getNumHabitacion());
            ps.executeUpdate();
            ps.close();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return resp;
        }

    @Override
    public boolean validarDatosRegistro(String nombreCliente, String numHabitacion, String nombreRecepcionista) {
        boolean valido = false;
        try {
            
            ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM cliente WHERE nombre = ?");
            ps.setString(1, nombreCliente);
            rs = ps.executeQuery();
            boolean clienteExiste = rs.next() && rs.getInt(1) > 0;
            ps.close();
            rs.close();
            
            ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM habitacion WHERE numero = ?");
            ps.setString(1, numHabitacion);
            rs = ps.executeQuery();
            boolean habitacionExiste = rs.next() && rs.getInt(1) > 0;
            ps.close();
            rs.close();
            
            ps = CON.conectar().prepareStatement("SELECT COUNT(*) FROM recepcionista WHERE nombre = ?");
            ps.setString(1, nombreRecepcionista);
            rs = ps.executeQuery();
            boolean recepcionistaExiste = rs.next() && rs.getInt(1) > 0;
            ps.close();
            rs.close();
            
            if (clienteExiste && habitacionExiste && recepcionistaExiste) {
                valido = true;
            }
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return valido;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(ID_Reserva) FROM reserva");
            rs = ps.executeQuery();
            while (rs.next()) {                
                totalRegistros = rs.getInt("COUNT(ID_Reserva)");
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
