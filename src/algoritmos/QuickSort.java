package algoritmos;

import sorting.AbstractSorting;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public T[] ordena(T[] array, int inicio, int fim) {
        if (inicio < fim) {
            int partitionIndex = partition(array, inicio, fim);

            ordena(array, inicio, partitionIndex - 1);
            ordena(array, partitionIndex + 1, fim);
        }
		return array;
	}

    private int partition(T[] array, int inicio, int fim) {
        T pivot = array[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        return i + 1;
    }

}
