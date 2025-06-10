package quickSort;

public class QuickSortSecuencial {

	public static void quickSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particionar(arr, izquierda, derecha);
            quickSort(arr, izquierda, indiceParticion - 1);
            quickSort(arr, indiceParticion + 1, derecha);
        }
    }

    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }

        intercambiar(arr, i + 1, derecha);
        return i + 1;
    }

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
