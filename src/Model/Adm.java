package Model;

import java.util.Date;

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
