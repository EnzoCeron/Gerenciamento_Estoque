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
        System.out.println("Id do produto a ser excluído: ");
        int id = Integer.parseInt(sc.nextLine());


        // Este método supõe que o processo de exclusão será tratado pelo Controller
        System.out.println("Preparado para excluir o produto: " + id);

        return new Produto(id);
    }


}
