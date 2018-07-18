package main.java.br.ip2.project.controller;

import main.java.br.ip2.project.model.Filme;
import main.java.br.ip2.project.model.GeneroFilme;
import main.java.br.ip2.project.repositorio.Repositorio;

import java.util.HashMap;

public class FilmeController {

    private static HashMap<Integer, Filme> fHashmap;
    private static HashMap<String, Filme> findHashmap;
    private Filme filme;
    private Repositorio<HashMap<Integer, Filme>> repositorio = new Repositorio<>();


    public FilmeController(){
        try{
            this.fHashmap = this.repositorio.ler("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapFilme.txt");
        }catch (Exception e){
            this.fHashmap = new HashMap<>();
        }
    }

    public void setFilme(Filme filme){
        this.filme = filme;
    }

    public Filme getFilme(){
        return this.fHashmap.get(this.filme.hashCode());
    }


    public void cadastrarFilme(Filme f) throws Exception{
        this.filme = f;
        if(fHashmap.containsKey(this.filme.hashCode())){
            throw new Exception();
        }
        fHashmap.put(this.filme.hashCode(),f);
        this.repositorio.setObject(this.fHashmap);
        this.repositorio.salvar("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void removerFilme(Filme f) throws Exception{
        this.filme = f;
        if (fHashmap.containsKey(this.filme.hashCode())){
            fHashmap.remove(this.filme.hashCode());
        } else {
            throw new Exception();
        }
        this.repositorio.setObject(this.fHashmap);
        this.repositorio.salvar("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public void alterarFilme(Filme f, Filme novoF) throws Exception{
        this.filme = f;

        if(fHashmap.containsKey(this.filme.hashCode())){
            fHashmap.remove(this.filme.hashCode());
            fHashmap.put(this.filme.hashCode(),novoF);
        }else{
            throw new Exception();
        }
        this.repositorio.setObject(this.fHashmap);
        this.repositorio.salvar("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapFilmes.txt");
    }
    public Filme procurarFilme(String title){
// resolver o problema do hashmap na busca pelo titulo do filme
        return null; //retorno temporário
    }
}
