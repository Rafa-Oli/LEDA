package algoritmos;

import sorting.AbstractSorting;

/**
 * QuickSort de pivô extra foca na implementação de um método de pivoteamento
 * O(n) para escolher um pivo com base nos valores do array. Este método deve
 * analisar os elementos do array e obter uma média dos valores para que seja 
 * usado como o pivô.
 * Lembre de identificar pivô que de fato existam no array, ou seja, você precisa
 * fazer uma busca no próprio array.
 * @author fabioleite
 *
 * @param <T>
 */
public class QuickSortExtraPivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public Integer[] ordena(T[] array, int inicio, int fim) {
		throw new UnsupportedOperationException("não implementado ainda");
	}


}
