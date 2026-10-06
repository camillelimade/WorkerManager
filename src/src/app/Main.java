package app;

import model.Desenvolvedor;
import model.Funcionario;
import model.Gerente;
import service.DesenvolvedorService;
import service.GerenteService;

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

    // função de formatação da leitura do usuário
    public static void linha() {
        System.out.println("-----------------------------------");
    }

    // método main vazio para a chamada de funções void
    public Main() {
    }

    public static void main(String[] args) {
        // cria a instancia de GerenteService para a execução de funções dessa entidade
        GerenteService executandoGerente = new GerenteService();
        DesenvolvedorService executandoDev = new DesenvolvedorService();
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
                        executandoGerente.menuGerente();
                        // recolhe a opção
                        int opcaoGerente = lendo.nextInt();
                        // limpeza de buffer
                        lendo.nextLine();
                        //  estrutura de casos especfica pro gerente
                        switch (opcaoGerente) {
                            case 1:
                                // recolhe as informações de cadastro do gerente
                                gerentes.add(executandoGerente.addGerente(idGerente));
                                idGerente++; // id já auto incrementado
                                break;
                            case 2:
                                // lista todos os gerentes
                                executandoGerente.listarGerentes(gerentes);
                                break;
                            case 3:
                                System.out.println("Digite o CPF do Gerente a ser atualizado: ");
                                String cpfGerente = lendo.nextLine();
                                executandoGerente.atualizarGerente(gerentes, cpfGerente);
                                break;
                            case 4:
                                System.out.println("Digit o CPF do Gerente a ser deletado: ");
                                String cpfGerenteDelete = lendo.nextLine();
                                executandoGerente.deletarGerente(gerentes, cpfGerenteDelete);
                                break;
                        }
                        break;
                    case 2:
                        // Administrar desenvolvedores
                        executandoDev.menuDev();
                        int opcaoDev = lendo.nextInt();
                        lendo.nextLine();
                        switch (opcaoDev) {
                            case 1:
                                // recolhe as informações de cadastro do dev
                                desenvolvedores.add(executandoDev.addDesenvolvedor(idDev));
                                idDev++; // id já auto incrementado
                                break;
                            case 2:
                                // lista todos os devs
                                executandoDev.listarDesenvolvedores(desenvolvedores);
                                break;
                            case 3:
                                System.out.println("Digite o CPF do Desenvolvedor a ser atualizado: ");
                                String cpfDev = lendo.nextLine();
                                executandoDev.atualizarDesenvolvedor(desenvolvedores, cpfDev);
                                break;
                            case 4:
                                System.out.println("Digit o CPF do Desenvolvedor a ser deletado: ");
                                String cpfDevDelete = lendo.nextLine();
                                executandoDev.deletarDesenvolvedor(desenvolvedores, cpfDevDelete);
                                break;
                        }
                        break;
                    case 3:
                        // lista todos os funcionarios e permite a consulta de um deles
                        // guardando gerentes
                        for (int i = 0; i < gerentes.size(); i++) {
                            funcionarios.add(gerentes.get(i));
                        }
                        // guardando devs
                        for (int i = 0; i < desenvolvedores.size(); i++) {
                            funcionarios.add(desenvolvedores.get(i));
                        }
                        System.out.println("Digite o CPF do Funcionario: ");
                        String cpfGeral = lendo.nextLine();
                        boolean encontrou = false;
                        for (int i = 0; i < funcionarios.size(); i++) {
                            if (funcionarios.get(i).getCpf().equalsIgnoreCase(cpfGeral)) {
                                encontrou = true;
                                linha();
                                System.out.println("Funcionário indice " + i + ": ");
                                linha();
                                System.out.println(funcionarios.get(i).toString());
                                linha();
                            }
                        }
                        if (encontrou == false) {
                            linha();
                            System.out.println("Funcionario não encontrado!");
                            linha();
                        }
                        break;
                    case 4:
                        // bonus de um funcionário
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
