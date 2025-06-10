package quickSort;

public class QuickSortSecuencial {

	public static void quickSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {// si la sublista tiene más de un elemento, se ordena
            
        	// Se obtiene el índice del pivote después de la partición
        	int indiceParticion = particionar(arr, izquierda, derecha);
        	// Llamada recursiva para ordenar la parte izquierda del pivote
        	quickSort(arr, izquierda, indiceParticion - 1);
        	// Llamada recursiva para ordenar la parte derecha del pivote
        	quickSort(arr, indiceParticion + 1, derecha);
        }
    }
	 // Método que realiza la partición del arreglo
    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];// Se elige el último elemento como pivote
        int i = izquierda - 1; // Índice del último elemento menor o igual al pivote

        
     // Recorre el subarreglo desde izquierda hasta antes del pivote
        for (int j = izquierda; j < derecha; j++) {
        	// Si el elemento actual es menor o igual al pivote
        	if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }
     // Coloca el pivote en su lugar final (después de los elementos menores)
        intercambiar(arr, i + 1, derecha);
     // Retorna la posición final del pivote para seguir dividiendo
        return i + 1;
    }
 // Método auxiliar que intercambia dos elementos en el arreglo
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
	
}
