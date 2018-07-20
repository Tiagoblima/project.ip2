package br.ip2.project.controller;

import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;
import br.ip2.project.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static br.ip2.project.model.GeneroFilme.*;

public class CatalogoController {


    private HashMap<GeneroFilme, ArrayList<Filme>> catalogo;
    private HashMap<Integer,Filme> fullHashMap;


    public CatalogoController(HashMap<Integer, Filme> origin){

        this.fullHashMap = origin;
        gerarCatalogo();

    }

    private void gerarCatalogo(){


        Collection<Filme> filmes =  this.fullHashMap.values();
        this.catalogo = new HashMap<>();

        ArrayList<Filme> arrayDrama = new ArrayList<>();
        ArrayList<Filme> arrayAcao = new ArrayList<>();
        ArrayList<Filme> arrayFamilia = new ArrayList<>();
        ArrayList<Filme> arrayNacionais = new ArrayList<>();
        ArrayList<Filme> arrayTerror = new ArrayList<>();
        ArrayList<Filme> arrayComedia = new ArrayList<>();
        ArrayList<Filme> arrayRomance = new ArrayList<>();

        for (Filme filme: filmes) {

            switch (filme.getGenero()){

                case DRAMA: { arrayDrama.add(filme); break; }
                case ACAO: { arrayAcao.add(filme); break; }
                case FAMILIA:{ arrayFamilia.add(filme); break; }
                case NACIONAIS: { arrayNacionais.add(filme); break; }
                case TERROR: { arrayTerror.add(filme);break; }
                case COMEDIA:{ arrayComedia.add(filme);break; }
                case ROMANCE: { arrayRomance.add(filme);break; }
            }

        }

        this.catalogo.put(DRAMA,arrayDrama);
        this.catalogo.put(ACAO,arrayAcao);
        this.catalogo.put(FAMILIA,arrayFamilia);
        this.catalogo.put(NACIONAIS,arrayNacionais);
        this.catalogo.put(TERROR,arrayTerror);
        this.catalogo.put(COMEDIA,arrayComedia);
        this.catalogo.put(ROMANCE,arrayRomance);

    }
    public HashMap<GeneroFilme,ArrayList<Filme>> getCatalogo(){

        gerarCatalogo();
        return this.catalogo;
    }

    public void setCatalogo(HashMap<GeneroFilme, ArrayList<Filme>> catalogo) {
        this.catalogo = catalogo;
    }

    public HashMap<Integer, Filme> getFullHashMap() {
        return fullHashMap;
    }

    public void setFullHashMap(HashMap<Integer, Filme> fullHashMap) {
        this.fullHashMap = fullHashMap;
    }

    public ArrayList<Filme> getArrayFilmes(GeneroFilme genero){
       return this.catalogo.get(genero);
    }


}
