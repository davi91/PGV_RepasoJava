package ejercicios;

import java.util.Scanner;

/**
 * Nombre: David Fernández Nieves
 * 2º DAM A, Repaso Java, PGV
 */


public class MayorNumero {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce el primer número: ");
		int num1 = scan.nextInt();
		System.out.print("Introduce el segundo número: ");
		int num2 = scan.nextInt();
		
		if( num1 < num2 ) {
			System.out.println(String.format("%d es mayor que %d", num2, num1));
		} else if( num1 > num2 ){
			System.out.println(String.format("%d es mayor que %d", num1, num2));
		} else {
			System.out.println("Los dos números son iguales");
		}
		
		scan.close(); 

	}

}
