package model;

public class Gerente extends Funcionario{
    private static int cont = 0;
    int ID;
    String departamento;

    public Gerente(String nome, String cpf, String dataNascimento, String telefone, double salario, String departamento) {
        super(nome, cpf, dataNascimento, telefone, salario);
        cont++;
        this.ID = cont;
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
