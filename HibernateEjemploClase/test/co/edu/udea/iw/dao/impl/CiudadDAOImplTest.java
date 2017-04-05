package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.hibernate.CiudadDAOHibernate;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImplTest {

	@Test
	public void testGet() {
		
		CiudadDAO ciudadDao = null;
		List<Ciudad> ciudades = null;
		
		try{
			ciudadDao = new CiudadDAOHibernate();
			ciudades = ciudadDao.get();
			
			for(Ciudad ciudad: ciudades){
				System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
			}
			
			assertTrue(ciudades.size() > 0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		CiudadDAO ciudadDao = null;
		Ciudad ciudad = null;
		
		try{
			ciudadDao = new CiudadDAOHibernate();
			ciudad = ciudadDao.get(100l);
			
			assertNotNull(ciudad);
			
			System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		CiudadDAO ciudadDao = null;
		Ciudad ciudad = new Ciudad();
		
		try{
			
			ciudad.setCodigo(105l);
			ciudad.setNombre("Villavicencio");
			ciudad.setCodigoArea("07");
			
			ciudadDao = new CiudadDAOHibernate();
			ciudadDao.insert(ciudad);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
