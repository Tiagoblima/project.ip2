package br.ip2.easylend.controller;

import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;

import java.util.ArrayList;

public class Features {



    private Filme filme;
    private GeneroFilme genero;
    private boolean preferencia;

    public Features(Filme filme , GeneroFilme genero , boolean preferencia) {
        this.filme = filme;
        this.genero = genero;
        this.preferencia = preferencia;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    public boolean isPreferencia() {
        return preferencia;
    }

    public void setPreferencia(boolean preferencia) {
        this.preferencia = preferencia;
    }
}




