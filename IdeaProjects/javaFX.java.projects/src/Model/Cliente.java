package Model;

import java.lang.*;

public abstract class Cliente extends Pessoa {

    private int qtdFilmes;
    private double credito;

    public Cliente(int qtdFilmes, double credito, String nome, int idade, String cpf, String dataAniv, Endereco endereco, String login, String senha) {
        super(nome,idade, cpf,dataAniv, endereco, login, senha);
        this.qtdFilmes = qtdFilmes;
        this.credito = credito;

    }

    public int getQtdFilmes() {
        return qtdFilmes;
    }

    public void setQtdFilmes(int qtdFilmes) {
        this.qtdFilmes = qtdFilmes;
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
