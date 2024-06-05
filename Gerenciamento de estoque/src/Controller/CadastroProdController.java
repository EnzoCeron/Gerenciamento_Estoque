package Controller;

 import View.CadastroProdutoView;
import Model.Produto;
import DAO.ProdutoDAO;

public class CadastroProdController {

    private final CadastroProdutoView cpv;
    private final Produto produto;
    private final ProdutoDAO pd;

    public CadastroProdController() {
        this.cpv = new CadastroProdutoView();
        this.produto = this.cpv.cadastrarProduto();
        this.pd = new ProdutoDAO();
        this.pd.inserirProduto(this.produto);
    }
   
}
