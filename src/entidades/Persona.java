
package entidades;


public abstract class Persona {
    private int id;
    private String nombre;
    private String telefono;
    private String documento;
    
    public Persona(){
        
    }
    
    public Persona(int id, String nombre, String telefono, String documento){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
}
