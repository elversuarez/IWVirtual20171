package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * Encargada de realizar conexiones a la baase de datos
 * @author Elver Su�rez Alzate -elver.suarez@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class DataSource {
	
	public Connection getConnection() throws MyException {
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "clase";
		String pws = "claseingenieraweb*";
		String consulta = "SELECT * FROM Ciudades";
		Connection con = null;
		try{
			//Va a cargar en el class Loader de la aplicaci�n el 
			//driver de la base de datos que vamos a acceder.
			Class.forName("com.mysql.jdbc.Driver");
			//Establece conexi�n con la base de datos
			//Solicita 3 atributos
			//Url conexi�n a la base de datos
			//Usuario de bd con el que se va a conectar
			//Contrase�a del usario
			con = DriverManager.getConnection(url, usuario, pws);
		}catch(ClassNotFoundException e){
			throw new MyException("El driver de conexi�n a la base de datos no ha sido encontrado", e);
		}catch (SQLException e) {
			throw new MyException("Ha ocurrido un error estableciendo conexi�n con la base de datos", e);
		}
		
		return con;
	}

}
