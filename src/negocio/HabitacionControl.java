/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.HabitacionDAO;
import entidades.Habitacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANY
 */
public class HabitacionControl {
    
    private final HabitacionDAO DATOS;
    private Habitacion obj;
    private DefaultTableModel modeloTabla; 
    private int registroMostrado;
    
    public HabitacionControl(){
        this.DATOS = new HabitacionDAO();
        this.obj = new Habitacion();
        this.registroMostrado = 0;
    }
    
    public DefaultTableModel listar(String tipo, String estado){
        List<Habitacion> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(tipo, estado));
        
        String[] titulos = {"NumHabitacion", "Tipo", "Estado", "Precio"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[4];
        this.registroMostrado = 0;
        
        for(Habitacion item:lista){
            registro[0] = item.getNumero();
            registro[1] = item.getTipo();
            registro[2] = item.getEstado();
            registro[3] = Integer.toString((int) item.getPrecio());
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1;
        }
        return this.modeloTabla;
    }
}
