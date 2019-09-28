package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Nombre: David Fernández Nieves
 * 2º DAM A, Repaso Java, PGV
 */

public class EntradaNumeros {

	private final static int MAX_NUMS = 20; // Máximo 20 números
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[MAX_NUMS];
		
		System.out.println("Máximo " + MAX_NUMS + " números");
		
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
		
		System.out.println("El mayor número es: " + MathFunctions.maximo(array));
		System.out.println("El menor número es: " + MathFunctions.minimo(array));
		System.out.println("La media de los números es: " + MathFunctions.media(array));
		System.out.println("La suma de los números es: " + MathFunctions.suma(array));
		MathFunctions.ordenarBurbuja(array); 
		MathFunctions.generarGráfico(array, "Gráfico números entrada");

		scan.close();
	}

}
