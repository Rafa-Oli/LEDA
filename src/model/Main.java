package model;

public class Main {
public static void main(String[] args) {
	Locadora locadora= new Locadora();
	Fita baby = new Fita("Baby Shark", new TipoInfantil());
	Fita incriveis = new Fita("Os Incriveis", new TipoInfantil());
	Fita coringa = new Fita("Coringa", new TipoLancamento());
	Fita vingadores = new Fita("Vingadores", new TipoLancamento());

	Fita[] actual = {incriveis,coringa,vingadores, baby};
	
	
	Fita[] esperado=locadora.ordenarFitasMergeSortPorValor(actual);
	for (Fita fita : esperado) {
		System.out.println(fita.getValor(1));
		System.out.println(fita.getTitulo());
	}
}
}
