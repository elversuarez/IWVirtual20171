package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Ciudad;


/**
 * Interface que me define los metodos permitidos para las Ciudades en 
 * el sistema
 * @author Elver Su�rez Alzate -elver.suarez@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface CiudadDAO {
	
	/**
	 * Obtiene la lista de ciudades que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return lista de ciudades ordenada
	 * @throws MyException ocurre cuando hay problemas con la conexi�n a la BD
	 */
	public List<Ciudad> get() throws MyException;
	
	/**
	 * Obtiene la informaci�n de una ciudad dado su codigo
	 * @param codigo codigo de la ciudad
	 * @return objeto Ciudad con la informaci�n almacenada
	 * @throws MyException ocurre cuando hay un error consultando la informaci�n.
	 */
	public Ciudad get(Long codigo) throws MyException;
	
	
	/**
	 * Almacena los datos de una ciudad en la base de datos
	 * @param ciudad objeto {@link Ciudad} con la informaci�n a almacenar
	 * @throws MyException cuando hay un error almacenando
	 */
	public void insert(Ciudad ciudad) throws MyException;
	
	/**
	 * Modifica los datos de una ciudad en la base de datos
	 * @param ciudad objeto {@link Ciudad} con la informaci�n a modificar
	 * @throws MyException cuando hay un error modificando
	 */
	public void update(Ciudad ciudad) throws MyException;
	
	/**
	 * Elimina los datos de una ciudad en la base de datos
	 * @param ciudad objeto {@link Ciudad} con la informaci�n a eliminar
	 * @throws MyException cuando hay un error eliminando
	 */
	public void delete(Ciudad ciudad) throws MyException;

}
