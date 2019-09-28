package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Nombre: David Fern�ndez Nieves
 * 2� DAM A, Repaso Java, PGV
 */

public class EntradaNumeros {

	private final static int MAX_NUMS = 20; // M�ximo 20 n�meros
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[MAX_NUMS];
		
		System.out.println("M�ximo " + MAX_NUMS + " n�meros");
		
		// Pedimos una vez
		System.out.print("Introduzca un numero: ");
		int n = scan.nextInt();
		nums[0] = n;
		int acc = 1;
		
		while( n != -1 && acc < MAX_NUMS ) {
			
			System.out.print("Introduzca un numero: ");
			n = scan.nextInt();
			
			if( n != -1 ) {  // El -1 no lo introducimos
				nums[acc] = n;	
				acc++;
			}
		}
		
		int[] array = Arrays.copyOf(nums, acc); // Redimensionamos el array para coger lo que queremos
		
		System.out.println("El mayor n�mero es: " + MathFunctions.maximo(array));
		System.out.println("El menor n�mero es: " + MathFunctions.minimo(array));
		System.out.println("La media de los n�meros es: " + MathFunctions.media(array));
		System.out.println("La suma de los n�meros es: " + MathFunctions.suma(array));
		MathFunctions.ordenarBurbuja(array); 
		MathFunctions.generarGr�fico(array, "Gr�fico n�meros entrada");

		scan.close();
	}

}
