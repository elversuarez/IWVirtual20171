package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Ciudad;


/**
 * Interface que me define los metodos permitidos para las Ciudades en 
 * el sistema
 * @author Elver Suárez Alzate -elver.suarez@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface CiudadDAO {
	
	/**
	 * Obtiene la lista de ciudades que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return lista de ciudades ordenada
	 * @throws MyException ocurre cuando hay problemas con la conexión a la BD
	 */
	public List<Ciudad> get() throws MyException;

}
