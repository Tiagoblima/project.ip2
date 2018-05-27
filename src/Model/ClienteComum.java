package Model;
import java.util.*;
public class ClienteComum extends Pessoa implements Cliente {


    public ClienteComum(int qtdFilmes, double credito, String nome, int idade, String cpf, Date dataAniv, Endereco endereco, String login, String senha) {

    }

    @Override
    public void Cliente(int qtdFilmes, double credito, String nome, Date dataAniv, String login, String senha) {

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

    //TODO Pensar nas desvantagens de ser um Cliente Comum
}
