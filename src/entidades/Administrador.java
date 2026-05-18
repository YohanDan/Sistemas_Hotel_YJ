
package entidades;


public class Administrador extends Persona {
    private String cargo;
    private String nivelAcceso;
    
    public Administrador(int id, String nombre, String telefono, String documento, String cargo, String nivelAcceso){
        super(id, nombre, telefono, documento);
        this.cargo = cargo;
        this.nivelAcceso = nivelAcceso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public String toString() {
        return "Administrador{" + "cargo=" + cargo + ", nivelAcceso=" + nivelAcceso + '}';
    }
}
