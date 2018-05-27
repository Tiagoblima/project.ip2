package Model;

import java.util.Date;

public class Adm extends Pessoa {

    public Adm(Catalogo catalogo, String nome, int idade, String cpf, Date dataAniv, Endereco endereco, String login, String senha) {
        super(nome,dataAniv,login,senha);
        
    }



}
