package main.java.br.ip2.project.model;

public enum GeneroFilme {
    TERROR, COMEDIA, ACAO, AVENTURA, ROMANCE, COMEDIA_ROMANTICA, INVALIDO, DRAMA;

    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void digaOqEh(GeneroFilme g){
        switch (g){
            case ACAO:
                System.out.println("Ação");
                g.setNome("Ação");
                break;

            case TERROR:
                System.out.println("Terror");
                g.setNome("Terror");
                break;

            case COMEDIA:
                System.out.println("Comédia");
                g.setNome("Comédia");
                break;

            case AVENTURA:
                System.out.println("Aventura");
                g.setNome("Aventura");
                break;

            case ROMANCE:
                System.out.println("Romance");
                g.setNome("Romance");
                break;

            case COMEDIA_ROMANTICA:
                System.out.println("Comédia Romantica");
                g.setNome("Comédia Romantica");
                break;

            case INVALIDO:
                System.out.println("Gênero Inválido");
                g.setNome("Gênero Inválido");
                break;

            default:
                System.out.println("Que gênero é esse?");
                g.setNome("Que gênero é esse?");
                break;
        }

    }


}
