package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public interface ClienteDAO {
	
	public List<Cliente> get() throws MyException;
	
	public void insert(Cliente cliente) throws MyException;
	
	public Cliente get(String cedula) throws MyException;
	
	public void update(Cliente cliente) throws MyException;

}
