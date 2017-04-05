package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Inteface con los metodos del DAO para usuario
 * @author Elver Suárez Alzate - elver.suarez@udea.edu.co
 *
 */
public interface UsuarioDAO {
	
	/**
	 * Entrega la información de un usuario dado su login
	 * @param login login del usuario
	 * @return datos del usuario
	 * @throws MyException cuando hay un error consultando.
	 */
	public Usuario get(String login) throws MyException;

}
