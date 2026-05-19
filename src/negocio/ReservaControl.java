
package negocio;

import datos.ReservaDAO;
import entidades.Reserva;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ReservaControl {
    
    private final ReservaDAO DATOS;
    private Reserva obj;
    private DefaultTableModel modeloTabla; 
    private int registroMostrado;
    
    public ReservaControl(){
        this.DATOS = new ReservaDAO();
        this.obj = new Reserva();
        this.registroMostrado = 0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Reserva> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"NumHabitacion", "NomCliente", "NomRecepcionista", "tipo", "estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[5];
        this.registroMostrado = 0;
        
        for(Reserva item:lista){
            registro[0] = item.getNumHabitacion();
            registro[1] = item.getNomCliente();
            registro[2] = item.getNomRecepcionista();
            registro[3] = item.getTipo();
            registro[4] = item.getEstado();
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(String numHabitacion, String nomCliente, String nomRecepcionista){
        List<Reserva> reservas = DATOS.listar(numHabitacion);
        
        if (!reservas.isEmpty()) {
            return "La habitacion ya esta en reserva";
        }else{
            obj.setNumHabitacion(numHabitacion);
            obj.setNomCliente(nomCliente);
            obj.setNomRecepcionista(nomRecepcionista);
            if (DATOS.insertar(obj)) {
                return "OK";
            }else{
                return "Error en el registro";
            }
        }
    }
    
    public boolean validarDatosRegistro(String nombreCliente, String numHabitacion, String nombreRecepcionista) {
        return DATOS.validarDatosRegistro(nombreCliente, numHabitacion, nombreRecepcionista);
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registroMostrado;
    }
}
