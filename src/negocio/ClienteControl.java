
package negocio;

import datos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteControl {
    
    private final ClienteDAO DATOS;
    private Cliente obj;
    private DefaultTableModel modeloTabla; 
    private int registroMostrado;
    
    public ClienteControl(){
        this.DATOS = new ClienteDAO();
        this.obj = new Cliente();
        this.registroMostrado = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Cliente> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"Id", "Nombre", "Telefono", "Documento", "tipoCliente"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String tipoCliente;
        String[] registro = new String[5];
        this.registroMostrado = 0;
        
        for(Cliente item:lista){
            if (item.getTipoCliente().equals("estandar")) {
                tipoCliente = "estandar";
            }else{
                tipoCliente = "VIP";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = Integer.toString(item.getTelefono());
            registro[3] = Integer.toString(item.getDocumento());
            registro[4] = item.getTipoCliente();
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, int telefono, int documento){
        if (DATOS.equals(nombre)) {
            return "El registro ya existe";
        }else{
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            if (DATOS.insertar(obj)) {
                return "OK";
            }else{
                return "Error en el registro";
            }
        }
    }
    
    public String actualizar(int id, String nombre, String nombreAnt, int telefono, int documento){
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDocumento(documento);
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualizacion";
            }
        }else{
            if (DATOS.equals(nombre)) {
                return "El registro ya existe";
            }else{
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setTelefono(telefono);
                obj.setDocumento(documento);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                }else{
                    return "Error en la actualizacion";
                }
            }
        }
    }
    
    public String eliminar(int id){
        if (DATOS.eliminar(id)) {
            return "OK";
        }else{
            return "No se puede eliminar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registroMostrado;
    }
}
