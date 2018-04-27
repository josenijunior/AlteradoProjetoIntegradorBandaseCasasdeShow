package com.appdigital.projetointegradorbandasecasasdeshow.model;

public class CasaDeShow {
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String telefone;
    private String cpf;
    private String tipocs;

    public CasaDeShow(String nome, String endereco, String bairro, String cidade, String email, String telefone, String cpf, String statuscasadeshow ){
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.tipocs = statuscasadeshow;



    }

    public String getTipocs() {
        return tipocs;
    }

    public void setTipocs(String tipocs) {
        this.tipocs = tipocs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




}
