package co.edu.udea.iw.dao.hibernate;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Direccion;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOHibernateTest {

	//@Test
	public void testInsert() {
		
		ClienteDAO clienteDAO = null;
		Cliente cliente = null;
		Usuario usuarioCrea = null;
		
		try{
			cliente = new Cliente();
			cliente.setCedula("98472733");
			cliente.setNombres("Elver");
			cliente.setApellidos("Suárez Alzate");
			cliente.setEmail("elver.suarez@udea.edu.co");
			
			usuarioCrea = new Usuario();
			usuarioCrea.setLogin("elver");
			
			cliente.setUsuarioCrea(usuarioCrea);
			cliente.setFechaCreacion(new Date());
			cliente.setEliminado(Boolean.FALSE);
			
			clienteDAO = new ClienteDAOHibernate();
			
			clienteDAO.insert(cliente);
			
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void getUnoTest(){
		ClienteDAO clienteDAO = null;
		Cliente cliente = null;
		
		try{
			clienteDAO = new ClienteDAOHibernate();
			
			cliente = clienteDAO.get("98472733");
			
			System.out.println(cliente.getNombres() + " " + cliente.getApellidos() + ": " + cliente.getUsuarioCrea().getNombres());
			
			for(Direccion direccion : cliente.getDirecciones()){
				System.out.println(direccion.getDireccion());
			}
			
			Assert.assertNotNull(cliente);
		}catch(MyException e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
