package service;
import model.Desenvolvedor;
import java.util.ArrayList;
import java.util.Scanner;
public class DesenvolvedorService {
    Scanner inputDev = new Scanner(System.in);
    // função de exibição do menu especifico do dev
    public int menuDev() {
        System.out.println("Bem vindo a Adminstração de Desenvolvedores: ");
        System.out.println("1) Cadastrar Desenvolvedores");
        System.out.println("2) Ler Desenvolvedores");
        System.out.println("3) Atualizar Desenvolvedores");
        System.out.println("4) Deletar Desenvolvedores");
        System.out.println("5) Sair do Menu de Desenvolvedores");
        return inputDev.nextInt();
    }
    public void DevsCRUD(ArrayList<Desenvolvedor> desenvolvedores, int ID){
        Scanner devCRUD = new Scanner(System.in);
        boolean menuRodar = true;
        while(menuRodar){
            switch (menuDev()) {
                case 1:
                    // recolhe as informações de cadastro do dev
                    desenvolvedores.add(addDesenvolvedor(ID));
                    ID++; // id já auto incrementado
                    break;
                case 2:
                    // lista todos os devs
                    listarDesenvolvedores(desenvolvedores);
                    break;
                case 3:
                    System.out.println("Digite o CPF do Desenvolvedor a ser atualizado: ");
                    String cpfDev = devCRUD.nextLine();
                    atualizarDesenvolvedor(desenvolvedores, cpfDev);
                    break;
                case 4:
                    System.out.println("Digit o CPF do Desenvolvedor a ser deletado: ");
                    String cpfDevDelete = devCRUD.nextLine();
                    deletarDesenvolvedor(desenvolvedores, cpfDevDelete);
                    break;
                case 5:
                    menuRodar = false;
                    FuncionarioService.linha();
                    System.out.println("Saindo do Menu de DEV's...");
                    FuncionarioService.linha();
                    System.out.println("Bem vindo de volta ao Menu Principal!");
                    FuncionarioService.linha();
                    break;
            }
        }
    }
    // cadastra devs
    public Desenvolvedor addDesenvolvedor(int ID) {
        Scanner lendoDev = new Scanner(System.in);
        FuncionarioService.linha();
        System.out.println("Cadastrando novo Desenvolvedor...");
        FuncionarioService.linha();
        System.out.println("Digite o Nome Completo do Desenvolvedor: ");
        String nomeCompleto = lendoDev.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite a Data de Nascimento do Desenvolvedor: ");
        String dataNascimento = lendoDev.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o CPF do Desenvolvedor: ");
        String cpf = lendoDev.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o Telefone do Desenvolvedor: ");
        String telefone = lendoDev.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite o Salário do Desenvolvedor: ");
        double salario = lendoDev.nextDouble();
        lendoDev.nextLine();
        FuncionarioService.linha();
        System.out.println("Digite a Linguagem principal do Desenvolvedor: ");
        String linguagem = lendoDev.nextLine();
        FuncionarioService.linha();
        Desenvolvedor novoDev = new Desenvolvedor(ID, nomeCompleto, cpf, dataNascimento, telefone, salario, linguagem);
        System.out.println("Desenvolvedor " + nomeCompleto + " cadastrado com sucesso!");
        FuncionarioService.linha();
        return novoDev;
    }
    // lista devs
    public void listarDesenvolvedores(ArrayList<Desenvolvedor> devs) {
        // scanner pra ler do usuário dentro do contetxo dessa função
        Scanner resposta = new Scanner(System.in);
        // formatação de linha
        FuncionarioService.linha();
        // pergunta se quer consultar um específico ou não
        System.out.println("Deseja um desenvolvedor específico? ");
        // recolhe o sim, Sim, sIm, siM, e SIM, se não for nenhum desses exibe lista geral
        String respo = resposta.nextLine();
        if (respo.equalsIgnoreCase("sim")) {
            System.out.println("Digite o ID do Desenvolvedor: ");
            int ID = resposta.nextInt();
            for (int i = 0; i < devs.size(); i++) {
                if (devs.get(i).getID() == ID) {
                    FuncionarioService.linha();
                    System.out.println(devs.get(i).toString());
                    FuncionarioService.linha();
                }else {
                    FuncionarioService.linha();
                    System.out.println("ID " + ID + " não encontrado!");
                    FuncionarioService.linha();
                }
            }
        }else {
            if (!devs.isEmpty()) {
                FuncionarioService.linha();
                System.out.println("Listando todos os desenvolvedores...");
                FuncionarioService.linha();
                for (int i  = 0; i < devs.size(); i++) {
                    System.out.println(devs.toString());
                    FuncionarioService.linha();
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
                FuncionarioService.linha();
                // localiza informa e exibe
                System.out.println("Desenvolvedor encontrado, dados atuais nesse ID: ");
                System.out.println(devs.get(i).toString());
                FuncionarioService.linha();
                // pede a atualização
                System.out.println("Digite os novos dados do Desenvolvedor: ");
                System.out.println("Nome completo: ");
                String novoNome = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setNome(novoNome);
                FuncionarioService.linha();
                System.out.println("Data de Nascimento: ");
                String novaDataNascimento = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setDataNascimento(novaDataNascimento);
                FuncionarioService.linha();
                System.out.println("CPF: ");
                String novoCPF = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setCpf(novoCPF);
                FuncionarioService.linha();
                System.out.println("Telefone: ");
                String novoTelefone = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setTelefone(novoTelefone);
                FuncionarioService.linha();
                System.out.println("Salário: ");
                double novoSalario = atualizaLeitor.nextDouble();
                // após pegar seta imediatamente
                devs.get(i).setSalario(novoSalario);
                atualizaLeitor.nextLine(); // limpa buffer
                FuncionarioService.linha();
                System.out.println("Linguagem principal: ");
                String novaLinguagem = atualizaLeitor.nextLine();
                // após pegar seta imediatamente
                devs.get(i).setLinguagemPrincipal(novaLinguagem);
                FuncionarioService.linha();
                System.out.println("Desenvolvedor atualizado com sucesso!");
                System.out.println(devs.get(i).toString());
                FuncionarioService.linha();
            }else {
                System.out.println("CPF " + CPF + " não encontrado!");
            }
        }
    }
    // deletar desenvolvedor
    public void deletarDesenvolvedor(ArrayList<Desenvolvedor> devs, String CPF) {
        for (int i = 0; i < devs.size(); i++) {
            if (devs.get(i).getCpf().equalsIgnoreCase(CPF)) {
                FuncionarioService.linha();
                System.out.println("Desenvolvedor encontrado: ");
                FuncionarioService.linha();
                System.out.println(devs.get(i).toString());
                FuncionarioService.linha();
                System.out.println("Desenvolvedor " +  devs.get(i).getNome() +  ", com ID " + devs.get(i).getID() + " deletado com sucesso!");
                FuncionarioService.linha();
                devs.remove(i);
            }
        }
    }
}



