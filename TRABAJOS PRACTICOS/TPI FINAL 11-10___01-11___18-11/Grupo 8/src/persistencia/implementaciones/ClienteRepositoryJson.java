package persistencia.implementaciones;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import modelo.Cliente;
import persistencia.Repository;

public class ClienteRepositoryJson implements Repository<Integer, Cliente> {

	private final ObjectMapper mapper = JsonMapper.builder()
	        .addModule(new JavaTimeModule())
	        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
	        .build();

	private final File archivo = new File("data/clientes.json");

	@Override
	public Map<Integer, Cliente> cargarTodos() throws IOException {
		if (!archivo.exists() || archivo.length() == 0) {
	        return new HashMap<Integer, Cliente>();
	    }
		
		JavaType tipoMap = mapper.getTypeFactory().constructMapType(Map.class, Integer.class, Cliente.class);

		return mapper.readValue(archivo, tipoMap);
	}

	@Override
	public void guardarTodos(Map<Integer, Cliente> clientes) throws IOException {
		archivo.getParentFile().mkdirs();
		mapper.writeValue(archivo, clientes);

	}
}
