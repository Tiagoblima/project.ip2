package Main;

import java.util.Objects;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected String cpf;
    protected String dataAniv;
    protected Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataAniv() {
        return dataAniv;
    }

    public void setDataAniv(String dataAniv) {
        this.dataAniv = dataAniv;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(String estado,String cidade,String bairro, String rua,int num) {
        this.endereco.setCidade(cidade);
        this.endereco.setEstado(estado);
        this.endereco.setBairro(bairro);
        this.endereco.setRua(rua);
        this.endereco.setNumero(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return getCpf() == pessoa.getCpf() &&
                Objects.equals(getNome(), pessoa.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf());
    }

    @Override
    public String toString() {
        return "com.firstApp.Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", dataAniv='" + dataAniv + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
