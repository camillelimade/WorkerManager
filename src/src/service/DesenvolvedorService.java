package service;
import model.Desenvolvedor;
import java.util.ArrayList;
import java.util.Scanner;
import static app.Main.linha;

public class DesenvolvedorService {
    // função de exibição do menu especifico do dev
    public void menuDev() {
        System.out.println("Bem vindo a Adminstração de Desenvolvedores: ");
        System.out.println("1) Cadastrar Desenvolvedores");
        System.out.println("2) Ler Desenvolvedores");
        System.out.println("3) Atualizar Desenvolvedores");
        System.out.println("4) Deletar Desenvolvedores");
    }
    // cadastra devs
    public Desenvolvedor addDesenvolvedor(int ID) {
        Scanner lendoDev = new Scanner(System.in);
        linha();
        System.out.println("Cadastrando novo Desenvolvedor...");
        linha();
        System.out.println("Digite o Nome Completo do Desenvolvedor: ");
        String nomeCompleto = lendoDev.nextLine();
        linha();
        System.out.println("Digite a Data de Nascimento do Desenvolvedor: ");
        String dataNascimento = lendoDev.nextLine();
        linha();
        System.out.println("Digite o CPF do Desenvolvedor: ");
        String cpf = lendoDev.nextLine();
        linha();
        System.out.println("Digite o Telefone do Desenvolvedor: ");
        String telefone = lendoDev.nextLine();
        linha();
        System.out.println("Digite o Salário do Desenvolvedor: ");
        double salario = lendoDev.nextDouble();
        lendoDev.nextLine();
        linha();
        System.out.println("Digite o Departamento do Desenvolvedor: ");
        String departamento = lendoDev.nextLine();
        linha();
        Desenvolvedor novoDev = new Desenvolvedor(ID, nomeCompleto, cpf, dataNascimento, telefone, salario, departamento);
        System.out.println("Desenvolvedor " + nomeCompleto + " cadastrado com sucesso!");
        linha();
        return novoDev;
    }
    // lista devs
    public void listarDesenvolvedores(ArrayList<Desenvolvedor> devs) {
        // scanner pra ler do usuário dentro do contetxo dessa função
        Scanner resposta = new Scanner(System.in);
        // formatação de linha
        linha();
        // pergunta se quer consultar um específico ou não
        System.out.println("Deseja um desenvolvedor específico? ");
        // recolhe o sim, Sim, sIm, siM, e SIM, se não for nenhum desses exibe lista geral
        String respo = resposta.nextLine();
        if (respo.equalsIgnoreCase("sim")) {
            System.out.println("Digite o ID do Desenvolvedor: ");
            int ID = resposta.nextInt();
            for (int i = 0; i < devs.size(); i++) {
                if (devs.get(i).getID() == ID) {
                    linha();
                    System.out.println(devs.get(i).toString());
                    linha();
                }else {
                    linha();
                    System.out.println("ID " + ID + " não encontrado!");
                    linha();
                }
            }
        }else {
            if (!devs.isEmpty()) {
                linha();
                System.out.println("Listando todos os desenvolvedores...");
                linha();
                for (int i  = 0; i < devs.size(); i++) {
                    System.out.println(devs.toString());
                    linha();
                }
            }else {
                System.out.println("Nenhum desenvolvedor encontrado! Tente cadastrar algum.");
            }
        }
    }
    // atualizar desenvolvedor
    public void atualizarDesenvolvedor(ArrayList<Desenvolvedor> devs, String CPF) {
        Scanner atualizaLeitor = new Scanner(System.in);
        for (int i = 0; i < devs.size(); i++) {
            if (devs.get(i).getCpf().equalsIgnoreCase(CPF)) {
                linha();
                // localiza informa e exibe
                System.out.println("Desenvolvedor encontrado, dados atuais nesse ID: ");
                System.out.println(devs.get(i).toString());
                linha();
                // pede a atualização
                System.out.println("Digite os novos dados do Desenvolvedor: ");
                System.out.println("Nome completo: ");
                String novoNome = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setNome(novoNome);
                linha();
                System.out.println("Data de Nascimento: ");
                String novaDataNascimento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setDataNascimento(novaDataNascimento);
                linha();
                System.out.println("CPF: ");
                String novoCPF = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setCpf(novoCPF);
                linha();
                System.out.println("Telefone: ");
                String novoTelefone = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setTelefone(novoTelefone);
                linha();
                System.out.println("Salário: ");
                double novoSalario = atualizaLeitor.nextDouble();
                // após pegar seta imediatamente
                devs.get(i).setSalario(novoSalario);
                atualizaLeitor.nextLine(); // limpa buffer
                linha();
                System.out.println("Linguagem principal: ");
                String novaLinguagem = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setLinguagemPrincipal(novaLinguagem);
                linha();
                System.out.println("Desenvolvedor atualizado com sucesso!");
                System.out.println(devs.get(i).toString());
                linha();
            }else {
                System.out.println("CPF " + CPF + " não encontrado!");
            }
        }
    }
    // deletar desenvolvedor
    public void deletarDesenvolvedor(ArrayList<Desenvolvedor> devs, String CPF) {
        for (int i = 0; i < devs.size(); i++) {
            if (devs.get(i).getCpf().equalsIgnoreCase(CPF)) {
                linha();
                System.out.println("Desenvolvedor encontrado: ");
                linha();
                System.out.println(devs.get(i).toString());
                linha();
                System.out.println("Desenvolvedor " +  devs.get(i).getNome() +  ", com ID " + devs.get(i).getID() + " deletado com sucesso!");
                linha();
                devs.remove(i);
            }
        }
    }
}



