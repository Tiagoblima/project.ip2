package br.ip2.project.model;
import br.ip2.project.model.Interface.Cliente;

public class ClientePremium extends Pessoa implements Cliente {


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
