package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

/**
 * Encargada de realizar conexiones a la baase de datos
 * @author Elver Suárez Alzate -elver.suarez@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class DataSource {
	
	private static DataSource instance = null;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	
	private DataSource(){
		
	}
	
	public static DataSource getInstance(){
		if(instance == null){
			instance = new DataSource();
		}
		
		return instance;
	}
	
	/**
	 * Entrega una sesión activa a la base de datos basadas en la configuración  de 
	 * Hibernate
	 * @return objeto de tipo Session
	 * @throws MyException ocurre cuando hay errores de configuración
	 */
	public Session getSesssion() throws MyException{
		
		try{
			if(factory == null){
				conf.configure("co/edu/udea/iw/dao/conf.cfg.xml");
				
				factory = conf.buildSessionFactory();
			}
			
			return factory.openSession();
		}catch(HibernateException e){
			throw new MyException("Ha ocurrio un error estableciendo conexión a la base de datos", e);
		}
		
	}

}
