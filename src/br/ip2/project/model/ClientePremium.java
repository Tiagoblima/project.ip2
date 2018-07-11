package br.ip2.project.model;

public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, String dataAniv, String login, String senha, int qtdFilmes, double credito) throws Exception {
        super(nome, email, dataAniv, login, senha, qtdFilmes, credito);
    }


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

    @Override
    public int getQtdFilmes() {
        return 0;
    }

    @Override
    public void setQtdFilmes(int qtdFilmes) {

    }

    @Override
    public double getCredito() {
        return 0;
    }

    @Override
    public void setCredito(double credito) {

    }

    @Override
    public void compraCredito(double dinheiro) {

    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getDataAniv() {
        return this.dataAniv;
    }


}
