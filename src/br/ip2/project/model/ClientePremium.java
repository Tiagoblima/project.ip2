package br.ip2.project.model;

public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, String dataAniv, String login, String senha, int qtdFilmes, double credito) throws Exception {
        super(nome, email, dataAniv, login, senha, qtdFilmes, credito);
    }


    //TODO Pensar nas vantagens de ser um Cliente Premium



    @Override
    public void setTipoCliente() { this.tipoCliente = "Premium"; }

    @Override
    public void setLimiteDeCredito() {

    }

    @Override
    public void setLimiteDeFilmes() {

    }

    @Override
    public void setLimiteDeTempo() {

    }








}
