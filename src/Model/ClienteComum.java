package Model;
import Model.Interface.Cliente;

import java.util.*;
public class ClienteComum extends Pessoa implements Cliente {



    private double credito;
    private int qtdFilmes;


    public ClienteComum(String nome,String email ,Date dataAniv, String login, String senha,int qtdFilmes, double credito) {
        this.nome = nome;
        this.dataAniv = dataAniv;
        this.login = login;
        this.senha = senha;
        this.qtdFilmes = qtdFilmes;
        this.credito = credito;
        this.email = email;
    }


    @Override
    public void setLimiteDeCredito() {

    }

    @Override
    public void setLimiteDeFilmes() {

    }

    @Override
    public void setLimiteDeTempo() {

    }

    @Override
    public String getEmail(){
        return this.email;
    }

    @Override
    public int getQtdFilmes() {
        return this.qtdFilmes;
    }

    @Override
    public void setQtdFilmes(int qtdFilmes) {
    this.qtdFilmes= qtdFilmes;
    }

    @Override
    public double getCredito() {
        return this.credito;
    }

    @Override
    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public void compraCredito(double dinheiro) {
        this.credito = dinheiro;
    }

    //TODO Pensar nas desvantagens de ser um Cliente Comum
}
