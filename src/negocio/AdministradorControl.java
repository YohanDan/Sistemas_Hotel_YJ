
package negocio;

import datos.AdministradorDAO;
import entidades.Administrador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class AdministradorControl {
    
    private final AdministradorDAO DATOS;
    private Administrador obj;
    private DefaultTableModel modeloTabla; 
    private int registroMostrado;
    
    public AdministradorControl(){
        this.DATOS = new AdministradorDAO();
        this.obj = new Administrador();
        this.registroMostrado = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Administrador> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"Id", "Nombre", "Telefono", "Documento", "Cargo"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String cargo;
        String[] registro = new String[5];
        this.registroMostrado = 0;
        
        for(Administrador item:lista){
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTelefono();
            registro[3] = item.getDocumento();
            registro[4] = item.isCargo()? "General" : "General";
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String telefono, String documento, boolean cargo){
        if (DATOS.equals(nombre)) {
            return "El registro ya existe";
        }else{
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDocumento(documento);
            obj.setCargo(cargo);
            if (DATOS.insertar(obj)) {
                return "OK";
            }else{
                return "Error en el registro";
            }
        }
    }
    
    public String actualizar(int id, String nombre, String nombreAnt, String telefono, String documento){
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
