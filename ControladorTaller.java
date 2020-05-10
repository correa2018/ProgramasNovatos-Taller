/***********************************************************************
* ControladorTaller.java
* Manuel Correa
* Tomado de Dean & Dean
*
* Esto controla la clase Taller.
***********************************************************************/

import java.util.Scanner;

public class ControladorTaller
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
	
		Taller curso = new Taller(2);
		
		// Datos de un estudiante.
		long cedula;
		String nombre;
		String apellido;
		int opcion;
		int busqueda;
		
		int insertarEstudiante;
		
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
					System.out.print("Ingrese el número de Cédula: ");
					cedula = stdIn.nextLong();
					stdIn.nextLine();
					
					insertarEstudiante = curso.buscarEstudianteBinaria(cedula);
					
					if (insertarEstudiante == -1)
					{
						System.out.print("Ingrese el nombre: ");
						nombre = stdIn.nextLine();
						System.out.print("Ingrese el apellido: ");
						apellido = stdIn.nextLine();
					
						curso.addEstudiante(cedula, nombre, apellido);
					}
					else
					{
						System.out.println("El estudiante esta registrado\n");
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
			System.out.println();
		} while(opcion != 4);
	} //Fin del main.
} //Fin de la clase ControladorTaller.
			
			
			
