package Controller;

import Model.Filme;

public class FilmeController {
    public static boolean salvarFilme(String titulo, int duracaoHora, int duracaoMinuto, int anoLanc, String sinopse){
        Filme filme;
        filme = new Filme(titulo,duracaoHora,duracaoMinuto, anoLanc, sinopse);

        return true; //retorno temporário, só para não dar erro

    }
}
