package test;

import quickSort.QuickSortConcurrente;


public class TestQuickSortConcurrente {

	public static void main(String[] args) {
			
		
		    int[] datos = generarArrayAleatorio(10000);
	        long inicio = System.currentTimeMillis();
	        QuickSortConcurrente.quickSortConcurrente(datos, 0, datos.length - 1);
	        long fin = System.currentTimeMillis();
	        System.out.println("Concurrente Tiempo de ejecución: " + (fin - inicio) + " ms");


	    }

	    private static int[] generarArrayAleatorio(int tamaño) {
	        int[] arr = new int[tamaño];
	        for (int i = 0; i < tamaño; i++) {
	            arr[i] = (int) (Math.random() * 10000);
	        }
	        return arr;
	    }


}
