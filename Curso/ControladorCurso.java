/***********************************************************************
* ControladorCurso.java
* Manuel Correa
* Tomado de Dean & Dean.
*
* Esta clase crea un objeto curso y ingresa y busca estudiantes en particular.
***********************************************************************/

import java.util.Scanner;

public class ControladorCurso
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		
		int numeroDeCupos;
		long cedula;
		String nombreDelCurso;
		String nombre;
		String apellido;
		int opcion;
		int busqueda;
		
		System.out.println("Programa que Crea y matricula estudiantes de" +
			" un curso");
		System.out.println();
		
		System.out.print("Ingrese el nombre del Curso: ");
		nombreDelCurso = stdIn.nextLine();
		
		System.out.print("Ingrese el numero de cupos: ");
		numeroDeCupos = stdIn.nextInt();
		stdIn.nextLine();
		
		long[] cedulas = new long[numeroDeCupos];
		String[] nombres = new String[numeroDeCupos];
		String[] apellidos = new String[numeroDeCupos];
		
		Curso curso = new Curso(nombreDelCurso, numeroDeCupos, cedulas,
			nombres, apellidos);
			
		do
		{
			System.out.println("********* Menú Principal **************");
			System.out.println("1.- Ingresar un estudiante");
			System.out.println("2.- Buscar un estudiante");
			System.out.println("3.- Imprimir Listado");
			System.out.println("4.- Salir");
			System.out.print("Ingrese su opción: ");
			opcion = stdIn.nextInt();
			stdIn.nextLine();
			System.out.println();
			
			switch (opcion)
			{
				case 1: 
					if (curso.cursoLLeno())
					{
						System.out.println("No hay cupos en el curso");
						System.out.println();
					}
					else
					{
						System.out.print("Ingrese el número de Cédula: ");
						cedula = stdIn.nextLong();
						stdIn.nextLine();
						if(curso.buscarEstudianteBinaria(cedula) != -1)
						{
							System.out.println("El estudiante ya esta registrado");
						}
						else
						{
							System.out.print("Ingrese el nombre: ");
							nombre = stdIn.nextLine();
							System.out.print("Ingrese el apellido: ");
							apellido = stdIn.nextLine();
							curso.setEstudiante(cedula, nombre, apellido);							
						}						
					}
					System.out.println();
					break;
					case 2: 
						if(curso.cursoVacio())
						{
							System.out.println("No Existen estudiantes registrados");
						}
						else
						{
							System.out.print("Ingrese el número de Cédula: ");
							cedula = stdIn.nextLong();
							stdIn.nextLine();
							
							busqueda = curso.buscarEstudianteBinaria(cedula);								
							
							if(busqueda == -1)
							{
								System.out.println("El estudiante no se encuentra registrado");
							}
							else
							{
								curso.imprimirEstudiante(busqueda);
							}
						}
						System.out.println();
						break;
					case 3:
						if(curso.cursoVacio())
						{
							System.out.println("No hay estudiantes registrados\n");
						}
						else
						{
							curso.imprimirListado();
						}
						break;
					case 4:
						System.out.println("Saliendo del programa");
						break;
							
			}
		} while(opcion != 4);
	}
}
		
		
