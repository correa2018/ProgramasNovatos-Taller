/***********************************************************************
* Estudiantes.java
* Manuel Correa
* Tomado de Dean & Dean.
*
* Esta clase almacena y recupera datos de los estudiantes de un taller
***********************************************************************/

public class Estudiante
{
	private long cedula;
	private String nombre;
	private String apellido;
	
	//******************************************************************
	
	public Estudiante(long cedula, String nombre, String apellido)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//******************************************************************
	
	public long getCedula()
	{
		return cedula;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
} // Fin de la clase Estudiante.
