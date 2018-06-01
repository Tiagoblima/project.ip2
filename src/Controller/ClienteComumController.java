package Controller;

import Model.ClienteComum;
import Model.Interface.Cliente;

import java.util.HashMap;

public class ClienteComumController {




    private HashMap<String,Cliente> CCHashMap = new HashMap<>(); //Cliente comum HashMap

    private Cliente cliente;


    public void setCliente(Cliente cliente){
        CCHashMap.clear();
       this.cliente = cliente;

   }


   public void cadastrarCliente() throws Exception
   {


       if(CCHashMap.containsKey(this.cliente.getLogin())){
           throw new Exception();
       }
       CCHashMap.put(this.cliente.getLogin(),this.cliente);

   }

   public boolean login(String login, String senha) {

       if (CCHashMap.containsKey(login)) {
           this.cliente = CCHashMap.get(login);
           if (cliente.getLogin() == senha) {
               return true;
           }
       }

       return false;
   }

}
