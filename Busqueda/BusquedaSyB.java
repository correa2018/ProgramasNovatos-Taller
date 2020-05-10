/***********************************************************************
* BusquedaSyB.java
* Manuel Correa
*
* Este programa realiza una busqueda sencuencial en un arreglo de 100000
* elementos ordenados de menora mayor.
***********************************************************************/

public class BusquedaSyB
{
	private int[] arreglo;
	private int numeroDeElementos;

		
	//******************************************************************
	
	public BusquedaSyB(int numeroDeElementos)
	{
		this.numeroDeElementos = numeroDeElementos;
		arreglo = new int[numeroDeElementos];
		for (int i=0; i<numeroDeElementos; i++)
		{
			arreglo[i] = (i + 1);
		}
	}
	
	
	//******************************************************************
	
	public void imprimirRangoDelArreglo()
	{
		System.out.println("Rango del Arreglo: de " + arreglo[0] + " a " +
			arreglo[numeroDeElementos-1] + ".");
	} //Fin de imprimir arreglo.
	
	//******************************************************************
	
	public boolean busquedaSecuencial(int numero)
	{
		for(int i=0; i<numeroDeElementos; i++)
		{
			if(arreglo[i] == numero)
			{
				return true;
			}
		}
		return false;
	} //Fin de busqueda secuencial.
	
	//******************************************************************
	
	public boolean busquedaBinaria(int numero)
	{
		int indiceMedio;
		long valorMedio;
		int	indiceBajo = 0;
		int indiceAlto = numeroDeElementos -1;
		
		while (indiceBajo <= indiceAlto)
		{
			indiceMedio = (indiceBajo + indiceAlto) / 2;
			valorMedio = arreglo[indiceMedio];
			
			if(numero == valorMedio)
			{
				return true;
			}
			else if (numero < valorMedio) 
			{
				indiceAlto = indiceMedio -1;
			}
			else
			{
				indiceBajo = indiceMedio + 1;
			}
		}
		return false;
	}//Fin de Busqueda binaria.
}
