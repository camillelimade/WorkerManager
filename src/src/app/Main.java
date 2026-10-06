package app;

import model.Desenvolvedor;
import model.Funcionario;
import model.Gerente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // função de exibição do menu principal
    public void menuPrincipal() {
        System.out.println("Menu Principal. Escolha a opção abaixo: ");
        System.out.println("1) Administrar Gerentes");
        System.out.println("2) Administrar Desenvolvedores");
        System.out.println("3) Consultar informações de um funcionário");
        System.out.println("4) Calcular e exibir o bônus de um funcionário");
        System.out.println("5) Imprimir dados de todos funcionários de uma categoria específica");
        System.out.println("6) Sair do programa");
    }
    // função de exibição do menu especifico do gerente
    public void menuGerente() {
        System.out.println("Bem vindo a Adminstração de Gerentes: ");
        System.out.println("1) Cadastrar Gerentes");
        System.out.println("2) Ler Gerentes");
        System.out.println("3) Atualizar Gerentes");
        System.out.println("4) Deletar Gerentes");
    }
    // metodo construtor vazio, serve para a criação da instancia de execução
    // função de formatação da leitura do usuário
    public void linha(){
        System.out.println("-----------------------------------");
    }
    // cadastra gerentes
    public Gerente addGerente(int ID) {
        Scanner lendoGerente = new Scanner(System.in);
        linha();
        System.out.println("Cadastrando novo Gerente...");
        linha();
        System.out.println("Digite o Nome Completo do Gerente: ");
        String nomeCompleto = lendoGerente.nextLine();
        linha();
        System.out.println("Digite a Data de Nascimento do Gerente: ");
        String dataNascimento = lendoGerente.nextLine();
        linha();
        System.out.println("Digite o CPF do Gerente: ");
        String cpf = lendoGerente.nextLine();
        linha();
        System.out.println("Digite o Telefone do Gerente: ");
        String telefone = lendoGerente.nextLine();
        linha();
        System.out.println("Digite o Salário do Gerente: ");
        double salario = lendoGerente.nextDouble();
        lendoGerente.nextLine();
        linha();
        System.out.println("Digite o Departamento do Gerente: ");
        String departamento = lendoGerente.nextLine();
        linha();
        Gerente novoGerente = new Gerente(nomeCompleto, cpf, dataNascimento, telefone, salario, ID, departamento);
        System.out.println("Gerente " + nomeCompleto + " cadastrado com sucesso!");
        linha();
        return novoGerente;
    }
    // lista gerentes
    public void listarGerentes(ArrayList<Gerente> gerentes) {
        // scanner pra ler do usuário dentro do contetxo dessa função
        Scanner resposta = new Scanner(System.in);
        // formatação de linha
        linha();
        // pergunta se quer consultar um específico ou não
        System.out.println("Deseja um gerente específico? ");
        // recolhe o sim, Sim, sIm, siM, e SIM, se não for nenhum desses exibe lista geral
        String respo = resposta.nextLine();
        if (respo.equalsIgnoreCase("sim")) {
            System.out.println("Digite o ID do Gerente: ");
            int ID = resposta.nextInt();
            for (int i = 0; i < gerentes.size(); i++) {
                if (gerentes.get(i).getID() == ID) {
                    linha();
                    System.out.println(gerentes.get(i).toString());
                    linha();
                }
            }
            linha();
            System.out.println("ID " + ID + " não encontrado!");
            linha();
        }else {
            if (!gerentes.isEmpty()) {
                linha();
                System.out.println("Listando todos os gerentes...");
                linha();
                for (Gerente gerente : gerentes) {
                    System.out.println(gerente.toString());
                    linha();
                }
            }else {
                System.out.println("Nenhum gerente encontrado! Tente cadastrar algum.");
            }
        }
    }
    // atualizar gerentes
    public void atualizarGerente(ArrayList<Gerente> gerentes, String CPF) {
        Scanner atualizaLeitor = new Scanner(System.in);
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf().equalsIgnoreCase(CPF)) {
                linha();
                // localiza informa e exibe
                System.out.println("Gerente encontrado, dados atuais nesse ID: ");
                System.out.println(gerentes.get(i).toString());
                linha();
                // pede a atualização
                System.out.println("Digite os novos dados do Gerente: ");
                System.out.println("Nome completo: ");
                String novoNome = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setNome(novoNome);
                linha();
                System.out.println("Data de Nascimento: ");
                String novaDataNascimento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setDataNascimento(novaDataNascimento);
                linha();
                System.out.println("CPF: ");
                String novoCPF = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setCpf(novoCPF);
                linha();
                System.out.println("Telefone: ");
                String novoTelefone = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setTelefone(novoTelefone);
                linha();
                System.out.println("Salário: ");
                double novoSalario = atualizaLeitor.nextDouble();
                // após pegar seta imediatamente
                gerentes.get(i).setSalario(novoSalario);
                atualizaLeitor.nextLine(); // limpa buffer
                linha();
                System.out.println("Departamento: ");
                String novoDepartamento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setDepartamento(novoDepartamento);
                linha();
                System.out.println("Gerente atualizado com sucesso!");
                System.out.println(gerentes.get(i).toString());
                linha();
            }else {
                System.out.println("CPF " + CPF + " não encontrado!");
            }
        }
    }
    public void deletarGerente(ArrayList<Gerente> gerentes, String CPF) {
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf().equalsIgnoreCase(CPF)) {
                linha();
                System.out.println("Gerente encontrado: ");
                linha();
                System.out.println(gerentes.get(i).toString());
                linha();
                System.out.println("Gerente " +  gerentes.get(i).getNome() +  ", com ID " + gerentes.get(i).getID() + " deletado com sucesso!");
                linha();
                gerentes.remove(i);
            }
        }

    }
    public Main() {
    }
    public static void main(String[] args) {
        // cria as listas de cada entidade, para futura consulta e leitura
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

        boolean loop = true;
        int idFuncionario = 0;
        int idGerente = 0;
        int idDev = 0;
        // instancia pra main executar métodos void
        Main executa = new Main();
        // variavel instancia de Scanner
        Scanner lendo = new Scanner(System.in);
        while (loop) {
            // chamando menu principal
            executa.menuPrincipal();
            // recolhe a opção selecionada no menu
            int opcao = lendo.nextInt();
            if (opcao >= 1 && opcao <= 6) {
                // limpa o buffer e evita erro de execução
                lendo.nextLine();
                // estrutura de casos que vai direcionar a função setada pelo usuário
                switch (opcao) {
                    case 1:
                        // Gestão de gerentes, executa menu do CRUD
                        executa.menuGerente();
                        // recolhe a opção
                        int opcaoGerente = lendo.nextInt();
                        // limpeza de buffer
                        lendo.nextLine();
                        //  estrutura de casos especfica pro gerente
                        switch (opcaoGerente) {
                            case 1:
                                // recolhe as informações de cadastro do gerente
                                gerentes.add(executa.addGerente(idGerente));
                                idGerente++; // id já auto incrementado
                                break;
                            case 2:
                                // lista todos os gerentes
                                executa.listarGerentes(gerentes);
                                break;
                            case 3:
                                System.out.println("Digite o CPF do Gerente a ser atualizado: ");
                                String cpfGerente = lendo.nextLine();
                                executa.atualizarGerente(gerentes, cpfGerente);
                                break;
                            case 4:
                                System.out.println("Digit o CPF do Gerente a ser deletado: ");
                                String cpfGerenteDelete = lendo.nextLine();
                                executa.deletarGerente(gerentes, cpfGerenteDelete);
                                break;
                        }
                        break;
                    case 6:
                        loop = false;
                        System.out.println("Finalizando programa...");
                        break;
                }
            } else {
                System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}
