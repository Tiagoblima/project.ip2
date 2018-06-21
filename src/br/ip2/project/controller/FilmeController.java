package br.ip2.project.controller;

import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;

public class FilmeController {
    public static boolean salvarFilme(String titulo, int duracaoHora, int duracaoMinuto, int anoLanc, String sinopse, GeneroFilme generoFilme){
        Filme filme;
        filme = new Filme(titulo,duracaoHora,duracaoMinuto, anoLanc, sinopse, generoFilme);

        return true; //retorno temporário, só para não dar erro

    }
}
