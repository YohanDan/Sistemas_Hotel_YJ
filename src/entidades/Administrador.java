
package entidades;


public class Administrador extends Persona {
    private boolean cargo;
    
    public Administrador(){
        
    }
    
    public Administrador(int id, String nombre, String telefono, String documento, boolean cargo){
        super(id, nombre, telefono, documento);
        this.cargo = cargo;
    }

    public boolean isCargo() {
        return cargo;
    }

    public void setCargo(boolean cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Administrador{" + "cargo=" + cargo + '}';
    }
}
