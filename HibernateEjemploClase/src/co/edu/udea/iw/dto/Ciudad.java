package co.edu.udea.iw.dto;

/**
 * DTO para la tabla Ciudad
 * @author Elver Su�rez Alzate -elver.suarez@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class Ciudad {

	private Long codigo;
	private String nombre;
	private String codigoArea;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

}
