//by davi

package Controller;

import DAO.ProdutoDAO;
import View.EdicaoProdutoView;
import Model.Produto;

public class EditProdController {

    private  final EdicaoProdutoView epv;
    private final Produto produto;
    private final ProdutoDAO pd;


    public EditProdController() {

        this.epv = new EdicaoProdutoView();
        this.produto = this.epv.EditarProduto();
        this.pd = new ProdutoDAO();
        this.pd.editarProduto(this.produto);


    }
}
