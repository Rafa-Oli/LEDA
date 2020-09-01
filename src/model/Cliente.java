package model;

public class Cliente {
	private int pontosDeAlugadorFrequente = 0;
	private String nome;
	private Aluguel[] fitasAlugadas;
	private double valorTotal = 0.0;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		Integer n= 0;
		fitasAlugadas= new Aluguel[n+1];
		fitasAlugadas[n]= aluguel;
		n++;
		
	}

	public int getPontosDeAlugadorFrequente() {
		return pontosDeAlugadorFrequente;
	}

	public void adicionaPontosDeAlugadorFrequente() {
		this.pontosDeAlugadorFrequente++;
	}

	public double extrato() {
       double valorCorrente = 0.0;

		for (Aluguel f : fitasAlugadas) {

			Aluguel cada = f;

			// determina valores para cada linha
			valorCorrente += cada.calcularValor(); // switch

			// trata de pontos de alugador frequente

			pontosDeAlugadorFrequente += calcularPontosAlugadorFrequente(cada);

			valorTotal += valorCorrente;

		} // For
		return valorCorrente;

	}

	public String mostraExtrato() {

		final String fimDeLinha = System.getProperty("line.separator");
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		for (Aluguel f : fitasAlugadas) {
			resultado += "\t" + f.getFita().getTitulo() + "\t" + extrato() + fimDeLinha;
		}

		// adiciona rodape
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + getPontosDeAlugadorFrequente() + " pontos de alugador frequente";

		return resultado;
	}


	private int calcularPontosAlugadorFrequente(Aluguel cada) {

		int pontos = 1;
		// adiciona bonus para aluguel de um lancamento por pelo menos 2 dias
		if (cada.getFita().getTipo() instanceof TipoLancamento && cada.getDiasAlugada() > 1) {
			pontos += 1;
		}
		return pontos;
	}

}