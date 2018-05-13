package Model;



public  class Catalogo {
    private Filme[] filmes;

    public Catalogo(Filme[] filmes) {
        this.filmes = filmes;
    }

    public Filme[] getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme[] filmes) {
        this.filmes = filmes;
    }

}
