package br.ip2.project.controller;




import br.ip2.project.model.*;
import br.ip2.project.repositorio.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FilmeController {


    private static FilmeController controller = new FilmeController();
    private final HashMap<Integer, Filme> fHashmap;
    private final HashMap<String, Filme> findHashmap;
    private Repositorio<HashMap<Integer, Filme>> repositorio = Repositorio.getInstance();


    private FilmeController(){

        HashMap<Integer, Filme> hashMap;
        try{
            hashMap = this.repositorio.ler("src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
        }catch (Exception e){
            hashMap = new HashMap<>();
        }
        fHashmap = hashMap;

        Collection<Filme> filmes =  fHashmap.values();

        findHashmap = new HashMap<>();
        for (Filme filme: filmes) {
            findHashmap.put(filme.getTitulo(),filme);
        }

    }

    public static FilmeController getInstance(){
        return controller;
    }

    public void cadastrarFilme(Filme filme) throws Exception{

        if(fHashmap.containsKey(filme.hashCode())){
            throw new Exception();
        }
        fHashmap.put(filme.hashCode(),filme);
        this.repositorio.salvar(fHashmap,"src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void removerFilme(Filme filme) throws Exception{

        if (fHashmap.containsKey(filme.hashCode())){
            fHashmap.remove(filme.hashCode());
        } else {
            throw new Exception();
        }

        this.repositorio.salvar(fHashmap,"src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void alterarFilme(Filme filmeVelho, Filme filmeNovo){

        this.fHashmap.replace(filmeVelho.hashCode(),filmeVelho,filmeNovo);

        this.repositorio.salvar(fHashmap,"src\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }

    public HashMap<Integer, Filme> getfHashmap() {
        return this.fHashmap;
    }
    public void setRepositorio(Repositorio<HashMap<Integer, Filme>> repositorio) {
        this.repositorio = repositorio;
    }

    public Filme procurarFilme(String title){
        return findHashmap.get(title);
    }
}
