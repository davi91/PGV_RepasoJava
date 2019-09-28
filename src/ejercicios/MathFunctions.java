package ejercicios;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Nombre: David Fernández Nieves
 * 2º DAM A, Repaso Java, PGV
 */

public class MathFunctions {

	public static void ordenarBurbuja( int[] arr ) {
		
		int it = 0;
		System.out.print(" Original: ");
		showArray(arr);
		
		for( int i = 1; i < arr.length; i++ ) {
			
			// Empezamos por length - 1, y cada vez tengo que comprobar menos
			for( int j = 0; j < arr.length - i; j++ ) {
				
				// Compruebo hasta el siguiente
				if( arr[j] > arr[j+1] ) {
					
					// Lo vamos colocando
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
				
				showArray(arr);
				it++;
			}
		}
		
		System.out.println("Nº iteraciones: " + it);
	}
	
	public static void showArray(int[] arr) {
		
		System.out.print(" [ " );
		int k = 0;
		for( k = 0; k < arr.length - 1; k++ ) {
			System.out.print(arr[k] + ", ");
		}
		
		if( arr.length > 1 )
			System.out.print(arr[k] + " ]\n ");
		else 
			System.out.print("]\n");
	}
	
	public static int maximo(int[] arr) {
		
		int r = arr[0];
		for( int i = 1; i < arr.length; i++ ) {
			
			if( arr[i] > r ) {
				r = arr[i];
			}
		}
		
		return r;		
	}
	
	public static int minimo(int[] arr) {
		
		int min = arr[0];
		for( int i = 1; i < arr.length; i++ ) {
			
			if( arr[i] < min ) {
				min = arr[i];
			}
		}
		
		return min;		
	}
	
	public static int media(int[] arr) {
		
		int media = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			media += arr[i];
		}
		
		return (media/arr.length);
	}
	
	public static int suma(int[] arr) {
		
		int suma = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			suma += arr[i];
		}
		
		return suma;
	}
	
	public static void generarGráfico(int[] nums, String title) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Gráficos de números");
		frame.setSize(512, 512);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for( int i = 0; i < nums.length; i++)
			dataset.addValue(nums[i], "Row "+i, "Column "+i);
		
		JFreeChart chart = ChartFactory.createBarChart(
				  title,
				  "Índices",
				  "Valores",
				  dataset,
				  PlotOrientation.VERTICAL,
				  true,
				  true,
				  true
				);
		
		ChartPanel chartPanel = new ChartPanel(chart, false);
		frame.setContentPane(chartPanel);
		frame.setVisible(true);			
		
	}
	
}
