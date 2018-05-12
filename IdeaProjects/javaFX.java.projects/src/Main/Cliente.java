package Main;


import java.lang.*;
public class Cliente extends Pessoa {

    private int qtdFilmes;
    private Catalogo catalogo;
    private double credito;
    private Filme filme;
    private String login;
    private String senha;


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
