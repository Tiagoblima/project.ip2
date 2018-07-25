package br.ip2.easylend.model;

public class ClientePremium extends Cliente {
// O cliente Premium não terá nenhum tipo de veto quanto ao acesso ao número de filmes disponíveis,
// nem precisará assistir à anuncios durante a exibição do filme.

    public ClientePremium(String nome, String email, String dataAniv, String login, String senha, Endereco endereco) throws Exception {
        super(nome, email, dataAniv, login, senha, endereco);
        super.tipoCliente = "Premium";
        super.qtdFilmes = 0;
    }

    @Override
    public void mudarTipoCliente() { super.tipoCliente = "Comum"; }


    //TODO Pensar nas vantagens de ser um Cliente Premium


}
