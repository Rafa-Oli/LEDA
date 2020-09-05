package algoritmos;

import sorting.AbstractSorting;

/**
 * QuickSort de pivô extra foca na implementação de um método de pivoteamento
 * O(n) para escolher um pivo com base nos valores do array. Este método deve
 * analisar os elementos do array e obter uma média dos valores para que seja
 * usado como o pivô.
 * Lembre de identificar pivô que de fato existam no array, ou seja, você precisa
 * fazer uma busca no próprio array.
 *
 * @param <T>
 * @author fabioleite
 */
public class QuickSortExtraPivo<T extends Comparable<T>> extends AbstractSorting<T> {

    private Object Integer;

    @Override
    public T[] ordena(T[] array, int inicio, int fim) {
        if (inicio < fim) {
            int q = partition(array, inicio, fim);
            ordena(array, inicio, q - 1);
            ordena(array, q + 1, fim);
        }
        return array;
    }

    private int partition(T[] A, int inicio, int fim) {

        int n = A.length;
        int media = 0;
        int soma = 0;

        for (int k = inicio; k <= fim; k++) {
            soma += (Integer) A[k];
        }
        media = soma / n;
        System.out.println("Media" + media + " Soma" + soma);

        int indice = 0;
        for (int k = inicio; k <= fim; k++) {
            if (((Integer) A[k]) == media) {
                indice = k;
                break;
            }
        }
        swap(A, indice, fim);
        T pivo = A[fim];
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (A[j].compareTo(pivo) <= 0) {
                i = i + 1;
                swap(A, i, j);
            }
        }
        //coloca o pivô na posição de ordenação
        swap(A, i + 1, fim);
        return i + 1;

    }
    private void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}