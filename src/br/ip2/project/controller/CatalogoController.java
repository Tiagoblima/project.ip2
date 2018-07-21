package br.ip2.project.controller;

import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;
import br.ip2.project.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static br.ip2.project.model.GeneroFilme.*;

public class CatalogoController {


    private static CatalogoController controller;
    private final HashMap<GeneroFilme, ArrayList<Filme>> catalogo = new HashMap<>();
    private final HashMap<Integer, Filme> fullHashMap = new HashMap<Integer, Filme>();;
    private final GeneroFilme genero;



    private CatalogoController(GeneroFilme generoFilme){


        Repositorio<HashMap<Integer, Filme>> repositorio = new Repositorio<>();

        HashMap<Integer, Filme> hashMap;
        try{
            hashMap = repositorio.ler("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
        }catch (Exception e){
            hashMap = new HashMap<>();
        }

        fullHashMap.putAll(hashMap);

        genero = generoFilme;
        gerarCatalogo();

    }


    public static CatalogoController getInstance(){
        return controller;
    }

    public static CatalogoController getInstance(GeneroFilme generoFilme){
         controller = new CatalogoController(generoFilme);
         return controller;
    }
    private void gerarCatalogo(){


        Collection<Filme> filmes =  fullHashMap.values();


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

    public HashMap<Integer, Filme> getFullHashMap() {
        return fullHashMap;
    }
    public ArrayList<Filme> getArrayFilmes(GeneroFilme genero){
       return this.catalogo.get(genero);
    }


    public GeneroFilme getGenero() {
        return genero;
    }
}
