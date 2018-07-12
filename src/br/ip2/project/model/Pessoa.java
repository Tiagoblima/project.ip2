package br.ip2.project.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    protected String nome;
    protected String email;
    protected String dataAniv;
    protected String login;
    protected String senha;
    protected Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAniv() {
        return this.dataAniv;
    }

    public void setDataAniv(String dataAniv) {
        this.dataAniv = dataAniv;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco(){
        return endereco;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

//EQUALS, HASHCODE E TOSTRING


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getLogin(), pessoa.getLogin()) &&
                Objects.equals(getSenha(), pessoa.getSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getSenha());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataAniv='" + dataAniv + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
