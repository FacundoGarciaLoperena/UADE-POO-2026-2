package persistencia;

import java.util.Map;

import excepciones.ClienteNoEncontradoException;
import modelo.Cliente;

public interface ClienteRepository extends Repository<Cliente, Integer> {

    Cliente obtenerPorId(int id) throws ClienteNoEncontradoException;
    
    Map<Integer,Cliente> obtenerClientesActivos();
    
    Map<Integer,Cliente> obtenerClientesMorosos();
    
    
}
