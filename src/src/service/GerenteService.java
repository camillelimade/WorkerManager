package service;

import model.Gerente;

import java.util.ArrayList;
import java.util.Scanner;


public class GerenteService {
    Scanner inputGerent = new Scanner(System.in);

    // função de exibição do menu especifico do gerente
    public int menuGerente() {
        System.out.println("Bem vindo a Adminstração de Gerentes: ");
        System.out.println("1) Cadastrar Gerentes");
        System.out.println("2) Ler Gerentes");
        System.out.println("3) Atualizar Gerentes");
        System.out.println("4) Deletar Gerentes");
        System.out.println("5) Encerrar Menu de Gerentes");
        return inputGerent.nextInt();
    }

    // cadastra gerentes
    public Gerente addGerente(int ID) {
        Scanner lendoGerente = new Scanner(System.in);
        FuncionarioService.linha();
        System.out.println("Cadastrando novo Gerente...");
        FuncionarioService.linha();
        System.out.println("Digite o Nome Completo do Gerente: ");
        String nomeCompleto = lendoGerente.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite a Data de Nascimento do Gerente: ");
        String dataNascimento = lendoGerente.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o CPF do Gerente: ");
        String cpf = lendoGerente.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o Telefone do Gerente: ");
        String telefone = lendoGerente.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o Salário do Gerente: ");
        double salario = lendoGerente.nextDouble();
        lendoGerente.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o Departamento do Gerente: ");
        String departamento = lendoGerente.nextLine();
        FuncionarioService.linha();
        Gerente novoGerente = new Gerente(ID, nomeCompleto, cpf, dataNascimento, telefone, salario, departamento);
        System.out.println("Gerente " + nomeCompleto + " cadastrado com sucesso!");
        FuncionarioService.linha();
        return novoGerente;
    }

    // lista gerentes
    public void listarGerentes(ArrayList<Gerente> gerentes) {
        // scanner pra ler do usuário dentro do contetxo dessa função
        Scanner resposta = new Scanner(System.in);
        // formatação de linha
        FuncionarioService.linha();
        // pergunta se quer consultar um específico ou não
        System.out.println("Deseja um gerente específico? ");
        // recolhe o sim, Sim, sIm, siM, e SIM, se não for nenhum desses exibe lista geral
        String respo = resposta.nextLine();
        if (respo.equalsIgnoreCase("sim")) {
            System.out.println("Digite o ID do Gerente: ");
            int ID = resposta.nextInt();
            for (int i = 0; i < gerentes.size(); i++) {
                if (gerentes.get(i).getID() == ID) {
                    FuncionarioService.linha();
                    System.out.println(gerentes.get(i).toString());
                    FuncionarioService.linha();
                } else {
                    FuncionarioService.linha();
                    System.out.println("ID " + ID + " não encontrado!");
                    FuncionarioService.linha();
                }
            }
        } else {
            if (!gerentes.isEmpty()) {
                FuncionarioService.linha();
                System.out.println("Listando todos os gerentes...");
                FuncionarioService.linha();
                for (Gerente gerente : gerentes) {
                    System.out.println(gerente.toString());
                    FuncionarioService.linha();
                }
            } else {
                System.out.println("Nenhum gerente encontrado! Tente cadastrar algum.");
            }
        }
    }

    // atualizar gerentes
    public void atualizarGerente(ArrayList<Gerente> gerentes, String CPF) {
        Scanner atualizaLeitor = new Scanner(System.in);
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf().equalsIgnoreCase(CPF)) {
                FuncionarioService.linha();
                // localiza informa e exibe
                System.out.println("Gerente encontrado, dados atuais nesse ID: ");
                System.out.println(gerentes.get(i).toString());
                FuncionarioService.linha();
                // pede a atualização
                System.out.println("Digite os novos dados do Gerente: ");
                System.out.println("Nome completo: ");
                String novoNome = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setNome(novoNome);
                FuncionarioService.linha();
                System.out.println("Data de Nascimento: ");
                String novaDataNascimento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setDataNascimento(novaDataNascimento);
                FuncionarioService.linha();
                System.out.println("CPF: ");
                String novoCPF = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setCpf(novoCPF);
                FuncionarioService.linha();
                System.out.println("Telefone: ");
                String novoTelefone = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setTelefone(novoTelefone);
                FuncionarioService.linha();
                System.out.println("Salário: ");
                double novoSalario = atualizaLeitor.nextDouble();
                // após pegar seta imediatamente
                gerentes.get(i).setSalario(novoSalario);
                atualizaLeitor.nextLine(); // limpa buffer
                FuncionarioService.linha();
                System.out.println("Departamento: ");
                String novoDepartamento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                gerentes.get(i).setDepartamento(novoDepartamento);
                FuncionarioService.linha();
                System.out.println("Gerente atualizado com sucesso!");
                System.out.println(gerentes.get(i).toString());
                FuncionarioService.linha();
            } else {
                System.out.println("CPF " + CPF + " não encontrado!");
            }
        }
    }

    // deletar gerente
    public void deletarGerente(ArrayList<Gerente> gerentes, String CPF) {
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf().equalsIgnoreCase(CPF)) {
                FuncionarioService.linha();
                System.out.println("Gerente encontrado: ");
                FuncionarioService.linha();
                System.out.println(gerentes.get(i).toString());
                FuncionarioService.linha();
                System.out.println("Gerente " + gerentes.get(i).getNome() + ", com ID " + gerentes.get(i).getID() + " deletado com sucesso!");
                FuncionarioService.linha();
                gerentes.remove(i);
            }
        }
    }
    public void GerentesCRUD(ArrayList<Gerente> gerentes, int ID) {
        Scanner gerenteCRUD = new Scanner(System.in);
        boolean menuRodar = true;
        while (menuRodar) {
            switch (menuGerente()) {
                case 1:
                    // recolhe as informações de cadastro do gerente, instanciando e adicionando ao ArrayList
                    gerentes.add(addGerente(ID));
                    break;
                case 2:
                    // lista todos os gerentes
                    listarGerentes(gerentes);
                    break;
                case 3:
                    System.out.println("Digite o CPF do Gerente a ser atualizado: ");
                    String cpfGerente = gerenteCRUD.nextLine();
                    atualizarGerente(gerentes, cpfGerente);
                    break;
                case 4:
                    System.out.println("Digit o CPF do Gerente a ser deletado: ");
                    String cpfGerenteDelete = gerenteCRUD.nextLine();
                    deletarGerente(gerentes, cpfGerenteDelete);
                    break;
                case 5:
                    menuRodar = false;
                    FuncionarioService.linha();
                    System.out.println("Saindo do Menu de Gerentes...");
                    FuncionarioService.linha();
                    System.out.println("Bem vindo de volta ao Menu Principal!");
                    FuncionarioService.linha();
                    break;
            }
        }
    }
}
