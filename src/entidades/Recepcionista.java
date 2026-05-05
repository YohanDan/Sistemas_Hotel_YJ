
package entidades;


public class Recepcionista extends Persona {
    private String cargo;
    private String turno;
    
    public Recepcionista(int id, String nombre, int telefono, int documento, String cargo, String turno){
        super(id, nombre, telefono, documento);
        this.cargo = cargo;
        this.turno = turno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "cargo=" + cargo + ", turno=" + turno + '}';
    }
}
