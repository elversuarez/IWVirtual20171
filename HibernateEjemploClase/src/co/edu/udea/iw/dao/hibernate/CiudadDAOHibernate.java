package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOHibernate implements CiudadDAO {

	@Override
	public List<Ciudad> get() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		try{
			session = DataSource.getInstance().getSesssion();
			
			criteria = session.createCriteria(Ciudad.class);
			
			ciudades = criteria.list();
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las ciudades", e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return ciudades;
		
	}

	@Override
	public Ciudad get(Long codigo) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Ciudad ciudad = null;
		
		//SELECT * FROM Ciudades where Codigo = ?
		
		try{
			session = DataSource.getInstance().getSesssion();
			
			///con criteria
//			criteria = session.createCriteria(Ciudad.class);
//			criteria.add(Restrictions.eq("codigo", codigo));
//			ciudad = (Ciudad)criteria.uniqueResult();
			
			//Utilizando el metodo get
			ciudad = (Ciudad)session.get(Ciudad.class, codigo);
			
			//Utilizando el metodo load
//			ciudad = (Ciudad)session.load(Ciudad.class, codigo);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las ciudades", e);
		}finally{
//			if(session != null){
//				session.close();
//			}
		}
		
		return ciudad;
		
	}

	@Override
	public void insert(Ciudad ciudad) throws MyException {

		Session session = null;
		Transaction tx = null;
		
		try{
			
			session = DataSource.getInstance().getSesssion();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando la ciudad", e);
		}finally{
			if(session != null){
			session.close();
			}
		}
	}
		
		@Override
		public void update(Ciudad ciudad) throws MyException {

			Session session = null;
			Transaction tx = null;
			
			try{
				
				session = DataSource.getInstance().getSesssion();
				tx = session.beginTransaction();
				session.update(ciudad);
				tx.commit();
				
			}catch(HibernateException e){
				throw new MyException("Ocurrio un error modificando la ciudad", e);
			}finally{
				if(session != null){
					session.close();
				}
			}
		}
		
		@Override
		public void delete(Ciudad ciudad) throws MyException {

			Session session = null;
			Transaction tx = null;
			
			try{
				
				session = DataSource.getInstance().getSesssion();
				tx = session.beginTransaction();
				session.delete(ciudad);
				tx.commit();
				
			}catch(HibernateException e){
				throw new MyException("Ocurrio un error eliminando la ciudad", e);
			}finally{
				if(session != null){
					session.close();
				}
			}
		}
		

}
