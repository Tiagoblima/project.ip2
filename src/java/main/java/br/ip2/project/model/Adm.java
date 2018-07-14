package main.java.br.ip2.project.model;

public class Adm extends Pessoa {

    private String codigoDeAcesso;

    public Adm(Catalogo catalogo, String nome, String dataAniv, String login, String senha,String codigoDeAcesso) {

        this.nome = nome;
        this.dataAniv = dataAniv;
        this.login = login;
        this.senha = senha;
        this.codigoDeAcesso = codigoDeAcesso;
    }



}
