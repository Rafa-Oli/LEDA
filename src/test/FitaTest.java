package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;

class FitaTest {

	@Test
	void testValorDoisDIAS() {
		Fita babyShark = new Fita("Baby Shark", new TipoInfantil());
		assertEquals(1.5, babyShark.getValor(2));
	}

	@Test
	void testValorQuatroDIAS() {
		Fita incriveis = new Fita("Os Incriveis", new TipoInfantil());
		assertEquals(3.0, incriveis.getValor(4));
	}

	@Test
	void testValorUmDIA() {
		Fita coringa = new Fita("Coringa", new TipoLancamento());
		assertEquals(3.0, coringa.getValor(1));
	}

	@Test
	void testValorDoisDIAs() {
		Fita Vingadores = new Fita("Mulher Maravilha", new TipoLancamento());
		assertEquals(6, Vingadores.getValor(2));
	}

	@Test
	void testValorCincoDIAs() {
		Fita Hulk = new Fita("Hulk", new TipoNormal());
		assertEquals(6.5, Hulk.getValor(5));
	}

}
