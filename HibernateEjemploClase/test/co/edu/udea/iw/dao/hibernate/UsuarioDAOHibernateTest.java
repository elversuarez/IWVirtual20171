package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOHibernateTest {

	@Test
	public void testGet() {
		Usuario usuario = null;
		UsuarioDAO usuarioDAO = null;
		
		try{
			usuarioDAO = new UsuarioDAOHibernate();
			
			usuario = usuarioDAO.get("elver");
			
			System.out.println(usuario.getNombres() + " " + usuario.getRol().getNombre());
			
			assertTrue(usuario != null);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
