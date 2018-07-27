package br.ip2.easylend.model;

import java.io.Serializable;
import java.util.Objects;

public class Filme implements Serializable {
//commit teste

    private String titulo;
    private GeneroFilme genero;
    private int duracaoHora;
    private int duracaoMinuto;
    private int anoLanc;
    private String sinopse;
    private String urlMiniatura;
    private String urlFilme;
    private String urlTrailler;
    private double preco;

    public Filme(String titulo, int duracaoHora, int duracaoMinuto, int anoLanc, String sinopse, GeneroFilme genero, double preco) {

        this.titulo = titulo;
        this.duracaoHora = duracaoHora;
        this.duracaoMinuto = duracaoMinuto; 
        this.anoLanc = anoLanc;
        this.sinopse = sinopse;
        this.genero = genero;
        this.preco = preco;
    }
    public void verificaHora(int hora) throws Exception{
        if(hora>23 || hora<0){
            throw new Exception();
        }
    }
    public void verificaMinuto(int minuto) throws Exception{
        if(minuto>59 || minuto<0){
            throw new Exception();
        }
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

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    public void setUrlMiniatura(String urlMiniatura){
        this.urlMiniatura = urlMiniatura;
    }

    public String getUrlMiniatura(){
        return this.urlMiniatura;
    }

    public void setUrlFilme(String urlMidia){
        this.urlFilme = urlMidia;
    }

    public String getUrlFilme(){
        return this.urlFilme;
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

    public String getUrlTrailler() {
        return urlTrailler;
    }

    public void setUrlTrailler(String urlTrailler) {
        this.urlTrailler = urlTrailler;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}


