package model;

public class Desenvolvedor extends Funcionario {
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
    public String toString() {
        return
        "ID: " + super.getID() +
        "\nNome: " + getNome() +
        "\nCPF: " + getCpf() +
        "\nData de Nascimento: " + getDataNascimento() +
        "\nTelefone: " + getTelefone() +
        "\nSalario: " + getSalario() +
        "\nLinguagem: " + getLinguagemPrincipal()
        ;
    }
    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }
    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }
}
