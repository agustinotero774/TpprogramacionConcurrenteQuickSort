package quickSort;

public class QuickSortConcurrente {

    private static final int UMBRAL = 20000; //Controla la creacion de hilos con el valor umbral

    public static void quickSortConcurrente(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) { // Condición base de la recursión
            int indiceParticion = particionar(arr, izquierda, derecha);// Se obtiene el índice del pivote tras la partición

            
            //Declaracion de hilos
            Thread izquierdaThread = null;
            Thread derechaThread = null;

            
         // Si la parte izquierda es mayor al umbral, se ordena en un hilo nuevo
            if ((indiceParticion - 1 - izquierda) > UMBRAL) {
                izquierdaThread = new Thread(() -> quickSortConcurrente(arr, izquierda, indiceParticion - 1));
                izquierdaThread.start();//Inicio de hilo
            } else {
            	// Si no, se ordena secuencialmente
                quickSortConcurrente(arr, izquierda, indiceParticion - 1);
            }

            
            // Lo mismo para la parte derecha
            if ((derecha - indiceParticion - 1) > UMBRAL) {
                derechaThread = new Thread(() -> quickSortConcurrente(arr, indiceParticion + 1, derecha));
                derechaThread.start();
            } else {
                quickSortConcurrente(arr, indiceParticion + 1, derecha);
            }
         // Esperar a que los hilos (si fueron creados) terminen antes de continuar	
            try {
                if (izquierdaThread != null) izquierdaThread.join();
                if (derechaThread != null) derechaThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // Método que realiza la partición
    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];// Elegimos el último elemento como pivote
        int i = izquierda - 1;// Índice del último elemento menor al pivote

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }
     // Colocamos el pivote en su posición ordenada
        intercambiar(arr, i + 1, derecha);
        return i + 1; // Devolvemos la posición final del pivote
    }
 // Método auxiliar para intercambiar dos elementos en el arreglo
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void imprimirArray(int[] arr) {// impresion del array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }    
}
    
