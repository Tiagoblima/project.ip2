package br.ip2.easylend.controller;



import br.ip2.easylend.model.*;
import br.ip2.easylend.repositorio.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;

public class ClienteController {


    private static ClienteController controller;
    private final HashMap<String,Cliente> CHashMap = new HashMap<>(); //Cliente HashMap
    private Repositorio<HashMap<String,Cliente>> repositorio = Repositorio.getInstance();

    public static Cliente cliente;
    public static String name;



    private ClienteController(){

        HashMap<String, Cliente> hashMap;
        try{
            hashMap = this.repositorio.ler("src\\br\\ip2\\easylend\\repositorio\\files\\hashMapCliente.txt");
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
        this.repositorio.salvar(CHashMap,"src\\br\\ip2\\easylend\\repositorio\\files\\hashMapCliente.txt");

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