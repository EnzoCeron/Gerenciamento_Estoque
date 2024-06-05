package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.VendaView;

import java.sql.ResultSet;

public class VendaController {

    private final VendaView vv;
    private final Produto produto;
    private final ProdutoDAO pd;

    public VendaController() {
        this.vv = new VendaView();
        this.pd = new ProdutoDAO();
        this.produto = this.vv.Venda();
        ResultSet rs = this.pd.Venda(produto);
        this.vv.printVendaResult(rs, produto);
    }
}
