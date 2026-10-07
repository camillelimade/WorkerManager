package service;

import java.util.Scanner;

public class FuncionarioService {
    Scanner inputFunc = new Scanner(System.in);
    // função de exibição do menu principal
    public int menuPrincipal() {
        System.out.println("Menu Principal. Escolha a opção abaixo: ");
        System.out.println("1) Administrar Gerentes");
        System.out.println("2) Administrar Desenvolvedores");
        System.out.println("3) Consultar informações de um funcionário");
        System.out.println("4) Calcular e exibir o bônus de um funcionário");
        System.out.println("5) Imprimir dados de todos funcionários de uma categoria específica");
        System.out.println("6) Sair do programa");
        return inputFunc.nextInt();
    }
    // função de formatação visual
    public static void linha() {
        System.out.println("-----------------------------------");
    }
}
