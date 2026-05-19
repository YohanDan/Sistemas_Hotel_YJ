
package datos.interfaces;

import java.util.List;


public interface ResimpleInterface<T> {
    public List<T> listar(String texto);
    public boolean insertar(T obj);
    public boolean validarDatosRegistro(String nombreCliente, String numHabitacion, String nombreRecepcionista);
    public int total();
}
