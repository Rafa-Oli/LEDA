package model;

import java.util.Arrays;

public class Locadora {

    private static final int TAMANHO_INICIAL_ARRAY = 10;

    private Cliente[] clientes;
    private Aluguel[] alugueis;
    private Fita[] fitas;
    private int sizeCliente = 0;
    private int sizeFita = 0;
    private int sizeAluguel = 0;

    public Locadora() {
        clientes = new Cliente[TAMANHO_INICIAL_ARRAY];
        fitas = new Fita[TAMANHO_INICIAL_ARRAY];
        alugueis = new Aluguel[TAMANHO_INICIAL_ARRAY];
    }

    //---------------------------------------------CLIENTE-------------------------------------------------------
    // QUESTÃO 7 : INSERINDO ELEMENTO E MANTENDO ORDENAÇÃO
    public void inserirClienteOrdenado(Cliente cliente) {
        if (sizeCliente == clientes.length) {
            aumentaSizeCliente();
        }

        clientes[sizeCliente++] = cliente;
        ordenarClientesPeloNome();
    }

    public Cliente getCliente(String nome) {
        int tamanhoVetor = sizeCliente;
        Cliente cliente = null;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];
            }
        }
        return cliente;

    }

    public void aumentaSizeCliente() {
        int novoSize = clientes.length * 2;
        clientes = Arrays.copyOf(clientes, novoSize);

    }

    // QUESTÃO 7: REMOÇÃO MANTENDO ORDENAÇÃO
    public Cliente removeCliente(String nome) {
        Cliente cliente = null;
        for (int i = 0; i < sizeCliente; i++) {
            if (clientes[i] == null) {
                break;
            }
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];

                for (int j = i; j < sizeCliente; j++) {
                    clientes[j] = clientes[j + 1];

                }
                sizeCliente--;
                return cliente;
            }
        }
        return cliente;
    }

    // QUESTÃO 3: INSERTION SORT
    public Cliente[] ordenarClientesPeloNome(Cliente[] clientes) {
        int sizeClientes2 = clientes.length;
        int ordenado = 1;
        int i;

        while (ordenado < sizeClientes2) {
            Cliente cliente = clientes[ordenado];
            if (clientes[ordenado] == null) {
                break;
            }

            for (i = ordenado; i > 0; i--) {
                if (cliente.getNome().compareTo(clientes[i - 1].getNome()) < 0) {
                    clientes[i] = clientes[i - 1];

                } else {
                    break;
                }

            }
            clientes[i] = cliente;
            ordenado++;
        }

        return clientes;

    }

    // QUESTÃO 3: INSERTION SORT
    public Cliente[] ordenarClientesPeloNome() {
        int ordenado = 1;
        int i;

        while (ordenado > 0) {
            Cliente first = clientes[ordenado];
            if (clientes[ordenado] == null) {
                break;
            }

            for (i = ordenado; i > 0; i--) {
                if (first.getNome().compareTo(clientes[i - 1].getNome()) < 0) {
                    clientes[i] = clientes[i - 1];

                } else {
                    break;
                }

            }
            clientes[i] = first;
            ordenado++;

        }

        return clientes;
    }

    // QUESTÃO 4 : PESQUISA LINEAR
    public Cliente buscaLinearClientes(String nome) {
        int tamanhoVetor = sizeCliente;
        Cliente cliente = null;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];
            }
        }
        return cliente;

    }

    // QUESTÃO 6: BUSCA BINÁRIA
    public Cliente buscaBinariaClientes(String nome) {
        int min = 0;
        int max = sizeCliente - 1;
        Cliente cliente = null;
        Cliente[] clientes = ordenarClientesPeloNome();

        while (min <= max) {
            int meio = (min + max) / 2;

            if (clientes[meio].getNome().compareTo(nome) == 0) {
                cliente = clientes[meio];
                return cliente;

            } else if (clientes[meio].getNome().compareTo(nome) < 0) { // lado direito
                min++;

            } else if (clientes[meio].getNome().compareTo(nome) > 0) { // lado esquerdo
                max--;

            }
        }

        return cliente;

    }
    // --------------------------------------FITA-----------------------------------------------------

    // QUESTÃO 7 : INSERINDO ELEMENTO E MANTENDO ORDENAÇÃO
    public void inserirFitaOrdenada(Fita fita) {
        if (sizeFita == fitas.length) {
            aumentaSizeFita();
        }
        fitas[sizeFita++] = fita;
        ordenarFitasPeloNome();
    }

    public Fita getFita(String nome) {
        int tamanhoVetor = sizeFita;
        Fita fita = null;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (fitas[i].getTitulo().equals(nome)) {
                fita = fitas[i];
            }
        }
        return fita;
    }

    public void aumentaSizeFita() {
        int novoSize = fitas.length * 2;
        fitas = Arrays.copyOf(fitas, novoSize);
    }

    // QUESTÃO 7: REMOÇÃO MANTENDO ORDENAÇÃO
    public Fita removeFita(String titulo) {
        Fita fita = null;
        for (int i = 0; i < sizeFita; i++) {
            if (fitas[i] == null) {
                break;
            }
            if (titulo.equals(fitas[i].getTitulo())) {
                fita = fitas[i];
                for (int j = i; j < sizeFita; j++) {
                    fitas[j] = fitas[j + 1];
                }
                sizeFita--;
                return fita;
            }
        }
        return fita;
    }

    // QUESTÃO 3: INSERTION SORT
    public Fita[] ordenarFitasPeloNome() {
        int ordenado = 1;
        int i;

        while (ordenado > 0) {
            Fita fita = fitas[ordenado];
            if (fitas[ordenado] == null) {
                break;
            }
            for (i = ordenado; i > 0; i--) {
                if (fita.getTitulo().compareTo(fitas[i - 1].getTitulo()) < 0) {
                    fitas[i] = fitas[i - 1];
                } else {
                    break;
                }
            }
            fitas[i] = fita;
            ordenado++;
        }
        return fitas;
    }

    // QUESTÃO 3: INSERTION SORT
    public Fita[] ordenaFitasPeloNome(Fita[] fitas) {
        int sizeFita = fitas.length;
        int ordenado = 1;
        int i;
        while (ordenado < sizeFita) {
            Fita fita = fitas[ordenado];
            for (i = ordenado; i > 0; i--) {
                if (fita.getTitulo().compareTo(fitas[i - 1].getTitulo()) < 0) {
                    fitas[i] = fitas[i - 1];
                } else {
                    break;
                }
            }
            fitas[i] = fita;
            ordenado++;
        }
        return fitas;
    }

    // QUESTÃO 4 : PESQUISA LINEAR
    public Fita buscaLinearFita(String titulo) {
        int tamanhoVetor = sizeFita;
        Fita fita = null;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (fitas[i].getTitulo().equals(titulo)) {
                fita = fitas[i];
            }
        }
        return fita;

    }

    // QUESTÃO 6: BUSCA BINÁRIA
    public Fita buscaBinariaFitas(String titulo) {
        int min = 0;
        int max = sizeFita - 1;
        Fita fita = null;
        Fita[] fitas = ordenarFitasPeloNome();

        while (min <= max) {
            int meio = (min + max) / 2;

            if (fitas[meio].getTitulo().compareTo(titulo) == 0) {
                fita = fitas[meio];
                return fita;

            } else if (fitas[meio].getTitulo().compareTo(titulo) < 0) { // lado direito
                min++;

            } else if (fitas[meio].getTitulo().compareTo(titulo) > 0) { // lado esquerdo
                max--;

            }
        }

        return fita;

    }

    //ROTEIRO 3: QUESTÃO 1- LETRA A
    public Fita[] ordenarFitasMergeSortPorValor(Fita[] fitas) {
        int n = fitas.length;
        if (n < 2) {
            return fitas;
        }
        int mid = n / 2; // DIVIDINDO O ARRAY
        Fita[] esquerdo = new Fita[mid];
        Fita[] direito = new Fita[n - mid];

        // COLOCANDO OS VALORES NO SUBARRAY ESQUERDO
        for (int i = 0; i < mid; i++) {
            esquerdo[i] = fitas[i];
        }
        // COLOCANDO OS VALORES NO SUBARRAY DIREITO
        for (int i = mid; i < n; i++) {
            direito[i - mid] = fitas[i];
        }
        // RECURSIVIDADES
        ordenarFitasMergeSortPorValor(esquerdo);
        ordenarFitasMergeSortPorValor(direito);

        merge(fitas, esquerdo, direito, mid, n - mid);

        return fitas;
    }

    // MÉTODO PARA COMPARAR E ORDENAR OS SUBARRAYS
    public static void merge(Fita[] a, Fita[] e, Fita[] d, int esquerdo, int direito) {

        int i = 0, j = 0, k = 0;

        while (i < esquerdo && j < direito) {
            if (e[i].getValor(1) <= d[j].getValor(1)) {
                a[k++] = e[i++];
            } else {
                a[k++] = d[j++];
            }
        }
        while (i < esquerdo) {
            a[k++] = e[i++];
        }

        while (j < direito) {
            a[k++] = d[j++];
        }

    }

    //ROTEIRO 3: QUESTÃO 1 - LETRA B
    public Fita[] ordenarFitasQuickSortPorValor(Fita[] fitas, int inicio, int fim) {
        if (inicio < fim) {
            int partitionIndex = partition(fitas, inicio, fim);

            ordenarFitasQuickSortPorValor(fitas, inicio, partitionIndex - 1);
            ordenarFitasQuickSortPorValor(fitas, partitionIndex + 1, fim);
        }
        return fitas;
    }

    private int partition(Fita[] fitas, int inicio, int fim) {
        double pivot = fitas[fim].getValor(1);
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (fitas[j].getValor(1) <= pivot) {
                i++;

                Fita swapTemp = fitas[i];
                fitas[i] = fitas[j];
                fitas[j] = swapTemp;
            }
        }

        Fita swapTemp = fitas[i + 1];
        fitas[i + 1] = fitas[fim];
        fitas[fim] = swapTemp;

        return i + 1;
    }


    // ------------------------------------------ALUGUEIS--------------------------------------------------------
    // QUESTÃO 7 : INSERINDO ELEMENTO E MANTENDO ORDENAÇÃO
    public void inserirAluguelOrdenado(Aluguel aluguel) {
        if (sizeAluguel == alugueis.length) {
            aumentaSizeAluguel();
        }

        alugueis[sizeAluguel++] = aluguel;

    }

    public Aluguel getAluguel(String nome) {
        int tamanhoVetor = sizeAluguel;
        Aluguel aluguel = null;
        for (int i = 0; i < tamanhoVetor; i++) {
            if (alugueis[i].getFita().getTitulo().equals(nome)) {
                aluguel = alugueis[i];
            }
        }
        return aluguel;
    }

    public void aumentaSizeAluguel() {
        int novoSize = alugueis.length * 2;
        alugueis = Arrays.copyOf(alugueis, novoSize);
    }

    // QUESTÃO 3: LETRA B - ORDENAR ALUGUEL PELO VALOR
    public Aluguel[] ordenarAlugueisPorValor(Aluguel[] alugueis) {
        int sizeAluguel2 = alugueis.length;
        int ordenado = 1;
        int i;

        while (ordenado < sizeAluguel2) {
            Aluguel aluguel = alugueis[ordenado];
            if (alugueis[ordenado] == null) {
                break;
            }
            for (i = ordenado; i > 0; i--) {
                if (aluguel.calcularValor() < alugueis[i - 1].calcularValor()) {
                    alugueis[i] = alugueis[i - 1];
                } else {
                    break;
                }
            }
            alugueis[i] = aluguel;
            ordenado++;
        }
        return alugueis;
    }

    // QUESTÃO 3: LETRA B - ORDENAR ALUGUEL PELO VALOR
    public Aluguel[] ordenarAlugueisPorValor() {
        int ordenado = 1;
        int i;

        while (ordenado < sizeAluguel) {
            Aluguel aluguel = alugueis[ordenado];
            if (alugueis[ordenado] == null) {
                break;
            }
            for (i = ordenado; i > 0; i--) {
                if (aluguel.calcularValor() < alugueis[i - 1].calcularValor()) {
                    alugueis[i] = alugueis[i - 1];
                } else {
                    break;
                }
            }
            alugueis[i] = aluguel;
            ordenado++;
        }
        return alugueis;
    }

    // QUESTÃO5: SELECTION SORT
    public Aluguel[] ordenarAlugueisSelectionSortPorValor() {
        alugueis = Arrays.copyOf(alugueis, sizeAluguel);
        for (int i = 0; i < sizeAluguel - 1; i++) {
            int index = i;
            for (int j = i + 1; j < sizeAluguel; j++) {
                if (alugueis[j].calcularValor() < alugueis[index].calcularValor()) {
                    index = j;
                }
            }
            Aluguel smallerNumber = alugueis[index];
            alugueis[index] = alugueis[i];
            alugueis[i] = smallerNumber;
        }

        return alugueis;
    }

    public int getSizeFita() {
        return sizeFita;
    }

    public void setSizeFita(int sizeFita) {
        this.sizeFita = sizeFita;
    }

    public int getSizeAluguel() {
        return sizeAluguel;
    }

    public void setSizeAluguel(int sizeAluguel) {
        this.sizeAluguel = sizeAluguel;
    }

    public Integer getSizeCliente() {
        return sizeCliente;
    }

    public void setSizeCliente(Integer sizeCliente) {
        this.sizeCliente = sizeCliente;
    }

}
