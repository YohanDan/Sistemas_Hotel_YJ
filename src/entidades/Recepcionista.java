
package entidades;


public class Recepcionista extends Persona {
    private boolean turno;
    
    public Recepcionista(){
        
    }
    
    public Recepcionista(int id, String nombre, String telefono, String documento, boolean turno){
        super(id, nombre, telefono, documento);
        this.turno = turno;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "turno=" + turno + '}';
    }
    
}
