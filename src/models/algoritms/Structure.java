package models.algoritms;

import java.util.Arrays;

public class Structure {
    private static final Integer default_capacity = 20;
    private Senha[] data;
    private int size = 0;

    public Structure() {
        data = new Senha[default_capacity];
    }

    public Senha[] getData() {
        return this.data;
    }

    public void add(Senha element) {
        if (size == data.length) {
            grow();
        }
        data[this.size] = element;
        size++;
    }

    private void grow() {
        int newSize = data.length + 10;
        data = Arrays.copyOf(data, newSize);
    }

    public Senha get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index:" + index + " , de Tamanho: " + index);
        }
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }


    // ----------------------------SELECTION SORT - OCORRÊNCIAS -------------------------------------------------
    public void selectionSortPorOcorrencia(Senha[] senhas) {
        int index;
        int max;
        int size = senhas.length;

        while (size > 0) {
            max = 0;
            for (index = 1; index < size; index++) {
                if (senhas[max].getOcorrencias() < senhas[index].getOcorrencias()) max = index;
            }
            swapSelectionSortOcorrencias(senhas, max, size - 1);
            size--;
        }

    }
    private void swapSelectionSortOcorrencias(Senha[] senhas, Integer max, Integer size) {
        Senha smallestNumber = senhas[max];
        senhas[max] = senhas[size];
        senhas[size] = smallestNumber;
    }


    //--------------------------SELECTION SORT - ALFABÉTICA ------------------------------------------------
    public void selectionSortPorAlfabetica(Senha[] senhas) {
        int index;
        int max;
        int size = senhas.length;

        while (size > 0) {
            max = 0;
            for (index = 1; index < size; index++) {
                if (senhas[max].getSenha().compareTo(senhas[index].getSenha()) < 0) max = index;
            }
            swapSelectionSortPorAlfabetica(senhas, max, size - 1);
            size--;
        }
    }

    private void swapSelectionSortPorAlfabetica(Senha[] senhas, Integer max, Integer size) {
        Senha smallestNumber = senhas[max];
        senhas[max] = senhas[size];
        senhas[size] = smallestNumber;
    }


    //--------------------------------INSERTION SORT - OCORRÊNCIAS -----------------------------------------------

    public void insertionSortPorOcorrencia(Senha[] data) {
        int n = data.length;
        for (int j = 1; j < n; j++) {
            Senha key = data[j];
            int i = j - 1;
            while ((i > -1) && (data[i].getOcorrencias() > key.getOcorrencias())) {
                data[i + 1] = data[i];
                i--;
            }
            data[i + 1] = key;
        }

    }


    //------------------------------------INSERTION SORT - ALFABÉTICO -------------------------------------------------
    public void insertionSortPorAlfabetica(Senha[] senhas) {
        int size = senhas.length;
        for (int i = 1; i < size; i++) {
            Senha key = senhas[i];
            int j = i - 1;
            while (j >= 0 && (senhas[j].getSenha().compareTo(key.getSenha()) > 0)) {
                senhas[j + 1] = senhas[j];
                j = j - 1;
            }
            senhas[j + 1] = key;
        }
    }



    //----------------------------------MERGE SORT - OCORRÊNCIAS -------------------------------------------------
    public void mergeSortPorOcorrencia(Senha[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Senha[] l = new Senha[mid];
        Senha[] r = new Senha[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSortPorOcorrencia(l, mid);
        mergeSortPorOcorrencia(r, n - mid);
        mergeOcorrencias(a, l, r, mid, n - mid);
    }

    public static void mergeOcorrencias(Senha[] a, Senha[] l, Senha[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getOcorrencias() <= r[j].getOcorrencias()) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    //-----------------------------------MERGE SORT - ALFABÉTICO ----------------------------------------------
    public void mergeSortPorAlfabetica(Senha[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Senha[] l = new Senha[mid];
        Senha[] r = new Senha[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSortPorAlfabetica(l, mid);
        mergeSortPorAlfabetica(r, n - mid);
        mergePorAlfabetica(a, l, r, mid, n - mid);
    }

    public static void mergePorAlfabetica(Senha[] a, Senha[] l, Senha[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getSenha().compareTo(r[j].getSenha()) < 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    // -----------------------------QUICK SORT - OCORRÊNCIAS ------------------------------------------------
    public void quickSortPorOcorrencia(Senha arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionQuickSortOcorrencia(arr, begin, end);

            quickSortPorOcorrencia(arr, begin, partitionIndex - 1);
            quickSortPorOcorrencia(arr, partitionIndex + 1, end);
        }
    }

    private int partitionQuickSortOcorrencia(Senha arr[], int begin, int end) {
        Senha pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getOcorrencias() <= pivot.getOcorrencias()) {
                i++;

                Senha swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Senha swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    //-----------------------------------QUICK SORT - ALFABÉTICO---------------------------------------------
    public void quickSortPorOrdemAlfabetica(Senha arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionQuickSortPorOrdemAlfabetica(arr, begin, end);

            quickSortPorOrdemAlfabetica(arr, begin, partitionIndex - 1);
            quickSortPorOrdemAlfabetica(arr, partitionIndex + 1, end);
        }
    }

    private int partitionQuickSortPorOrdemAlfabetica(Senha arr[], int begin, int end) {
        Senha pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getSenha().compareTo(pivot.getSenha()) < 0) {
                i++;

                Senha swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Senha swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    //-----------------------------------QUICK SORT MEDIANA DE TRÊS - OCORRENCIAS ---------------------------------
    public void quicksortMedianaDeTresOcorrencia(Senha[] A) {
        quicksortMedianaDeTresOcorrencia(A, 0, A.length - 1);
    }
    private static void quicksortMedianaDeTresOcorrencia(Senha[] A, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTresOcorrencia(A, inicio, fim);
            quicksortMedianaDeTresOcorrencia(A, inicio, q - 1);
            quicksortMedianaDeTresOcorrencia(A, q + 1, fim);
        }
    }
    private static int partitionQuickMedianaDeTresOcorrencia(Senha[] A, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        Senha a = A[inicio];
        Senha b = A[meio];
        Senha c = A[fim];
        int medianaIndice;
        if (a.getOcorrencias() < b.getOcorrencias()) {
            if (b.getOcorrencias() < c.getOcorrencias()) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (a.getOcorrencias() < c.getOcorrencias()) {
                    //a < c && c <= b
                    medianaIndice = fim;
                } else {
                    //c <= a && a < b
                    medianaIndice = inicio;
                }
            }
        } else {
            if (c.getOcorrencias() < b.getOcorrencias()) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (c.getOcorrencias() < a.getOcorrencias()) {
                    //b <= c && c < a
                    medianaIndice = fim;
                } else {
                    //b <= a && a <= c
                    medianaIndice = inicio;
                }
            }
        }
        swapMedianaDeTresOcorrencia(A, medianaIndice, fim);
        Senha pivo = A[fim];
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (A[j].getOcorrencias() <= pivo.getOcorrencias()) {
                i = i + 1;
                swapMedianaDeTresOcorrencia(A, i, j);
            }
        }
        swapMedianaDeTresOcorrencia(A, i + 1, fim);
        return i + 1;
    }

    private static void swapMedianaDeTresOcorrencia(Senha[] A, int i, int j) {
        Senha temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    //-----------------------------------QUICK SORT MEDIANA DE TRÊS - ALFABÉTICO -------------------------------------
    public void quicksortMedianaDeTresAlfabetica(Senha[] A) {
        quicksortMedianaDeTresAlfabetica(A, 0, A.length - 1);
    }
    private static void quicksortMedianaDeTresAlfabetica(Senha[] A, int inicio, int fim) {
        if (inicio < fim) {
            int q = partitionQuickMedianaDeTresAlfabetica(A, inicio, fim);
            quicksortMedianaDeTresAlfabetica(A, inicio, q - 1);
            quicksortMedianaDeTresAlfabetica(A, q + 1, fim);
        }
    }
    private static int partitionQuickMedianaDeTresAlfabetica(Senha[] A, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        Senha a = A[inicio];
        Senha b = A[meio];
        Senha c = A[fim];
        int medianaIndice;
        if (a.getSenha().compareTo(b.getSenha()) < 0) {
            if (b.getSenha().compareTo(c.getSenha()) < 0) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (a.getSenha().compareTo(c.getSenha()) < 0) {
                    //a < c && c <= b
                    medianaIndice = fim;
                } else {
                    //c <= a && a < b
                    medianaIndice = inicio;
                }
            }
        } else {
            if (c.getSenha().compareTo(b.getSenha()) < 0) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (c.getSenha().compareTo(a.getSenha()) < 0) {
                    //b <= c && c < a
                    medianaIndice = fim;
                } else {
                    //b <= a && a <= c
                    medianaIndice = inicio;
                }
            }
        }
        swapMedianaDeTresAlfabetica(A, medianaIndice, fim);
        Senha pivo = A[fim];
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (A[j].getSenha().compareTo(pivo.getSenha()) <= 0) {
                i = i + 1;
                swapMedianaDeTresAlfabetica(A, i, j);
            }
        }
        swapMedianaDeTresAlfabetica(A, i + 1, fim);
        return i + 1;
    }
    private static void swapMedianaDeTresAlfabetica(Senha[] A, int i, int j) {
        Senha temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    //-----------------------------------COUNTING SORT - OCORRENCIAS -------------------------------------
    void countSort(Senha array[], int size) {
        Senha[] output = new Senha[size + 1];
        Senha max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i].getOcorrencias() > max.getOcorrencias())
                max = array[i];
        }
        int[] count = new int[max.getOcorrencias() + 1];


        for (int i = 0; i < max.getOcorrencias(); ++i) {
            count[i] = 0;
        }


        for (int i = 0; i < size; i++) {
            count[array[i].getOcorrencias()]++;
        }


        for (int i = 1; i <= max.getOcorrencias(); i++) {
            count[i] += count[i - 1];
        }


        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i].getOcorrencias()] - 1] = array[i];
            count[array[i].getOcorrencias()]--;
        }


        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }


    //-----------------------------------HEAPSORT - OCORRENCIAS -------------------------------------
    public void heapSortOcorrencias(Senha arr[]){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyOcorrencias(arr, n, i);

        for (int i=n-1; i>0; i--) {
            Senha temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyOcorrencias(arr, i, 0);
        }
    }
    void heapifyOcorrencias(Senha arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        if (l < n && arr[l].getOcorrencias()  > arr[largest].getOcorrencias()) {
            largest = l;
        }
        if (r < n && arr[r].getOcorrencias()  > arr[largest].getOcorrencias()) {
            largest = r;
        }
        if (largest != i){
            Senha swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyOcorrencias(arr, n, largest);
        }
    }



    //-----------------------------------HEAPSORT - ALFABÉTICO -------------------------------------
    public void heapSortAlfabetico(Senha arr[]){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyAlfabetico(arr, n, i);

        for (int i=n-1; i>0; i--) {
            Senha temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyAlfabetico(arr, i, 0);
        }
    }
    void heapifyAlfabetico(Senha arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        if (l < n && arr[l].getSenha().compareTo(arr[largest].getSenha()) > 0) {
            largest = l;
        }
        if (r < n && arr[r].getSenha().compareTo(arr[largest].getSenha()) > 0) {
            largest = r;
        }
        if (largest != i){
            Senha swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyAlfabetico(arr, n, largest);
        }
    }

}