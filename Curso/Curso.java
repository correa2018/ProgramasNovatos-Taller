/***********************************************************************
* Curso.java
* Manuel Correa
* Tomado de Dean & Dean
*
* Esta clase representa un curso particular de una escuela.
***********************************************************************/

public class Curso
{
	private String nombreDelCurso;
	private long[] cedulas;
	private String[] nombres;
	private String[] apellidos;
	private int numeroDeEstudiantes;
	private int numeroDeCupos;
	
	//******************************************************************
	
	public Curso(String nombreDelCurso, int numeroDeCupos, long[] cedulas,
		String[] nombres, String[] apellidos)
	{
		this.nombreDelCurso = nombreDelCurso;
		this.numeroDeCupos = numeroDeCupos;
		this.cedulas = cedulas;
		this.apellidos = apellidos;
		this.nombres = nombres;
	} //Fin del constructor.
	
	//******************************************************************
	
	// Este método introduce los datos de cada estudiante inscrito.
	public void setEstudiante(long cedula, String nombre, String apellido)
	{
		int indice = posicionDeDesplazamiento(cedula);
		
		cedulas[indice] = cedula;
		nombres[indice] = nombre;
		apellidos[indice] = apellido;
		numeroDeEstudiantes++;
	}
	
	//******************************************************************
	
	//Este método devuelve el índice del número de cedula encontrada 0  
	//-1 si no encontró la identificación. BusquedaSecuencial.
	
	public int buscarEstudianteSecuencial(long cedula)
	{		
		for(int i=0; i<numeroDeEstudiantes; i++)
		{
			if(cedulas[i] == cedula)
			{
				return i;
			}
		} //Fin del for.
		return -1;
	} // Fin de buscarEstudiante.
	
	//*****************************************************************
	//Este método tomado de Dean & Dean, ejecuta una busqueda binaria.
	
	public int buscarEstudianteBinaria(long cedula)
	{
		int indiceMedio;
		long valorMedio;
		int	indiceBajo = 0;
		int indiceAlto = numeroDeEstudiantes -1;
		
		while (indiceBajo <= indiceAlto)
		{
			indiceMedio = (indiceBajo + indiceAlto) / 2;
			valorMedio = cedulas[indiceMedio];
			
			if(cedula == valorMedio)
			{
				return indiceMedio;
			}
			else if (cedula < valorMedio) 
			{
				indiceAlto = indiceMedio -1;
			}
			else
			{
				indiceBajo = indiceMedio + 1;
			}
		}
		return -1;
	}
				
	//******************************************************************
	
	// Este método imprime un estudiante en particular.
	
	public void imprimirEstudiante(int i)
	{
		System.out.println("Apellido: " + apellidos[i]);
		System.out.println("Nombre: " + nombres[i]);
	}
	
	//******************************************************************
	
	// Este método imprime el listado de estudiantes.
	
	public void imprimirListado()
	{
		final String ENCABEZADO = "%-10s%1s%25s%1s%25s\n";
		final String LISTADO = "%-10d%1s%25s%1s%25s\n";

		System.out.printf(ENCABEZADO, "Cédula", "|", "Apellido", "|", "Nombre");
		System.out.printf(ENCABEZADO, "----------","|", "-------------------------","|",
		 "-------------------------");
		
		for(int i=0; i<numeroDeEstudiantes; i++)
		{
			System.out.printf(LISTADO,cedulas[i], "|", apellidos[i], "|", nombres[i]);
		}
		System.out.println();
	}	
	
	//******************************************************************
	
	//Este método devuelve si es curso esta lleno o no.
	
	public boolean cursoLLeno()
	{
		if (numeroDeCupos == numeroDeEstudiantes) return true;
		return false;
	}
	
	//******************************************************************
	// Este método devuelve si la lista esta vacia.
	
	public boolean cursoVacio()
	{
		if(numeroDeEstudiantes == 0) return true;
		return false;
	}
	
	//******************************************************************
	// Este método devuelve la posición de inserción del Estudiante.
	
	public int posicionDeDesplazamiento(long cedula)
	{		
		if (cursoVacio()) return 0;
		
		int i=0;
		while( cedula > cedulas[i])
		{
			i++;
			if (i == numeroDeEstudiantes) return numeroDeEstudiantes;
		}
		
		for(int j=numeroDeEstudiantes; j>i; j--)
		{
			cedulas[j] = cedulas[j-1];
			nombres[j] = nombres[j-1];
			apellidos[j] = apellidos[j-1];			
		}		
		return i;
	} // Fin de posicionDeDesplazamiento.	
		
} //Fin de la clase Curso.
