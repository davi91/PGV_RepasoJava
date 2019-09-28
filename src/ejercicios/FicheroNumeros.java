package ejercicios;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Nombre: David Fernández Nieves
 * 2º DAM A, Repaso Java, PGV
 */

public class FicheroNumeros {

	private final static int MAX_NUMS = 20; // Máximo 20 números
	
	public static void main(String[] args) {
		
		System.out.println("Leyendo del fichero enteros.txt.....");
		int[] array = cargarDatosFicheros("enteros.txt");
		
		if( array != null ) {
			
			System.out.println("El mayor número es: " + MathFunctions.maximo(array));
			System.out.println("El menor número es: " + MathFunctions.minimo(array));
			System.out.println("La media de los números es: " + MathFunctions.media(array));
			System.out.println("La suma de los números es: " + MathFunctions.suma(array));
			MathFunctions.generarGráfico(array, "Gráfico números fichero");
			MathFunctions.ordenarBurbuja(array);		// No nos hace falta devolver nada, los arrays se modifican dinámicamente
			guardarFichero("ordenados.txt", array);
			
		}
		
		
	}
	
	// Para visualizar el fichero en el explorador del proyecto una vez guardado en Eclipse hay que refrescar el proyecto
	public static void guardarFichero(String nombre, int[] array ) {
		
		FileOutputStream file = null;
		OutputStreamWriter out = null;
		BufferedWriter writer = null;
		
		try {
			
			// Aprovechamos la función toString del Array
			String arrayStr = Arrays.toString(array).replaceAll("[\\[\\]\\s]", "") // Usamos una expresión regular para quitar '[', ']' y espacios en blanco
													.replace(',', ';');
			
			file = new FileOutputStream(nombre); // Siempre se guardará en la raiz del proyecto
			out = new OutputStreamWriter(file, StandardCharsets.UTF_8); // Necesitamos guardarlo en una codificación estándar
			writer = new BufferedWriter(out);
			
			writer.write(arrayStr.toString()); // Podemos guardar un String completo, vamos a sustituir lo que tenga, no es especificado append en el constructor del file
			
		} catch (IOException e) {
			System.err.println("Error al guardar el fichero");
		} finally {
			
			try {
				
				if( writer != null ) {
					writer.close();
				}
				
				if( out != null ) {
					out.close();
				}
				
				if( file != null ) {
					file.close();
				}
				
			} catch (IOException e) {
				System.err.println("Error al cerrar el fichero");
			}
		}
	}
	
	public static int[] cargarDatosFicheros( String nombre ) {
		
		FileInputStream file = null;
		InputStreamReader in = null;
		BufferedReader data = null;
		
		try {
			
			int[] array = new int[MAX_NUMS];
			
			file = new FileInputStream("enteros.txt"); // Este archivo tiene que estar en la raiz del proyecto
			in = new InputStreamReader(file, StandardCharsets.UTF_8);
			data = new BufferedReader(in);
			
			int count = 0;
			String line;
			
			int n;
	
			// Leemos linea por linea, limpiamos y lo pasamos a entero, siempre vemos que no es -1
			while( count < MAX_NUMS &&  (n = ((line = data.readLine()) != null) ? Integer.parseInt(line.trim()) : -1) != -1 ) {
				array[count] = n;
				count++;
			}
			
			return Arrays.copyOf(array, count);  // Devolvemos nuestro array redimensionado
			
		} catch( FileNotFoundException e ) {
			System.err.println("No se encuentra enteros.txt en el sitio correcto");
		} catch( IOException e ) {
			System.err.println("Error al procesar el fichero"); // Por ejemplo, cuando no es un número lo que tenemos
			
		} finally {
			
			try {
				
				if( file != null )
					file.close();
				
				if( in != null ) {
					in.close();
				}
				
				if( data != null ) {
					data.close();
				}
			} catch (IOException e) {
				System.err.println("Error al cerrar el fichero");
			}
		}
		
		return null;
	}



}
