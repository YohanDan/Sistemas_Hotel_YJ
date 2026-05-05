
package entidades;


public class Habitacion {
    private int idHabitacion;
    private int numero;
    private String tipo;
    private String estado;
    private double precio;
    
    public Habitacion(int idHabitacion, int numero, String tipo, String estado, double precio){
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
}
