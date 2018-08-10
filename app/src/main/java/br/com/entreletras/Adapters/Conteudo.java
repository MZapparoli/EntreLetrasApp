package br.com.entreletras.Adapters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Conteudo implements Serializable{

    public String titulo;
    public String descricao;

    public Conteudo() {

    }

    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
