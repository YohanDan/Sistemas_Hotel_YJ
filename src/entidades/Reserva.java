
package entidades;


public class Reserva {
    private int idReserva;
    private String estado;
    
    public Reserva(int idReserva, String estado){
        this.estado = estado;
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", estado=" + estado + '}';
    }
}
