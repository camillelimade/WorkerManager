import model.Gerente;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner lendo = new Scanner(System.in);
        System.out.println("Menu Principal. Escolha a opção abaixo: ");
        System.out.println("1) Administrar Gerentes");
        System.out.println("2) Administrar Desenvolvedores");
        System.out.println("3) Consultar informações de um funcionário");
        System.out.println("4) Calcular e exibir o bônus de um funcionário");
        System.out.println("5) Imprimir dados de todos funcionários de uma categoria específica");
        System.out.println("6) Sair do programa");
        int opcao = lendo.nextInt();
        lendo.nextLine();
        switch (opcao) {
            case 1:
                System.out.println("Bem vindo a Adminstração de Gerentes: ");
                System.out.println("1) Cadastrar Gerentes");
                System.out.println("2) Ler Gerentes");
                System.out.println("3) Atualizar Gerentes");
                System.out.println("4) Deletar Gerentes");
                int opcaoGerente = lendo.nextInt();
                lendo.nextLine();
                switch (opcaoGerente) {
                    case 1:
                        System.out.println("Digite o Nome Completo do Gerente: ");
                        String nomeCompleto = lendo.nextLine();
                        System.out.println("Digite a Data de Nascimento do Gerente: ");
                        String dataNascimento = lendo.nextLine();
                        System.out.println("Digite o CPF do Gerente: ");
                        String cpf = lendo.nextLine();
                        System.out.println("Digite o Telefone do Gerente: ");
                        String telefone = lendo.nextLine();
                        System.out.println("Digite o Salário do Gerente: ");
                        double salario = lendo.nextDouble();
                        System.out.println("Digite o Departamento do Gerente: ");
                        String departamento = lendo.nextLine();
                        Gerente novoGerent = new Gerente(
                                nomeCompleto,
                                cpf,
                                dataNascimento,
                                telefone,
                                salario,
                                departamento
                        );

                        break;
                }
                break;
        }
    }
}
