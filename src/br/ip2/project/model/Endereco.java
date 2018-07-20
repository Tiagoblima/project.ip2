package br.ip2.project.model;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String rua;
    private String bairro;
    private String estado;
    private String cidade;
    private int numero;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return  rua +
                ", " + numero + ".\n "+ bairro +", "+
                ". " + cidade +
                ", " + estado +
                ".";
    }
}
