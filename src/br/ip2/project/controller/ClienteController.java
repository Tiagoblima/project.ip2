package br.ip2.project.controller;



import br.ip2.project.model.*;
import br.ip2.project.repositorio.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ClienteController {


    private HashMap<String,Cliente> CHashMap; //Cliente HashMap
    private Cliente cliente;
    private Repositorio<HashMap<String,Cliente>> repositorio = new Repositorio<>();

    public ClienteController(){
        try{
            this.CHashMap = this.repositorio.ler("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");
        }catch (Exception e){
            this.CHashMap = new HashMap<>();
        }
    }
    public void setCliente(ClienteComum cliente){
       this.cliente = cliente;
   }

   public Cliente getCliente(){

         return this.CHashMap.get(this.cliente.getLogin());
   }

    public void cadastrarCliente(Cliente cliente) throws Exception
    {

        this.cliente = cliente;

        if(CHashMap.containsKey(this.cliente.getLogin())){

               throw new Exception();
        }

        CHashMap.put(this.cliente.getLogin(),this.cliente);
        this.repositorio.setObject(this.CHashMap);
        this.repositorio.salvar("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\hashMapCliente.txt");

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
        Repositorio<Cliente> clienteRepositorio = new Repositorio<>();
        clienteRepositorio.setObject(this.cliente);
       clienteRepositorio.salvar("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\Bufcliente.txt");

   }

   public HashMap<String, Cliente> getCCHashMap() {
        return CHashMap;
    }

   public void setCCHashMap(HashMap<String, Cliente> CCHashMap) {
        this.CHashMap = CCHashMap;
    }
}
