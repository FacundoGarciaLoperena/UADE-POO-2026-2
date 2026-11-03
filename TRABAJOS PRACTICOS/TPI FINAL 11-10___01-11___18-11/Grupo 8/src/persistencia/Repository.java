package persistencia;

import java.util.List;

public interface Repository<T, ID> {

    void agregar(T entidad);

    List<T> obtenerTodos();

    T obtenerPorId(ID id);

    void modificar(T entidad);

    void eliminar(ID id);

    void eliminarTodos();
}