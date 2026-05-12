
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
    
    public ClienteControl(){
        this.DATOS = new ClienteDAO();
        this.obj = new Cliente();
    }
    
    public DefaultTableModel listar(String texto){
        List<Cliente> lista = new ArrayList<>();
        lista.addALL(DATOS.listar(texto));
        
        String[] titulos = {"Id", "Nombre", "Telefono", "Documento", "tipoCliente"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String tipoCliente;
        String[] registro = new String[5];
        
        for(Cliente item:lista){
            if (item.istipoCliente()) {
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
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, int telefono, int documento){
        if (DATOS.existe(nombre)) {
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
        
    }
    
    public String eliminar(int id){
        
    }
    
    public int total(){
        
    }
}
