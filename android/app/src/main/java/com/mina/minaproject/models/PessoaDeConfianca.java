package com.mina.minaproject.models;

public class PessoaDeConfianca {
    private String nome;
    private String telefone;
    private String nivelDeRelacionamento;

    public PessoaDeConfianca() {
    }

    public PessoaDeConfianca(String nome, String telefone, String nivelDeRelacionamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.nivelDeRelacionamento = nivelDeRelacionamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNivelDeRelacionamento() {
        return nivelDeRelacionamento;
    }

    public void setNivelDeRelacionamento(String nivelDeRelacionamento) {
        this.nivelDeRelacionamento = nivelDeRelacionamento;
    }
}
