package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Aluguel;
import model.Cliente;
import model.Fita;
import model.Locadora;
import model.TipoInfantil;
import model.TipoLancamento;

class LocadoraTest {
    Cliente cliente = new Cliente("Angela");
    Cliente cliente2 = new Cliente("Rafaela");
    Cliente cliente3 = new Cliente("Marcos");

    Fita baby = new Fita("Baby Shark", new TipoInfantil());
    Fita incriveis = new Fita("Os Incriveis", new TipoInfantil());
    Fita coringa = new Fita("Coringa", new TipoLancamento());
    Fita vingadores = new Fita("Vingadores", new TipoLancamento());

    Aluguel alugado = new Aluguel(baby, 2);
    Aluguel alugado2 = new Aluguel(incriveis, 4);
    Aluguel alugado3 = new Aluguel(coringa, 1);
    Aluguel alugado4 = new Aluguel(vingadores, 2);
    Locadora locadora = new Locadora();

    @Test
    void testInserirClientes() {
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente3);

        assertEquals(cliente.getNome(), "Angela");
        assertEquals(cliente2.getNome(), "Rafaela");
        assertEquals(cliente3.getNome(), "Marcos");
    }

    @Test
    void testRemoverCliente() {
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente3);
        Cliente clienteRem = locadora.removeCliente("Marcos");
        assertEquals(cliente3.getNome(), clienteRem.getNome());
    }

    @Test
    void ordenarClientesPeloNome() {
        Cliente clienteOrd = new Cliente("Luciana");
        Cliente clienteOrd2 = new Cliente("Mariana");
        Cliente clienteOrd3 = new Cliente("Marcos");

        Cliente[] clientes = {clienteOrd, clienteOrd2, clienteOrd3};
        Cliente[] clientesEsp = {clienteOrd, clienteOrd3, clienteOrd2};

        assertArrayEquals(clientesEsp, locadora.ordenarClientesPeloNome(clientes));
    }

    @Test
    void buscaLinearClientes() {
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente3);
        assertEquals(cliente, locadora.buscaLinearClientes("Angela"));

    }

    @Test
    void buscaBinariaClientes() {
        locadora.inserirClienteOrdenado(cliente);
        locadora.inserirClienteOrdenado(cliente2);
        locadora.inserirClienteOrdenado(cliente3);
        assertEquals(cliente2, locadora.buscaBinariaClientes("Rafaela"));
    }

    @Test
    void testInserirFitas() {
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(incriveis);
        locadora.inserirFitaOrdenada(coringa);

        assertEquals(baby.getTitulo(), "Baby Shark");
        assertEquals(incriveis.getTitulo(), "Os Incriveis");
        assertEquals(coringa.getTitulo(), "Coringa");

    }

    @Test
    void testRemoverFita() {
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(incriveis);
        locadora.inserirFitaOrdenada(coringa);
        Fita FitaRem = locadora.removeFita("Os Incriveis");
        assertEquals(incriveis.getTitulo(), FitaRem.getTitulo());
    }

    @Test
    void ordenarFitasPeloNome() {
        Fita f1 = new Fita("Baby Shark", new TipoInfantil());
        Fita f2 = new Fita("Os Incriveis", new TipoInfantil());
        Fita f3 = new Fita("Coringa", new TipoLancamento());
        Fita[] fitas = {f1, f2, f3};
        Fita[] fitasEsp = {f1, f3, f2};

        Assertions.assertArrayEquals(fitasEsp, locadora.ordenaFitasPeloNome(fitas));
    }

    @Test
    void buscaLinearFitas() {
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(incriveis);
        locadora.inserirFitaOrdenada(coringa);
        assertEquals(incriveis, locadora.buscaLinearFita("Os Incriveis"));
    }

    @Test
    void buscaBinariaFitas() {
        locadora.inserirFitaOrdenada(baby);
        locadora.inserirFitaOrdenada(incriveis);
        locadora.inserirFitaOrdenada(coringa);
        assertEquals(coringa, locadora.buscaBinariaFitas("Coringa"));
    }

    @Test
    void testInserirAluguelOrdenado() {
        locadora.inserirAluguelOrdenado(alugado);
        locadora.inserirAluguelOrdenado(alugado2);
        locadora.inserirAluguelOrdenado(alugado3);

        assertEquals(alugado.getFita().getTitulo(), "Baby Shark");
        assertEquals(alugado2.getFita().getTitulo(), "Os Incriveis");
        assertEquals(alugado3.getFita().getTitulo(), "Coringa");
    }

    @Test
    void ordenarAlugueisPorValor() {
        locadora.inserirAluguelOrdenado(alugado);
        locadora.inserirAluguelOrdenado(alugado2);
        locadora.inserirAluguelOrdenado(alugado3);

        Aluguel[] alugueis = locadora.ordenarAlugueisPorValor();

        assertEquals(1.5, alugueis[0].calcularValor());
        assertEquals(3.0, alugueis[1].calcularValor());
        assertEquals(3.0, alugueis[2].calcularValor());
    }

    @Test
    void OrdenarAlugueisPorValor() {
        Aluguel[] alugueis = {alugado, alugado2, alugado3};
        Aluguel[] alugueisEsp = {alugado, alugado2, alugado3};

        assertArrayEquals(alugueisEsp, locadora.ordenarAlugueisPorValor(alugueis));

    }

    @Test
    void OrdenarAlugueisPorSelectionSort() {
        locadora.inserirAluguelOrdenado(alugado);
        locadora.inserirAluguelOrdenado(alugado2);
        locadora.inserirAluguelOrdenado(alugado3);
        Aluguel[] alugueis = {alugado, alugado2, alugado3};

        assertArrayEquals(alugueis, locadora.ordenarAlugueisSelectionSortPorValor());

    }

    @Test
    void ordenarFitasMergeSortPorValor() {
        Fita[] actual = {incriveis, coringa, vingadores, baby};
        Fita[] expected = {incriveis, baby, coringa, vingadores};
        locadora.ordenarFitasMergeSortPorValor(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void ordenarFitasQuickSortPorValor() {
        Fita[] actual = {incriveis, coringa, vingadores, baby};
        Fita[] expected = {incriveis, baby, vingadores, coringa};
        locadora.ordenarFitasQuickSortPorValor(actual, 0, 3);
        assertArrayEquals(expected, actual);
    }
}
