package model;

import java.sql.Date;

public class Desenvolvedor extends Funcionario{
    String linguagemPrincipal;

    public Desenvolvedor(String nome, String cpf, Date dataNascimento, String telefone, double salario, String linguagemPrincipal) {
        super(nome, cpf, dataNascimento, telefone, salario);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    @Override
    public double calcularBonus() {
        return 0.15 * super.getSalario();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Linguagem Principal: " + linguagemPrincipal);
    }
}
