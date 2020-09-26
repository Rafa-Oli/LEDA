package ordenation;

import main.Structure;

import java.util.Arrays;


public class SelectionSort {
    public void ordenar(String[] list) {
        String[] temp, temp2;
        for (int i = 1; i < list.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
               if (Integer.parseInt(list[j].substring(0, 1)) < Integer.parseInt(list[index].substring(0, 1))) {
                    index = j;
                 // System.out.println(Integer.parseInt(list[j].substring(0, 1)));
                }
            }
            if(index != i) {
               System.out.println(i);
                String smallerNumber = list[i];
                list[i] = list[index];
                list[index] = smallerNumber;
            }

        }

        for (String a : list) {
            System.out.println("AQUII");
            System.out.println(a);
        }

    }

    public void print(String[] list) {
        for (String a : list) {
            System.out.println(a);
        }

    }
}
