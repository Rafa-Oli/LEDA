package model;

public class Fita {

	private String titulo;
	private TipoFilme tipo;

	public Fita(String titulo, TipoFilme tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}

	public TipoFilme getTipo() {
		return tipo;
	}

	public void setTipo(TipoFilme tipo) {
		this.tipo = tipo;
	}

	public Fita() {
		this.titulo = "";
		this.tipo = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getValor(int diasAlugada) {
		return tipo.getValor(diasAlugada);
	}

}
