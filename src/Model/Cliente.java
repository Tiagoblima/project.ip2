package Model;

import java.util.Date;

public interface Cliente {


    public abstract void Cliente(int qtdFilmes, double credito, String nome, Date dataAniv, String login, String senha);

    public abstract void setLimiteDeCredito();
    public abstract void setLimiteDeFilmes();
    public abstract void setLimiteDeTempo();


    public abstract int getQtdFilmes();

    public abstract void setQtdFilmes(int qtdFilmes);

    public abstract double getCredito();

    public abstract void setCredito(double credito);

    public abstract void compraCredito(double dinheiro);

}
