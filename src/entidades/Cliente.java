
package entidades;


public class Cliente extends Persona {
    private boolean tipoCliente;
    
    public Cliente(){
        
    }
    
    public Cliente(int id, String nombre, String telefono, String documento, boolean tipoCliente){
        super(id, nombre, telefono, documento);
        this.tipoCliente = tipoCliente;
    }

    public boolean isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "tipoCliente=" + tipoCliente + '}';
    }
}
