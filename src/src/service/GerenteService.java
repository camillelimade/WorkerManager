package service;
import model.Gerente;

import java.util.ArrayList;
import java.util.Scanner;
import static app.Main.linha;

public class GerenteService {
    // função de exibição do menu especifico do gerente
    public void menuGerente() {
        System.out.println("Bem vindo a Adminstração de Gerentes: ");
        System.out.println("1) Cadastrar Gerentes");
        System.out.println("2) Ler Gerentes");
        System.out.println("3) Atualizar Gerentes");
        System.out.println("4) Deletar Gerentes");
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
        Gerente novoGerente = new Gerente(ID, nomeCompleto, cpf, dataNascimento, telefone, salario, departamento);
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
                }else {
                    linha();
                    System.out.println("ID " + ID + " não encontrado!");
                    linha();
                }
            }
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
    // deletar gerente
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
}
