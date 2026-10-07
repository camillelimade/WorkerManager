package app;
import model.Desenvolvedor;
import model.Funcionario;
import model.Gerente;
import service.DesenvolvedorService;
import service.FuncionarioService;
import service.GerenteService;
import java.util.ArrayList;
import java.util.Scanner;
import static service.FuncionarioService.linha;

public class Main {
    public static void main(String[] args) {
        // cria a instancia de GerenteService para a execução de funções dessa entidade
        GerenteService execGerent = new GerenteService();
        DesenvolvedorService execDev = new DesenvolvedorService();
        FuncionarioService execFunc = new FuncionarioService();
        // cria as listas de cada entidade, para futura consulta e leitura
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

        boolean loop = true;
        int idFuncionario = 0;
        int idGerente = 0;
        int idDev = 0;
        // variavel instancia de Scanner
        Scanner lendo = new Scanner(System.in);
        while (loop) {
            int op = execFunc.menuPrincipal();
            //  execFunc.menuPrincipal(); chama o menu principal e já retorna o valor selecionado, dentro do loop
            if (op >= 1 &&  op <= 6) { // verifica se o retorno está dentro das pré-condições
                // estrutura de casos que vai direcionar a função setada pelo usuário
                switch (op) {
                    case 1:
                        // Gestão de gerentes, executa menu do CRUD
                        execGerent.GerentesCRUD(gerentes, idFuncionario);
                        break;
                    case 2:
                        // Administrar desenvolvedores
                        execDev.DevsCRUD(desenvolvedores, idFuncionario);
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
                                FuncionarioService.linha();
                                System.out.println("Funcionário indice " + i + ": ");
                                FuncionarioService.linha();
                                System.out.println(funcionarios.get(i).toString());
                                FuncionarioService.linha();
                            }
                        }
                        if (encontrou == false) {
                            FuncionarioService.linha();
                            System.out.println("Funcionario não encontrado!");
                            FuncionarioService.linha();
                        }
                        break;
                    case 4:
                        // lista todos os funcionarios e permite a consulta de um deles
                        // guardando gerentes
                        for (int i = 0; i < gerentes.size(); i++) {
                            funcionarios.add(gerentes.get(i));
                        }
                        // guardando devs
                        for (int i = 0; i < desenvolvedores.size(); i++) {
                            funcionarios.add(desenvolvedores.get(i));
                        }
                        FuncionarioService.linha();
                        System.out.println("Digite o CPF do Funcionario: ");
                        String cpfGeralBonus = lendo.nextLine();
                        boolean encontrouBonus = false;
                        for (int i = 0; i < funcionarios.size(); i++) {
                            if (funcionarios.get(i).getCpf().equalsIgnoreCase(cpfGeralBonus)) {
                                encontrouBonus = true;
                                FuncionarioService.linha();
                                System.out.println("Funcionário indice " + i + ": ");
                                FuncionarioService.linha();
                                System.out.println("Bônus do Funcionário: ");
                                System.out.println(funcionarios.get(i).calcularBonus());
                                FuncionarioService.linha();
                                System.out.println("Demais dados: ");
                                System.out.println(funcionarios.get(i).toString());
                                FuncionarioService.linha();
                            }
                        }
                        if (encontrouBonus == false) {
                            FuncionarioService.linha();
                            System.out.println("Funcionario não encontrado!");
                            FuncionarioService.linha();
                        }
                        break;
                    case 5:
                        System.out.println("Selecione uma categoria para listar: ");
                        System.out.println("1. Gerentes");
                        System.out.println("2. Desenvolvedores");
                        int cat =  lendo.nextInt();
                        lendo.nextLine();
                        if (cat == 1) {
                            for (int i = 0; i < gerentes.size(); i++) {
                                System.out.println(gerentes.get(i).toString());
                                FuncionarioService.linha();
                            }
                        }else if (cat == 2) {
                            for (int i = 0; i < desenvolvedores.size(); i++) {

                                System.out.println(desenvolvedores.get(i).toString());
                                FuncionarioService.linha();
                            }
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
