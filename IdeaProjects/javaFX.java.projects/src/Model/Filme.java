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

    public static ArrayList <Filme> getFilmes (Filme filme){
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
