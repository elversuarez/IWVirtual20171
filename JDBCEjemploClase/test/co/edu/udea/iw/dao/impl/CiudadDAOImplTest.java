package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImplTest {

	@Test
	public void testGet() {
		
		CiudadDAO ciudadDao = null;
		List<Ciudad> ciudades = null;
		
		try{
			ciudadDao = new CiudadDAOImpl();
			ciudades = ciudadDao.get();
			
			for(Ciudad ciudad: ciudades){
				System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
			}
			
			assertTrue(ciudades.size() > 0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
