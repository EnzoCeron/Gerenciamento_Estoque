
//lógica: vai carregar os dados de um produto existente e permitir ao usuário alterá-los, Davi.

package View;


import java.util.Scanner;
import Model.Produto;




public class EdicaoProdutoView {

    private Scanner sc;

    public EdicaoProdutoView() {
        sc = new Scanner(System.in);
    }

    public Produto  EditarProduto() {

        System.out.println("----Edicao de Produto----");
        System.out.println("Nome do produto a ser editado: ");
        String nome = sc.nextLine();
        System.out.println("Nova descricao: ");
        String descricao = sc.nextLine();
        System.out.println("Valor do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Produto editado com sucesso!");


        return new Produto( nome, descricao, preco);


    }

}
