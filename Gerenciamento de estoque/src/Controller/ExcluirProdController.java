

package Controller;

import View.EdicaoProdutoView;
import View.ExcluirProdutoView;
import DAO.ProdutoDAO;
import Model.Produto;

public class ExcluirProdController {
    private ExcluirProdutoView exc;
    private ProdutoDAO pd;
    private Produto produto;

    public ExcluirProdController() {

        this.exc = new ExcluirProdutoView();
        this.produto = this.exc.excluirProduto();
        this.pd = new ProdutoDAO();
        this.pd.excluirProduto(this.produto);


    }


}
