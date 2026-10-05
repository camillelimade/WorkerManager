package model;

import interfaces.Bonificavel;

import java.sql.Date;

public class Funcionario implements Bonificavel {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private double salario;

    public Funcionario(String nome, String cpf, Date dataNascimento, String telefone, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("Salário: " + salario);
    }
    public double calcularBonus(){
        return 0.1 * this.salario;
    }
}
