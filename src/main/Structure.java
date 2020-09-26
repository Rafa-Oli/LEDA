package main;

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


    public void selectionSortPorOcorrencia(Senha[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].getOcorrencias() < array[index].getOcorrencias()) {
                    index = j;
                }
            }

            Senha smallerNumber = array[index];
            array[index] = data[i];
            array[i] = smallerNumber;

        }
    }

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
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(Senha[] a, Senha[] l, Senha[] r, int left, int right) {

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


}