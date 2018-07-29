package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.FilmeController;
import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;

public class FilmeDataBase {

        //  Trailler width: 450 height: 275
        // Filme width: 1382 height 784

        //Modelo sinopse
//                        "Captain John Miller (Tom Hanks) takes his men behind enemy \n" +
//        "                \\nlines to find Private James Ryan, whose three brothers have\n" +
//        "                \\nbeen killed in combat. Surrounded by the brutal realties of war,\n" +
//        "                \\nwhile searching for Ryan, each man embarks upon a personal journey\n" +
//        "                \\nand discovers their own strength to triumph over an uncertain future\n" +
//        "                \\nwith honor, decency and courage.";

        public static void drama1(){

                String titulo = "O Resgate do Soldado Ryan";

                String sinopse = "Captain John Miller (Tom Hanks) takes his men" +
                                 "\nbehind enemy lines to find Private James Ryan, " +
                                 "\nwhose three brothers have been killed in combat." +
                                 "\nSurrounded by the brutal realties of war, while  " +
                                 "\nsearching for Ryan, each man embarks upon a personal" +
                                 "\njourney and discovers their own strength to triumph" +
                                 "\nover an uncertain future with honor, decency and courage.";


                String urlM = "http://t2.gstatic.com/images?q=tbn:ANd9GcR0lDhR_dXAKTm9wysp3nWu6kP0V5skJBVbCNC_Q8urAWcr4iF_";
                String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/RYExstiQlLc?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
                String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/RYExstiQlLc?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

                int ano = 1998;
                int h = 2;
                int min = 49;
                double preco = 200;

                Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.DRAMA,preco);
                filme.setUrlFilme(urlF);
                filme.setUrlMiniatura(urlM);
                filme.setUrlTrailler(urlT);

                FilmeController controller = FilmeController.getInstance();

                try {
                        controller.cadastrarFilme(filme);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static void aventura1(){
            String titulo = "Warcraft: O Primeiro Encontro de Dois Mundos";

            String sinopse = "A região de Azeroth sempre viveu em paz, até a chegada " +
                             "\ndos guerreiros Orc. Com a abertura de um portal, eles " +
                             "\npuderam chegar à nova Terra com a intenção de destruir" +
                             "\no povo inimigo. Cada lado da batalha possui um grande " +
                             "\nherói, e os dois travam uma disputa pessoal, colocando" +
                             "\nem risco seu povo, sua família e todas as pessoas que amam.";


            String urlM = "http://br.web.img2.acsta.net/r_1920_1080/pictures/16/03/30/18/58/593834.jpg";
            String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/Dqvz8w-latE?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
            String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/Dqvz8w-latE?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

            int ano = 2016;
            int h = 2;
            int min = 04;
            double preco = 200;

            Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.AVENTURA,preco);
            filme.setUrlFilme(urlF);
            filme.setUrlMiniatura(urlM);
            filme.setUrlTrailler(urlT);

            FilmeController controller = FilmeController.getInstance();

            try {

//                controller.removerFilme(controller.procurarFilme(titulo));
                    controller.cadastrarFilme(filme);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void drama2(){

            String titulo = "Cavalo de Guerra";

            String sinopse = "A história da amizade entre Albert e seu cavalo Joey." +
                             "\nDepois de ser vendido para a cavalaria inglesa" +
                             "\ndurante a Primeira Guerra Mundial, o corcel emociona" +
                             "\nambos os lados com sua bravura. Albert se alista para " +
                             "\nrecuperar seu amigo e trazer Joey de volta para casa.";


            //width="1382" height="784"
            String urlM = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXBuSj7EtQjW3iitUzdRx4geUWvrBMogLSRSLE3DvWQKHcAAuNDilnHw";
            String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/T96mgZFAQkQ?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
            String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/T96mgZFAQkQ?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

            int ano = 2011;
            int h = 2;
            int min = 26;
            double preco = 250;

            Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.DRAMA,preco);
            filme.setUrlFilme(urlF);
            filme.setUrlMiniatura(urlM);
            filme.setUrlTrailler(urlT);

            FilmeController controller = FilmeController.getInstance();

            try {
           //   controller.removerFilme(controller.procurarFilme(titulo));
                controller.cadastrarFilme(filme);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    public static void drama3(){

        String titulo = "Uma Mente Brilhante";

        String sinopse = "John Forbes Nash Jr. é reconhecido como gênio da matemática" +
                         "\naos 21 anos. Cedo, casa-se com uma bela mulher, mas logo " +
                         "\ncomeça a dar sinais de esquizofrenia. Após anos de luta " +
                          "\ncontra a doença, ele acaba ganhando o prêmio Nobel.";


        //width="1382" height="784"
        String urlM = "https://upload.wikimedia.org/wikipedia/pt/thumb/b/b1/UmaMenteBrilhante.jpg/225px-UmaMenteBrilhante.jpg";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/NHFjCMwd3Pk?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/NHFjCMwd3Pk?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        int ano = 2001;
        int h = 2;
        int min = 20;
        double preco = 225;

        Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.DRAMA,preco);
        filme.setUrlFilme(urlF);
        filme.setUrlMiniatura(urlM);
        filme.setUrlTrailler(urlT);

        FilmeController controller = FilmeController.getInstance();

        try {
        //    controller.removerFilme(controller.procurarFilme(titulo));
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
