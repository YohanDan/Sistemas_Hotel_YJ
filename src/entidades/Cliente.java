
package entidades;


public class Cliente extends Persona {
    private String tipoCliente;
    
    public Cliente(int id, String nombre, int telefono, int documento, String tipoCliente){
        super(id, nombre, telefono, documento);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "tipoCliente=" + tipoCliente + '}';
    }
}
