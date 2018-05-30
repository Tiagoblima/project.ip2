package Controller;

import Model.ClienteComum;
import Model.Interface.Cliente;

import java.util.HashMap;

public class ClienteComumController {


    private HashMap<String,Cliente> CCHashMap = new HashMap<>(); //Cliente comum HashMap

    private Cliente cliente;

   public void setCliente(Cliente cliente){
       this.cliente = cliente;

   }

   public boolean cadastrarCliente()
   {

       if(CCHashMap.containsKey(this.cliente.getLogin())){
           return false;
       }
       CCHashMap.put(this.cliente.getLogin(),this.cliente);
       return true;
   }



}
