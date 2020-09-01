package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.TipoLancamento;
import model.TipoNormal;
import model.Fita;
import model.TipoInfantil;

class AluguelTest {
	private static final int CINCO_DIAS_ALUGADA = 5;
	private static final int UM_DIA_ALUGADA = 1;
	private static final int DOIS_DIA_ALUGADA = 2;
	private static final int QUATRO_DIAS_ALUGADA = 4;

	static Fita lancamento;
	static Fita Normal;
	static Fita Infantil;

	@BeforeAll
	public static void construirInstancias() {
		lancamento = new Fita("Lancamento", new TipoLancamento());
		Normal = new Fita("Normal", new TipoNormal());
		Infantil = new Fita("Infantil", new TipoInfantil());
	}

	@Test
	void testAluguelLancamento() {
		assertEquals(lancamento.getValor(UM_DIA_ALUGADA), 3);
		assertEquals(lancamento.getValor(DOIS_DIA_ALUGADA), 6);
	}

	@Test
	void testAluguelNormal() {
		assertEquals(Normal.getValor(CINCO_DIAS_ALUGADA), 6.5);
	}

	@Test
	void testAluguelInfantil() {
		assertEquals(Infantil.getValor(DOIS_DIA_ALUGADA), 1.5);
		assertEquals(Infantil.getValor(QUATRO_DIAS_ALUGADA), 3);
	}

}
