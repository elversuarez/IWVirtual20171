package co.edu.udea.iw.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOHibernate implements UsuarioDAO {

	@Override
	public Usuario get(String login) throws MyException {
		
		Session session = null;
		Usuario usuario = null;
		
		try{
			session = DataSource.getInstance().getSesssion();
			
			usuario = (Usuario)session.get(Usuario.class, login);
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el usuario", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return usuario;
		
	}

}
