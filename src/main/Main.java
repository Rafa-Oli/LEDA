package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Senha senha;
        String arq = "C:\\Users\\ACER\\IdeaProjects\\PROJETO-LEDA\\senha.txt";
        String saida = "C:\\Users\\ACER\\IdeaProjects\\PROJETO-LEDA\\saida.txt";

        Structure ordenacao = new Structure();

        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] lines = line.split(" ");

                senha = new Senha((lines[2]), Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
                ordenacao.add(senha);
                line = br.readLine();
            }
            System.out.println(ordenacao.size());
        } catch (Exception e) {
            e.getStackTrace();
        }

        Senha[] senhas = Arrays.copyOf(ordenacao.getData(), ordenacao.size());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(saida))) {
            String linha = "";
            ordenacao.heapSortOcorrencias(senhas);
            for (int i = 0; i < ordenacao.size(); i++) {
                linha = senhas[i].getTam() + " " + senhas[i].getOcorrencias() + " " + senhas[i].getSenha();
                bw.write(linha + "\n");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}


