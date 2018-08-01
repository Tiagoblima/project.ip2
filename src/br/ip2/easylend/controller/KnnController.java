package br.ip2.easylend.controller;

import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;

import java.util.ArrayList;

public class KnnController {

    private static KnnController ourInstance = new KnnController();

    private ArrayList<Filme> filmes;
    private ArrayList<Filme> clienteFilmes;
    private ArrayList<Features> featuresArrayList;
    private ArrayList<Filme> selectedFilmes;

    public static KnnController getInstance() {
        return ourInstance;
    }

    private KnnController() {

    }


    public void setArraies(ArrayList<Filme> filmes, ArrayList<Filme> clienteFilmes){
        this.filmes = filmes;
        this.clienteFilmes = clienteFilmes;
    }


    public ArrayList<Filme> knnRun() {

        this.featuresArrayList = new ArrayList <>();

        boolean preferencia = false;

        for (Filme cFilme : this.clienteFilmes) {

            GeneroFilme genero = cFilme.getGenero();

            for (Filme filme : this.filmes) {

                if(genero.equals(filme.getGenero()) && ! filme.equals(cFilme)){ preferencia = true; }

                this.featuresArrayList.add(new Features(filme,genero,preferencia));

            }

        }
        selectFilme();
        return selectedFilmes;
    }

    public ArrayList <Filme> getSelectedFilmes() {
        return selectedFilmes;
    }

    public void setSelectedFilmes(ArrayList <Filme> selectedFilmes) {
        this.selectedFilmes = selectedFilmes;
    }

    public void selectFilme(){

        for (Features features: this.featuresArrayList) {
            if(features.isPreferencia()){ this.selectedFilmes.add(features.getFilme());}
        }
    }
    public ArrayList <Features> getFeaturesArrayList() {
        return featuresArrayList;
    }
}



