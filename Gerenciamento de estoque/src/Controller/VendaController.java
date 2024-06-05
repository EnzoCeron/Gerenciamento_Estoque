package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.VendaView;
public class VendaController {

    private VendaView vv;
    private Produto produto;
    private ProdutoDAO pd;

    public VendaController() {
        this.vv = new VendaView();
        this.produto = this.vv.Venda();
        this.pd = new ProdutoDAO();
        this.pd.Venda(this.produto);
    }
}
