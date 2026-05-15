
package entidades;


public abstract class Persona {
    private int id;
    private String nombre;
    private int telefono;
    private int documento;
    
    public Persona(){
        
    }
    
    public Persona(int id, String nombre, int telefono, int documento){
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
}
