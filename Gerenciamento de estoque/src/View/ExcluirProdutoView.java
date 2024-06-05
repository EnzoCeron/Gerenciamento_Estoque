//by davi

package View;

import java.util.Scanner;
import Model.Produto;

public class ExcluirProdutoView {
    private Scanner sc;

    public ExcluirProdutoView() {
        sc = new Scanner(System.in);
    }

    public Produto excluirProduto() {
        System.out.println("---Exclusão de Produto---");
        System.out.println("Nome do produto a ser excluído: ");
        String nome = sc.nextLine();


        // Este método supõe que o processo de exclusão será tratado pelo Controller
        System.out.println("Preparado para excluir o produto: " + nome);

        return new Produto(nome);
    }


}
