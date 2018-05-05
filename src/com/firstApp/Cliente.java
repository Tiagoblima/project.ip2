package com.firstApp;

public class Cliente extends Pessoa {

    private int qtdFilmes;
    private Catalogo catalogo;
    private double credito;

    public Cliente(String nome, int idade, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;

    }
    public int getQtdFilmes() {
        return qtdFilmes;
    }

    public void setQtdFilmes(int qtdFilmes) {
        this.qtdFilmes = qtdFilmes;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    public void compraCredito(double dinheiro){
        this.credito += dinheiro*(dinheiro/4);
    }



}
