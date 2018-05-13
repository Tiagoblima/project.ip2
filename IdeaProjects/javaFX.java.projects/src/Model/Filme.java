package Model;

import Interface.Main;

import java.util.ArrayList;
import java.util.Objects;

public class Filme {

    private String titulo;
    private int duracaoHora;
    private int duracaoMinuto;
    private int anoLanc;
    private String sinopse;

    public Filme(String titulo, int duracaoHora, int duracaoMinuto, int anoLanc, String sinopse) {
        this.titulo = titulo;
        this.duracaoHora = duracaoHora;     //SERÁ PRECISO TRATAR ESSA ENTRADA, POIS ELA NÃ PODERÁ SER MAIOR QUE 23
        this.duracaoMinuto = duracaoMinuto; //SERÁ PRECISO TRATAR ESSA ENTRADA, POIS ELA NÃ PODERÁ SER MAIOR QUE 59
        this.anoLanc = anoLanc;
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoHora() {
        return duracaoHora;
    }

    public void setDuracaoHora(int duracaoHora) {
        this.duracaoHora = duracaoHora;
    }

    public int getDuracaoMinuto() {
        return duracaoMinuto;
    }

    public void setDuracaoMinuto(int duracaoMinuto) {
        this.duracaoMinuto = duracaoMinuto;
    }

    public int getAnoLanc() {
        return anoLanc;
    }

    public void setAnoLanc(int anoLanc) {
        this.anoLanc = anoLanc;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public boolean adicionaFilme(Filme filme){
        //TODO FINALIZAR IMPLEMENTAÇÃO DO CADASTRO DE FILMES
        getFilmes().add(filme);

        return true; // retorno provisório
    }
    public boolean removeFilme(Filme filme){
        //TODO FINALIZAR IMPLEMENTAÇÃO DA REMOÇÃO DE FILMES
        getFilmes().remove(filme);

        return true; // retorno provisório
    }
    public boolean atualizaFilme(Filme a, Filme a2){
        //TODO FINALIZAR IMPLEMENTAÇÃO DA ATUALIZAÇÃO DE FILMES
        getFilmes().remove(a);
        getFilmes().add(a2);

        return true; //retorno provisório
    }

    public static ArrayList <Filme> getFilmes (){
        ArrayList<Filme> filmes = new ArrayList<>();

        return filmes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Filme)) {
            return false;
        }
        Filme filme = (Filme) o;

        return getDuracaoHora() == filme.getDuracaoHora() &&
                getDuracaoMinuto() == filme.getDuracaoMinuto() &&
                getAnoLanc() == filme.getAnoLanc() &&
                Objects.equals(getTitulo(), filme.getTitulo()) &&
                Objects.equals(getSinopse(), filme.getSinopse());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitulo(), getDuracaoHora(), getDuracaoMinuto(), getAnoLanc(), getSinopse());
    }

    @Override
    public String toString() {
        return  "Título: " + titulo + "/n" +
                "Duração: "+ duracaoHora + ":" + duracaoMinuto + "/n"+
                "Ano de Lançamento: " + anoLanc + "/n"+
                "Sinopse: /n" + sinopse;
    }
}
