/***********************************************************************
* Taller.java
* Manuel Correa
* Tomado de Dean & Dean.
*
* Esta clase almacena los estudiantes que cursan un taller en particular
***********************************************************************/

class Taller
{
	private Estudiante[] estudiantes; //contiene los estudiantes matriculados
	private int numeroDeEstudiantes = 0;

	//******************************************************************
	
	public Taller(int tamanioInicial)
	{
		estudiantes = new Estudiante[tamanioInicial];
	} //Fin del constructor Taller.

	//******************************************************************
	
	public void addEstudiante(long cedula, String nombre, String apellido)
	{
		int indice = posicionDeDesplazamiento(cedula);
				
		estudiantes[indice] = new Estudiante(cedula, nombre,apellido);
		numeroDeEstudiantes++;		
	} //Fin de addEstudiante.
	
	//******************************************************************
	
	public boolean cursoVacio()
	{
		if (numeroDeEstudiantes == 0) return true;
		return false;
	}
	
	//******************************************************************
	
	// Este método imprime un estudiante en particular.
	
	public void imprimirEstudiante(int i)
	{
		System.out.println("Apellido: " + estudiantes[i].getApellido());
		System.out.println("Nombre: " + estudiantes[i].getNombre());
	}
	
	//******************************************************************	
	
	//Este metodo imprime un listado de los estudiantes.
	
	public void imprimirListado()
	{
		final String ENCABEZADO = "%-10s%1s%25s%1s%25s\n";
		final String LISTADO = "%-10d%1s%25s%1s%25s\n";
	
		System.out.printf(ENCABEZADO, "Cédula", "|", "Apellido", "|", "Nombre");
		System.out.printf(ENCABEZADO, "----------","|", "-------------------------","|",
			"-------------------------");
		
		for (int i=0; i<numeroDeEstudiantes; i++)
		{
			
			System.out.printf(LISTADO,estudiantes[i].getCedula(), "|",
				estudiantes[i].getApellido(), "|", 
				estudiantes[i].getNombre());
		}
	} // fin de imprimirListado.
	
	//******************************************************************

	// Este método busca si un estudiante esta matriculado en el curso
	// a partir de un número de cédula dado, en virtud que es único para
	// cada estudiante.
	
	public int buscarEstudianteSecuencial(long cedula)
	{
		for (int i=0; i<numeroDeEstudiantes; i++)
		{
			if(estudiantes[i].getCedula() == cedula)
			{
				return i;
			}
		} // Fin del for.
		
		return -1;
	} // Fin de buscarEstudiante.
	
	//******************************************************************
	
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
			valorMedio = estudiantes[indiceMedio].getCedula();
			
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
	
	// Este método devuelve la posición de inserción del Estudiante.
	
	private int posicionDeDesplazamiento(long cedula)
	{	
		if (numeroDeEstudiantes == estudiantes.length)
		{
			duplicarLongitudDelArreglo();
		}
			
		if (numeroDeEstudiantes == 0) return 0;
		
		int i=0;
		while( cedula > estudiantes[i].getCedula())
		{
			i++;
			if (i == numeroDeEstudiantes) return numeroDeEstudiantes;
		}
		
		
		
		for(int j=numeroDeEstudiantes; j>i; j--)
		{
			estudiantes[j] = estudiantes[j-1];
		
		}		
		return i;
	} // Fin de posicionDeDesplazamiento.
	
	//******************************************************************
	
	// Este método duplica la longitud del arreglo.
	
	private void duplicarLongitudDelArreglo()
	{
		Estudiante[] estudiantes2 = new Estudiante[ 2 * estudiantes.length];
		System.arraycopy(estudiantes, 0, estudiantes2, 0, estudiantes.length);
		estudiantes = estudiantes2;
	} // Fin de duplicarLongitudDelArreglo.
} // Fin de la clase Taller.
