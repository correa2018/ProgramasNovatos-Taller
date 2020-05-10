/***********************************************************************
* ControladorBusquedaSyB.java
* Manuel Correa
*
* Este programa evalua la busqueda secuencial y binaria para un mismo 
* arreglo de datos.
***********************************************************************/

import java.util.Scanner;

public class ControladorBusquedaSyB
{
	public static void main(String[] args)
	{
		int numeroDeElementos;
		int numero; 			//Numero a buscar en el arreglo.
		char continuar;			//Variable de control del ciclo do.				
		long tiempoInicial;
		long tiempoFinal;
		double tiempoDeEjecucion;
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Programa que compara la eficiencia de la " +
			"buqueda secuencial vs Binaria");
		
		System.out.print("\nIntroduzca el numero de elementos a evaluar:");
		numeroDeElementos = stdIn.nextInt();
		stdIn.nextLine();
		
		
		BusquedaSyB busqueda = new BusquedaSyB(numeroDeElementos);
		
		busqueda.imprimirRangoDelArreglo();
		
		do
		{
			System.out.print("\nIntroduzca el numero a buscar: ");
			numero = stdIn.nextInt();
			stdIn.nextLine();
			
			tiempoInicial = System.nanoTime();					
			if(busqueda.busquedaSecuencial(numero))
			{
				System.out.println("\nBusqueda secuencial exitosa");			
			}
			else
			{
				System.out.println("\nFallo la busqueda secuencia, no esta en el rango");
			}
			tiempoFinal = System.nanoTime();
			tiempoDeEjecucion = (double)( tiempoFinal - tiempoInicial)/1000000.0;		
			
			System.out.println("Tiempo de busqueda secuencial = " + 
				tiempoDeEjecucion + "ms");
			
			tiempoInicial = System.nanoTime();	
			if(busqueda.busquedaBinaria(numero))
			{
				System.out.println("\n\nBusqueda Binaria exitosa");			
			}
			else
			{
				System.out.println("\n\nFallo la busqueda Binaria, no esta en el rango");
			}
			tiempoFinal = System.nanoTime();
			tiempoDeEjecucion = (double)( tiempoFinal - tiempoInicial)/1000000.0;		
			
			System.out.println("Tiempo de busqueda Binaria = " + 
				tiempoDeEjecucion + "ms");
			
			System.out.print("\nDesea realizar otra busqueda (Si/No): ");
			continuar = stdIn.nextLine().charAt(0);
		} while( continuar == 's' || continuar == 'S');
		
	} //Fin del main
} //Fin de la clase ControladorBusquedaSyB.
