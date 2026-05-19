
package entidades;


public class Reserva {
    private int idReserva;
    private String numHabitacion;
    private String nomCliente;
    private String nomRecepcionista;
    private String tipo;
    private String estado;
    
    public Reserva(){
        
    }
    
    public Reserva(int idReserva, String numHabitacion, String nomCliente, String nomRecepcionista, String tipo, String estado){
        this.idReserva = idReserva;
        this.numHabitacion = numHabitacion;
        this.nomCliente = nomCliente;
        this.nomRecepcionista = nomRecepcionista;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getNomRecepcionista() {
        return nomRecepcionista;
    }

    public void setNomRecepcionista(String nomRecepcionista) {
        this.nomRecepcionista = nomRecepcionista;
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

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", numHabitacion=" + numHabitacion + ", nomCliente=" + nomCliente + ", nomRecepcionista=" + nomRecepcionista + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
}
