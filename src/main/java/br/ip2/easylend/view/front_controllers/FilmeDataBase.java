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

        public static void drama2(){

            String titulo = "Cavalo de Guerra";

            String sinopse = "A história da amizade entre Albert e seu cavalo Joey." +
                             "\nDepois de ser vendido para a cavalaria inglesa" +
                             "\ndurante a Primeira Guerra Mundial, o corcel emociona" +
                             "\nambos os lados com sua bravura. Albert se alista para " +
                             "\nrecuperar seu amigo e trazer Joey de volta para casa.";


            //width="1382" height="784"
            String urlM = "https://upload.wikimedia.org/wikipedia/pt/thumb/7/73/War_Horse_P%C3%B4ster.jpg/220px-War_Horse_P%C3%B4ster.jpg";
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
//              controller.removerFilme(filme);
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


    public static void aventura2(){

        String titulo = "Jurassic World";

        String sinopse = "Localizado na costa da Costa Rica,\n" +
                         "o resort de luxo Jurassic World oferece\n" +
                         "um habitat para uma variedade de dinossauros\n" +
                         "geneticamente modificados, incluindo o indomável\n" +
                         "e inteligente Indominus rex. Quando a criatura\n" +
                         "massiva escapa, desencadeia uma reação em cadeia\n" +
                         "que faz com que os outros dinossauros corram furiosos.\n" +
                         "Agora , cabe a um ex-militar e especialista em animais\n" +
                         "(Chris Pratt) usar suas habilidades especiais para salvar\n" +
                         "dois jovens irmãos e o resto dos turistas de um ataque " +
                         "\npré-histórico e total.";


        String urlM = "http://t1.gstatic.com/images?q=tbn:ANd9GcT9t_mvZu0k-wS_QqvQmPKc6FMkwJoj0HgUjwLJK7uGG_NtZBxV";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/uLvNnhZwKmA?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1380\" height=\"784\" src=\"https://www.youtube.com/embed/uLvNnhZwKmA?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        int ano = 2015;
        int h = 2;
        int min = 4;
        double preco = 195;

        Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.AVENTURA,preco);
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

    public static void acao3(){

        String titulo = "Warcraft: O Primeiro Encontro de Dois Mundos";

        String sinopse = "Ethan Hunt e a equipe do FMI unem forças\n" +
                         "com o assassino da CIA, August Walker,\n" +
                         "para evitar um desastre de proporções épicas.\n" +
                         "O negociante de armas John Lark e um grupo\n" +
                         "de terroristas conhecidos como os Apóstolos\n" +
                         "planejam usar três núcleos de plutônio para\n" +
                         "um ataque nuclear simultâneo ao Vaticano," +
                         "Jerusalém e Meca, a Arábia Saudita .\n" +
                         "Quando as armas desaparecem, Ethan e sua\n" +
                         "equipe se encontram em uma corrida desesperada\n" +
                         "contra o tempo para evitar que caiam nas mãos erradas.";


        String urlM = "http://t1.gstatic.com/images?q=tbn:ANd9GcTDuzrnxIkh11AqI-6PrU9Qrycml22OhFHM9UwGmlkxCsPctLTr";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/wb49-oV0F78?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1380\" height=\"784\" src=\"https://www.youtube.com/embed/wb49-oV0F78?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        int ano = 2018;
        int h = 2;
        int min = 28;
        double preco = 350;

        Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.ACAO,preco);
        filme.setUrlFilme(urlF);
        filme.setUrlMiniatura(urlM);
        filme.setUrlTrailler(urlT);

        FilmeController controller = FilmeController.getInstance();

        try {
             //  controller.removerFilme(controller.procurarFilme(titulo));
               filme.setTitulo("Mission: Impossible – Fallout");
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //  Trailler width: 450 height: 275
    // Filme width: 1382 height 784
    public static void acao1(){

        String titulo = "Ant-Man and the Wasp";

        String sinopse = "Scott Lang está lidando com as conseqüências\n" +
                         "de suas escolhas como super-herói e pai.\n" +
                         "Abordado por Hope van Dyne e Dr. Hank Pym,\n" +
                         "Lang deve mais uma vez vestir a roupa de Homem-Formiga\n" +
                         "e lutar ao lado da Vespa. A missão urgente logo leva\n" +
                         "a revelações secretas do passado como a dupla dinâmica\n" +
                         "fi se encontra em uma batalha épica contra um poderoso\n" +
                         "novo inimigo.\n";


        //width="1382" height="784"
        String urlM = "http://t1.gstatic.com/images?q=tbn:ANd9GcQeA9IA-C1GiNpVwEXXm-jcFOFpuYvjd-n30RmAtSs8511N2NMi";
        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/UUkn-enk2RU?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/UUkn-enk2RU?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        int ano = 2018;
        int h = 2;
        int min = 5;
        double preco = 321;

        Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.ACAO,preco);
        filme.setUrlFilme(urlF);
        filme.setUrlMiniatura(urlM);
        filme.setUrlTrailler(urlT);

        FilmeController controller = FilmeController.getInstance();

        try {
//            controller.removerFilme(filme);
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void acao2(){

        String titulo = "Vingadores da Marvel montam";

        String sinopse = "Quando o malvado irmão de Thor, Loki (Tom Hiddleston),\n" +
                         "ganha acesso ao poder ilimitado do cubo de energia\n" +
                          "chamado Tesseract, Nick Fury (Samuel L. Jackson),\n" +
                         "diretor da SHIELD, inicia um esforço de recrutamento\n" +
                         "de super-heróis para derrotar a ameaça sem precedentes" +
                         "à Terra. Juntando-se à \"equipe dos sonhos\" do Fury estão" +
                         "Homem de Ferro (Robert Downey Jr.), Capitão América (Chris Evans)," +
                         "o Hulk (Mark Ruffalo), Thor (Chris Hemsworth), a Viúva Negra " +
                         "(Scarlett Johansson) e Hawkeye (Jeremy Renner).";


        //width="1382" height="784"
        String urlM = "http://t1.gstatic.com/images?q=tbn:ANd9GcTp0qlAoWcOOswIkL_qpjYzJqCCDmWXiBzCXiqbE43Obo8c0Z-s";
        String urlT = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/kq84NymZYJE?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlF = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/kq84NymZYJE?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        int ano = 2012;
        int h = 2;
        int min = 23;
        double preco = 289;

        Filme filme = new Filme(titulo,h,min,ano,sinopse, GeneroFilme.ACAO,preco);
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

}
