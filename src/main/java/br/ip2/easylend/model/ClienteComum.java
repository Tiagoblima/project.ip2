package br.ip2.easylend.model;

public class ClienteComum extends Cliente {

//      O cliente comum terá acesso a um número limitado de filmes por mês ou semana,
//      além de possíveis publicidades no ato da reprodução do filme.
// Eu entendi, eu criei o atributo abaixo para diferenciar a quantidade de filmes que o cliente tem da quantidade de filmes
// que ele pode adquirir

    private int limiteDeFilmes;

    public ClienteComum(String nome, String email, String dataAniv, String login, String senha, Endereco endereco) throws Exception {
        super(nome, email, dataAniv, login, senha, endereco);
         super.tipoCliente = "Comum";
         super.qtdFilmes = 0;
         this.limiteDeFilmes = 100;

    }

    @Override
    public void mudarTipoCliente() { super.tipoCliente = "Premium"; this.credito = 10000000;}

    public int getLimiteDeFilmes() {
        return limiteDeFilmes;
    }

    public void setLimiteDeFilmes(int limiteDeFilmes) {
        this.limiteDeFilmes = limiteDeFilmes;
    }


    //TODO Pensar nas desvantagens de ser um Cliente Comum
}
