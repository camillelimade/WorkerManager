package model;

public class Gerente extends Funcionario{
    int ID;
    String departamento;

    public Gerente(String nome, String cpf, String dataNascimento, String telefone, double salario, int ID, String departamento) {
        super(nome, cpf, dataNascimento, telefone, salario);
        this.ID = ID;
        this.departamento = departamento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
            "\nID: " + getID() +
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
