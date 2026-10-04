package model;

import java.sql.Date;

public class Gerente extends Funcionario{
    String departamento;

    public Gerente(String nome, String cpf, Date dataNascimento, String telefone, double salario, String departamento) {
        super(nome, cpf, dataNascimento, telefone, salario);
        this.departamento = departamento;
    }
    @Override
    public double calcularBonus(){
        return 0.2 * super.getSalario();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Departamento: " + this.departamento);
    }
}
