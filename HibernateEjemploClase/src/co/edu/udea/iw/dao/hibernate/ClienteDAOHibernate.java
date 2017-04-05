package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.PieChart.Data;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOHibernate implements ClienteDAO {

	@Override
	public List<Cliente> get() throws MyException {
		
		Session session = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		Criteria criteria = null;
		
		try{
			session = DataSource.getInstance().getSesssion();
			criteria = session.createCriteria(Cliente.class);
			
			criteria.addOrder(Order.asc("fechaCreacion"));
			
			
			clientes = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando los clientes", e);
		}
		
		return clientes;
	}

	@Override
	public void insert(Cliente cliente) throws MyException {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = DataSource.getInstance().getSesssion();
			transaction = session.beginTransaction();
			
			session.save(cliente);
			
			transaction.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando el cliente", e);
		}
	}

	@Override
	public Cliente get(String cedula) throws MyException {
		Session session = null;
		Cliente cliente = null;

		
		try{
			session = DataSource.getInstance().getSesssion();
		
			cliente = (Cliente)session.get(Cliente.class, cedula);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando los clientes", e);
		}
		
		return cliente;
	}

	@Override
	public void update(Cliente cliente) throws MyException {
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = DataSource.getInstance().getSesssion();
			transaction = session.beginTransaction();
			
			session.update(cliente);
			
			transaction.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error actualizando el cliente", e);
		}
		
	}

}
