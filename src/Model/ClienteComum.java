package Model;
import Model.Interface.Cliente;

import java.util.*;
public class ClienteComum extends Pessoa implements Cliente {



    private double credito;
    private int qtdFilmes;



    public ClienteComum(String nome,String email ,String dataAniv, String login, String senha,int qtdFilmes, double credito)throws Exception {


        verificarInput(nome);
        verificarInput(dataAniv);
        verificarInput(login);
        verificarInput(senha);
        verificarInput(email);

        this.nome = nome;
        this.dataAniv = dataAniv;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.qtdFilmes = qtdFilmes;
        this.credito = credito;


    }

    public void verificarInput(String string)throws Exception
    {
        if(string.isEmpty()) {
            throw new Exception();
        }
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
    public String getLogin(){
        return this.login;
    }

    @Override
    public String getSenha(){
        return this.senha;
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
