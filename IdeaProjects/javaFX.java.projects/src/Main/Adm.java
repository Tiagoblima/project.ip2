package Main;

public class Adm extends Pessoa {
    private String login;
    private String senha;
    private Cliente[] clientes;
    Catalogo catalogo;

    public Adm(String login, String senha, Cliente[] clientes, Catalogo catalogo) {

        this.login = login;
        this.senha = senha;
        this.clientes = clientes;
        this.catalogo = catalogo;
    }
}
