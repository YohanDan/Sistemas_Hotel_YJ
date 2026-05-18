
package datos.interfaces;

import java.util.List;


public interface HabimpleInterface<T> {
    public List<T> listar(String tipo, String estado);
    
}
