package br.ip2.project.controller;




import br.ip2.project.model.*;
import br.ip2.project.repositorio.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FilmeController {


    //Eu alterei para não estatico para poder retornar o hashMap
    private HashMap<Integer, Filme> fHashmap;
    private static HashMap<String, Filme> findHashmap;
    private Filme filme;
    private Repositorio<HashMap<Integer, Filme>> repositorio = new Repositorio<>();


    public FilmeController(){
        try{
            fHashmap = this.repositorio.ler("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
        }catch (Exception e){
            fHashmap = new HashMap<>();
        }
    }

    public void setFilme(Filme filme){
        this.filme = filme;
    }

    public Filme getFilme(){
        return fHashmap.get(this.filme.hashCode());
    }


    public void cadastrarFilme(Filme f) throws Exception{
        this.filme = f;
        if(fHashmap.containsKey(this.filme.hashCode())){
            throw new Exception();
        }
        fHashmap.put(this.filme.hashCode(),f);
        this.repositorio.setObject(fHashmap);
        this.repositorio.salvar("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void removerFilme(Filme f) throws Exception{
        this.filme = f;
        if (fHashmap.containsKey(this.filme.hashCode())){
            fHashmap.remove(this.filme.hashCode());
        } else {
            throw new Exception();
        }
        this.repositorio.setObject(fHashmap);
        this.repositorio.salvar("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void alterarFilme(Filme f, Filme novoF) throws Exception{
        this.filme = f;

        if(fHashmap.containsKey(this.filme.hashCode())){
            fHashmap.remove(this.filme.hashCode());
            fHashmap.put(this.filme.hashCode(),novoF);
        }else{
            throw new Exception();
        }
        this.repositorio.setObject(fHashmap);
        this.repositorio.salvar("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }

    public HashMap<Integer, Filme> getfHashmap() {
        return this.fHashmap;
    }
    public void setfHashmap(HashMap<Integer, Filme> fHashmap) {
        this.fHashmap = fHashmap;
    }
    public static void setFindHashmap(HashMap<String, Filme> findHashmap) {
        FilmeController.findHashmap = findHashmap;
    }
    public void setRepositorio(Repositorio<HashMap<Integer, Filme>> repositorio) {
        this.repositorio = repositorio;
    }



    public Filme procurarFilme(String title){

        Collection<Filme> filmes =  fHashmap.values();

        findHashmap = new HashMap<>();
        for (Filme filme: filmes) {
            findHashmap.put(filme.getTitulo(),filme);
        }

        return findHashmap.get(title);
    }
}
