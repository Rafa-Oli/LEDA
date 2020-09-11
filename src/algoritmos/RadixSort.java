package algoritmos;

import sorting.AbstractSorting;


public class RadixSort extends AbstractSorting<Integer> {

    @Override
    public Integer[] ordena(Integer[] array, int inicio, int fim) {
        int size = array.length;
        // pegando o maior elmentos do array
        int max = getMax(array, size);
        // Aplicando o CountingSort para classificar os elmentos com no valor local
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
        return array;
    }

    int getMax(Integer array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    void countingSort(Integer array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculando a contagem de elementos
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculando a contagem acumulativa
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Colocando os elementos em ordem de Classificação
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }
}
