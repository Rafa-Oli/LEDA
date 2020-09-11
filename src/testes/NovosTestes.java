package testes;

import algoritmos.CountingSort;
import algoritmos.ExtendedCountingSort;
import algoritmos.RadixSort;
import org.junit.jupiter.api.*;
import algoritmos.QuickSortExtraPivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.AbstractSorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;


class NovosTestes {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpart;
//	private Integer[] vetorVazio;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private AbstractSorting<Integer> Implementacao;
	private Integer[] vetorPiorCaso;
	private Integer[] vetorMelhorCaso;

	@BeforeEach
	public void setUp() {
		populaVetorValoresIguais(new Integer[] {10, 10, 10, 10, 10, 10, 10, 10});
		populaVetorTamImpar(new Integer[] {3, 99, 48, 13, 47, 18, 1, 28, 59, 22, 67});
		populaVetorTamPar(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		//populaVetorVazio(new Integer[] {});
		populaVetorRepetidos(new Integer[] {2, 6, 98, 54, 6, 78, 2, 34, 87, 78, 2, 1 });
		populaVetorMelhorCaso(new Integer[] {1, 5, 8, 12, 38, 40, 45, 67, 70, 78, 80, 98});
		populaVetorPiorCaso(new Integer[] {59, 43, 36, 20, 19, 17, 13, 10, 8, 5, 2, 1});
		getImplementacao();
	}

	private void getImplementacao() {
		//TODO: colocar a implementação do método a ser testada
		this.Implementacao = new QuickSortExtraPivo<Integer>();
//		Assert.fail("falhar quando não tiver implementação");
	}

	public void populaVetorRepetidos(Integer[] arrayArgumento) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void populaVetorValoresIguais(Integer[] arrayArgumento) {
		this.vetorValoresIguais = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void populaVetorTamImpar(Integer[] arrayArgumento) {
		this.vetorTamImpart = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void populaVetorTamPar(Integer[] arrayArgumento) {
		this.vetorTamPar = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

//	public void populaVetorVazio(Integer[] arrayArgumento) {
//		this.vetorVazio = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
//	}

	public void populaVetorPiorCaso(Integer[] arrayArgumento) {
		this.vetorPiorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void populaVetorMelhorCaso(Integer[] arrayArgumento) {
		this.vetorMelhorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void testeGenerico(Integer[] array) {
		Integer[] copia1 = {};
		if (array.length > 0) {
			copia1 = Arrays.copyOf(array, array.length);
		}
		Implementacao.sort(array);
		Arrays.sort(copia1);
		assertArrayEquals(copia1, array);
	}
	@Test
	public void testSortVetorPar() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorTamPar, 3, 99));


		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorTamPar, 23, 88));
	}

	@Test
	public void testSortVetorImpar() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorTamImpart, vetorTamImpart.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorTamImpart, 1, 99));


		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorTamImpart, vetorTamImpart.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorTamImpart, 3, 67));
	}

	@Test
	public void testSortRepetidos() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorValoresRepetidos, 1, 98));

		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorValoresRepetidos, 2, 1));
	}

	@Test
	public void testSortIguais() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorValoresIguais, vetorValoresIguais.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorValoresIguais, 10, 10));

		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorValoresIguais, vetorValoresIguais.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorValoresIguais, 10, 10));
	}
	//@Test
	//public void testSortVazio() {}
	@Test
	public void testSortPiorCaso() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorPiorCaso, vetorPiorCaso.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorPiorCaso, 1, 59));

		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorPiorCaso, vetorPiorCaso.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorPiorCaso, 59, 1));
	}

	@Test
	public void testSortMelhorCaso() {
		CountingSort countingSort = new CountingSort();
		Integer[] expected;
		expected = Arrays.copyOf(vetorMelhorCaso, vetorMelhorCaso.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, countingSort.ordena(vetorMelhorCaso, 1, 98));

		RadixSort radixSort = new RadixSort();
		Integer[] expected2;
		expected2 = Arrays.copyOf(vetorMelhorCaso, vetorMelhorCaso.length);
		Arrays.sort(expected2);
		assertArrayEquals(expected2, radixSort.ordena(vetorMelhorCaso, 1, 98));

	}
	@Test
	public void testSortNegativos() {
		ExtendedCountingSort extendedCountingSort = new ExtendedCountingSort();
		Integer[] expected = {-5, -10, 0, -3, 8, 5, -1, 10};
		Integer[] actual = {-10, -5, -3, -1, 0, 5, 8, 10 };
		Arrays.sort(expected);
		assertArrayEquals(expected, extendedCountingSort.ordena(actual, -10, 10));
	}
}
