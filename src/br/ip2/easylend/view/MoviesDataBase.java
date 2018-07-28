package br.ip2.easylend.view;

import br.ip2.easylend.controller.FilmeController;
import br.ip2.easylend.model.Filme;

import static br.ip2.easylend.model.GeneroFilme.DRAMA;

public class MoviesDataBase {





    public static void drama1(){

        FilmeController controller = FilmeController.getInstance();

        String titulo = "O Resgate do Soldado Ryan";

        String urlM = "https://images.livrariasaraiva.com.br/imagemnet/imagem.aspx/?pro_id=9416818&qld=90&l=430&a=-1";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/RYExstiQlLc?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/RYExstiQlLc?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        double preco = 20;
        int hora = 2;
        int min = 49;
        int ano = 1998;

        String sinopse = "Ao desembarcar na Normandia, no dia 6 de junho de 1944,\n" +
                         "o Capitão Miller recebe a missão de comandar um grupo do\n" +
                         "Segundo Batalhão para o resgate do soldado James Ryan, " +
                         "\no caçula de quatro irmãos, dentre os quais três morreram " +
                         "\nem combate. Por ordens do chefe George C. Marshall, eles " +
                         "\nprecisam procurar o soldado e garantir o seu retorno, " +
                         "\ncom vida, para casa.";



        Filme filme = new Filme(titulo,hora,min,ano,sinopse,DRAMA,preco);

        filme.setUrlFilme(urlF);
        filme.setUrlMiniatura(urlM);
        filme.setUrlTrailler(urlT);
        try {
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void drama2(){

        FilmeController controller = FilmeController.getInstance();

        String titulo = "Cavalo de Guerra";

        String urlM = "https://img.wook.pt/images/cavalo-de-guerra-michael-morpurgo/MXwxMzk5ODUwN3w5NTcyNDUwfDEzODM1MjMyMDAwMDA=/250x";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/JPNyNr2Kp4w?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/JPNyNr2Kp4w?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        double preco = 25;
        int hora = 2;
        int min = 27;
        int ano = 2011;

        String sinopse = "A história da amizade entre Albert e seu cavalo Joey.\n" +
                "Depois de ser vendido para a cavalaria inglesa durante\n" +
                "a Primeira Guerra Mundial, o corcel emociona ambos os\n" +
                "lados com sua bravura. Albert se alista para recuperar\n" +
                "seu amigo e trazer Joey de volta para casa.";



        Filme filme = new Filme(titulo,hora,min,ano,sinopse,DRAMA,preco);

        filme.setUrlFilme(urlF);
        filme.setUrlMiniatura(urlM);
        filme.setUrlTrailler(urlT);
        filme.setUrlImdb("https://www.imdb.com/title/tt0120815/");
        try {
            controller.removerFilme(controller.procurarFilme(filme.getTitulo()));
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
