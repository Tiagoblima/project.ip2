package Controller;

import Model.Filme;
import Model.GeneroFilme;

public class FilmeController {
    public static boolean salvarFilme(String titulo, int duracaoHora, int duracaoMinuto, int anoLanc, String sinopse, GeneroFilme generoFilme){
        Filme filme;
        filme = new Filme(titulo,duracaoHora,duracaoMinuto, anoLanc, sinopse, generoFilme);

        return true; //retorno temporário, só para não dar erro

    }
}
