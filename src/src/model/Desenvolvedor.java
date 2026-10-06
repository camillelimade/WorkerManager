package model;

public class Desenvolvedor extends Funcionario{
    String linguagemPrincipal;

    public Desenvolvedor(int ID, String nome, String cpf, String dataNascimento, String telefone, double salario, String linguagemPrincipal) {
        super(ID, nome, cpf, dataNascimento, telefone, salario);
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
