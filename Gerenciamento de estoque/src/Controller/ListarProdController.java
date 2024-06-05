package Controller;

import DAO.ProdutoDAO;
import View.ListarProdutoView;

public class ListarProdController {
    
    private final ListarProdutoView lpv;
    private final ProdutoDAO pd;

    public ListarProdController(){
        this.lpv = new ListarProdutoView();
        this.pd = new ProdutoDAO();
        this.lpv.listarProdutos(this.pd.listarProdutos());
    }
}
