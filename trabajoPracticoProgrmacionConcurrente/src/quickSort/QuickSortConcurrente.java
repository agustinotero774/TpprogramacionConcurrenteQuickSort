package quickSort;

public class QuickSortConcurrente {

    private static final int UMBRAL = 20000;

    public static void quickSortConcurrente(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particionar(arr, izquierda, derecha);

            Thread izquierdaThread = null;
            Thread derechaThread = null;

            if ((indiceParticion - 1 - izquierda) > UMBRAL) {
                izquierdaThread = new Thread(() -> quickSortConcurrente(arr, izquierda, indiceParticion - 1));
                izquierdaThread.start();
            } else {
                quickSortConcurrente(arr, izquierda, indiceParticion - 1);
            }

            if ((derecha - indiceParticion - 1) > UMBRAL) {
                derechaThread = new Thread(() -> quickSortConcurrente(arr, indiceParticion + 1, derecha));
                derechaThread.start();
            } else {
                quickSortConcurrente(arr, indiceParticion + 1, derecha);
            }

            try {
                if (izquierdaThread != null) izquierdaThread.join();
                if (derechaThread != null) derechaThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    
    public static void imprimirArray(int[] arr) {// impresion del array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    
}
    
