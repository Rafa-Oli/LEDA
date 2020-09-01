package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Aluguel;
import model.Cliente;
import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;

class ClienteTest {
	public Fita baby;
	public Fita Incriveis;
	public Fita coringa;
	public Fita Vingadores;
	public Fita Hulk;

	@Before
	void criarFitasTeste() {
		baby = new Fita("Baby Shark", new TipoInfantil());
		Incriveis = new Fita("Os Incriveis", new TipoInfantil());
		coringa = new Fita("Coringa", new TipoLancamento());
		Vingadores = new Fita("Os Vingadores", new TipoLancamento());
		Hulk = new Fita("Hulk", new TipoNormal());
	}

	@Test
	void testExtrato() {
		Cliente cliente = new Cliente("Jose");
		Cliente cliente2 = new Cliente("Maria");

		Aluguel alugado2 = new Aluguel(baby, 2);
		Aluguel alugado5 = new Aluguel(Incriveis, 4);
		Aluguel alugado3 = new Aluguel(coringa, 1);
		Aluguel alugado4 = new Aluguel(Vingadores, 1);
		Aluguel alugado6 = new Aluguel(Vingadores, 2);
		Aluguel alugado7 = new Aluguel(Hulk, 5);

		cliente2.adicionaAluguel(alugado3);
		cliente2.adicionaAluguel(alugado4);
		cliente.adicionaAluguel(alugado5);
		cliente.adicionaAluguel(alugado2);
		cliente2.adicionaAluguel(alugado6);
		cliente2.adicionaAluguel(alugado7);

		assertEquals(cliente2.getNome(), "Maria");
		assertEquals(cliente.getNome(), "Jose");

	}

}
