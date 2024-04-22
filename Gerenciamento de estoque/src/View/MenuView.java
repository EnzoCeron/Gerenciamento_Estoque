package View;

import java.util.Scanner;

public class MenuView {

    private Scanner sc;

    public MenuView() {
        sc = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("----Menu----");
        System.out.println("(1) - cadastrar usuario");
        System.out.println("(2) - listar usuarios");
        System.out.println("(3) - sair");
        System.out.println("Opcao: ");
        return sc.nextInt();

    }

    public void opcaoInvalida(){
        System.out.println("Opcao invalida");
    }



}
