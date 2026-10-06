package model;

public class Gerente extends Funcionario{
    String departamento;

    public Gerente(int ID, String nome, String cpf, String dataNascimento, String telefone, double salario, String departamento) {
        super(ID, nome, cpf, dataNascimento, telefone, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return
            "ID: " + super.getID() +
            "\nNome: " + getNome() +
            "\nCPF: " + getCpf() +
            "\nData de Nascimento: " + getDataNascimento() +
            "\nTelefone: " + getTelefone() +
            "\nSalario: " + getSalario() +
            "\nDepartamento: " + getDepartamento()
        ;
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
