package br.ip2.project.controller;

import br.ip2.project.model.ClienteComum;
import br.ip2.project.repositorio.Repositorio;

import java.util.HashMap;

public class ClienteComumController {


    private HashMap<String,ClienteComum> CCHashMap = new HashMap<>(); //Cliente comum HashMap
    private ClienteComum cliente;
    private Repositorio<HashMap<String,ClienteComum>> repositorio = new Repositorio<HashMap<String, ClienteComum>>();




    public ClienteComumController(){
        this.CCHashMap = this.repositorio.ler("src\\br.ip2.project.repositorio\\files\\hashMapClienteC.txt");
    }
    public void setCliente(ClienteComum cliente){
       this.cliente = cliente;
   }




   public void cadastrarCliente() throws Exception
   {

       if(CCHashMap.containsKey(this.cliente.getLogin())){

           throw new Exception();
       }

       CCHashMap.put(this.cliente.getLogin(),this.cliente);
       this.repositorio.setObject(this.CCHashMap);
       this.repositorio.salvar("src\\br.ip2.project.repositorio\\files\\hashMapClienteC.txt");
   }

   public void login(String login, String senha)throws Exception
   {



       if (!CCHashMap.containsKey(login)) {
           throw new Exception();
       }

       this.cliente = CCHashMap.get(login);
       if (!(this.cliente.getSenha().equals(senha))) {
           throw new Exception();
       }

   }

    public HashMap<String, ClienteComum> getCCHashMap() {
        return CCHashMap;
    }

    public void setCCHashMap(HashMap<String, ClienteComum> CCHashMap) {
        this.CCHashMap = CCHashMap;
    }
}
