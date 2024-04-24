package View;

import java.util.Scanner;
import Model.Produto;

public class CadastroProdutoView {

    private Scanner sc;

    public CadastroProdutoView() {
        sc = new Scanner(System.in);
    }

    public Produto cadastrarProduto(){
        System.out.println("----Cadastro de Produto----");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Descrição: ");
        String descricao = sc.nextLine();
        System.out.println("Preço: ");
        double preco = sc.nextDouble();
        System.out.println("Estoque Inical: ");
        int quantidade = sc.nextInt();
        System.out.println("Produto cadastrado com sucesso!");

        int id = 0;
        
        return new Produto(id, nome, descricao, quantidade, preco);

    }

}
