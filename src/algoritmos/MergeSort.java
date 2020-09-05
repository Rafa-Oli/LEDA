package algoritmos;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public T[] ordena(T[] array, int inicio, int fim) {

        if (fim - inicio < 1) {
            return array;
        }
        int mid = (inicio + fim) / 2; // DIVIDINDO O ARRAY
        ordena(array, inicio, mid);
        ordena(array, mid + 1, fim);

        merge(array, inicio, mid, fim);
        return array;
    }
    public void merge(T[] array, int inicio, int mid, int fim) {
    	Object[] temporario = new Object[fim - inicio + 1];
        int i = inicio; //esquerda
        int j = mid + 1; //direita
        int k = 0;
        while (i <= mid && j <= fim) {
            if (array[i].compareTo(array[j]) < 0) {
                temporario[k] = array[i++];
            } else {
                temporario[k] = array[j++];
            }
            k++;
        }
        if (i <= mid && j > fim) {
            while (i <= mid) {
                temporario[k++] = array[i++];
            }
        } else {
            while (j <= fim) {
                temporario[k++] = array[j++];
            }
        }
        for (k = 0; k < temporario.length; k++) {
            array[k + inicio] = (T) (temporario[k]);
        }
    }


}


