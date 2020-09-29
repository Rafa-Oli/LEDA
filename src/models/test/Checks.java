package models.test;

import java.io.BufferedReader;
import java.io.FileReader;

//Classe para verificação das ordenações
public class Checks {
    public static void main(String[] args) {
        Checks checks= new Checks();
        checks.checkAlfabetico();
    }
   void checkOcorrencia() {
        boolean check = false;
        String saida = "C:\\Users\\ACER\\IdeaProjects\\PROJETO-LEDA\\saida.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(saida))) {
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] lines = line.split(" ");
                for (int i = 0; i < 430000; i++) {
                    if (Integer.parseInt(lines[1]) <= Integer.parseInt(lines[1] + 1)) {
                        check = true;
                    }
                }
                line = br.readLine();
            }
            if(check = true){
                System.out.println("Está ordenado");
            }else{
                System.out.println("Não está ordenado");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    void checkAlfabetico() {
        boolean check = false;
        String saida = "C:\\Users\\ACER\\IdeaProjects\\PROJETO-LEDA\\saida.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(saida))) {
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] lines = line.split(" ");
                for (int i = 0; i < 1000; i++) {
                    if (lines[2].compareTo(lines[2] + 1) <= 0 ) {
                        check = true;
                    }
                }
                line = br.readLine();
            }
            if(check = true){
                System.out.println("Está ordenado");
            }else{
                System.out.println("Não está ordenado");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }




}
