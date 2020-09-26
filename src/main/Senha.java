package main;

import java.util.Objects;

public class Senha {

    private String senha;
    private int tam;
    private int ocorrencias;


    Senha(String senha, int tam, int ocorrencias) {
        this.senha = senha;
        this.tam = tam;
        this.ocorrencias = ocorrencias;
    }

    void setSenha(String senha) {
        this.senha = senha;

    }

    void setTam(int tam) {
        this.tam = tam;

    }

    void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Senha senha1 = (Senha) o;
        return tam == senha1.tam &&
                ocorrencias == senha1.ocorrencias &&
                Objects.equals(senha, senha1.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senha, tam, ocorrencias);
    }

    String getSenha(){
        return senha;
    }
   int getTam(){
        return tam;
    }

    int getOcorrencias(){
        return ocorrencias;
    }
}
