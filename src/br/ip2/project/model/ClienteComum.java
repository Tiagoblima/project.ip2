package br.ip2.project.model;

public class ClienteComum extends Cliente {


    public ClienteComum(String nome, String email, String dataAniv, String login, String senha, int qtdFilmes, double credito) throws Exception {
        super(nome, email, dataAniv, login, senha, qtdFilmes, credito);
         super.tipoCliente = "Comum";
    }

    @Override
    public void mudarTipoCliente() { super.tipoCliente = "Premium"; }

    @Override
    public void setLimiteDeCredito() {

    }

    @Override
    public void setLimiteDeFilmes() {

    }

    @Override
    public void setLimiteDeTempo() {

    }




    //TODO Pensar nas desvantagens de ser um Cliente Comum
}
