
package entidades;


public class Habitacion {
    private int idHabitacion;
    private String numero;
    private String tipo;
    private String estado;
    private double precio;
    
    public Habitacion(){
        
    }
    
    public Habitacion(int idHabitacion, String numero, String tipo, String estado, double precio){
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
}
