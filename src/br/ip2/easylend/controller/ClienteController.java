package br.ip2.easylend.controller;


import br.ip2.easylend.model.Cliente;
import br.ip2.easylend.model.Filme;
import br.ip2.easylend.repositorio.JsonController;
import br.ip2.easylend.repositorio.Repositorio;
import com.google.gson.Gson;
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ClienteController {


    private static ClienteController controller;
    private final HashMap<String,Cliente> CHashMap = new HashMap<>(); //Cliente HashMap
    private Repositorio <HashMap> repositorio = Repositorio.getInstance();
    private CatalogoController catalogoController = CatalogoController.getInstance();
    public static Cliente cliente;
    private ArrayList<Filme> preferencias;

    public ArrayList <Filme> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(ArrayList <Filme> preferencias) {
        this.preferencias = preferencias;
    }

    private ClienteController(){

        HashMap hashMap;
        try{
            String path = "src\\br\\ip2\\easylend\\repositorio\\files\\hashMapCliente.txt";
            hashMap = this.repositorio.ler(path);
        }catch (Exception e){
            hashMap  = new HashMap<>();
        }

        this.CHashMap.putAll(hashMap);

    }


    public static synchronized ClienteController getInstance() {
        if(controller==null) controller = new ClienteController();
        return controller;
    }

    public Cliente getCliente(){

        return cliente;
    }

    public void cadastrarCliente(Cliente novoCliente) throws Exception
    {

        if(CHashMap.containsKey(novoCliente.getLogin())){

               throw new Exception();
        }

        cliente = novoCliente;

        CHashMap.put(cliente.getLogin(), cliente);



    }

   public void login(String login, String senha)throws Exception
   {

       if (!CHashMap.containsKey(login)) {
             throw new Exception();
       }

       cliente = CHashMap.get(login);



       if(!cliente.getSenha().equals(senha)){
           throw new Exception();
       }


   }

   public void alterarLogin(String login) throws Exception {

        if(CHashMap.containsKey(login)){
            throw new Exception();
        }
        cliente.setLogin(login);
        updateCliente();
   }

   public HashMap<String, Cliente> getCHashMap(){
        return this.CHashMap;
   }
   public ArrayList<Filme> getFilmesClienteArray(){

       Collection<Filme> filmes = cliente.getfilmesCliente().values();
       return new ArrayList <>(filmes);
   }
   public void updateCliente(){

        CHashMap.replace(cliente.getLogin(),cliente);
       this.repositorio.salvar(CHashMap,"src\\br\\ip2\\easylend\\repositorio\\files\\hashMapCliente.txt");
   }


}
