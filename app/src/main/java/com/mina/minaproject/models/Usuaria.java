package com.mina.minaproject.models;

import java.util.ArrayList;
import java.util.Date;

public class Usuaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String cidade;
    private String email;
    private String senha;
    private ArrayList<PessoaDeConfianca> pessoasDeConfianca = new ArrayList();

    private double latitude;
    private double longitude;

    public Usuaria() {

    }

    public void salvarFirestore(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<PessoaDeConfianca> getPessoasDeConfianca() {
        return pessoasDeConfianca;
    }

    public void setPessoasDeConfianca(ArrayList<PessoaDeConfianca> pessoasDeConfianca) {
        this.pessoasDeConfianca = pessoasDeConfianca;
    }

    public void addPessoasDeConfianca(PessoaDeConfianca pessoasDeConfianca) {
        this.pessoasDeConfianca.add(pessoasDeConfianca);
    }
}
