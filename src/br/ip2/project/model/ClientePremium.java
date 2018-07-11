package br.ip2.project.model;

public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, String dataAniv, String login, String senha, int qtdFilmes, double credito) throws Exception {
        super(nome, email, dataAniv, login, senha, qtdFilmes, credito);
        super.tipoCliente = "Premium";
    }

    @Override
    public void mudarTipoCliente() { super.tipoCliente = "Comum"; }


    //TODO Pensar nas vantagens de ser um Cliente Premium

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
