import java.util.Scanner;

public class Main {
    public Main() {
    }

    public int menu(){
        Scanner op =  new Scanner(System.in);
        System.out.println("Menu Principal. Escolha a opção abaixo: ");
        System.out.println("1) Administrar Gerentes");
        System.out.println("2) Administrar Desenvolvedores");
        System.out.println("3) Consultar informações de um funcionário");
        System.out.println("4) Calcular e exibir o bônus de um funcionário");
        System.out.println("5) Imprimir dados de todos funcionários de uma categoria específica");
        System.out.println("6) Sair do programa");
        return op.nextInt();
    }
    public static void main(String[] args) {

    }
}
