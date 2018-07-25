package br.ip2.easylend.model;

public abstract class Cliente extends Pessoa{

    protected double credito;
    protected int qtdFilmes; //LIMITADOR DE FILMES
    protected String tipoCliente;


    public Cliente(String nome,String email ,String dataAniv, String login, String senha, Endereco endereco)throws Exception {


        verificarInput(nome);
        verificarInput(dataAniv);
        verificarInput(login);
        verificarInput(senha);
        verificarInput(email);

        this.nome = nome;
        this.dataAniv = dataAniv;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;

    }

    private void verificarInput(String string)throws Exception
    {
        if(string.isEmpty()) {
            throw new Exception();
        }
    }


    public abstract void mudarTipoCliente();
    public String getTipoCliente(){ return this.tipoCliente;}
    public String getEmail(){
        return this.email;
    }
    public int getQtdFilmes() {
        return this.qtdFilmes;
    }
    public void setQtdFilmes(int qtdFilmes) {
        this.qtdFilmes= qtdFilmes;
    }
    public double getCredito() {
        return this.credito;
    }
    public void setCredito(double credito) { this.credito = credito; }
    public void compraCredito(double dinheiro) {this.credito = dinheiro; }
    public String getLogin(){
        return this.login;
    }
    public String getSenha(){
        return this.senha;
    }
    public String getDataNasc() { return this.getDataAniv(); }



}
