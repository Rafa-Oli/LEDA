package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer>  {

	int inicio;
	int fim;
	private int tamanho;
	int qtdeElementos;
	private Integer[] fila;
	public MinhaFila() {

	}
	
	public MinhaFila(int tamanhoInicial) {
		inicio = fim = -1;
		tamanho = tamanhoInicial;
		fila = new Integer[tamanho];
		qtdeElementos=0;

	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException{
		if (! isFull()){
			if (inicio == -1){
				inicio = 0;
			}
			fim++;
			fila[fim] = item;
			qtdeElementos++;
		}else {
			throw new FilaCheiaException();

		}
		
	}

	public void mostrar(){
		String elementos = "";
		for (int i = inicio; i<=fim; i++) {
			elementos += fila[i]+ "  ";
		}
		System.out.println(elementos);
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException{
      int value=0;

		if (!isEmpty()) {
			value=inicio;
			inicio++;
			qtdeElementos--;
		}else {
			throw new FilaVaziaException();
		}

		return fila[value];
	}

	@Override
	public Integer verificarCauda() {
		return fila[fim];
	}

	@Override
	public Integer verificarCabeca() {
		return fila[inicio];
	}

	@Override
	public boolean isEmpty() {
		if (qtdeElementos == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (qtdeElementos == tamanho - 1){
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws FilaVaziaException,FilaCheiaException{
		MinhaFila fila= new MinhaFila(7);

		fila.enfileirar(3);
		fila.enfileirar(5);
		fila.enfileirar(7);
		fila.enfileirar(4);
		fila.enfileirar(2);
		fila.mostrar();
		fila.desenfileirar();
System.out.println(fila.verificarCabeca());

		fila.mostrar();





	}

}
