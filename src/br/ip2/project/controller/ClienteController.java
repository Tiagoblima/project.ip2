package br.ip2.project.controller;

import br.ip2.project.model.Cliente;
import br.ip2.project.model.ClienteComum;
import br.ip2.project.repositorio.Repositorio;

import java.util.HashMap;

public class ClienteController {


    private HashMap<String,Cliente> CHashMap; //Cliente HashMap
    private Cliente cliente;
    private Repositorio<HashMap<String,Cliente>> repositorio = new Repositorio<>();




    public ClienteController(){

        this.CHashMap = this.repositorio.ler("src\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");
    }
    public void setCliente(ClienteComum cliente){
       this.cliente = cliente;
   }

   public void cadastrarCliente(Cliente cliente) throws Exception
   {

       this.cliente = cliente;

       if(CHashMap.containsKey(this.cliente.getLogin())){

           throw new Exception();
       }

       CHashMap.put(this.cliente.getLogin(),this.cliente);
       this.repositorio.setObject(this.CHashMap);
       this.repositorio.salvar("src\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");
   }

   public void login(String login, String senha)throws Exception
   {

       if (!CHashMap.containsKey(login)) {
           throw new Exception();
       }

       this.cliente = CHashMap.get(login);
       if (!(this.cliente.getSenha().equals(senha))) {
           throw new Exception();
       }

   }

    public HashMap<String, Cliente> getCCHashMap() {
        return CHashMap;
    }

    public void setCCHashMap(HashMap<String, Cliente> CCHashMap) {
        this.CHashMap = CCHashMap;
    }
}
