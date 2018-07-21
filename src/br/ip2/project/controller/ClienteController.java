package br.ip2.project.controller;



import br.ip2.project.model.*;
import br.ip2.project.repositorio.*;

import java.util.HashMap;

public class ClienteController {


    private static ClienteController controller = new ClienteController();
    private final HashMap<String,Cliente> CHashMap = new HashMap<>(); //Cliente HashMap
    private Repositorio<HashMap<String,Cliente>> repositorio = new Repositorio<>();

    private static Cliente cliente;

    private ClienteController(){

        HashMap<String, Cliente> hashMap;
        try{
            hashMap = this.repositorio.ler("src\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");
        }catch (Exception e){
            hashMap  = new HashMap<>();
        }

        this.CHashMap.putAll(hashMap);

    }


    public static ClienteController getInstance() {
        return controller;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void cadastrarCliente(Cliente cliente) throws Exception
    {


        if(CHashMap.containsKey(cliente.getLogin())){

               throw new Exception();
        }

        CHashMap.put(cliente.getLogin(), cliente);
        this.repositorio.setObject(this.CHashMap);
        this.repositorio.salvar("src\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");

    }

   public void login(String login, String senha)throws Exception
   {

        if (!CHashMap.containsKey(login)) {
            throw new Exception();
        }

        cliente = CHashMap.get(login);
        if (!(cliente.getSenha().equals(senha))) {
           throw new Exception();
        }



   }


}
