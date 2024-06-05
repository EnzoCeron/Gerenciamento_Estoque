package View;

import java.util.Scanner;

public class MenuView {

    private final Scanner sc;

    public MenuView() {
        sc = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("----Menu----");
        System.out.println("(1) - cadastrar usuario");
        System.out.println("(2) - Listar usuarios");
        System.out.println("(3) - Excluir usuario");
        System.out.println("(4) - Cadastrar produto");
        System.out.println("(5) - Listar produtos");
        System.out.println("(6) - Pesquisar produto");
        System.out.println("(7) - Excluir produto");
        System.out.println("(8) - Atualizar produto");
        System.out.println("(9) - Realizar venda");
        System.out.println("(10) - Realizar compra");
        //System.out.println("(11) - Relatorio de compras e vendas");
        System.out.println("(99) - Sair");
        System.out.println("Opcao: ");
        return sc.nextInt();

    }

    public void opcaoInvalida(){
        System.out.println("Opcao invalida");
    }



}
